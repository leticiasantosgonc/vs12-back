package br.com.dbccompany;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe Conta")
class ContaTest {
    Cliente leticiaCliente = new Cliente("Letícia", "045.869.362-20");
    ContaCorrente conta1 = new ContaCorrente(leticiaCliente, "1234", 10, 250.00, 100.00);
    ContaPoupanca conta2 = new ContaPoupanca(leticiaCliente, "258", 1, 300.00);
    ContaPagamento conta3 = new ContaPagamento(leticiaCliente, "369", 6, 500.00);

    @Test
    @DisplayName("Deve Testar Saque Conta Corrente E Verificar Saldo Com Sucesso")
    void sacarContaCorrente() {
        conta1.sacar(300);
        Assertions.assertEquals(50, conta1.retornarSaldoComChequeEspecial());
    }

    @Test
    @DisplayName("Deve Testar Saque Conta Corrente Sem Saldo")
    void sacarContaCorrenteSemSaldo(){
        conta1.sacar(400);
        Assertions.assertEquals(350, conta1.retornarSaldoComChequeEspecial());
    }

    @Test
    @DisplayName("Deve Testar Saque Conta Poupanca E Verificar Saldo Com Sucesso")
    void sacarContaPoupanca(){
        conta2.creditarTaxa();
        conta2.sacar(300);
        Assertions.assertEquals(3, conta2.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Saque Conta Poupanca Sem Saldo")
    void sacarContaPoupancaSemSaldo() {
        conta2.creditarTaxa();
        conta2.sacar(305);
        Assertions.assertEquals(303, conta2.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Saque Conta Pagamento E Verificar Saldo Com Sucesso")
    void sacarContaPagamento() {
        conta3.sacar(450);
        Assertions.assertEquals(45.75, conta3.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Saque Conta Pagamento Sem Saldo")
    void sacarContaPagamentoSemSaldo(){
        conta3.sacar(505);
        Assertions.assertEquals(500, conta3.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Transferencia E Verificar Saldo Com Sucesso")
    void transferenciaComSaldo() {
        conta2.transferir(conta3, 100);
        Assertions.assertEquals(200, conta2.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Transferencia Sem Saldo")
    void transferenciaSemSaldo(){
        conta2.transferir(conta3, 350);
        Assertions.assertEquals(300, conta2.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Deposito E Verificar Saldo Com Sucesso")
    void depositoComSaldo(){
        conta2.depositar(100);
        Assertions.assertEquals(400, conta2.getSaldo());
    }

    @Test
    @DisplayName("Deve Testar Deposito Negativo")
    void depositoNegativo(){
        conta2.depositar(-10);
        Assertions.assertEquals(false, conta2.depositar(-10));
    }
}