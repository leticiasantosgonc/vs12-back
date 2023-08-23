package br.com.dbc.vemser.pessoa.apimongo.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;


@Data
@Document
public class PessoaEntity {
    @Id
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private String nome;
    private String email;
}
