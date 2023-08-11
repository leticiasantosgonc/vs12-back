package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException{
        PessoaDTO pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        ContatoEntity entity = objectMapper.convertValue(contato, ContatoEntity.class);
        entity.setIdPessoa(pessoa.getIdPessoa());
        ContatoEntity contatoCriado = contatoRepository.save(entity);

        ContatoDTO contatoDTO = convertToDTO(contatoCriado);
        return contatoDTO;
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contato) throws RegraDeNegocioException{
        ContatoEntity contatoRecuperado = returnById(id);

        contatoRecuperado.setTipoContato(contato.getTipoContato());
        contatoRecuperado.setDescricao(contato.getDescricao());
        contatoRecuperado.setNumero(contato.getNumero());
        contatoRecuperado.setIdPessoa(contato.getIdPessoa());

        return retornarDTO(contatoRepository.save(contatoRecuperado));

    }

    public void delete(Integer id) throws RegraDeNegocioException{
        ContatoEntity contatoRecuperado = returnById(id);
        contatoRepository.delete(contatoRecuperado);
    }

    public ContatoEntity returnById(Integer id) throws RegraDeNegocioException{
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("contato não encontrado"));
    }

    public List<ContatoDTO> list() {
        List<ContatoEntity> contatos = contatoRepository.findAll();
        return this.convertToDTOList(contatos);
    }

//    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
//        List<ContatoEntity> contatos = contatoRepository.findById(idPessoa);
//        return contatos.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
//    }

    private ContatoDTO convertToDTO(ContatoEntity contato){
        ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
        return contatoDTO;
    }

    private List<ContatoDTO> convertToDTOList(List<ContatoEntity> contatosList){
        return contatosList.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    public ContatoDTO retornarDTO(ContatoEntity entity) {
        return objectMapper.convertValue(entity, ContatoDTO.class);
    }
}