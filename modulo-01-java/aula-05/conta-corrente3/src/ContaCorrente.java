public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;
    public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public boolean sacar(double valor) {
        double saldo = getSaldo();
        if (valor > this.retornarSaldoComChequeEspecial()) {
            System.out.println("Saque não realizado");
            return false;
        }
        if (valor <= 0) {
            System.out.println("Saque não realizado");
            return false;
        }
        saldo -= valor;
        setSaldo(saldo);
        System.out.println("Saque realizado");
        return true;
    }
    public double retornarSaldoComChequeEspecial() {
        return chequeEspecial + getSaldo();
    }
    public void imprimir(){
        System.out.println(getCliente().getNome()+"\nAgência: " + getAgencia()+"\nNúmero da conta: " +getNumeroConta()+"\nSaldo com Cheque especial: R$ "+ retornarSaldoComChequeEspecial());
    }
}
