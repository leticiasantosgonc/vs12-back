public class Conta implements Movimentacao{
    private Cliente cliente;
    private String numeroConta;
    private int agencia;
    private double saldo;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
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
    public boolean transferir(ContaCorrente conta, double valor) {
        if (this.sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }
}
