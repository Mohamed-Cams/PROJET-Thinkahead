package modeTexte;

import java.util.Scanner;

public class JoueurHumain extends Joueur {

    public JoueurHumain(String nom) {
        super(nom);
        // TODO Auto-generated constructor stub
    }

    private String nom;

    public String joueEn() {
        // Renvoie le type de joueur (humain ou ordinateur)
        return "";
    }

    public Position play(Partie game) {
        Scanner clavierx = new Scanner(System.in);
        Scanner claviery = new Scanner(System.in);
        System.out.print("Entrer le numero de la colonne (1 a 3) : ");
        int x = clavierx.nextInt();
        System.out.print("Entrer le numero de la ligne (1 a 3) : ");
        int y = claviery.nextInt();

        Position mon_tuple = new Position(x - 1, y - 1);
        return mon_tuple;
    }
}
