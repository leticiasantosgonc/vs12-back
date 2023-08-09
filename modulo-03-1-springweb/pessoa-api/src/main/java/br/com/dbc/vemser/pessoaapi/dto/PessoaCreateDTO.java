package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {
  @NotEmpty
  @NotBlank
  @Schema(description = "Nome da Pessoa", required = true, example = "Pedro José")
  private String nome;

  @NotNull
  @Schema(description = "Data de nascimento", required = true, example = "06/10/1996")
  private LocalDate dataNascimento;

  @CPF
  @NotNull
  @Schema(description = "Cpf da pessoa", required = true, example = "45619835067")
  private String cpf;
}
