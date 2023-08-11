package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    @Autowired
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public void delete(Integer id) throws RegraDeNegocioException{
        EnderecoEntity enderecoEntity = returnById(id);
        enderecoRepository.delete(enderecoEntity);
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        PessoaDTO pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        EnderecoEntity entity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        entity.setIdPessoa(pessoa.getIdPessoa());
        EnderecoEntity enderecoNovo = enderecoRepository.save(entity);

        EnderecoDTO enderecoDTO = convertToDTO(enderecoNovo);
        return enderecoDTO;
    }

    public EnderecoEntity returnById(Integer id) throws RegraDeNegocioException{
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("endereco não encontrado"));
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException{
        EnderecoEntity enderecoRecuperado = returnById(id);

        enderecoRecuperado.setCep(endereco.getCep());
        enderecoRecuperado.setCidade(endereco.getCidade());
        enderecoRecuperado.setNumero(endereco.getNumero());
        enderecoRecuperado.setIdPessoa(endereco.getIdPessoa());
        enderecoRecuperado.setComplemento(endereco.getComplemento());
        enderecoRecuperado.setLogradouro(endereco.getLogradouro());
        enderecoRecuperado.setEstado(endereco.getEstado());
        enderecoRecuperado.setPais(endereco.getPais());
        enderecoRecuperado.setTipo(endereco.getTipo());
        enderecoRecuperado.setIdEndereco(id);

        return retornarDTO(enderecoRepository.save(enderecoRecuperado));
    }

    public List<EnderecoDTO> list() {
        List<EnderecoEntity> enderecos = enderecoRepository.findAll();
        return this.convertToDTOList(enderecos);
    }

//    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) {
//        return enderecoRepository.findById(idPessoa);
//    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("endereco não encontrado"));
    }

    private EnderecoDTO convertToDTO(EnderecoEntity endereco){
       EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);

        return enderecoDTO;
    }

    private List<EnderecoDTO> convertToDTOList(List<EnderecoEntity> enderecos){
        return enderecos.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }
    public EnderecoDTO retornarDTO(EnderecoEntity entity) {
        return objectMapper.convertValue(entity, EnderecoDTO.class);
    }

}
