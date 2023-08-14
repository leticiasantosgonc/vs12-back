package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.EnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController implements EnderecoControllerDoc {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable("id") Integer id) throws RegraDeNegocioException{
        enderecoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@PathVariable("idPessoa") Integer idPessoa, @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> update(@Valid @PathVariable("id") Integer id,
                                                 @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException{
        return ResponseEntity.ok(enderecoService.update(id, enderecoAtualizar));

    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> list() {
        return new ResponseEntity<>(enderecoService.list(), HttpStatus.OK);
    }

//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoEntity> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
//        return enderecoService.listByIdPessoa(idPessoa);
//    }

    @GetMapping("/{idEndereco}")
    public EnderecoEntity findById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        return enderecoService.findById(id);
    }
}