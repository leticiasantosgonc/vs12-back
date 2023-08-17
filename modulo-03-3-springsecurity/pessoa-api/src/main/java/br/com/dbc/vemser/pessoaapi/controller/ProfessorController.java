//package br.com.dbc.vemser.pessoaapi.controller;
//
//
//import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
//import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
//import br.com.dbc.vemser.pessoaapi.service.ProfessorService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@Validated
//@RestController
//@RequestMapping("/professor")
//public class ProfessorController {
//
//    private final ProfessorService professorService;
//
//    public ProfessorController(ProfessorService professorService) {
//        this.professorService = professorService;
//    }
//
//    @GetMapping
//    public List<ProfessorEntity> list(){
//        return new ResponseEntity<>(professorService.list(), HttpStatus.OK).getBody();
//    }
//
//    @PostMapping
//    public ProfessorEntity create(@Valid @RequestBody ProfessorEntity professor){
//        return new ResponseEntity<>(professorService.create(professor), HttpStatus.OK).getBody();
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable("id") ProfessorPK id){
//        professorService.delete(id);
//    }
//
//}
