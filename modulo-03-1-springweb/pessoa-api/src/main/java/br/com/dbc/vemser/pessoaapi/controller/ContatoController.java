package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
@Slf4j
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        return new ResponseEntity<>(contatoService.list(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByIdCliente(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                             @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException, MessagingException {
        log.info("criando contato");
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> update(@Valid @PathVariable("id") Integer id,
                                          @Valid @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException, MessagingException {
        Contato contatoAtualizado = contatoService.update(id, contatoAtualizar);
        return ResponseEntity.ok(contatoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Long id) throws RegraDeNegocioException, MessagingException {
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}