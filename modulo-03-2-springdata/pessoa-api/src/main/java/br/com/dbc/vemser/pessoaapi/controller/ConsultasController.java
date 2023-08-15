package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/consultas")
public class ConsultasController {
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;

    public ConsultasController(ContatoRepository contatoRepository, EnderecoRepository enderecoRepository, PessoaRepository pessoaRepository) {
        this.contatoRepository = contatoRepository;
        this.enderecoRepository = enderecoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping("/endereco-pais")
    public ResponseEntity<List<EnderecoEntity>> findEnderecoByPais(@Param("pais") String pais) {
        return new ResponseEntity<>(enderecoRepository.findEnderecoByPais(pais), HttpStatus.OK);
    }
    @GetMapping("/endereco-idPessoa")
    public ResponseEntity<List<EnderecoEntity>> findEnderecoByIdPessoa(@RequestParam Integer idPessoa){
        return new ResponseEntity<>(enderecoRepository.findEnderecoByPessoa(idPessoa), HttpStatus.OK);
    }

}
