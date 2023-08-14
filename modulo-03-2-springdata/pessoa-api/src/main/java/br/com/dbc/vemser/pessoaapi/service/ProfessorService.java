package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.ProfessorEntity;
import br.com.dbc.vemser.pessoaapi.entity.pk.ProfessorPK;
import br.com.dbc.vemser.pessoaapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorEntity create(ProfessorEntity professor) {
        return professorRepository.save(professor);
    }

    public List<ProfessorEntity> list(){
        return professorRepository.findAll();
    }

    public void delete(ProfessorPK id){
      professorRepository.deleteById(id);
    }
}
