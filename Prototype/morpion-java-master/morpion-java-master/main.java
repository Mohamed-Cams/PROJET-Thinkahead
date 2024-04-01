import java.util.Scanner;

class main
{
    public static void main(String[] args)
    {   
    
        Human h1 = new Human("X");
        Human h2 = new Human("O");

        AI ai = new AI("O");
        
        Scanner clavier = new Scanner(System.in);
       
        System.out.print("\n1 - Joueur contre joueur\n2 - Joueur contre ordinateur\n");
        int config = 0;
        while(config < 1 || config > 2) {
            System.out.print("\nChoisissez une configuration : \n");
            config = clavier.nextInt();
        }
        if(config == 1) {
            Game game = new Game(3, h1, h2);
            game.start();
        }
        else {
            Game game = new Game(3, ai, h1);
            game.start();
        }
    }

}
