import java.util.Random;

public class Tamagotchi
{
    //Define os atributos iniciais do tamagotchi
    private String nome;
    private int idade;
    private int peso;
    private int contador; //inicia o contador com o valor zero
    
    //Constrói o objeto tamagotchi - método construtor
    public Tamagotchi(String nome, int idade, int peso){
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.contador = 0;
    }
    
    //Métodos de acesso
    public String getNome(){
        return this.nome; //pega o nome
    }
    
    public int getIdade(){
        return this.idade; //pega a idade
    }
    
    public int getPeso(){
        return this.peso; //pega o peso
    }
    
    public void setNome(String nome){
        this.nome = nome; //seta o nome
    }
    
    public void setIdade(int idade){
        this.idade = idade; //seta a idade
    }
    
    public void setPeso(int peso){
        this.peso = peso; //seta o peso
    }
    
    //Métodos auxiliares
    public void dormir(){
        this.idade += 1; //aumenta em 1 a idade do tamagotchi quando o método é chamado
    }
    
    public void permanecerAcordado(){
    }
    
    public void comerMuito(){
        this.peso += 5; //aumenta em 5kg o peso do tamagotchi quando o método é chamado
    }

    public void comerPouco(){
        this.peso += 1; //aumenta em 1kg o peso do tamagotchi quando o método é chamado
    }
    
    public void naoComer(){
        this.peso -= 2; //diminui em 2kg o peso do tamagotchi quando o método é chamado
    }
    
    public void caminhar(){
        this.peso -= 1; //diminui em 1kg o peso do tamagotchi quando o método é chamado
    }

    public void correr(){
        this.peso -= 4; //diminui em 4kg o peso do tamagotchi quando o método é chamado
    }
    
    //método que realiza a chamada dos outros métodos quando o tamagotchi sente sono
    public void sentirSono(){
       
        if (this.contador < 5) {
            int sonoOp = Teclado.leInt("Estou com sono 😴, devo: 1)Dormir 2)Permancer acordado (digite 1 ou 2)");
            
            if (sonoOp == 1) {
                this.dormir(); 
                this.contador = 0; //chama o método dormir e seta para zero o valor do contador
            } else if (sonoOp == 2) {
                this.permanecerAcordado(); //chama o método permanecer acordado
                this.contador++; //aumenta em 1 o valor do contador
            }
        } else {
            this.dormir();
            System.out.println("Permaneci acordado muitas vezes, agora vou dormir.");
            this.contador = 0;
        }
    } 
    
    //método que realiza a chamada dos outros métodos quando o tamagotchi sente fome
    public void sentirFome(){
        int fomeOp = Teclado.leInt("Estou com fome 😋, devo: 1)Comer muito 2)Comer pouco 3)Não comer (digite 1, 2 ou 3)");
        
        if(fomeOp == 1){
            this.comerMuito();
            this.dormir(); //faz com que o método comer muito seja chamado e, logo após, o dormir
        } else if(fomeOp == 2) {
            this.comerPouco(); //faz com que o método comer pouco seja chamado
        } else if (fomeOp == 3) {
            this.naoComer(); //faz com que o método não comer seja chamado
        }
    }
    
    //método que realiza a chamada dos outros métodos quando o tamagotchi sente tédio
    public void sentirTedio(){
        int tedioOp = Teclado.leInt("Estou entendiado 😑, devo: 1)Correr 2)Caminhar (digite 1 ou 2)");
    
        if (tedioOp == 1) {
            this.correr(); //faz com que o método correr seja chamado
        } else if (tedioOp == 2) {
            this.caminhar();
            this.sentirFome(); //faz com que o método caminhar seja chamado e, logo após, o método sentir fome
        }
    }
    
    //método que controla os desejos que serão chamados
    public void desejos(){
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(3) + 1; //Sorteia aleatoriamente números entre 1 e 3
        
        //define o valor de cada desejo;
        if (valor == 1){
            this.sentirSono();
        } else if (valor == 2){
            this.sentirFome();
        } else if(valor == 3){
            this.sentirTedio();
        }
    }
    
    //método que seta os valores dentro dos quais o tamagotchi está vivo
    public boolean getEstaVivo(){
        System.out.println("Estou com: "+this.getIdade()+" ano(s) e peso: "+this.getPeso()+"kg.");
        boolean vivo = (this.peso > 0 && this.peso <= 20) && (this.idade >= 0 && this.idade < 15);
        return vivo;
    }
}
