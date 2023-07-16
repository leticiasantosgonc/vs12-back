import java.sql.Array;
import java.util.Scanner;

public class aula02 {
    //vs12-back - JAVA-Aprendendo sobre Array, Matriz e Laços
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int soma=0, media;

        System.out.println("---Atividade aula 01-Array---");
        for (int valores : array) {
            soma += valores;
        }
        media = (soma/ array.length);
        System.out.println("Soma: "+soma+"\nMédia: "+media);

       System.out.println("\n---Atividade aula 02-Matriz---");
       int total=0, aux=0;
       int[][] matriz =
               {{2, 4, 6}, //12
               {1, 3, 5}}; //9
       int[] auxArray = new int[matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                aux += matriz[i][j];
                total += matriz[i][j];
            }
            auxArray[i]=aux;
            System.out.println("Soma linha "+(i+1)+": "+aux);
            aux = 0;
        }
        System.out.println("Total: "+total);
        int sub=0;
        for (int valores : auxArray) {
            sub = valores - sub;
        }
        System.out.println("Subtração da 1 linha pela linha 2: "+sub);

        System.out.println("\n-----Atividade aula 03-Laços-----");
        int[] valor = new int[5];
        int mediaValores, totalValores=0;
        System.out.println("Informe os valores do vetor de 5 posições");
        for (int i = 0; i < valor.length; i++) {
            valor[i] = ler.nextInt();
            totalValores += valor[i]; //enquanto solicita os valores, já soma, acumulativo
        }
        mediaValores = totalValores/valor.length;
        System.out.println("Total do array: "+totalValores);
        System.out.println("Média dos valores do array: "+mediaValores);
    }
}
