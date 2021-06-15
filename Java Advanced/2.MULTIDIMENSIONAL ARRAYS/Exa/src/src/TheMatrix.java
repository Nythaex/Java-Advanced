import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ArraySize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] board = new char[ArraySize[0]][];
        for (int i = 0; i <= board.length - 1; i++) {
            board[i] = String.join("", scanner.nextLine().split(" ")).toCharArray();
        }
        char newSpecialSymbol = scanner.nextLine().charAt(0);
        int[] rowsAndColsStart = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = rowsAndColsStart[0];
        int col = rowsAndColsStart[1];
        char forChange = board[rowsAndColsStart[0]][rowsAndColsStart[1]];
        board[rowsAndColsStart[0]][rowsAndColsStart[1]] = newSpecialSymbol;
        changeBoard(board, forChange, newSpecialSymbol, rows, col);
        printBoard(board);


    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i <= board.length - 1; i++) {
            for (int a = 0; a <= board[i].length - 1; a++) {
                System.out.print(board[i][a]);
            }
            System.out.println();
        }
    }

    private static void changeBoard(char[][] board, char forChange, char newSpecialSymbol, int rows, int col) {
        if (rows + 1 < board.length) {
            if (board[rows + 1][col] == forChange) {
                board[rows + 1][col] = newSpecialSymbol;
                changeBoard(board, forChange, newSpecialSymbol, rows + 1, col);
            }
        }
        if (rows - 1 >= 0) {
            if (board[rows - 1][col] == forChange) {
                board[rows - 1][col] = newSpecialSymbol;
                changeBoard(board, forChange, newSpecialSymbol, rows - 1, col);
            }
        }
        if (col + 1 < board[rows].length) {
            if (board[rows][col + 1] == forChange) {
                board[rows][col + 1] = newSpecialSymbol;
                changeBoard(board, forChange, newSpecialSymbol, rows, col + 1);
            }
        }
        if (col - 1 >= 0) {
            if (board[rows][col - 1] == forChange) {
                board[rows][col - 1] = newSpecialSymbol;
                changeBoard(board, forChange, newSpecialSymbol, rows, col - 1);
            }

        }


    }
}
