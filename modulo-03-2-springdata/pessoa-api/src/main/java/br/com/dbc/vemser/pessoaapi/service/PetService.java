package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;

    public PetEntity create(PetEntity pet) {
        return petRepository.save(pet);
    }
    public List<PetEntity> list(){
        return petRepository.findAll();
    }

    public void delete(PetEntity id){
        petRepository.deleteById(id.getIdPet());
    }
}
