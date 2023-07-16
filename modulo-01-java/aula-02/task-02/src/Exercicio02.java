import java.util.Scanner;

public class Exercicio02 {
    /*
     Você informará um número e quando alguém for tentar adivinhá-lo o programa deverá informar se
     acertou o número ou se errou, se errou o programa deverá apresentar uma das
     seguintes frases: O número a ser encontrado é menor do que você digitou ou O
     número a ser encontrado é maior do que você digitou. OBS: o programa deve parar
      quando a pessoa acertar o número adivinhado. */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int num, acertaNum;

        System.out.println("Informe o número: ");
        num = Integer.parseInt(ler.nextLine());

        do{
            System.out.println("Informe o número: ");
            acertaNum = Integer.parseInt(ler.nextLine());

            if (acertaNum > num){
                System.out.println("O número a ser encontrado é menor do que você digitou");
            } else if (acertaNum < num){
                System.out.println("O número a ser encontrado é maior do que você digitou");
            } else {
                System.out.println("Você acertou!");
            }

        }while (num != acertaNum);
    }
}
