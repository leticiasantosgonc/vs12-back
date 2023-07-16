public class Exercicio05 {
    /* Receba uma matriz 10x3 onde contém 10 itens de supermercado (linhas) que foram
    cotados em 3 mercados diferentes (colunas). Com esses dados, escreva um algoritmo
    que calcule qual é o mercado mais barato para se comprar considerando todos os
    preços listados.*/
    public static void main(String[] args) {
        float auxTotal=0;
        float[] totalMerc = new float[3];
        float[][] precoProd =
                {{1, 1, 2},
                {12, 4, 4},
                {4, 3, 3},
                {1, 11, 3},
                {6, 7, 6},
                {9, 10, 10},
                {6, 5, 6},
                {5, 2, 4},
                {9, 9, 8},
                {3, 2, 6}};

        for (int i = 0; i < precoProd.length; i++) {
            for (int j = 0; j < precoProd[i].length; j++) {
                switch (j){
                    case 0:
                        totalMerc[j] += precoProd[i][j];
                        break;
                    case 1:
                        totalMerc[j] += precoProd[i][j];
                        break;
                    case 2:
                        totalMerc[j] += precoProd[i][j];
                        break;
                }
            }
        }
        for (int i = 0; i < totalMerc.length; i++) {
            if(i == 0){
                auxTotal = totalMerc[i];
            }
            if(auxTotal > totalMerc[i]){
                auxTotal = totalMerc[i];
            }
        }
        System.out.println("Mercado mais barato é:"+auxTotal);
    }
}
