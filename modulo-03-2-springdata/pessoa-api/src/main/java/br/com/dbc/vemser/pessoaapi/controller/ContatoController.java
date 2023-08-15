package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.ContatoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController  implements ContatoControllerDoc{
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> findAll() {
        return new ResponseEntity<>(contatoService.findAll(), HttpStatus.OK);
    }
//    @GetMapping("/{idPessoa}")
//    public ResponseEntity<List<ContatoDTO>> listByIdCliente(@PathVariable("idPessoa") Integer idPessoa) {
//        List<ContatoDTO> contatosDTO = contatoService.listByIdPessoa(idPessoa);
//        return new ResponseEntity<>(contatosDTO, HttpStatus.OK);
//    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                             @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException{
        return new ResponseEntity<>(contatoService.create(idPessoa, contato), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") @Positive Integer idContato,
                                             @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException{
        ContatoDTO contatoAtualizar = contatoService.update(idContato, contato);
        return new ResponseEntity<>(contatoAtualizar, HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Void> delete(@PathVariable("idContato") Integer idContato) throws RegraDeNegocioException{
        contatoService.delete(idContato);
        return ResponseEntity.ok().build();
    }
}