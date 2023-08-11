package br.com.dbc.vemser.pessoaapi;

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
}

