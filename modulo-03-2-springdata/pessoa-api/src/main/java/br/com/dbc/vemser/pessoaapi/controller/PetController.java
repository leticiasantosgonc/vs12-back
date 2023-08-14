package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetEntity> list(){
        return new ResponseEntity<>(petService.list(), HttpStatus.OK).getBody();
    }

    @PostMapping
    public PetEntity create(@Valid @RequestBody PetEntity pet){
        return new ResponseEntity<>(petService.create(pet), HttpStatus.OK).getBody();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") PetEntity id){
        petService.delete(id);
    }

}
