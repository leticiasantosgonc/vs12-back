package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContatoService {

    @Autowired
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;

   public List<ContatoDTO> findAll() {
        List<ContatoEntity> listContatos = contatoRepository.findAll();
        List<ContatoDTO> contatosDTO = new ArrayList<>();

        for (ContatoEntity contatoEntity : listContatos) {
            contatosDTO.add(retornarDTO(contatoEntity));
        }
        return contatosDTO;
    }

//    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
//        List<ContatoEntity> contatos = contatoRepository.findById(idPessoa);
//        return contatos.stream()
//                .map(this::convertToDTO)
//                .collect(Collectors.toList());
////    }
    public ContatoDTO create(Integer idPessoa, ContatoCreateDTO contato) throws RegraDeNegocioException{
        PessoaEntity pessoa = pessoaService.findById(idPessoa);

        ContatoEntity contatoCriado = retornarEntity(contato);
        contatoCriado.setPessoaEntity(pessoa);
        ContatoEntity contatoEnviar = contatoRepository.save(contatoCriado);
        return retornarDTO(contatoEnviar);
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoDTO) throws RegraDeNegocioException{
        ContatoEntity contatoAtualizar = contatoRepository.findById(idContato)
                        .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));

        contatoAtualizar.setTipoContato(contatoDTO.getTipoContato());
        contatoAtualizar.setDescricao(contatoDTO.getDescricao());
        contatoAtualizar.setNumero(contatoDTO.getNumero());

        ContatoEntity contatoAtualizado = contatoRepository.save(contatoAtualizar);
        return retornarDTO(contatoAtualizado);
    }
    public void delete(Integer id) throws RegraDeNegocioException{
        contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contatoRepository.deleteById(id);
    }
    public ContatoEntity retornarEntity(ContatoCreateDTO contatoDTO) {
        return objectMapper.convertValue(contatoDTO, ContatoEntity.class);
    }

    public ContatoDTO retornarDTO(ContatoEntity entity) {
        return objectMapper.convertValue(entity, ContatoDTO.class);
    }
}
