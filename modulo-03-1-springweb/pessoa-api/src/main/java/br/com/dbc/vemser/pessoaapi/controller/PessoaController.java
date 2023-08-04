package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pessoa") // localhost:8080/pessoa
public class PessoaController {

    // Modelo ANTIGO de Injeção
    // @Autowired
    private final PessoaService pessoaService;

    @Value("${user}")
    private String usuario;

    @Value("${spring.application.name}")
    private String app;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/hello") // GET localhost:8080/pessoa/hello
    public String hello() {
        return "Hello WORLD!\n" + " <br>App: " + app + " <br>Usuario: " + usuario;
    }

    @GetMapping("/hello-2") // GET localhost:8080/pessoa/hello-2
    public String hello2() {
        return "Hello world 2!";
    }

    @GetMapping // GET localhost:8080/pessoa
    public List<Pessoa> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // GET localhost:8080/pessoa/byname?nome=Rafa
    public List<Pessoa> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
    }

    @PostMapping // POST localhost:8080/pessoa
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa pessoa) {
        return new ResponseEntity<>(pessoaService.create(pessoa) , HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // PUT localhost:8080/pessoa/1000
    public ResponseEntity<Pessoa> update(@PathVariable("idPessoa") Integer id,
                                         @RequestBody Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaAlterada = pessoaService.update(id, pessoaAtualizar);
        return ResponseEntity.ok(pessoaAlterada);
    }

    @DeleteMapping("/{idPessoa}") // DELETE localhost:8080/pessoa/10
    public ResponseEntity<Void> delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
        return ResponseEntity.ok().build();
    }

}
