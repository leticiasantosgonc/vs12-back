import java.util.Scanner;

public class Exercicio06 {
    /* Desenvolver um vetor que contenha 10 números (não será pedido ao usuário). Com esse vetor faça:
        a. Peça um número ao usuário e armazene-o;
        b. Imprima quantas vezes o número digitado existe no vetor;
        c. Imprima quantos números menores que o número digitado;
        d. Imprima quantos números maiores que o número digitado*/
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int[] numeros = {1, 10, 3, 4, 5, 10, 7, 8, 9, 10};
        int auxNum, cont=0;
        int qtdMenor=0, qtdMaior=0;

        System.out.println("Informe um número para procurar");
        auxNum = Integer.parseInt(ler.nextLine());

        for (int i = 0; i < numeros.length; i++) {
            if(auxNum == numeros[i]){
                cont++;
            }
            if (auxNum > numeros[i]){
                qtdMenor++;
            }
            if (auxNum < numeros[i]){
                qtdMaior++;
            }
        }
        System.out.println("O número "+auxNum+" aparece "+cont+" vezes");
        System.out.println("Quantidade de números menores que o número informado: "+qtdMenor);
        System.out.println("Quantidade de números maiores que o número informado: "+qtdMaior);
    }
}
