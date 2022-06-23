public class Principal
{
    public static void main(String[] args){
        
        String nomeDoTamagotchi = Teclado.leString("Digite o nome do seu Tamagotchi: ");       
        
        Tamagotchi tamagotchi = new Tamagotchi(nomeDoTamagotchi, 0, 1);
        
        System.out.println("Ei, sou o "+nomeDoTamagotchi+" 🤖 "+"e a partir de agora você quem decide como vou viver.");
        
        while (tamagotchi.getEstaVivo()) {
            tamagotchi.desejos();
        }
        
        if(!tamagotchi.getEstaVivo()){
            System.out.println("Seu tamagotchi morreu ☠");
        }
    }
}
