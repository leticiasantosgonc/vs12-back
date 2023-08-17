package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

public interface EnderecoControllerDoc {

        @Operation(summary = "Listar enderecos", description = "Lista todas os enderecos do banco")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna a lista de enderecos"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @GetMapping
        public ResponseEntity<List<EnderecoDTO>> findAll();

//        @Operation(summary = "Listar enderecos", description = "Lista endereco pelo id")
//        @ApiResponses(
//                value = {
//                        @ApiResponse(responseCode = "200", description = "Retorna o endereco"),
//                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
//                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
//                }
//        )
//        @GetMapping("/{idEndereco}")
//        public EnderecoEntity findById(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException;

        @Operation(summary = "Criar endereco", description = "Cria endereco")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna novo endereco"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @PostMapping("/{idPessoa}")
        public ResponseEntity<EnderecoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                                  @Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException;

        @Operation(summary = "Alterar endereco", description = "Altera endereco")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna endereco alterado"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @PutMapping("/{idEndereco}")
        public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") @Positive Integer idEndereco,
                                                  @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException;

        @Operation(summary = "Deletar endereco", description = "Deleta endereco")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna endereco deletado"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @DeleteMapping("/{idEndereco}")
        public ResponseEntity<Void> delete(@PathVariable("idEndereco") Integer idEndereco) throws RegraDeNegocioException;
}
