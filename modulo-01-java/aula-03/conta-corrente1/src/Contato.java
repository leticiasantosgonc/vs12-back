public class Contato {
    String descricao;
    String telefone;
    int tipo;

    public void imprimirContato(){
        if (tipo == 1){
            System.out.println("Contato residencial: "+telefone+" descrição: "+descricao);
        }else {
            System.out.println("Contato comercial: "+telefone+" descrição: "+descricao);
        }
    }
}
