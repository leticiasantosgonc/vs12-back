package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void delete(Long id) throws Exception {
        enderecoRepository.delete(id);
    }

    public Endereco create(Integer idPessoa, Endereco endereco) {
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco endereco) throws Exception {
        return enderecoRepository.update(id, endereco);
    }


    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco findById(Integer idEndereco) throws Exception {
        return enderecoRepository.findById(idEndereco);
    }
}
