import java.util.Random;
import java.util.Scanner;

public class Jeu {
    private static final int TAILLE = 3; // Taille du tableau
    private static final int MAX = 100; // Valeur maximale pour les nombres aléatoires
    private static final int JOUEUR_1 = 1;
    private static final int JOUEUR_2 = 2;
    private static final int ORDINATEUR = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Création du tableau de jeu
        int[][] tableau = new int[TAILLE][TAILLE];
        // Initialisation du tableau avec des nombres aléatoires
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                tableau[i][j] = random.nextInt(10) + 1;
            }
        }

        // Affichage du tableau de jeu
        afficherTableau(tableau);

        // Détermination du premier joueur
        int premierJoueur = random.nextInt(2) + 1;
        System.out.println("Le joueur " + premierJoueur + " commence.");

        // Boucle de jeu
        int currentPlayer = premierJoueur;
        int totalJoueur1 = 0;
        int totalJoueur2 = 0;
        while (true) {
            int[] choix;
            if (currentPlayer == JOUEUR_1) {
                System.out.println("Joueur 1, choisissez un nombre :");
                choix = choisirNombre(tableau);
            } else if (currentPlayer == JOUEUR_2) {
                System.out.println("Joueur 2, choisissez un nombre dans la colonne:");
                choix = choisirNombre(tableau);
            } else {
                System.out.println("Tour de l'ordinateur...");
                choix = choisirNombreOrdinateur(tableau);
            }

            if (choix == null) {
                System.out.println("Plus de coups possibles. Fin du jeu.");
                break;
            }

            int ligne = choix[0];
            int colonne = choix[1];

            int valeur = tableau[ligne][colonne];
            System.out.println("Nombre choisi : " + valeur);

            if (currentPlayer == JOUEUR_1) {
                totalJoueur1 += valeur;
            } else {
                totalJoueur2 += valeur;
            }

            tableau[ligne][colonne] = 0; // Marquer la case comme déjà choisie

            afficherTableau(tableau);

            // Vérification si la partie est terminée
            if (colonne == TAILLE - 1) {
                System.out.println("Dernière colonne choisie. Fin de la partie.");
                break;
            }

            currentPlayer = (currentPlayer == JOUEUR_1) ? JOUEUR_2 : JOUEUR_1;
        }

        // Affichage des résultats
        System.out.println("Total joueur 1 : " + totalJoueur1);
        System.out.println("Total joueur 2 : " + totalJoueur2);
        if (totalJoueur1 > totalJoueur2) {
            System.out.println("Le joueur 1 a gagné !");
        } else if (totalJoueur2 > totalJoueur1) {
            System.out.println("Le joueur 2 a gagné !");
        } else {
            System.out.println("Match nul !");
        }

        scanner.close();
    }

    // Méthode pour choisir un nombre dans le tableau
    public static int[] choisirNombre(int[][] tableau) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            choix = scanner.nextInt();
            if (choix < 1 || choix > MAX) {
                System.out.println("Veuillez choisir un nombre entre 1 et " + MAX + " :");
            }
        } while (choix < 1 || choix > MAX);

        // Rechercher la position du nombre choisi dans le tableau
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                if (tableau[i][j] == choix) {
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    // Méthode pour choisir un nombre dans la colonne spécifiée du tableau
    public static int[] choisirNombre(int[][] tableau, int colonne) {
        Scanner scanner = new Scanner(System.in);
        int choix;
        do {
            choix = scanner.nextInt();
            if (choix < 1 || choix > MAX) {
                System.out.println("Veuillez choisir un nombre entre 1 et " + MAX + " :");
            }
        } while (choix < 1 || choix > MAX);

        // Rechercher la position du nombre choisi dans la colonne spécifiée du tableau
        for (int i = 0; i < TAILLE; i++) {
            if (tableau[i][colonne] == choix) {
                return new int[] { i, colonne };
            }
        }
        return null;
    }

    // Méthode pour choisir un nombre par l'ordinateur
    public static int[] choisirNombreOrdinateur(int[][] tableau) {
        Random random = new Random();
        int ligne;
        int colonne;
        do {
            ligne = random.nextInt(TAILLE);
            colonne = random.nextInt(TAILLE);
        } while (tableau[ligne][colonne] == 0);

        return new int[] { ligne, colonne };
    }

    // Méthode pour afficher le tableau
    public static void afficherTableau(int[][] tableau) {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }
    }
}
