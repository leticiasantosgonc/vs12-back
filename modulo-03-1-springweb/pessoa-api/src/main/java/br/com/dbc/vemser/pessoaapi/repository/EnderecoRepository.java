package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    public static List<Endereco> enderecosList = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();
    private final PessoaRepository pessoaRepository;

    public EnderecoRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;

        enderecosList.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "Avenida Rudá", 1, "Sala", "95555-000", "Osório", "RS", "Brasil"));
        enderecosList.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "Rua Imbituba", 266, "Apto", "95888-000", "Porto Alegre", "RS", "Brasil"));
        enderecosList.add(new Endereco(COUNTER.incrementAndGet(), 4, TipoEndereco.RESIDENCIAL, "Rua Sepetiba", 764, "Casa", "35258-000", "Capão da Canoa", "RS", "Brasil"));
    }

    public List<Endereco> list() {
        return enderecosList;
    }

    public List<Endereco> listByIdEndereco(int idEndereco) {
        return enderecosList.stream()
                .filter(x -> x.getIdEndereco() == idEndereco)
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(int idPessoa) {
        return enderecosList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public void delete(int idEndereco) throws Exception {
        Endereco endereco = enderecosList.stream()
                .filter(x -> x.getIdEndereco() == idEndereco)
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não encontrado"));
        enderecosList.remove(endereco);
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        enderecosList.add(endereco);
        return endereco;
    }

    public Endereco update(int idEndereco, Endereco endereco) throws Exception {
        Endereco enderecoAlterado = enderecosList.stream()
                .filter(x -> x.getIdEndereco() == idEndereco)
                .findFirst()
                .orElseThrow(() -> new Exception("Endereco não econtrado"));
        enderecoAlterado.setTipo(endereco.getTipo());
        enderecoAlterado.setLogradouro(endereco.getLogradouro());
        enderecoAlterado.setNumero(endereco.getNumero());
        enderecoAlterado.setComplemento(endereco.getComplemento());
        enderecoAlterado.setCep(endereco.getCep());
        enderecoAlterado.setCidade(endereco.getCidade());
        enderecoAlterado.setEstado(endereco.getEstado());
        enderecoAlterado.setPais(endereco.getPais());
        return enderecoAlterado;
    }
}
