package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PetCreateDTO {

    @Schema(description = "Nome do pet")
    @NotBlank
    private String nome;

    private TipoPet tipo;
}
