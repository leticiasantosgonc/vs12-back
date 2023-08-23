package br.com.dbc.vemser.pessoa.apimongo.dtos;

import lombok.Data;

@Data
public class PessoaCreateDTO {
    private String nome;
    private String email;
}
