package br.com.dbc.vemser.pessoa.apimongo.controllers;

import br.com.dbc.vemser.pessoa.apimongo.dtos.PessoaDTO;
import br.com.dbc.vemser.pessoa.apimongo.services.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> listar(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> listarPeloId(@PathVariable String id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }
}
