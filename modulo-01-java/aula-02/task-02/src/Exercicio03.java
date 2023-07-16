import java.util.Scanner;

public class Exercicio03 {
    /*Desenvolver um algoritmo que peça nome, altura, idade, peso dos jogadores de
    basquete, enquanto o nome do jogador for diferente da palavra SAIR o programa
    deverá pedir essas informações, após cadastrados deverá aparecer as seguintes
    informações: Quantidade de jogadores cadastrados; Altura do maior Jogador;
    Jogador mais velho; Jogador mais pesado; Média das alturas jogadores*/

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nome = "", nomeMaisAlto=null, nomeMaisVelho = null, nomeMaisPesado = null;
        int qtdJogador=0, idade, maisVelho=0;
        float altura, peso, maisAlto=0, maisPesado=0, mediaAltura=0, auxMedia=0;

        while (!nome.equals("sair")) {
            System.out.println("Informe o nome do jogador: ");
            nome = ler.nextLine();
            nome = nome.toLowerCase();

            if (nome.equals("sair")) {
               break;
            }

            System.out.println("Informe a altura: ");
            altura = Float.parseFloat(ler.nextLine());
            System.out.println("Informe a idade: ");
            idade = Integer.parseInt(ler.nextLine());
            System.out.println("Informe o peso: ");
            peso = Float.parseFloat(ler.nextLine());

            qtdJogador++;

            if (maisAlto < altura) {
                maisAlto = altura;
                nomeMaisAlto = nome;
            }
            if (maisVelho < idade) {
                maisVelho = idade;
                nomeMaisVelho = nome;
            }
            if (maisPesado < peso) {
                maisPesado = peso;
                nomeMaisPesado = nome;
            }

            auxMedia += altura;
            mediaAltura = auxMedia / qtdJogador;
        }
        System.out.println("Quantidade de jogadores: "+qtdJogador);
        System.out.println("Mais alto: "+maisAlto+" Jogador: "+nomeMaisAlto);
        System.out.println("Mais velho: "+maisVelho+" Jogador: "+nomeMaisVelho);
        System.out.println("Mais pesaso: "+maisPesado+ " Jogador: "+nomeMaisPesado);
        System.out.println("Altura média dos jogadores: "+mediaAltura);
    }
}
