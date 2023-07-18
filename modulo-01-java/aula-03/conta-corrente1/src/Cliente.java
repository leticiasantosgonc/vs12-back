public class Cliente {
    String nome;
    String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

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
}
