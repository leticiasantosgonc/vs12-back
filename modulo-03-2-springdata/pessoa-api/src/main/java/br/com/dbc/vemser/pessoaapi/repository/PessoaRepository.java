package br.com.dbc.vemser.pessoaapi.repository;

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

    @Query("SELECT DISTINCT p FROM PESSOA p LEFT JOIN FETCH p.enderecos")
    List<PessoaEntity> findPessoasComEnderecos();

    @Query("SELECT DISTINCT p FROM PESSOA p LEFT JOIN FETCH p.contatos")
    List<PessoaEntity> findPessoasComContatos();
}
