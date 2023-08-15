package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PessoaService pessoaService;
    public PetEntity create(Integer idPessoa, PetEntity pet) throws RegraDeNegocioException {
        PessoaEntity pessoa = pessoaService.findById(idPessoa);

        PetEntity entity = new PetEntity();
        entity.setPessoaEntity(pessoa);
        return (petRepository.save(entity));
    }
    public List<PetEntity> list(){
        return petRepository.findAll();
    }

    public PetEntity update(Integer idPet, PetEntity pet) throws RegraDeNegocioException {
        PetEntity petAtualizar = petRepository.findById(idPet)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
        petAtualizar.setTipo(pet.getTipo());
        petAtualizar.setNome(pet.getNome());

        return(petRepository.save(petAtualizar));
    }
    public void delete(Integer id){
        petRepository.deleteById(id);
    }
}
