public class ContaCorrente extends Conta implements Impressao{
    private double chequeEspecial;

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public boolean sacar(double valor) {
        double saldo = getSaldo();
        if (valor > this.retornarSaldoComChequeEspecial()) {
            return false;
        } else if (valor <= 0) {
            return false;
        }
        saldo -= valor;
        setSaldo(saldo);
        return true;
    }
    public double retornarSaldoComChequeEspecial() {
        return chequeEspecial + getSaldo();
    }

    public void imprimir(){
        System.out.println("Agência: " + getAgencia()+"\nNúmero da conta: " +getNumeroConta()+ "\nSaldo com Cheque especial: R$ "+ retornarSaldoComChequeEspecial());
    }

}
