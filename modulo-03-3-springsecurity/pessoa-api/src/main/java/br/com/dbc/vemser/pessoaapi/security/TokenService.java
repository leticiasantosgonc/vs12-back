package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {
    private static final String TOKEN_PREFIX = "Bearer";

    private static final String CARGOS_CLAIM = "cargos";


    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    //private final UsuarioService usuarioService;

    public String generateToken(UsuarioEntity usuarioEntity) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        List<String> cargos = usuarioEntity.getCargos().stream()
                .map(CargoEntity::getAuthority)
                .toList();

        return TOKEN_PREFIX + " " +
                Jwts.builder()
                        .setIssuer("vemser-api")
                        .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                        .claim(CARGOS_CLAIM, cargos)
                        .setIssuedAt(now)
                        .setExpiration(exp)
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
    }
//    public String getToken(UsuarioEntity usuarioEntity) {
//        String tokenTexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
//        String token = Base64.getEncoder().encodeToString(tokenTexto.getBytes());
//        return token;
//    }

//    public UsernamePasswordAuthenticationToken isValid(String token) {
//        if (token != null) {
//            Claims body = Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody();
//            String user = body.get(Claims.ID, String.class);
//            if (user != null) {
//                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
//                        new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
//                return usernamePasswordAuthenticationToken;
//            }
//        }
//        return null;
//    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token != null) {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String user = body.get(Claims.ID, String.class);
            if (user != null) {
                List<String> cargos = body.get(CARGOS_CLAIM, List.class);
                List<SimpleGrantedAuthority> authorities = cargos.stream()
                        .map(SimpleGrantedAuthority::new)
                        .toList();
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(user, null, authorities);
                return usernamePasswordAuthenticationToken;
            }
        }
        return null;
    }
}