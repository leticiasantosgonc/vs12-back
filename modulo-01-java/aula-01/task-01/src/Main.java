import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        //variáveis exercício 1
        String nome, cid, uf;
        int id;
        //variáveis exercício 2
        int op;
        //variáveis exercício 3
        String palavra;
        //variáveis exercício 5
        float altura, base, area;
        //variáveis exercício 6
        int total, nulos, brancos, validos;
        float percBrancos, percNulos, percValidos;
        //variáveis exercício 7
        String cod;
        float totalCompra = 0;
        int qtd;
        //variáveis exercício 8
        float salarioAntigo = 0, salarioAtual = 0;
        String cargo;
        //variáveis exercicio 9

        //variáveis exercicio 10
        float nota1 = 0, nota2 = 0, nota3 = 0, me = 0, ma =0;
        String codAluno;

                System.out.println("-----Exercício 01-----");
        /*Desenvolver um algoritmo que exiba as seguintes informações, porém o que está
        sublinhado será solicitado ao usuário (por meio do Scanner).
        EXEMPLO: Olá seu nome é João, você tem 16 anos, é da cidade de Florianópolis, situada no estado de Santa Catarina.*/

        System.out.println("Informe seu nome:");
        nome = leitura.nextLine();
        System.out.println("Informe sua idade:");
        id = leitura.nextInt();
        leitura.nextLine();
        System.out.println("Informe sua cidade:");
        cid = leitura.nextLine();
        System.out.println("Informe seu estado:");
        uf = leitura.nextLine();

        System.out.println("Olá seu nome é "+nome+", você tem "+id+" anos, é da cidade de "+cid+", situada no estado de "+uf);
        System.out.println("-----Exercício 02-----");
        /* Criar um algoritmo onde o usuário possa escolher o estado e haverá uma lista com determinadas
        cidades daquele aquele estado. O usuário poderá escolher uma cidade, após escolher a cidade
        desejada irá aparecer dados sobre a mesma (população, principal festa, IDH...).
        OBS: Deverá conter 3 estados e para cada estado 2 cidades */

        System.out.println("Menu UFs\n1-RS\n2-SC\n3-PR");
        op = leitura.nextInt();

        switch (op){
            case 1: //RS
                System.out.println("Cidades do RS\n1-Porto Alegre\n2-Capão da Canoa");
                op = leitura.nextInt();
                if(op == 1){
                    System.out.println("Porto Alegre\nPopulação: 1,5 milhão\nPrincipal festa: Jogo do Internacional\nIDH: 0,805");
                } else {
                    System.out.println("Capão da Canoa\nPopulação: 55 mil\nPrincipal festa: Capão Geek Fest\nIDH: 0,743,");
                }
                break;
            case 2: //SC
                System.out.println("Cidades do SC\n1-Florianópolis\n2-Chapecó");
                op = leitura.nextInt();
                if(op == 1){
                    System.out.println("Florianópolis\nPopulação: 508 mil\nPrincipal festa: Planeta Atlântida\nIDH: 0,847");
                } else {
                    System.out.println("Chapecó\nPopulação: 224 mil\nPrincipal festa: Festa do Carvão\nIDH: 0,848 ");
                }
                break;
            case 3: //PR
                System.out.println("Cidades do PR\n1-Curitiba\n2-Ponta Grossa");
                op = leitura.nextInt();
                if(op == 1){
                    System.out.println("Curitiba\nPopulação: 1,8 milhão\nPrincipal festa: Festa das Orquideas\nIDH: 0,823");
                } else {
                    System.out.println("Ponta Grossa\nPopulação: 355 mil\nPrincipal festa: Festa do Peixe\nIDH: 0,763,");
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        leitura.nextLine(); // limpando o buffer
        System.out.println("-----Exercício 03----");
        /*Criar um tradutor que traduza as seguintes palavras de inglês para português e de português para inglês.
        Cachorro Dog - Tempo Time - Amor Love - Cidade City
        Feliz Happy - Triste Sad - Deveria Shoul*/
        System.out.println("Informe a palavra que deseja traduzir:");
        palavra = leitura.nextLine();
        palavra = palavra.toLowerCase();
        if (palavra.equals("cachorro")){
            System.out.println("Dog");
        } else if(palavra.equals("dog")){
            System.out.println("Cachorro");
        } else if(palavra.equals("tempo")){
            System.out.println("Time");
        }else if(palavra.equals("time")){
            System.out.println("Tempo");
        }else if(palavra.equals("amor")){
            System.out.println("Love");
        }else if(palavra.equals("love")){
            System.out.println("Amor");
        }else if(palavra.equals("cidade")){
            System.out.println("City");
        }else if(palavra.equals("city")){
            System.out.println("Cidade");
        } else if(palavra.equals("feliz")){
            System.out.println("Happy");
        } else if(palavra.equals("happy")){
            System.out.println("Feliz");
        } else if(palavra.equals("triste")){
            System.out.println("Sad");
        } else if(palavra.equals("sad")){
            System.out.println("Triste");
        } else if(palavra.equals("deveria")){
            System.out.println("Shoul");
        } else if(palavra.equals("shoul")){
            System.out.println("Deveria");
        } else {
            System.out.println("Essa palavra não é válida");
        }
        System.out.println("-----Exercício 04----");
        /*Escreva um algoritmo que armazene o valor 10 em uma variável A e o valor 20 em uma variável B.
        A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteúdos fazendo com
        que o valor que está em A passe para B e vice-versa. Ao final, escrever os valores que ficaram armazenados nas variáveis*/

        //variáveis exercício 4
        int varA = 10;
        int varB = 20;
        int varAux;

        System.out.println("Antes da troca\nVariável A: "+varA+"\nVariável B: "+varB);
        varAux = varA;
        varA = varB;
        varB = varAux;
        System.out.println("\nDepois da troca\nVariável A: "+varA+"\nVariável B: "+varB);

        System.out.println("-----Exercício 05----");
        /* Escreva um algoritmo para ler as dimensões de um retângulo (base e altura), calcular e escrever
        a área do retângulo.*/
        System.out.println("Informe a altura do retângulo");
        altura = leitura.nextFloat();
        System.out.println("Informe a base do retângulo");
        base = leitura.nextFloat();

        area = base * altura;
        System.out.println("A área do retângulo é: "+area);
        System.out.println("-----Exercício 06----");
        /* Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos
        brancos, nulos e válidos. Calcular e escrever o percentual que cada um representa em relação ao
        total de eleitores.*/

        System.out.println("Informe o número total de eleitores:");
        total = leitura.nextInt();
        System.out.println("Informe o número de votos brancos:");
        brancos = leitura.nextInt();
        System.out.println("Informe o número de votos nulos:");
        nulos = leitura.nextInt();
        System.out.println("Informe o número de votos válidos:");
        validos = leitura.nextInt();

        percBrancos = (brancos*100)/total;
        percNulos = (nulos*100)/total;
        percValidos = (validos*100)/total;

        System.out.println("Total de eleitores: "+total+"\n Percentual de brancos: "+percBrancos+"%\n Percentual de nulos: "+percNulos+"%\n Percentual de Válidos: "+percValidos+"%");

        leitura.nextLine();//limpando o buffer
        System.out.println("-----Exercício 07----");
        /* Um vendedor precisa de um algoritmo que calcule o preço total devido por um cliente. O
        algoritmo deve receber o código de um produto e a quantidade comprada e calcular o preço
        total, usando a tabela abaixo. Mostre uma mensagem no caso de código inválido.*/
        System.out.println("Informe o código do produto: ");
        cod = leitura.nextLine();
        cod = cod.toUpperCase();
        if (cod.equals("ABCD")){ // 5,30
            System.out.println("Informe a quantidade comprada: ");
            qtd = leitura.nextInt();
            totalCompra = (float) (5.30 * qtd);
            System.out.println("Total da compra: R$ "+totalCompra);
        } else if(cod.equals("XYPK")){ // 6,00
            System.out.println("Informe a quantidade comprada: ");
            qtd = leitura.nextInt();
            totalCompra = (float) (5.30 * qtd);
            System.out.println("Total da compra: R$ "+totalCompra);
        } else if(cod.equals("KLMP")){ //3,20
            System.out.println("Informe a quantidade comprada: ");
            qtd = leitura.nextInt();
            totalCompra = (float) (5.30 * qtd);
            System.out.println("Total da compra: R$ "+totalCompra);
        } else if(cod.equals("QRST")){ //2,50
            System.out.println("Informe a quantidade comprada: ");
            qtd = leitura.nextInt();
            totalCompra = (float) (5.30 * qtd);
            System.out.println("Total da compra: R$ "+totalCompra);
        } else {
            System.out.println("Código inválido");
        }

        System.out.println("-----Exercício 08----");
        /*Uma empresa concederá um aumento de salário aos seus funcionários, variável de acordo com o
        cargo, conforme a tabela abaixo. Faça um algoritmo que leia o salário e o cargo de um
        funcionário e calcule o novo salário. Se o cargo do funcionário não estiver na tabela, ele deverá,
        então, receber 40% de aumento. Mostre o salário antigo, o novo salário e a diferença.*/

        System.out.println("Informe o sálario do funcionário");
        salarioAntigo = leitura.nextFloat();
        leitura.nextLine();
        System.out.println("Informe o cargo do funcionário");
        cargo = leitura.nextLine();
        cargo = cargo.toLowerCase();

        if(cargo.equals("gerente")){ // 10%
            salarioAtual = (salarioAntigo * 10)/100;
            salarioAtual += salarioAntigo;
            System.out.println("Salário antigo: "+salarioAntigo+"\nNovo salário: "+salarioAtual+"\nDiferença: "+(salarioAtual-salarioAntigo));
        } else if(cargo.equals("engenheiro")){ // 20%
            salarioAtual = (salarioAntigo * 20)/100;
            salarioAtual += salarioAntigo;
            System.out.println("Salário antigo: "+salarioAntigo+"\nNovo salário: "+salarioAtual+"\nDiferença: "+(salarioAtual-salarioAntigo));
        } else if(cargo.equals("tecnico")){ // 30%
            salarioAtual = (salarioAntigo * 30)/100;
            salarioAtual += salarioAntigo;
            System.out.println("Salário antigo: "+salarioAntigo+"\nNovo salário: "+salarioAtual+"\nDiferença: "+(salarioAtual-salarioAntigo));
        } else { //40%
            salarioAtual = (salarioAntigo * 40)/100;
            salarioAtual += salarioAntigo;
            System.out.println("Salário antigo: "+salarioAntigo+"\nNovo salário: "+salarioAtual+"\nDiferença: "+(salarioAtual-salarioAntigo));
        }

        System.out.println("-----Exercício 09----");
        /*Escrever um algoritmo que lê a hora de início e hora de término de um jogo, ambas subdivididas
        em dois valores distintos: horas e minutos. Calcular e escrever a duração do jogo, também em
        horas e minutos, considerando que o tempo máximo de duração de um jogo é de 24 horas e que
        o jogo pode iniciar em um */

        int inicioHora, inicioMin, fimHora, fimMin, totalMinutos, duracaoJogoH, duracaoJogoM;
        System.out.println("Informe o ínicio do jogo em hora:");
        inicioHora = leitura.nextInt();
        System.out.println("Informe o ínicio do jogo em minuto:");
        inicioMin = leitura.nextInt();
        System.out.println("Informe o término do jogo em hora");
        fimHora = leitura.nextInt();
        System.out.println("Informe o término do jogo em hora");
        fimMin = leitura.nextInt();

        if(inicioHora >= 1){
            totalMinutos = inicioHora * 60;
            inicioMin += totalMinutos;
        }
        if(fimHora >= 1){
            totalMinutos = fimHora * 60;
            fimMin += totalMinutos;
        }
        System.out.println(fimMin - inicioMin);
        duracaoJogoH = (fimMin-inicioMin)/60;
        duracaoJogoM = (fimMin-inicioMin)%60;
        System.out.println("Duração do jogo: "+duracaoJogoH+"h"+duracaoJogoM+"min");

      System.out.println("-----Exercício 10----");
        /* Escrever um algoritmo que lê o número de identificação, as 3 notas obtidas por um aluno nas 3
        verificações e a média dos exercícios que fazem parte da avaliação. Calcular a média de
        aproveitamento, usando a fórmula: MA = (Nota1 + Nota2 x 2 + Nota3 x 3 + ME )/ 7*/
      System.out.println("Informe o código de verificação do aluno");
      codAluno = leitura.nextLine();
      leitura.nextLine();
      System.out.println("Informe a nota 1 do aluno");
      nota1 = leitura.nextFloat();
      System.out.println("Informe a nota 2 do aluno");
      nota2 = leitura.nextFloat();
      System.out.println("Informe a nota 3 do aluno");
      nota3 = leitura.nextFloat();
      System.out.println("Informe a média dos exercícios do aluno");
      me = leitura.nextFloat();

      leitura.nextLine();
      ma = (nota1 + (nota2 * 2)+ (nota3 * 3) + me)/7;

      if (ma >= 9){ // A - aprovado
        System.out.println("O aluno código "+codAluno+" \nNota 1: "+nota1+" \nNota 2: "+nota2+" \nNota 3: "+nota3+" \nMédia Exercicios: "+me+" \nMédia Aproveitamento: "+ma+" \nConceito A\nResultado:APROVADO");
      } else if (ma >= 7.5 && ma < 9){ //B - aprovado
        System.out.println("O aluno código "+codAluno+" \nNota 1: "+nota1+" \nNota 2: "+nota2+" \nNota 3: "+nota3+" \nMédia Exercicios: "+me+" \nMédia Aproveitamento: "+ma+" \nConceito B\nResultado:APROVADO");
      } else if (ma >= 6 && ma < 7.5){ //C - aprovado
        System.out.println("O aluno código "+codAluno+" \nNota 1: "+nota1+" \nNota 2: "+nota2+" \nNota 3: "+nota3+" \nMédia Exercicios: "+me+" \nMédia Aproveitamento: "+ma+" \nConceito C\nResultado:APROVADO");
      } else if (ma >= 4 && ma < 6){ //D - reprovado
        System.out.println("O aluno código "+codAluno+" \nNota 1: "+nota1+" \nNota 2: "+nota2+" \nNota 3: "+nota3+" \nMédia Exercicios: "+me+" \nMédia Aproveitamento: "+ma+" \nConceito D\nResultado:REPROVADO");
      } else if (ma < 4) { //E - reprovado
        System.out.println("O aluno código "+codAluno+" \nNota 1: "+nota1+" \nNota 2: "+nota2+" \nNota 3: "+nota3+" \nMédia Exercicios: "+me+" \nMédia Aproveitamento: "+ma+" \nConceito E\nResultado:REPROVADO");
      }
    }
}