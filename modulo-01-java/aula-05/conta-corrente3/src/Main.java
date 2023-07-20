public class Main {
    public static void main(String[] args) {
    Contato leticiaContato = new Contato("Whatsapp", "3625-8014", 1);
    Endereco leticiaEndereco = new Endereco(1, "Av Ruda", 258, "casa", "95555-000", "Capao", "RS", "Brasil" );
    Cliente leticiaCliente = new Cliente("Letícia", "045.869.362-20", leticiaContato, leticiaEndereco);

    ContaCorrente contaCorrenteLeticia = new ContaCorrente(leticiaCliente, "258369", 10, 300, 100);
    ContaPagamento contaPagamentoLeticia = new ContaPagamento(leticiaCliente, "258369", 10, 300);

    Contato vitorContato = new Contato("Whatsapp", "3625-8014", 1);
    Endereco vitorEndereco = new Endereco(1, "Av Ruda", 258, "casa", "95555-000", "Capao", "RS", "Brasil" );
    Cliente vitorCliente = new Cliente("Vitor", "258.369.147-25", vitorContato, vitorEndereco);

    ContaPoupanca contaPoupancaVitor = new ContaPoupanca(vitorCliente, "589", 5, 1500);

    contaPoupancaVitor.sacar(1300); //200
    contaPoupancaVitor.imprimir();

    contaCorrenteLeticia.depositar(200); //500
    contaCorrenteLeticia.imprimir();
    contaCorrenteLeticia.sacar(550); //uso cheque especial
    contaCorrenteLeticia.imprimir();

    contaPagamentoLeticia.imprimir();
    contaPagamentoLeticia.sacar(298); // 298 + 4,25

    contaPoupancaVitor.transferir(contaCorrenteLeticia, 600); //200
    contaCorrenteLeticia.imprimir(); //50 do cheque especial
    contaPoupancaVitor.transferir(contaCorrenteLeticia, 100); //100
    contaCorrenteLeticia.imprimir(); //150
    contaPagamentoLeticia.transferir(contaPoupancaVitor, 200); //100
    contaPoupancaVitor.imprimir(); //300
    }
}

/*
○ 1 cliente com conta poupança
● Realize ao menos 3 movimentações entre as contas (saque, depósito e transferência)
● Ao final, imprima os dados da conta
*/