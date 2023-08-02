package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;
public class ContatoService {
    private ContatoRepository contatoRepository;
    public ContatoService(){
        contatoRepository = new ContatoRepository();
    }
    public List<Contato> list(){
        return contatoRepository.list();
    }
    public List<Contato> contatoPessoa(int idPessoa) {
        return contatoRepository.contatoPessoa(idPessoa);
    }
    public Contato create (Contato contato, int idPessoa){
        return contatoRepository.create(contato, idPessoa);
    }

    public Contato update (int idContato, Contato atualizaContato) throws Exception{
        Contato buscaContato = getContato(idContato);
        buscaContato.setNumero(atualizaContato.getNumero());
        return buscaContato;
    }
    private Contato getContato(int idContato) throws Exception{
        Contato buscaContato = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato() == idContato).findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado!"));
        return buscaContato;
    }

    public void delete(int idContato) throws Exception {
        Contato buscaContato = getContato(idContato);
        contatoRepository.delete(buscaContato);
    }
}
