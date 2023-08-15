package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query("SELECT ep FROM br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity ep WHERE ep.pais = ?1" )
    List<EnderecoEntity> findEnderecoByPais(String pais);

    @Query("SELECT endereco FROM ENDERECO_PESSOA endereco JOIN endereco.pessoas pessoa WHERE pessoa.idPessoa = ?1")
    List<EnderecoEntity> findEnderecoByPessoa(Integer idPessoa);

}
