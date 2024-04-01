import java.util.Scanner;



// Class Human - Implementation de Player pour le joueur
public class Human extends Player {
    
    public Human(String sign) {
        super(sign);
    }

    public Tuple play(Game game) {
        Scanner clavierx = new Scanner(System.in);
        Scanner claviery = new Scanner(System.in);
        System.out.print("Entrer le numero de la colonne (1 a 3) : ");
        int x = clavierx.nextInt();
        System.out.print("Entrer le numero de la ligne (1 a 3) : ");
        int y = claviery.nextInt();

        Tuple mon_tuple = new Tuple(x-1, y-1);
        return mon_tuple;
    }

}
