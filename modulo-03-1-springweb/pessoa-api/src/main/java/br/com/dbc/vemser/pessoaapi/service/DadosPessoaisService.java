package br.com.dbc.vemser.pessoaapi.service;


import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DadosPessoaisService {

    private final DadosPessoaisClient dadosPessoaisClient;

    public DadosPessoaisService(DadosPessoaisClient dadosPessoaisClient) {
        this.dadosPessoaisClient = dadosPessoaisClient;
    }

    public List<DadosPessoaisDTO> getAll() {
        return dadosPessoaisClient.getAll();
    }

    public DadosPessoaisDTO post(DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    public DadosPessoaisDTO put(String cpf, DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    public DadosPessoaisDTO get(String cpf) {
        return dadosPessoaisClient.get(cpf);
    }

    public void delete(String cpf) {
        dadosPessoaisClient.delete(cpf);
    }
}