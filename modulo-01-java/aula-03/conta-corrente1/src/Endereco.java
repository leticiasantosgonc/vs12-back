public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimirEndereco() {
        if (tipo == 1){
            System.out.println("Endereço residencial: "+logradouro+" nº: "+numero+" complemento: "+complemento+" Cep: "+cep+" Cidade: "+cidade
            +"/"+estado+" - "+pais);
        }else {
            System.out.println("Endereço residencial: "+logradouro+" nº: "+numero+" complemento: "+complemento+" Cep: "+cep+" Cidade: "+cidade
                    +"/"+estado+" - "+pais);
        }
    }
}

