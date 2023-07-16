import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicio01 {
    /*Elabore um programa para uma papelaria que leia o nome e o valor de um produto.
    Em seguida, faça uma lista de 1 a 10 unidades do produto, sendo que o desconto de
    uma unidade desse produto seja de 5% e de 2 seja 10% de 3 = 15% etc... Até
    alcançar os 50% de desconto */

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        DecimalFormat df =  new DecimalFormat("0.00"); //arruma o print do valor final

        String nomeProd;
        float valorProd, descFinal = 0, valorFinal = 0;

        //= Integer.parseInt(ler.nextLine());
        System.out.println("Informe o nome do produto:");
        nomeProd = ler.nextLine();
        System.out.println("Informe o valor do produto:");
        valorProd = Float.parseFloat(ler.nextLine());

        int desc = 5;
        for (int i = 0; i < 10; i++) {
            float auxDesc;
            auxDesc = (valorProd * desc) / 100;
            descFinal = valorProd - auxDesc;
            valorFinal = descFinal*(i+1);
            System.out.println((i+1)+" x"+" R$ "+df.format(descFinal)+" = "+df.format(valorFinal));
            desc += 5;
            descFinal = 0;
            auxDesc = 0;
        }
    }
}
