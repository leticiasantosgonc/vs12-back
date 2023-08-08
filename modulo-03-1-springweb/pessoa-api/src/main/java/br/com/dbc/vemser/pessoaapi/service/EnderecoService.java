package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
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

    public void delete(Long id) throws RegraDeNegocioException, MessagingException {
        Endereco enderecoRecuperado = getEndereco(id);

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro(enderecoRecuperado.getLogradouro());
        enderecoDTO.setNumero(enderecoRecuperado.getNumero());
        enderecoDTO.setCidade(enderecoRecuperado.getCidade());
        enderecoDTO.setEstado(enderecoRecuperado.getEstado());
        emailService.sendTemplateEmailDeleteEndereco(enderecoDTO);
        enderecoRepository.delete(id);
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException, MessagingException {

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

        emailService.sendTemplateEmailCreateEndereco(enderecoDTO);
        return enderecoDTO;
    }

    public Endereco update(Integer id, Endereco endereco) throws RegraDeNegocioException, MessagingException {
        Endereco enderecoRecuperado = getEndereco(Long.valueOf(id));

        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setLogradouro(enderecoRecuperado.getLogradouro());
        enderecoDTO.setNumero(enderecoRecuperado.getNumero());
        enderecoDTO.setCidade(enderecoRecuperado.getCidade());
        enderecoDTO.setEstado(enderecoRecuperado.getEstado());

        emailService.sendTemplateEmailUpdateEndereco(enderecoDTO);
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
        EnderecoDTO enderecoDTO = new EnderecoDTO();

        enderecoDTO.setIdPessoa(endereco.getIdPessoa());
        enderecoDTO.setIdEndereco(endereco.getIdEndereco());
        enderecoDTO.setTipo(endereco.getTipo());
        enderecoDTO.setLogradouro(endereco.getLogradouro());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setComplemento(endereco.getComplemento());
        enderecoDTO.setCep(endereco.getCep());
        enderecoDTO.setCidade(endereco.getCidade());
        enderecoDTO.setEstado(endereco.getEstado());
        enderecoDTO.setPais(endereco.getPais());

        return enderecoDTO;
    }

    private List<EnderecoDTO> convertToDTOList(List<Endereco> enderecos){
        return enderecos.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    private Endereco getEndereco(Long id) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não encontrado!"));
        return enderecoRecuperado;
    }
}
