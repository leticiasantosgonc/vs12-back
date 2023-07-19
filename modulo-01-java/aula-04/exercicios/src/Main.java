public class Main {
    public static void main(String[] args) {
        //teste clase Pessoa
       Pessoa pessoa = new Pessoa("Letícia", "Santos");

       System.out.println(pessoa.getNome()+" "+pessoa.getSobrenome());
       pessoa.setIdade(26);
       System.out.println(pessoa.getIdade());
       pessoa.setSobrenome("Gonçalves");
       System.out.println(pessoa.getNome()+" "+pessoa.getSobrenome());

       //teste classe Animal
       Animal animal = new Animal("Nix");
       System.out.println(animal.caminha());
       Gato nix = new Gato();
       System.out.println(nix.caminha());
       System.out.println(nix.mia());










    }
}