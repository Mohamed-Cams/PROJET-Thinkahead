import java.lang.NullPointerException;

// Class Computer - Implementation de Player pour l'ordinateur
public class AI extends Player {

    public AI(String sign) {
        super(sign);
    }

    public Tuple play(Game game) {

        Tuple2 r_tuple = this.bestMove(game, game.table, game.size, this.sign);
        Tuple mon_tuple = new Tuple(r_tuple.x, r_tuple.y);
        System.out.print(r_tuple.x+" "+r_tuple.y+"\n");
        return mon_tuple;

    }

    // Selectionner la meilleure possibilitee de jeu
    public Tuple2 bestMove(Game game, String table[][], int size, String sign) {
        // On recupere le sign de l'adverse pour nos calculs
        String other;
        if(sign == "O") {
            other = "X";
        }
        else {
            other = "O";
        }
        // On cree un tableau vide pour y ajouter nos possibilitees avec leur score
        Tuple2 moves[] = new Tuple2[10];

        // On parcours le tableau pour classer chaque possibilitee
        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                // Si la case est disponible
                if(table[x][y] == "*") {
                    // On fait une copie du tableau dans laquelle on joue
                    String copy[][] = new String[table.length][table[0].length];
                    for(int m=0; m<table.length; m++){
                        for(int n=0; n<table[m].length; n++) {
                            copy[m][n] = table[m][n];
                        }
                    }
                    copy[x][y] = sign;
                    // Et on recupere le resultat
                    String win = game.win(copy);

                    int score = 10;
                    // Si le tableau est plein et que personne ne gagne, on le grade 0
                    if(win == "*" && game.full(copy) == true) {
                        score = 0;
                    }
                    else if(win == sign) {
                        score = 1;
                    }
                    // Sinon, on le grade avec l'oppose du score pour le joueur adverse
                    // pour son meilleur coup dans son jeu suivant
                    else {
                        Tuple2 y_tuple = this.bestMove(game, copy, size, other);
                        score = 0 - y_tuple.z;
                    }
                    if(score != 10) {
                        Tuple my_tuple = new Tuple(x, y);
                        Tuple2 result = new Tuple2(my_tuple, score);
                        //Si le score est 1, on joue ce coup
                        if(score == 1) {
                            return result;
                        }
                        // Sinon on l'ajout dans la liste avec les autres et on continue
                        int k = 0;
                        while ( k < moves.length ){
                            if(moves[k] == null) {
                                moves[k] = result;
                                break;
                            }
                            else {
                                k++;
                            }
                        } 
                    } 
                }
            }
        }
        // Une fois tous les coups dans la liste, on les trie par score
        int min_score = 10;
        Tuple2 to_return = moves[0];
        int h = 0;
        while(moves[h] != null) {
            if(moves[h].z < min_score) {
                min_score = moves[h].z;
                to_return = moves[h];
            }
            h++;
        }
        return to_return;
        // Et on joue le meilleur
    }

}
