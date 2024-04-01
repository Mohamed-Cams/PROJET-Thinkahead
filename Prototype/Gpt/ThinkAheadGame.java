import java.util.Random;
import java.util.Scanner;

public class ThinkAheadGame {
    private int[][] grid;
    private int size;
    private String player1;
    private String player2;
    private boolean vsComputer;
    private boolean player1Turn;
    private Random random;

    public ThinkAheadGame(int size, String player1, String player2, boolean vsComputer) {
        this.size = size;
        this.player1 = player1;
        this.player2 = player2;
        this.vsComputer = vsComputer;
        this.player1Turn = true;
        this.random = new Random();
        this.grid = new int[size][size];
    }

    public void startGame() {
        System.out.println("Starting ThinkAhead Game...");
        printGrid();

        while (!isGameOver()) {
            int row, col;
            if (vsComputer && !player1Turn) {
                System.out.println(player2 + "'s turn (Computer):");
                int[] computerMove = getComputerMove();
                row = computerMove[0];
                col = computerMove[1];
            } else {
                String currentPlayer = player1Turn ? player1 : player2;
                System.out.println(currentPlayer + "'s turn:");
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter row: ");
                row = scanner.nextInt();
                System.out.print("Enter column: ");
                col = scanner.nextInt();
            }

            if (isValidMove(row, col)) {
                makeMove(row, col);
                printGrid();
                player1Turn = !player1Turn;
            } else {
                System.out.println("Invalid move! Please try again.");
            }
        }

        System.out.println("Game Over!");
    }

    private void printGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private boolean isGameOver() {
        // Game over if all cells are selected
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidMove(int row, int col) {
        return grid[row][col] == 0;
    }

    private void makeMove(int row, int col) {
        int maxValue = getMaxValue(row, col);
        grid[row][col] = maxValue;
    }

    private int getMaxValue(int row, int col) {
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max, grid[row][i]);
            max = Math.max(max, grid[i][col]);
        }
        return max + 1;
    }

    private int[] getComputerMove() {
        int[] move = new int[2];
        int row = random.nextInt(size);
        int col = random.nextInt(size);
        while (!isValidMove(row, col)) {
            row = random.nextInt(size);
            col = random.nextInt(size);
        }
        move[0] = row;
        move[1] = col;
        return move;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grid size: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter player 1 name: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter player 2 name: ");
        String player2 = scanner.nextLine();
        System.out.print("Play against computer? (yes/no): ");
        String vsComputerStr = scanner.nextLine();
        boolean vsComputer = vsComputerStr.equalsIgnoreCase("yes");

        ThinkAheadGame game = new ThinkAheadGame(size, player1, player2, vsComputer);
        game.startGame();
    }
}
