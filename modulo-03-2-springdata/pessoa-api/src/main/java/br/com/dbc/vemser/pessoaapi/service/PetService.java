package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.PetEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService {
    @Autowired
    private final PetRepository petRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public List<PetDTO> findAll() {
        List<PetEntity> listPets = petRepository.findAll();
        List<PetDTO> petDTO = new ArrayList<>();

        for (PetEntity petEntity : listPets) {
            petDTO.add(retornarDTO(petEntity));
        }
        return petDTO;
    }
    public PetDTO create(Integer idPessoa, PetCreateDTO pet) throws RegraDeNegocioException{
        PessoaEntity pessoa = pessoaService.findById(idPessoa);

        PetEntity petCriado = retornarEntity(pet);
        petCriado.setPessoaEntity(pessoa);
        PetEntity petEnviar = petRepository.save(petCriado);
        return retornarDTO(petEnviar);
    }

    public PetDTO update(Integer idPet, PetCreateDTO petCreateDTO) throws RegraDeNegocioException{
        PetEntity petAtualizar = petRepository.findById(idPet)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));

        petAtualizar.setTipo(petCreateDTO.getTipo());
        petAtualizar.setNome(petCreateDTO.getNome());

        PetEntity petAtualizado = petRepository.save(petAtualizar);
        return retornarDTO(petAtualizado);
    }
    public void delete(Integer id) throws RegraDeNegocioException{
        petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
        petRepository.deleteById(id);
    }
    public PetEntity retornarEntity(PetCreateDTO petDTO) {
        return objectMapper.convertValue(petDTO, PetEntity.class);
    }

    public PetDTO retornarDTO(PetEntity entity) {
        return objectMapper.convertValue(entity, PetDTO.class);
    }
}
