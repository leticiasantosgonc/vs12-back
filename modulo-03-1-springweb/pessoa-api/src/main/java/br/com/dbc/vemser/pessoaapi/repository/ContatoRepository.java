package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*1*/, 1, TipoContato.RESIDENCIAL, "71987425886", "WhatsApp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*2*/, 2, TipoContato.RESIDENCIAL, "55997425862", "WhatsApp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*3*/, 3, TipoContato.COMERCIAL, "43982583826", "Loja"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*4*/, 4, TipoContato.COMERCIAL, "54992782586", "Loja"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet() /*5*/, 4, TipoContato.RESIDENCIAL, "51987992586", "Casa"));
    }
    public Contato create(Contato contato, int idPessoa) {
        contato.setIdContato(COUNTER.incrementAndGet());
        contato.setIdPessoa(idPessoa);
        listaContatos.add(contato);
        return contato;
    }
    public List<Contato> list() {
        return listaContatos;
    }
    public List<Contato> contatoPessoa (int idPessoa) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa() == idPessoa).collect(Collectors.toList());
    }
    public void delete(Contato contato) {
        listaContatos.remove(contato);
    }
}
