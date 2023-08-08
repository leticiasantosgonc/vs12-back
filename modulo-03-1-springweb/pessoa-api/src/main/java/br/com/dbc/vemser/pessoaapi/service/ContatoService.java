package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public void delete(Long id) throws RegraDeNegocioException, MessagingException {
        Contato contatoRecuperado = getContato(id);

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setNumero(contatoRecuperado.getNumero());
        emailService.sendTemplateEmailDeleteContato(contatoDTO);
        contatoRepository.delete(id);
    }

    private Contato getContato(Long id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado!"));
        return contatoRecuperado;
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException, MessagingException {
        Contato entity = objectMapper.convertValue(contato, Contato.class);
        entity.setIdPessoa(idPessoa);
        entity.setTipoContato(contato.getTipoContato());
        entity.setNumero(contato.getNumero());
        entity.setDescricao(contato.getDescricao());

        Contato contatoCriado = contatoRepository.create(entity);
        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setIdPessoa(contatoCriado.getIdPessoa());
        contatoDTO.setIdContato(contatoCriado.getIdContato());
        contatoDTO.setTipoContato(contatoCriado.getTipoContato());
        contatoDTO.setNumero(contatoCriado.getNumero());
        contatoDTO.setDescricao(contatoCriado.getDescricao());

        emailService.sendTemplateEmailCreateContato(contatoDTO);
        return contatoDTO;
    }

    public Contato update(Integer id,Contato contato) throws RegraDeNegocioException, MessagingException {

        ContatoDTO contatoDTO = new ContatoDTO();
        contatoDTO.setIdContato(id);
        contatoDTO.setDescricao(contato.getDescricao());
        contatoDTO.setNumero(contato.getNumero());
        contatoDTO.setTipoContato(contato.getTipoContato());
        contatoDTO.setIdPessoa(contato.getIdPessoa());

        emailService.sendTemplateEmailUpdateContato(contatoDTO);
        return contatoRepository.update(id, contato);
    }

    public List<ContatoDTO> list() {
        List<Contato> contato = contatoRepository.list();
        List<ContatoDTO> contatosDTO = this.convertToDTOList(contato);
        return contatosDTO;
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

    private ContatoDTO convertToDTO(Contato contato){
        ContatoDTO contatoDTO = new ContatoDTO();

        contatoDTO.setIdPessoa(contato.getIdPessoa());
        contatoDTO.setIdContato(contato.getIdContato());
        contatoDTO.setTipoContato(contato.getTipoContato());
        contatoDTO.setNumero(contato.getNumero());
        contatoDTO.setDescricao(contato.getDescricao());

        return contatoDTO;
    }

    private List<ContatoDTO> convertToDTOList(List<Contato> listaContatos){
        return listaContatos.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }
}
