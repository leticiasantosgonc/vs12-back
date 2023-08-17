package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @Schema(description = "tipo do contato", required = true, example = "Comercial")
    private TipoContato tipoContato;

    @NotNull
    @Size(max = 13)
    @Schema(description = "contato", required = true, example = "51980764599")
    private String numero;

    @NotEmpty
    @Schema(description = "descrição do contato", required = true, example = "loja")
    private String descricao;
}
