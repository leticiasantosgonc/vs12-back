public class ContaCorrente {
    public Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("Agência: " + agencia + "Número da conta: " + numeroConta + " saldo: " + saldo + " Cheque especial: " + chequeEspecial);
    }

    public boolean sacar(double valor) {
        if (valor > this.retornarSaldoComChequeEspecial()) {
            return false;
        } else if (valor <= 0) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    public boolean depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        saldo += valor;
        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        return chequeEspecial + saldo;
    }

    public boolean transferir(ContaCorrente conta, double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }
}
