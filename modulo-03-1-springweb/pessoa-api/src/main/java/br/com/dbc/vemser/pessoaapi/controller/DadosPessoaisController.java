package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import br.com.dbc.vemser.pessoaapi.service.DadosPessoaisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dados-pessoais")
@RequiredArgsConstructor
public class DadosPessoaisController {
    // @Autowired
    private final DadosPessoaisService dadosPessoaisService;

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return dadosPessoaisService.getAll();
    }

    @PostMapping
    public DadosPessoaisDTO create(
            @RequestBody DadosPessoaisDTO dadosPessoaisDTO) throws Exception {
        return dadosPessoaisService.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO update(@PathVariable("cpf") String cpf,
                                   @RequestBody DadosPessoaisDTO dto) throws Exception {
        return dadosPessoaisService.put(cpf, dto);
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf){
        return dadosPessoaisService.get(cpf);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf){
        dadosPessoaisService.delete(cpf);
    }
}
