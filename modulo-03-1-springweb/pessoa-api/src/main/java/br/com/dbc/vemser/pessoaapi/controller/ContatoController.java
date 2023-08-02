package br.com.dbc.vemser.pessoaapi.controller;


import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato") // localhost:8080/contato
public class ContatoController {

    private ContatoService contatoService;
    public ContatoController(){
        contatoService = new ContatoService();
    }

    @GetMapping // GET localhost:8080/contato
    public List<Contato> list() {
        return contatoService.list();
    }
    @GetMapping("/pessoa") // GET localhost:8080/contato/pessoa?id=4
    public List<Contato> contatoPessoa(@RequestParam("id") int idPessoa) {
        return contatoService.contatoPessoa(idPessoa);
    }
    @PostMapping // POST localhost:8080/contato?id=2
    public Contato create(@RequestParam("id") int idPessoa, @RequestBody Contato contato) {
        return contatoService.create(contato, idPessoa);
    }
    @PutMapping("/{idContato}") // PUT localhost:8080/contato/5
    public Contato update(@PathVariable("idContato") int idContato, @RequestBody Contato contato) throws Exception {
        return contatoService.update(idContato, contato);
    }
    @DeleteMapping("/{idContato}") // DELETE localhost:8080/pessoa/6
    public void delete(@PathVariable("idContato") int idContato) throws Exception {
        contatoService.delete(idContato);
    }
}
