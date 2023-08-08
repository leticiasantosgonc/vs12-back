package br.com.dbc.vemser.pessoaapi;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

@SpringBootTest
class PessoaApiApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() throws MessagingException {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome("Letícia");
		pessoaDTO.setIdPessoa(1);
		emailService.sendTemplateEmailCreate(pessoaDTO);
	}
	@Test
	void contextLoadsUpdate() throws MessagingException {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome("Letícia");
		emailService.sendTemplateEmailUpdate(pessoaDTO);
	}

	@Test
	void contextLoadsDelete() throws MessagingException {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome("Letícia");
		emailService.sendTemplateEmailDelete(pessoaDTO);
	}

	@Test
	void contextLoadsDeleteContato() throws MessagingException {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setNumero("51980506745");
		emailService.sendTemplateEmailDeleteContato(contatoDTO);
	}

	@Test
	void contextLoadsUpdateContato() throws MessagingException {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setNumero("51980506745");
		emailService.sendTemplateEmailUpdateContato(contatoDTO);
	}

	@Test
	void contextLoadsCreateContato() throws MessagingException {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setNumero("51980506745");
		emailService.sendTemplateEmailCreateContato(contatoDTO);
	}

	@Test
	void contextLoadsCreateEndereco() throws MessagingException {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setLogradouro("Rua Paraguassu");
		enderecoDTO.setNumero(787);
		enderecoDTO.setCidade("Gramado");
		enderecoDTO.setEstado("RS");
		emailService.sendTemplateEmailCreateEndereco(enderecoDTO);
	}
	@Test
	void contextLoadsDeleteEndereco() throws MessagingException {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setLogradouro("Rua Paraguassu");
		enderecoDTO.setNumero(787);
		enderecoDTO.setCidade("Gramado");
		enderecoDTO.setEstado("RS");
		emailService.sendTemplateEmailDeleteEndereco(enderecoDTO);
	}
	@Test
	void contextLoadsUpdateEndereco() throws MessagingException {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setLogradouro("Rua Paraguassu");
		enderecoDTO.setNumero(787);
		enderecoDTO.setCidade("Gramado");
		enderecoDTO.setEstado("RS");
		emailService.sendTemplateEmailUpdateEndereco(enderecoDTO);
	}

}

