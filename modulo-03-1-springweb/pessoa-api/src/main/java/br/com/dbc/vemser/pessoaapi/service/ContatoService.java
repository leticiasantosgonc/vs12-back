package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

    public void delete(Long id) throws Exception {
        contatoRepository.delete(id);
    }

    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
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

        return contatoDTO;
    }

    public Contato update(Integer id,Contato contato) throws Exception {
        return contatoRepository.update(id, contato);
    }


    public List<Contato> list() {
        return contatoRepository.list();
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }
}
