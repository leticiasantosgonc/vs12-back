package br.com.dbc.vemser.pessoa.apimongo.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class PessoaDTO {
    @Id
    private String id;
    private String nome;
    private String email;
}
