package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;

    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
    }

    public void delete(Long id) throws Exception {
        contatoRepository.delete(id);
    }

    public Contato create(Integer idPessoa, Contato contato) throws Exception {
        Pessoa pessoa = pessoaService.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        contato.setIdPessoa(pessoa.getIdPessoa());
        return contatoRepository.create(contato);
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
