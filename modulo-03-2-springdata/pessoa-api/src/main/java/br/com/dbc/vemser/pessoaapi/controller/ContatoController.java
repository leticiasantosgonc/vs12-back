package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.documentacao.ContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
@Slf4j
public class ContatoController implements ContatoControllerDoc {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list() {
        return new ResponseEntity<>(contatoService.list(), HttpStatus.OK);
    }
//    @GetMapping("/{idPessoa}")
//    public ResponseEntity<List<ContatoDTO>> listByIdCliente(@PathVariable("idPessoa") Integer idPessoa) {
//        List<ContatoDTO> contatosDTO = contatoService.listByIdPessoa(idPessoa);
//        return new ResponseEntity<>(contatosDTO, HttpStatus.OK);
//    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                             @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException{
        log.info("criando contato");
        ContatoDTO contatoDTO = contatoService.create(idPessoa, contato);
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContatoDTO> update(@Valid @PathVariable("id") Integer id,
                                             @RequestBody ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException{
        return ResponseEntity.ok(contatoService.update(id, contatoAtualizar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws RegraDeNegocioException{
        contatoService.delete(id);
        return ResponseEntity.ok().build();
    }
}