package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.EnderecoControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController implements EnderecoControllerDoc {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> findAll() {
        return new ResponseEntity<>(enderecoService.findAll(), HttpStatus.OK);
    }
//    @GetMapping("/{idEndereco}")
//    public EnderecoEntity findById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
//        return enderecoService.findById(id);
//    }
    @PostMapping("/{idPessoa}")
    public ResponseEntity<EnderecoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                             @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        return new ResponseEntity<>(enderecoService.create(idPessoa, endereco), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<List<EnderecoDTO>> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findByIdPessoa(idPessoa));
    }
    
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") @Positive Integer idEndereco,
                                             @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        EnderecoDTO enderecoAtualizar = enderecoService.update(idEndereco, endereco);
        return new ResponseEntity<>(enderecoAtualizar, HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException{
        enderecoService.delete(idEndereco);
        return ResponseEntity.ok().build();
    }
}