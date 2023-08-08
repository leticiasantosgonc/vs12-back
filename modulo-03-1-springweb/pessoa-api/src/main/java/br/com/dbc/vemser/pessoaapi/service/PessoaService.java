package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PessoaService {

    // @Autowired
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException, MessagingException {
        Pessoa entity = objectMapper.convertValue(pessoa, Pessoa.class);
        entity.setCpf(pessoa.getCpf());
        entity.setNome(pessoa.getNome());
        entity.setDataNascimento(pessoa.getDataNascimento());

        Pessoa pessoa1 = pessoaRepository.create(entity);

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setIdPessoa(pessoa1.getIdPessoa());
        pessoaDTO.setDataNascimento(pessoa1.getDataNascimento());
        pessoaDTO.setCpf(pessoa1.getCpf());
        pessoaDTO.setNome(pessoa1.getNome());

        emailService.sendTemplateEmailCreate(pessoaDTO);
        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        List<Pessoa> pessoa = pessoaRepository.list();
        List<PessoaDTO> pessoasDTO = this.convertToDTOList(pessoa);
        return pessoasDTO;
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws RegraDeNegocioException, MessagingException {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setCpf(pessoaRecuperada.getCpf());
        pessoaDTO.setNome(pessoaRecuperada.getNome());
        pessoaDTO.setDataNascimento(pessoaRecuperada.getDataNascimento());

        emailService.sendTemplateEmailUpdate(pessoaDTO);
        return pessoaRecuperada;
    }
    public void delete(Integer id) throws RegraDeNegocioException, MessagingException {
        Pessoa pessoaRecuperada = getPessoa(id);

        PessoaDTO pessoaDTO = new PessoaDTO();
        pessoaDTO.setNome(pessoaRecuperada.getNome());
        emailService.sendTemplateEmailDelete(pessoaDTO);

        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }
    private PessoaDTO convertToDTO(Pessoa pessoa){
        PessoaDTO pessoaDTO = new PessoaDTO();

        pessoaDTO.setIdPessoa(pessoa.getIdPessoa());
        pessoaDTO.setDataNascimento(pessoa.getDataNascimento());
        pessoaDTO.setCpf(pessoa.getCpf());
        pessoaDTO.setNome(pessoa.getNome());

        return pessoaDTO;
    }

    private List<PessoaDTO> convertToDTOList(List<Pessoa> listaPessoas){
        return listaPessoas.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }

    public Pessoa findById(Integer idPessoa) throws RegraDeNegocioException {
        return pessoaRepository.findById(idPessoa);
    }
}
