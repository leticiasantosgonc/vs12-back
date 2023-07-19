public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        cliente1.setNome("Letícia");
        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.setNumeroConta("10");
        contaCorrente1.setAgencia(1);
        contaCorrente1.setCliente(cliente1);
        contaCorrente1.setSaldo(1000);
        contaCorrente1.setChequeEspecial(200);

        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.setSaldo(3000);
        contaCorrente2.setChequeEspecial(1000);

        System.out.println(contaCorrente1.getSaldo());
        System.out.println(contaCorrente1.retornarSaldoComChequeEspecial());
        if(contaCorrente1.sacar(1100)){
            System.out.println("sacou");
        }else{
            System.out.println("não sacou");
        }
        contaCorrente1.imprimir();
        contaCorrente1.depositar(500);
        contaCorrente1.imprimir();

        contaCorrente2.imprimir();
        contaCorrente2.transferir(contaCorrente1, 400);
        contaCorrente1.imprimir();
        contaCorrente2.imprimir();

        ContaPoupanca contaPoupanca1 = new ContaPoupanca();
        contaPoupanca1.setAgencia(5);
        contaPoupanca1.setNumeroConta("1000");
        contaPoupanca1.setSaldo(600);

        contaPoupanca1.imprimir();
        contaPoupanca1.creditarTaxa();
        contaPoupanca1.imprimir();

        Endereco[] endereco = new Endereco[2];
        endereco[0] = new Endereco();
        endereco[0].setCidade("Capao");
        cliente1.setEnderecos(endereco);
        cliente1.imprimirEnderecos();




    }
}