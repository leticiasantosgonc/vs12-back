public class Main {
    public static void main(String[] args) {
       Pessoa pessoa1 = new Pessoa();
       Pessoa pessoa2 = new Pessoa();

        pessoa1.nome = "Letícia";
        pessoa1.sobrenome = "Santos";
        pessoa1.idade = 26;
        pessoa1.whatsapp = "940503789";

        pessoa2.nome = "Vitor";
        pessoa2.sobrenome = "Nunes";
        pessoa2.idade = 27;
        pessoa2.whatsapp = "980506099";


        pessoa1.conversar(pessoa2.nome);
        pessoa1.retornarNomeCompleto();
        pessoa1.ehMaiordeIdade();
        pessoa1.mandarWhatsApp(pessoa2,"olá");

//        int idadeTeste = 14;
//        String mensagem = idadeTeste > 18 ? "Maior de idade" : "Menor de idade";
//        System.out.println(mensagem);
    }
}