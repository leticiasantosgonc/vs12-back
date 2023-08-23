package br.com.dbc.vemser.pessoa.apimongo.repositories;

import br.com.dbc.vemser.pessoa.apimongo.entities.PessoaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends MongoRepository<PessoaEntity, String> {

}
