public class Pessoa {
    private String nome;
    private String sobrenome;
    private String whatsapp;
    private int idade;

    public Pessoa(){

    }
    public Pessoa(String nome, String sobrenome){
        this.nome= nome;
        this.sobrenome= sobrenome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getSobrenome(){
        return sobrenome;
    }
    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }
    public String getWhatsapp(){
        return whatsapp;
    }
    public void setWhatsapp(String whatsapp){
        this.whatsapp = whatsapp;
    }
}

