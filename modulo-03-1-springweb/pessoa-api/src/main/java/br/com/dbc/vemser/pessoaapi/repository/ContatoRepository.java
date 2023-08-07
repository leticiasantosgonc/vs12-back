package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    public static List<Contato> contatosList = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaRepository pessoaRepository;

    public ContatoRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

        contatosList.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.COMERCIAL, "048995876566", "whatsapp"));
        contatosList.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL, "04833545655", "casa"));
        contatosList.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.COMERCIAL, "051998654789", "trabalho"));
    }

    public void delete(Long id) throws RegraDeNegocioException {
        Contato contato = contatosList.stream()
                .filter(x -> x.getIdContato() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrado"));
        contatosList.remove(contato);
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contatosList.add(contato);
        return contato;
    }

    public Contato update(Integer id, Contato contato) throws RegraDeNegocioException {
        Contato contatoAlterado = contatosList.stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não econtrada"));
        contatoAlterado.setTipoContato(contato.getTipoContato());
        contatoAlterado.setNumero(contato.getNumero());
        contatoAlterado.setDescricao(contato.getDescricao());
        return contatoAlterado;
    }


    public List<Contato> list() {
        return contatosList;
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatosList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
