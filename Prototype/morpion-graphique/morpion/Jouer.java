package morpion;

import javax.swing.*; // Librairie graphique
import java.awt.*; // Composants Java 
import java.awt.event.*; // Permet d'utiliser les événements liés aux composants
import java.util.*; // Utilitaires, ici pour la génération de nombres aléatoires

public class Jouer {

    public static void main(String[] args) {
        // Création d'une fenetre MorpionFrame
        MorpionFrame morp = new MorpionFrame();

        morp.setSize(190, 250);

        // Récupère la taille de l'écran pour centrer la fenetre
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        morp.setLocation((screenSize.width - morp.getWidth()) / 2, (screenSize.height - morp.getHeight()) / 2);

        morp.setVisible(true);
    }
}