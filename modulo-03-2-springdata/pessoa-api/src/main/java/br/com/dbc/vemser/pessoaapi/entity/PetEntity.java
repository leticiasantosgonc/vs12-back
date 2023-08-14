package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ", sequenceName = "seq_pet2", allocationSize = 1)
    @Column(name = "id_pet")
    private Integer idPet;

    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;

    @Column(name = "nome")
    private String nome;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoPet tipo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet")
    private PessoaEntity pet;


}
