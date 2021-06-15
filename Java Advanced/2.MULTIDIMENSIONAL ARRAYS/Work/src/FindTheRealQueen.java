import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] theBoard = new char[8][8];
        for (int i = 0; i < theBoard.length; i++) {
            String[] text = scanner.nextLine().split(" ");
            char[] col = String.join("", text).toCharArray();
            theBoard[i] = col;
        }
        int[] indexes = new int[2];
        boolean check = true;
        for (int i = 0; i <= theBoard.length - 1; i++) {
            for (int a = 0; a <= theBoard[i].length - 1; a++) {
                check = true;
                if (theBoard[i][a] == 'q') {
                    int row = i;
                    int col = 0;
                    while (col < 8) {
                        if (theBoard[row][col] == 'q' && col != a) {
                            check = false;
                            break;
                        }
                        col++;
                    }
                    if (!check) {
                        break;
                    }
                    row = 0;
                    col = a;
                    while (row < 8) {
                        if (theBoard[row][col] == 'q' && row != i) {
                            check = false;
                            break;
                        }
                        row++;
                    }
                    if (!check) {
                        break;
                    }
                    row = i;
                    col = a;
                    while (row < 8 && col < 8) {
                        if (theBoard[row][col] == 'q' && !(row == i && col == a)) {
                            check = false;
                            break;
                        }
                        col++;
                        row++;
                    }
                    if (!check) {
                        break;
                    }
                    row = i;
                    col = a;
                    while (row < 8 && col >= 0) {
                        if (theBoard[row][col] == 'q' && !(row == i && col == a)) {
                            check = false;
                            break;
                        }
                        col--;
                        row++;
                    }
                    if (!check) {
                        break;
                    }
                    row = i;
                    col = a;
                    while (row >= 0 && col >= 0) {
                        if (theBoard[row][col] == 'q' && !(row == i && col == a)) {
                            check = false;
                            break;
                        }
                        col--;
                        row--;
                    }
                    if (!check) {
                        break;
                    }
                    row = i;
                    col = a;
                    while (row >= 0 && col < 8) {
                        if (theBoard[row][col] == 'q' && !(row == i && col == a)) {
                            check = false;
                            break;
                        }
                        col++;
                        row--;
                    }
                    if (!check) {
                        break;
                    }
                    if (check) {
                        System.out.println(i + " " + a);
                        return;
                    }
                }
            }
        }
    }
}
