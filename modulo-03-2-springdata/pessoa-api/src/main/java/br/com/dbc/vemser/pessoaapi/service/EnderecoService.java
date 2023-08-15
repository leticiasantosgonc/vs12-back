package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public List<EnderecoDTO> findAll() {
        List<EnderecoEntity> listEnderecos = enderecoRepository.findAll();
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();

        for (EnderecoEntity enderecoEntity : listEnderecos) {
            enderecosDTO.add(retornarDTO(enderecoEntity));
        }
        return enderecosDTO;
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        PessoaEntity pessoa = pessoaService.findById(idPessoa);

        EnderecoEntity enderecoCriado = retornarEntity(endereco);
        //enderecoCriado.setPessoas(pessoa.getIdPessoa());
        EnderecoEntity enderecoEnviar = enderecoRepository.save(enderecoCriado);
        return retornarDTO(enderecoEnviar);
    }
    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoDTO) throws RegraDeNegocioException{
        EnderecoEntity enderecoAtualizar = enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));

        enderecoAtualizar.setCep(enderecoDTO.getCep());
        enderecoAtualizar.setCidade(enderecoDTO.getCidade());
        enderecoAtualizar.setNumero(enderecoDTO.getNumero());
        enderecoAtualizar.setComplemento(enderecoDTO.getComplemento());
        enderecoAtualizar.setLogradouro(enderecoDTO.getLogradouro());
        enderecoAtualizar.setEstado(enderecoDTO.getEstado());
        enderecoAtualizar.setPais(enderecoDTO.getPais());
        enderecoAtualizar.setTipo(enderecoDTO.getTipo());

        EnderecoEntity enderecoAtualizado = enderecoRepository.save(enderecoAtualizar);
        return retornarDTO(enderecoAtualizado);
    }
    public void delete(Integer id) throws RegraDeNegocioException{
        enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado"));
        enderecoRepository.deleteById(id);
    }
    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("endereco não encontrado"));
    }

    public EnderecoEntity retornarEntity(EnderecoCreateDTO enderecoDTO) {
        return objectMapper.convertValue(enderecoDTO, EnderecoEntity.class);
    }

    public EnderecoDTO retornarDTO(EnderecoEntity entity) {
        return objectMapper.convertValue(entity, EnderecoDTO.class);
    }
}
