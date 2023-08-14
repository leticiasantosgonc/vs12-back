package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class PetDTO extends PetCreateDTO{

    @Schema(description = "Identificador único de pet")
    private Integer idPet;
}
