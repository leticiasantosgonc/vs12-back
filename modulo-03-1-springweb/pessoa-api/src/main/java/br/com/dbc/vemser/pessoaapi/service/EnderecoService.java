package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public void delete(Long id) throws Exception {
        enderecoRepository.delete(id);
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        Endereco entity = objectMapper.convertValue(endereco, Endereco.class);
        entity.setIdPessoa(idPessoa);
        entity.setTipo(endereco.getTipo());
        entity.setLogradouro(endereco.getLogradouro());
        entity.setNumero(endereco.getNumero());
        entity.setComplemento(endereco.getComplemento());
        entity.setCep(endereco.getCep());
        entity.setCidade(endereco.getCidade());
        entity.setEstado(endereco.getEstado());
        entity.setPais(endereco.getPais());

        Endereco enderecoCriado = enderecoRepository.create(entity);

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setIdPessoa(enderecoCriado.getIdPessoa());
        enderecoDTO.setIdEndereco(enderecoCriado.getIdEndereco());
        enderecoDTO.setTipo(enderecoCriado.getTipo());
        enderecoDTO.setLogradouro(enderecoCriado.getLogradouro());
        enderecoDTO.setNumero(enderecoCriado.getNumero());
        enderecoDTO.setComplemento(enderecoCriado.getComplemento());
        enderecoDTO.setCep(enderecoCriado.getCep());
        enderecoDTO.setCidade(enderecoCriado.getCidade());
        enderecoDTO.setEstado(enderecoCriado.getEstado());
        enderecoDTO.setPais(enderecoCriado.getPais());

        return enderecoDTO;
    }

    public Endereco update(Integer id, Endereco endereco) throws Exception {
        return enderecoRepository.update(id, endereco);
    }


    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco findById(Integer idEndereco) throws Exception {
        return enderecoRepository.findById(idEndereco);
    }
}
