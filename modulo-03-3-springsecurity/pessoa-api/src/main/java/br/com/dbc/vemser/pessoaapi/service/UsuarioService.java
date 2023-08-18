package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public Optional<UsuarioEntity> findById(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public Optional<UsuarioEntity> createUsuario(LoginDTO loginDTO){
        UsuarioEntity novoUsuario = new UsuarioEntity();
        novoUsuario.setLogin(loginDTO.getLogin());
        novoUsuario.setSenha(loginDTO.getSenha());

        UsuarioEntity usuarioSalvo = usuarioRepository.save(novoUsuario);

        return Optional.of(usuarioSalvo);
    }
}