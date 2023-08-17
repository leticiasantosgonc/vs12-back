package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletoDTO;
import br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeIgnoreCaseContaining(String nome);
    List<PessoaEntity> findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate dataInicial, LocalDate dataFinal);

    @Query("SELECT NEW br.com.dbc.vemser.pessoaapi.dto.RelatorioDTO("+
            "p.id, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "e.cep, " +
            "e.cidade, " +
            "e.estado, " +
            "e.pais, " +
            "pet.nome)" +
            "FROM PESSOA p " +
            "LEFT JOIN p.contatos c " +
            "LEFT JOIN p.enderecos e " +
            "LEFT JOIN p.pets pet ")
    Set<RelatorioDTO> createRelatorioDTO();
}
