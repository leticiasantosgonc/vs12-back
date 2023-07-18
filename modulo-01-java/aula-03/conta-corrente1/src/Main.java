public class Main {
    public static void main(String[] args) {
        Cliente pessoa1 = new Cliente();
        Cliente pessoa2 = new Cliente();

        Contato contato1 = new Contato();
        Contato contato2 = new Contato();

        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();

        //teste classe cliente
        pessoa1.nome="Leticia";
        pessoa1.cpf="67810682549";

        pessoa2.nome="Vitor";
        pessoa2.cpf="86523908616";

        //teste classe contato
        contato1.descricao= "numero whatsapp";
        contato1.telefone= "980678599";
        contato1.tipo = 1;

        contato2.descricao= "numero loja";
        contato2.telefone= "953641722";
        contato2.tipo = 2;

        //teste classe endereço
        endereco1.estado = "RS";
        endereco1.pais = "Brasil";
        endereco1.cep = "95555000";
        endereco1.complemento= "casa";
        endereco1.cidade= "Osório";
        endereco1.numero= 764;
        endereco1.logradouro= "Rua Rudá";
        endereco1.tipo = 1;

        endereco2.estado = "RS";
        endereco2.pais = "Brasil";
        endereco2.cep = "95588000";
        endereco2.complemento= "Sala 03";
        endereco2.cidade= "Xangri-la";
        endereco2.numero= 3058;
        endereco2.logradouro= "Av. Paraguassu";
        endereco2.tipo = 2;
        
        conta1.numeroConta = "12354";
        conta1.agencia = 10;
        conta1.saldo = 115.30;
        conta1.chequeEspecial = 200.00;

        conta2.numeroConta = "258369";
        conta2.agencia = 5;
        conta2.saldo = 7600.60;
        conta2.chequeEspecial = 5340.00;
        

        pessoa1.contatos[0] = contato1;
        pessoa1.enderecos[0] = endereco1;
        conta1.cliente = pessoa1;

        pessoa2.contatos[0] = contato2;
        pessoa2.contatos[1] = contato1;
        pessoa2.enderecos[0] = endereco1;
        pessoa2.enderecos[1] = endereco2;
        conta2.cliente = pessoa2;

       pessoa1.imprimirCliente();
       System.out.println("Sando na conta: R$ "+conta1.retornarSaldoComChequeEspecial());
        if (conta1.sacar(1000)){
            System.out.println("Saque realizado");
        }else{
            System.out.println("Saque não realizado");
        }

       System.out.println(" ");

       pessoa2.imprimirCliente();
       System.out.println("Saldo na conta R$ "+conta2.retornarSaldoComChequeEspecial());
       if (conta2.depositar(150)){
           System.out.println("Deposito realizado");
       }else{
           System.out.println("Depósito não realizado");
       }
       System.out.println("Saldo na conta R$"+conta2.retornarSaldoComChequeEspecial());

       if(conta2.transferir(conta1, 5800)){
           System.out.println("Transferencia realizada");
       }else {
           System.out.println("Transferencia não realizada");
       }
       System.out.println("Saldo na conta R$ "+conta2.retornarSaldoComChequeEspecial());

       System.out.println(" ");
       pessoa1.imprimirCliente();
       System.out.println("Saldo na conta R$ "+conta1.retornarSaldoComChequeEspecial());



    }
}