package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EnderecoCreateDTO {
    @Schema(description = "id da pessoa", required = true, example = "1")
    private Integer idPessoa;

    @NotNull
    @Schema(description = "tipo do endereco", required = true, example = "Residencial")
    private TipoEndereco tipo;

    @NotNull
    @Size(max = 250)
    @Schema(description = "nome da rua", required = true, example = "Avenida Paraguassu")
    private String logradouro;

    @NotNull
    @Schema(description = "numero da residência", required = true, example = "679")
    private Integer numero;

    @Schema(description = "complemento", required = true, example = "casa")
    private String complemento;

    @NotEmpty
    @Size(max = 8)
    @Schema(description = "cep da cidade", required = true, example = "34955000")
    private String cep;

    @NotEmpty
    @Size(max = 250)
    @Schema(description = "nome da cidade", required = true, example = "Porto Alegre")
    private String cidade;

    @NotNull
    @Schema(description = "nome do estado", required = true, example = "RS")
    private String estado;

    @NotNull
    @Schema(description = "nome do pais", required = true, example = "Brasil")
    private String pais;
}
