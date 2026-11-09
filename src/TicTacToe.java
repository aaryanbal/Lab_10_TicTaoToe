
import java.util.Scanner;

public class TicTacToe {

    private static final int ROWS = 3;
    private static final int COLS = 3;

    private static String board[][] = new String[ROWS][COLS];


    static void main() {

        Scanner in = new Scanner(System.in);
        clearBoard();

        String player = "X";
        boolean gameOver = false;
        while (!gameOver) {
            display();

            System.out.print("Enter row 1 to 3: ");
            int rowMove = in.nextInt();
            System.out.print("Enter column 1 to 3: ");
            int colMove = in.nextInt();

            rowMove = rowMove - 1;
            colMove = colMove - 1;

            if (isValidMove(rowMove, colMove)) {
                board[rowMove][colMove] = player;
                if (isWin(player)) {
                    display();
                    System.out.println("Player " + player + " wins");
                    gameOver = true;
                }
                else if (isTie()){
                    display();
                    System.out.print("It's a tie.");
                    gameOver = true;
                }
                else {
                    if(player.equals("X")) {
                        player = "O";
                    }
                    else {
                        player = "X";
                    }
                }
            }
            else {
                System.out.print("Invalid move");
            }
            display();

        }
    }


    private static void clearBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = " ";
            }
        }
    }

    private static void display() {
        System.out.println("1   2   3");

        for (int row = 0; row < ROWS; row++) {
            System.out.print(row + 1);
            System.out.print(" ");

            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col]);

                if (col < COLS - 1) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            if (row < ROWS - 1) {
                System.out.println(" ");
            }
        }
    }

    private static boolean isWin(String player) {
        if (isColWin(player) || isRowWin(player) || isDiagnolWin(player)) {
            return true;
        }
        return false;
    }

    private static boolean isRowWin(String player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isColWin(String player) {
        for (int col = 0; col < COLS; col++) {
            if (board[col][0].equals(player) && board[col][1].equals(player) && board[col][2].equals(player)) {
                return true;
            }
        }
        return false;
    }
    private static boolean isDiagnolWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)) {
            return true;
        }
        if (board[0][2].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        }

        return false;
    }
    private static boolean isTie() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValidMove(int row, int col) {
        boolean retVal = false;

        if (board[row][col].equals(" ")) {
            retVal = true;
        }
        return retVal;
    }
}
