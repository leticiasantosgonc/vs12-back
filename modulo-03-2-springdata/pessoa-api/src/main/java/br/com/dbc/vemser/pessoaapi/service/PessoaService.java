package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.EntidadeNaoEncontradaException;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
//import org.hibernate.mapping.Set;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    private final String NOT_FOUND_MESSAGE = "ID da pessoa nao encontrada";

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity pessoaEntity = converterDTO(pessoa);
        return retornarDTO(pessoaRepository.save(pessoaEntity));
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll().stream()
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não econtrada"));
        return entity;
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaDto) throws RegraDeNegocioException, EntidadeNaoEncontradaException {
        PessoaEntity pessoaEntityRecuperada = returnPersonById(id);

        pessoaEntityRecuperada.setCpf(pessoaDto.getCpf());
        pessoaEntityRecuperada.setEmail(pessoaDto.getEmail());
        pessoaEntityRecuperada.setDataNascimento(pessoaDto.getDataNascimento());
        pessoaEntityRecuperada.setNome(pessoaDto.getNome());

        return retornarDTO(pessoaRepository.save(pessoaEntityRecuperada));
    }

    public void delete(Integer id) {
        try {
            PessoaEntity pessoaEntityRecuperada = returnPersonById(id);
            pessoaRepository.delete(pessoaEntityRecuperada);
        } catch (EntidadeNaoEncontradaException ex){
            ex.printStackTrace();
        }
    }

    public PessoaEntity returnPersonById(Integer id) throws EntidadeNaoEncontradaException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(NOT_FOUND_MESSAGE));
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.findAll().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .map(this::retornarDTO)
                .collect(Collectors.toList());
    }

    public PessoaEntity converterDTO(PessoaCreateDTO dto) {
        return objectMapper.convertValue(dto, PessoaEntity.class);
    }

    public PessoaDTO retornarDTO(PessoaEntity entity) {
        return objectMapper.convertValue(entity, PessoaDTO.class);
    }

    public List<PessoaEntity> getPessoasByCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    public List<PessoaEntity> getPessoasByDataNascimento(LocalDate dataInicial, LocalDate dataFinal) {
        return pessoaRepository.findByDataNascimentoBetween(dataInicial, dataFinal);
    }
    public List<PessoaEntity> getPessoasByNome(String nome) {
        return pessoaRepository.findByNomeIgnoreCaseContaining(nome);
    }

    public Map<String, Set> listaEnderecoPessoa(Integer idPessoa){
        Map<String, Set> map = new HashMap<>();
        List<PessoaEntity> pessoas= new ArrayList<>();
        if(idPessoa != null) {
            pessoas = pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getIdPessoa() == idPessoa)
                    .collect(Collectors.toList());
        }else{
            pessoas = pessoaRepository.findAll();
        }
        for(PessoaEntity pessoa: pessoas){
            map.put(pessoa.getNome(), pessoa.getEnderecos());
        }
        return map;
    }

    public Map<String, Map<String, Set>> listaPessoaCompleto(Integer idPessoa) {
        Map<String, Map<String, Set>> map = new HashMap<>();
        List<PessoaEntity> pessoas = new ArrayList<>();

        try {
            if (idPessoa != null) {
                PessoaEntity pessoa = pessoaRepository.findById(idPessoa).orElse(null);
                if (pessoa != null) {
                    pessoas.add(pessoa);
                }
            } else {
                pessoas = pessoaRepository.findAll();
            }

            for (PessoaEntity pessoa : pessoas) {
                Map<String, Set> pessoaInfo = new HashMap<>();
                pessoaInfo.put("Enderecos", pessoa.getEnderecos());
                pessoaInfo.put("Pets", pessoa.getPets());
                pessoaInfo.put("Contatos", pessoa.getContatos());

                map.put(pessoa.getNome(), pessoaInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Você pode logar a exceção ou retornar uma mensagem de erro apropriada aqui
        }

        return map;
    }



    public Map<String, Set> listaPetPessoa(Integer idPessoa){
        Map<String, Set> map = new HashMap<>();
        List<PessoaEntity> pessoas= new ArrayList<>();
        if(idPessoa != null) {
            pessoas = pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getIdPessoa() == idPessoa)
                    .collect(Collectors.toList());
        }else{
            pessoas = pessoaRepository.findAll();
        }
        for(PessoaEntity pessoa: pessoas){
            map.put(pessoa.getNome(), pessoa.getPets());
        }
        return map;
    }

    public Map<String, Set> listaContatoPessoa(Integer idPessoa){
        Map<String, Set> map = new HashMap<>();
        List<PessoaEntity> pessoas= new ArrayList<>();
        if(idPessoa != null) {
            pessoas = pessoaRepository.findAll().stream()
                    .filter(pessoa -> pessoa.getIdPessoa() == idPessoa)
                    .collect(Collectors.toList());
        }else{
            pessoas = pessoaRepository.findAll();
        }
        for(PessoaEntity pessoa: pessoas){
            map.put(pessoa.getNome(), pessoa.getContatos());
        }
        return map;
    }
}
