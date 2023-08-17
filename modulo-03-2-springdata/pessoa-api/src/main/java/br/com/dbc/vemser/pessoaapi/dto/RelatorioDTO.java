package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

@Data
public class RelatorioDTO {

    private Integer id;
    private String nome;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String nomePet;

    public RelatorioDTO(Integer id, String nome, String email, String numero, String cep, String cidade, String estado, String pais, String nomePet) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.nomePet = nomePet;
    }
}
