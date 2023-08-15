package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.documentacao.PessoaControllerDoc;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
//import org.hibernate.mapping.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController implements PessoaControllerDoc {

    // Modelo ANTIGO de Injeção
    // @Autowired
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    public PessoaController(PessoaService pessoaService, PessoaRepository pessoaRepository) {
        this.pessoaService = pessoaService;
        this.pessoaRepository = pessoaRepository;
    }

    @GetMapping // GET localhost:8080/pessoa
    public ResponseEntity<List<PessoaDTO>> list() {
        return new ResponseEntity<>(pessoaService.list(), HttpStatus.OK);
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public ResponseEntity<List<PessoaDTO>> listByName(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(pessoaService.listByName(nome));
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoa) {
        return new ResponseEntity<>(pessoaService.create(pessoa), HttpStatus.OK);
    }

    // Atualizar pessoa
    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<PessoaDTO> update(@PathVariable("idPessoa") Integer id,
                                            @RequestBody @Valid PessoaCreateDTO pessoaAtualizada) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizada));
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/pessoa/cpf")
    public List<PessoaEntity> getPessoasByCpf(@RequestParam String cpf) {
        return pessoaService.getPessoasByCpf(cpf);
    }

    @GetMapping("/pessoa/data-nascimento")
    public List<PessoaEntity> getPessoasByDataNascimento(
            @RequestParam String dataInicial,
            @RequestParam String dataFinal) {
        LocalDate dataInicio = LocalDate.parse(dataInicial);
        LocalDate dataFim = LocalDate.parse(dataFinal);
        return pessoaService.getPessoasByDataNascimento(dataInicio, dataFim);
    }

    @GetMapping("/pessoa/nome")
    public List<PessoaEntity> getPessoasByNome(@RequestParam String nome) {
        return pessoaService.getPessoasByNome(nome);
    }

    @GetMapping("/listar-com-contatos")
    public ResponseEntity<Map<String, Set>>listaContatoPessoa(@RequestParam(required = false) Integer idPessoa){
        return new ResponseEntity<>(pessoaService.listaContatoPessoa(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/listar-com-enderecos")
    public ResponseEntity<Map<String, Set>>listaEnderecoPessoa(@RequestParam(required = false) Integer idPessoa){
        return new ResponseEntity<>(pessoaService.listaEnderecoPessoa(idPessoa), HttpStatus.OK);
    }

    @GetMapping("/listar-com-pets")
    public ResponseEntity<Map<String, Set>>listaPetPessoa(@RequestParam(required = false) Integer idPessoa){
        return new ResponseEntity<>(pessoaService.listaPetPessoa(idPessoa), HttpStatus.OK);
    }

//    @GetMapping("/pessoa-completo")
//    public ResponseEntity<List<PessoaEntity>> obterPessoasCompletas(@RequestParam(required = false) Long id) {
//        List<PessoaEntity> pessoas = pessoaRepository.findPessoasCompletoById(id);
//        return ResponseEntity.ok(pessoas);
//    }
}