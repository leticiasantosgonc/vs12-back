public class ContaPoupanca extends Conta implements Impressao{
    static double JUROS_MENSAL = 1.01;

    public void creditarTaxa(){
        double taxa;
        taxa = (getSaldo() * JUROS_MENSAL);
        setSaldo(taxa);
    }
    public void imprimir(){
        System.out.println("Agência: " +getAgencia()+"\nNúmero da conta: " +getNumeroConta()+ "\nSaldo: "+getSaldo());
    }
}
