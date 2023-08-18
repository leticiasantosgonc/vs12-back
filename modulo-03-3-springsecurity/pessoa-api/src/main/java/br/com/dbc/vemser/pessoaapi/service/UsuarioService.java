package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import br.com.dbc.vemser.pessoaapi.security.SecurityConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final SecurityConfiguration securityConfiguration;
    private final ObjectMapper objectMapper;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO createUsuario(UsuarioCreateDTO usuario) {
        UsuarioEntity novoUsuario = new UsuarioEntity();
        novoUsuario.setLogin(usuario.getLogin());
        novoUsuario.setSenha(securityConfiguration.passwordEncoder().encode(usuario.getSenha()));

        return retornarDTO(usuarioRepository.save(novoUsuario));
    }

    public UsuarioDTO retornarDTO(UsuarioEntity usuarioEntity) {
        return objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
    }

}