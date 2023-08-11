package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "ENDERECO_PESSOA")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_SEQ")
    @SequenceGenerator(name = "ENDERECO_SEQ", sequenceName = "seq_endereco2", allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    @Column (name = "id_pessoa")
    private Integer idPessoa;

    @Column (name = "tipo")
    private TipoEndereco tipo;

    @Column (name = "logradouro")
    private String logradouro;

    @Column (name = "numero")
    private Integer numero;

    @Column (name = "complemento")
    private String complemento;

    @Column (name = "cep")
    private String cep;

    @Column (name = "cidade")
    private String cidade;

    @Column (name = "estado")
    private String estado;

    @Column (name = "pais")
    private String pais;

}
