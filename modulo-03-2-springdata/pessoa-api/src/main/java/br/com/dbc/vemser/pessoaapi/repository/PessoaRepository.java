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


    @Query(value = "SELECT new br.com.dbc.vemser.pessoaapi.entity.PessoaCompletoDTO(" +
            "pe.nome, "+
            "pe.dataNascimento, "+
            "pe.cpf, "+
            "pe.email, "+
            "c.idContato, "+
            "c.tipoContato, "+
            "c.numero, "+
            "c.descricao, "+
            "p.nome, "+
            "p.tipo, "+
            "e.idEndereco, "+
            "e.tipo, "+
            "e.logradouro, "+
            "e.numero, "+
            "e.complemento, "+
            "e.cep, "+
            "e.cidade, "+
            "e.estado, "+
            "e.pais, "+
            "FROM PessoaEntity pe\n" +
            "JOIN pe.ContatoEntity c\n" +
            "JOIN pe.PetEntity p\n" +
            "LEFT JOIN pe.EnderecoEntity e\n" +
            "WHERE PessoaEntity.idPessoa = ?1)")
    PessoaCompletoDTO findPessoaCompleto(Integer idPessoa);


}
