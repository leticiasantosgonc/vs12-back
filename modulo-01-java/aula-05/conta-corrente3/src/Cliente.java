import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String cpf;
    private List<Contato> contatos = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente(){

    }
    public Cliente(String nome, String cpf, Contato contato, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        contatos.add(contato);
        enderecos.add(endereco);
    }

    public void imprimirContatos(){
        for ( Contato contato : contatos) {
            contato.imprimirContato();
        }
    }
    public void imprimirEnderecos(){
        for (Endereco endereco : enderecos) {
            if (endereco == null){
                break;
            }
            endereco.imprimirEndereco();
        }
    }
    public void imprimirCliente(){
        System.out.println("Cliente: "+nome+" CPF: "+cpf);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public List<Contato> getContatos() {
        return contatos;
    }
    public void setContatos(Contato contato) {
        contatos.add(contato);
    }
    public List<Endereco> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(Endereco endereco) {
        enderecos.add(endereco);
    }
}
