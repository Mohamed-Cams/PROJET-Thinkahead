public class Game {

    public Game ( int size, Player player1, Player player2 ) {
        // Initialisation du tableau de jeu
        this.size = size;
        this.table = new String[this.size][this.size];
        this.player1 = player1;
        this.player2 = player2;
        for(int i = 0; i < this.table.length; i++) {
            for (int j = 0; j < this.table[i].length; j++) {
                this.table[i][j] = "*";
            }
        }
        this.tab_player[0] = this.player1;
        this.tab_player[1] = this.player2;
    }

    public int size;
    public Player player1;
    public Player player2;
    public String table[][]; 
    public Player tab_player[] = new Player[2];

    // Deroulement de la partie
    public void start() {
        String win = "*";
        while ( win == "*" && !(this.full(this.table)) ) {
            for(int i = 0; i < this.tab_player.length; i++) {
                if( !(this.full(this.table)) && win == "*") {
                    this.show();
                    System.out.print("Au tour de "+this.tab_player[i].sign+" de jouer !\n");
                    int x = -1;
                    int y = -1;
                    boolean chang = false;
                    while( chang == false ) {
                        Tuple my_tuple = this.tab_player[i].play(this);
                        x = my_tuple.x;
                        y = my_tuple.y;
                        if(x >= 0 && x < this.size && y >= 0 && y < this.size && this.table[x][y] == "*") {
                            chang = true;
                            this.table[x][y] = this.tab_player[i].sign;
                        }
                    }
                    int str = y+1;
                    String strr = String.valueOf(str);
                    int str2 = x+1;
                    String strr2 = String.valueOf(str2);
                    System.out.print(this.tab_player[i].sign+" joue ligne "+strr+", colonne "+strr2+"\n");
                    win = this.win(this.table);
                }
            }
        }
        this.show();
        if(win == "*") {
            System.out.print("Match nul !\n");
            return;
        }
        System.out.print(win+" remporte la partie !\n");
    }

    // Affichage du tableau
    public void show() {
        System.out.print("");
        String line = "  ";
        for(int x = 0; x < this.size; x++) {
            int str = x+1;
            String strr = String.valueOf(str);
            line += strr+" ";
        }
        System.out.print(line+"\n");
        for(int y = 0; y < this.size; y++) {
            int str = y+1;
            String strr = String.valueOf(str);  
            line = strr+" ";
            for(int x = 0; x < this.size; x++) {
                line += this.table[x][y]+" ";
            }
            System.out.print(line+"\n");
        }
        System.out.print(""+"\n");
    }

    // Change la valeur d'une case si libre
    public boolean play(int x, int y, String player) {
        if(x >= 0 && x < this.size && y >= 0 && y < this.size && this.table[x][y] == "*") {
            this.table[x][y] = player;
            return true;
        }
        return false;
    }

    // Regarde si un joueur a gagne
    public String win(String table[][]) {
        for(int i = 0; i < this.size; i++) {
            String line = line(table, i);
            if(line != "*") {
                return line;
            }
            String col = this.col(table, i);
            if(col != "*") {
                return col;
            }
        }
        for(int i = 0; i < 2; i++) {
            String dia = this.dia(table, i);
            if(dia != "*") {
                return dia;
            }
        }
        return "*";
    }

    // Verifie une ligne
    public String line (String table[][], int y) {
        String player = table[0][y];
        boolean changed = false;
        for(int x = 0; x < this.size; x++) {
            if(table[x][y] != player) {
                changed = true;
            }
        }
        if(changed){
            return "*";
        }
        else {
            return player;
        }
    }

    // Verifie une colonne
    public String col(String table[][], int x) {
        String player = table[x][0];
        boolean changed = false;
        for(int y = 0; y < this.size; y++) {
            if(table[x][y] != player) {
                changed = true;
            }
        }
        if(changed){
            return "*";
        }
        else {
            return player;
        }
    }

    // Verifie une diagonale
    public String dia (String table[][], int d) {
        int i;
        if(d==0) {
            i = 0;
        }
        else {
            i = this.size - 1;
        }
        String player = table[i][0];
        boolean changed = false;
        for(int x = 0; x < this.size; x++) {
            if(d==0) {
                i = x;
            }
            else {
                i = this.size-1-x;
            }
            if(table[i][x] != player) {
                changed = true;
            }
        }
        if(changed){
            return "*";
        }
        else {
            return player;
        }
    }


    public boolean full (String table[][]) {
        for(int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == "*") {
                    return false;
                }
            }
        }
        return true;
    }

}
