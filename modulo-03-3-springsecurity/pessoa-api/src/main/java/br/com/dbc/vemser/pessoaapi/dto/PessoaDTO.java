package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
public class PessoaDTO extends PessoaCreateDTO {
  @Schema(description = "Identificador único da pessoa")
  private Integer idPessoa;
}
