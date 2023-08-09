package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException{
        PessoaDTO pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));

        Contato entity = objectMapper.convertValue(contato, Contato.class);
        entity.setIdPessoa(pessoa.getIdPessoa());
        Contato contatoCriado = contatoRepository.create(entity);;

        ContatoDTO contatoDTO = convertToDTO(contatoCriado);
        return contatoDTO;
    }

    public Contato update(Integer id, Contato contato) throws RegraDeNegocioException{
        ContatoDTO contatoDTO = convertToDTO(contato);
        return contatoRepository.update(id, contato);
    }

    public void delete(Long id) throws RegraDeNegocioException{
        contatoRepository.delete(id);
    }

    public List<ContatoDTO> list() {
        List<Contato> contatos = contatoRepository.list();
        List<ContatoDTO> contatosDTO = this.convertToDTOList(contatos);
        return contatosDTO;
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        List<Contato> contatos = contatoRepository.listByIdPessoa(idPessoa);
        return contatos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ContatoDTO convertToDTO(Contato contato){
        ContatoDTO contatoDTO = objectMapper.convertValue(contato, ContatoDTO.class);
        return contatoDTO;
    }

    private List<ContatoDTO> convertToDTOList(List<Contato> contatosList){
        return contatosList.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }
}
