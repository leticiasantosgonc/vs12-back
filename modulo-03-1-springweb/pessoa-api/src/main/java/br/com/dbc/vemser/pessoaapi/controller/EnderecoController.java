package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
@Slf4j
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Long id) throws RegraDeNegocioException, MessagingException {
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                              @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException, MessagingException {
        log.info("criando endereco");
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Endereco> update(@Valid @PathVariable("id") Integer id,
                                           @Valid @RequestBody Endereco enderecoAtualizar) throws RegraDeNegocioException, MessagingException {
        Endereco enderecoAtualizado = enderecoService.update(id, enderecoAtualizar);
        return ResponseEntity.ok(enderecoAtualizado);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        return new ResponseEntity<>(enderecoService.list(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("/{idEndereco}")
    public Endereco findById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        return enderecoService.findById(id);
    }
}