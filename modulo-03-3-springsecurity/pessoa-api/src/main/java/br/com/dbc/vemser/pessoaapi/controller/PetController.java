package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PetDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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
    public ResponseEntity<List<PetDTO>> findAll() {
        return new ResponseEntity<>(petService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/{idPessoa}")
    public ResponseEntity<PetDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                              @Valid @RequestBody PetCreateDTO pet) throws RegraDeNegocioException{
        return new ResponseEntity<>(petService.create(idPessoa, pet), HttpStatus.OK);
    }

    @PutMapping("/{idPet}")
    public ResponseEntity<PetDTO> update(@PathVariable("idPet") @Positive Integer idPet,
                                              @RequestBody PetCreateDTO pet) throws RegraDeNegocioException{
        PetDTO petAtualizar = petService.update(idPet, pet);
        return new ResponseEntity<>(petAtualizar, HttpStatus.OK);
    }

    @DeleteMapping("/{idPet}")
    public ResponseEntity<Void> delete(@PathVariable("idPet") Integer idPet) throws RegraDeNegocioException{
        petService.delete(idPet);
        return ResponseEntity.ok().build();
    }


}
