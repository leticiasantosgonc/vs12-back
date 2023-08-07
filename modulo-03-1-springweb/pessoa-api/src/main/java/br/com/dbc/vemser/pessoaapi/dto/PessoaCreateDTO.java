package br.com.dbc.vemser.pessoaapi.dto;

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
  private String nome;

  @NotNull
  private LocalDate dataNascimento;

  @CPF
  @NotNull
  private String cpf;
}
