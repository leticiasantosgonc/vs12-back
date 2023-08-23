package br.com.dbc.vemser.pessoa.apimongo.services;

import br.com.dbc.vemser.pessoa.apimongo.dtos.PessoaCreateDTO;
import br.com.dbc.vemser.pessoa.apimongo.dtos.PessoaDTO;
import br.com.dbc.vemser.pessoa.apimongo.entities.PessoaEntity;
import br.com.dbc.vemser.pessoa.apimongo.repositories.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    private String NOT_FOUND_MESSAGE = "Id da pessoa não encontrado";

    public List<PessoaDTO> findAll(){
        return pessoaRepository.findAll().stream().map(this::returnDTO).collect(Collectors.toList());
    }

    public PessoaDTO findById(String id){
        PessoaEntity pessoa = pessoaRepository.findById(id).get();
        return returnDTO(pessoa);
    }

    public PessoaEntity returnEntity(PessoaCreateDTO pessoaCreateDTO){
        return objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
    }

    public PessoaDTO returnDTO(PessoaEntity pessoa){
        return objectMapper.convertValue(pessoa, PessoaDTO.class);
    }
}
