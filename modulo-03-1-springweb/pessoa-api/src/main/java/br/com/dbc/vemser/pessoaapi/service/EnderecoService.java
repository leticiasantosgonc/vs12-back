package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService) {
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdEndereco(int idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    public List<Endereco> listByIdPessoa(int idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public void delete(int idEndereco) throws Exception {
        enderecoRepository.delete(idEndereco);
    }

    public Endereco create(int idPessoa, Endereco endereco) throws Exception {
        Pessoa pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
        endereco.setIdPessoa(pessoa.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco update(int idEndereco, Endereco endereco) throws Exception {
        return enderecoRepository.update(idEndereco, endereco);
    }


}
