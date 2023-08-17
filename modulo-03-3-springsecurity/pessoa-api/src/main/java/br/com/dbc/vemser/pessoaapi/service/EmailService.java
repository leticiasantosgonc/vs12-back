package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final Configuration fmConfiguration;

    @Value("${spring.mail.username}") // Injete o valor da propriedade
    private String emailUsername;
    private String from = "Letícia Santos <leticia.goncalves@dbccompany.com.br>";

    public void sendTemplateEmailCreate(PessoaDTO pessoaDTO) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

       try {
           helper.setFrom(from);
           helper.setTo("leticiasantosgonc@gmail.com");
           helper.setSubject("Email Create Pessoa");
           String content = getContentFromTemplateCreate(pessoaDTO);

           helper.setText(content, true);

           mailSender.send(helper.getMimeMessage());
       }catch (IOException | TemplateException e){
           e.printStackTrace();
       }
    }
    public void sendTemplateEmailCreateContato(ContatoDTO contatoDTO) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Create Contato");
            String content = getContentFromTemplateCreateContato(contatoDTO);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailCreateEndereco(EnderecoDTO enderecoDTO) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Create Endereco");
            String content = getContentFromTemplateCreateEndereco(enderecoDTO);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailUpdate(PessoaDTO pessoa) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Update Pessoa");
            String content = getContentFromTemplateUpdate(pessoa);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailUpdateContato(ContatoDTO contato) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Update Contato");
            String content = getContentFromTemplateUpdateContato(contato);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailUpdateEndereco(EnderecoDTO enderecoDTO) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Update Endereco");
            String content = getContentFromTemplateUpdateEndereco(enderecoDTO);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailDelete(PessoaDTO pessoa) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Delete Pessoa");
            String content = getContentFromTemplateDelete(pessoa);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailDeleteContato(ContatoDTO contato) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Delete Contato");
            String content = getContentFromTemplateDeleteContato(contato);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public void sendTemplateEmailDeleteEndereco(EnderecoDTO enderecoDTO) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            helper.setFrom(from);
            helper.setTo("leticiasantosgonc@gmail.com");
            helper.setSubject("Email Delete Endereco");
            String content = getContentFromTemplateDeleteEndereco(enderecoDTO);

            helper.setText(content, true);

            mailSender.send(helper.getMimeMessage());
        }catch (IOException | TemplateException e){
            e.printStackTrace();
        }
    }

    public String getContentFromTemplateCreate(PessoaDTO pessoaDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", String.valueOf(pessoaDTO.getIdPessoa()));
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }
    public String getContentFromTemplateCreateContato(ContatoDTO contatoDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("numero", contatoDTO.getNumero());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template4-Contato.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }

    public String getContentFromTemplateCreateEndereco(EnderecoDTO enderecoDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("logradouro", enderecoDTO.getLogradouro());
        dados.put("numero", String.valueOf(enderecoDTO.getNumero()));
        dados.put("cidade", enderecoDTO.getCidade());
        dados.put("estado", enderecoDTO.getEstado());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template7-Endereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }

    public String getContentFromTemplateUpdate(PessoaDTO pessoaDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template2.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }

    public String getContentFromTemplateUpdateContato(ContatoDTO contatoDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("numero", contatoDTO.getNumero());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template5-Contato.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }

    public String getContentFromTemplateUpdateEndereco(EnderecoDTO enderecoDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("logradouro", enderecoDTO.getLogradouro());
        dados.put("numero", String.valueOf(enderecoDTO.getNumero()));
        dados.put("cidade", enderecoDTO.getCidade());
        dados.put("estado", enderecoDTO.getEstado());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template8-Endereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }
    public String getContentFromTemplateDelete(PessoaDTO pessoaDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template3.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }

    public String getContentFromTemplateDeleteContato(ContatoDTO contatoDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("numero", contatoDTO.getNumero());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template6-Contato.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }

    public String getContentFromTemplateDeleteEndereco(EnderecoDTO enderecoDTO) throws IOException, TemplateException, MessagingException {
        Map<String, String> dados = new HashMap<>();
        dados.put("logradouro", enderecoDTO.getLogradouro());
        dados.put("numero", String.valueOf(enderecoDTO.getNumero()));
        dados.put("cidade", enderecoDTO.getCidade());
        dados.put("estado", enderecoDTO.getEstado());
        dados.put("email", emailUsername);
        Template template = fmConfiguration.getTemplate("email-template9-Endereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);

        return html;
    }
}
