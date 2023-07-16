import java.util.Scanner;

public class Exercicio04 {
    /*Faça um programa que leia uma matriz de 5x4 inteiros contendo as seguintes informações do tipo inteiro:
    a. Primeira coluna: número da matrícula b. Segunda coluna: media das provas
    c. Terceira coluna: média dos trabalhos d. Quarta coluna: nota final
    Elabore um programa que: a. Leia as 3 primeiras informações de cada aluno
    b. Calcule a nota final = (media das provas * 0,6 + media dos trabalhos * 0,4)
    c. Imprima a matrícula que obteve a m*/
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[][] alunos = new int[5][4];
        int[] notaFinal = new int[5];
        int maiorNotaFinal=0, matMaiorNota=0, auxMedia=0;

        for (int i = 0; i < alunos.length; i++) {
            for (int j = 0; j < alunos[i].length; j++) {

                switch (j) {
                    case 0:
                        System.out.println("Informe a matricula: ");
                        alunos[i][j] = Integer.parseInt(ler.nextLine());
                        break;

                    case 1:
                        System.out.println("Informe a média das provas: ");
                        alunos[i][j] = Integer.parseInt(ler.nextLine());
                        break;

                    case 2:
                        System.out.println("Informe a média dos trabalhos: ");
                        alunos[i][j] = Integer.parseInt(ler.nextLine());
                        break;

                    case 3:
                        notaFinal[i] = (int) ((alunos[i][1] * 0.6) + (alunos[i][2] * 0.4));
                        auxMedia += notaFinal[i];
                        if(maiorNotaFinal < notaFinal[i]){
                            maiorNotaFinal = notaFinal[i];
                            matMaiorNota = alunos[i][0];
                        }
                        break;
                }
            }
        }
        System.out.println("Matricula com maior nota final: "+matMaiorNota);
        System.out.println("Média das notas finais: "+(auxMedia/alunos.length));
    }
}
