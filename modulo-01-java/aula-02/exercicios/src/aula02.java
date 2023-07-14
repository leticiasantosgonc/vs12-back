import java.util.Scanner;

public class aula02 {
    //vs12-back - JAVA-Aprendendo sobre Array, Matriz e Laços
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[] array = {1, 2, 3};
        int soma, media;

        System.out.println("-----Atividade aula 01-Array-----");
//        soma = array[0] + array[1] + array[2];
//        media = (array[0] + array[1] + array[2])/3;
//        System.out.println("Soma: "+soma);
//        System.out.println("Média: "+media);

        System.out.println("-----Atividade aula 02-Matriz-----");
//        int somaLum, totalM, somaLdois, sub;
//        //int [][] matriz = new int[2][2];
//        int[][] matriz =
//                {{2, 4}, //6
//                {1, 3}}; //4
//        totalM = matriz[0][0]+matriz[1][0]+matriz[0][1]+matriz[1][1]; //10
//        somaLum = matriz[0][0]+matriz[0][1]; //6
//        somaLdois = matriz[1][0]+matriz[1][1]; //4
//        sub = (matriz[0][0]+matriz[0][1]) - (matriz[1][0]+matriz[1][1]); //2
//
//        System.out.println("Total: "+totalM);
//        System.out.println("Soma da 1 linha: "+somaLum);
//        System.out.println("Soma da 2 linha: "+somaLdois);
//        System.out.println("Subtração da 1 linha pela 2: "+sub);

        System.out.println("-----Atividade aula 03-Laços-----");
//        System.out.println("Print array com laço");
//        for (int i = 0; i < array.length; i++) {
//            System.out.println(array[i]);
//        }
//        System.out.println("Print matriz com laço");
//        for (int i = 0; i < matriz.length; i++) {
//            for (int j = 0; j < matriz[i].length; j++) {
//                System.out.println(matriz[i][j]);
//            }
//        }
//        System.out.println("Print array com Forech");
//        for (int numero: array) {
//            System.out.println(numero);
//        }

        //String nome = Integer.parseInt(sc.nextLine())
        int[] valor = new int[5];
        int mediaValores, totalValores=0;
        System.out.println("Informe os valores do vetor de 5 posições");
        for (int i = 0; i < valor.length; i++) {
            valor[i] = ler.nextInt();
            totalValores += valor[i]; //enquanto solicita os valores, já soma, acumulativo
        }
        mediaValores = totalValores/valor.length;
        System.out.println("O valor total do array é: "+totalValores);
        System.out.println("A média dos valores do array é: "+mediaValores);
    }
}
