package br.com.dbc.vemser.pessoaapi.documentacao;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface ContatoControllerDoc {

        @Operation(summary = "Listar contatos", description = "Lista todas os contatos do banco")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        public ResponseEntity<List<ContatoDTO>> list();

        @Operation(summary = "Listar contato", description = "Lista pessoa pelo id")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna contato pelo id"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @GetMapping("/{idPessoa}")
        public ResponseEntity<List<ContatoDTO>> listByIdCliente(@PathVariable("idPessoa") Integer idPessoa);

        @Operation(summary = "Criar contato", description = "Cria contato")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna novo contato"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @PostMapping("/{idPessoa}")
        public ResponseEntity<ContatoDTO> create(@Valid @PathVariable("idPessoa") Integer idPessoa,
                                                 @Valid @RequestBody ContatoCreateDTO contato) throws RegraDeNegocioException;

        @Operation(summary = "Alterar contato", description = "Altera contato")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna contato alterado"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @PutMapping("/{id}")
        public ResponseEntity<Contato> update(@Valid @PathVariable("id") Integer id,
                                              @Valid @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException;

        @Operation(summary = "Deletar contato", description = "Deleta contato")
        @ApiResponses(
                value = {
                        @ApiResponse(responseCode = "200", description = "Retorna contato deletado"),
                        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
                }
        )
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> delete(@Valid @PathVariable("id") Long id) throws RegraDeNegocioException;

 }

