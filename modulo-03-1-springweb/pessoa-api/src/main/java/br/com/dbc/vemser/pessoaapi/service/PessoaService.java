package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class PessoaService {

    // @Autowired
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException{
        Pessoa entity = objectMapper.convertValue(pessoa, Pessoa.class);

        Pessoa pessoaAdicionada = pessoaRepository.create(entity);
        PessoaDTO pessoaDTO = convertToDTO(pessoaAdicionada);

        return pessoaDTO;
    }

    public List<PessoaDTO> list(){
        List<Pessoa> pessoa = pessoaRepository.list();
        List<PessoaDTO> pessoasDTO = this.convertToDTOList(pessoa);
        return pessoasDTO;
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar) throws Exception {
        Pessoa pessoaRecuperada = getPessoa(id);

        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());

        return pessoaRecuperada;
    }

    public void delete(Integer id) throws RegraDeNegocioException{
        Pessoa pessoaRecuperada = getPessoa(id);
        pessoaRepository.delete(pessoaRecuperada);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    private Pessoa getPessoa(Integer id) throws RegraDeNegocioException{
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada!"));
        return pessoaRecuperada;
    }

    private PessoaDTO convertToDTO(Pessoa pessoa){
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);

        return pessoaDTO;
    }

    private List<PessoaDTO> convertToDTOList(List<Pessoa> listaPessoas){
        return listaPessoas.stream()
                .map(this::convertToDTO).collect(Collectors.toList());
    }
}
