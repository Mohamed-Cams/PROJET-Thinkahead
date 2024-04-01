package morpion;

import javax.swing.*; // Librairie graphique
import java.awt.*; // Composants Java 
import java.awt.event.*; // Permet d'utiliser les événements liés aux composants
import java.util.*;

class Joueur {
    private int _symb;
    private String _nom;

    // Constructeur de Joueur
    // Reçoit le nom et le symbole et les affectent
    public Joueur(int symb, String nom) {
        _symb = symb;
        _nom = nom;
    }

    // Méthode qui renvoit le symbole
    public int getSymb() {
        return _symb;
    }

    // Méthode qui renvoit le nom
    public String getNom() {
        return _nom;
    }
}
