public class ContaPoupanca extends Conta implements Impressao{
    static double JUROS_MENSAL = 1.01;

    public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    public void creditarTaxa(){
        double taxa;
        taxa = (getSaldo() * JUROS_MENSAL);
        setSaldo(taxa);
        System.out.println("Taxa creditada!");
    }
    public void imprimir(){
        System.out.println(getCliente().getNome()+"\nAgência: " +getAgencia()+"\nNúmero da conta: " +getNumeroConta()+ "\nSaldo: "+getSaldo());
    }
}
