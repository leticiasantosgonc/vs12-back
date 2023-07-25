package br.com.dbccompany;

public class ContaPagamento extends Conta implements Impressao{
    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public boolean sacar(double valor) {
        double saldo;
        if (valor <= 0) {
            //System.out.println("Saque não realizado");
            return false;
        }
        if ((getSaldo() - TAXA_SAQUE) < valor){
            //System.out.println("Não realizado");
            return false;
        }
        saldo = (getSaldo() - TAXA_SAQUE) - valor;
        //System.out.println("Realizado");
        setSaldo(saldo);
        return true;
    }
        @Override
    public void imprimir() {
        System.out.println("Agência: " +getAgencia()+"\nNúmero da conta: " +getNumeroConta()+ "\nSaldo: "+getSaldo());
    }
}
