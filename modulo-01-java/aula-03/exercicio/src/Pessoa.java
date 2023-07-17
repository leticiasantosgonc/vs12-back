public class Pessoa {
    String nome;
    String sobrenome;
    String whatsapp;
    int idade;

    public void conversar(String pessoa){
        System.out.println(this.nome+" conversou com "+pessoa);
    }
    public void retornarNomeCompleto(){
        System.out.println(nome+" "+sobrenome);
    }

    public boolean ehMaiordeIdade(){
        if (this.idade > 18){
            System.out.println("É maior de idade!");
            return true;
        }else{
            System.out.println("Não é maior de idade!");
            return false;
        }
    }
    public void mandarWhatsApp (Pessoa pessoa, String mensagem){
        System.out.println(this.nome+ " enviou a mensagem: "+mensagem+" "+pessoa.nome);
    }


}
