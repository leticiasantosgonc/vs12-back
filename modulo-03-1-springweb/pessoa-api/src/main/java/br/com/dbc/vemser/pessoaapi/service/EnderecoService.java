package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public void delete(Long id) throws RegraDeNegocioException{
        enderecoRepository.delete(id);
    }

    public Endereco create(Integer idPessoa, Endereco endereco) throws RegraDeNegocioException{
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco endereco) throws RegraDeNegocioException{
        return enderecoRepository.update(id, endereco);
    }

    public List<EnderecoDTO> list() {
        List<Endereco> endereco = enderecoRepository.list();
        List<EnderecoDTO> enderecosDTO = this.convertToDTOList(endereco);
        return enderecosDTO;
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco);
    }

    private EnderecoDTO convertToDTO(Endereco endereco){
       EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);

        return enderecoDTO;
    }

    private List<EnderecoDTO> convertToDTOList(List<Endereco> enderecos){
        return enderecos.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }
}
