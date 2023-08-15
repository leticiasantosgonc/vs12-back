package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeIgnoreCaseContaining(String nome);
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

//    @Query("SELECT NEW br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO(" +
//            "pe.idPessoa, " +
//            "pe.nome, " +
//            "pe.dataNascimento, " +
//            "pe.cpf, " +
//            "pe.email, " +
//            "c.idContato, " +
//            "c.tipoContato, " +
//            "c.numero, " +
//            "p.idPet, " +
//            "p.nome AS petNome, " +
//            "e.idEndereco, " +
//            "e.tipo, " +
//            "e.logradouro, " +
//            "e.numero, " +
//            "e.complemento, " +
//            "e.cep, " +
//            "e.cidade, " +
//            "e.estado, " +
//            "e.pais) " +
//            "FROM PessoaEntity pe " +
//            "LEFT JOIN pe.contatos c " +
//            "LEFT JOIN pe.pets p " +
//            "LEFT JOIN pe.enderecos e " +
//            "WHERE pe.idPessoa = :idPessoa")
//    PessoaCompletoDTO findPessoaCompleto(Integer idPessoa);
}
