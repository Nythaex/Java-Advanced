import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ArraySize = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        char[][] board = new char[ArraySize[0]][];
        int[] player = {0, 0};
        for (int i = 0; i <= board.length - 1; i++) {
            char[] fill = scanner.nextLine().toCharArray();
            for (int a = 0; a <= fill.length - 1; a++) {
                if (fill[a] == 'P') {
                    player[0] = i;
                    player[1] = a;
                }
            }
            board[i] = fill;
        }
        Boolean dead = false;
        Boolean won = false;
        char[] comands = scanner.nextLine().toCharArray();
        int col = player[1];
        int row = player[0];
        for (int i = 0; i <= comands.length - 1; i++) {
            board[row][col] = '.';
            if (comands[i] == 'R') {
                if (col + 1 < board[row].length) {
                    col++;
                }else {
                    won=true;
                }
            } else if (comands[i] == 'L') {
                if (col - 1 >= 0) {
                    col--;
                }else {
                    won=true;
                }
            } else if (comands[i] == 'U') {
                if (row - 1 >= 0) {
                    row--;
                }else {
                    won=true;
                }
            } else if (comands[i] == 'D') {
                if (row + 1 < board.length) {
                    row++;
                }else {
                    won=true;
                }
            }
            if (board[row][col]=='B'){
                dead=true;
            }else if (won){

            }
            else {
                board[row][col]='P';
            }
            for (int bunnyI = 0; bunnyI <= board.length - 1; bunnyI++) {
                for (int bunnyA = 0; bunnyA <= board[bunnyI].length - 1; bunnyA++) {
                    if (board[bunnyI][bunnyA] == 'B') {
                        if (bunnyI - 1 >= 0) {
                            if (board[bunnyI - 1][bunnyA]=='P'){
                                dead=true;
                            }
                            if(board[bunnyI - 1][bunnyA] != 'B'){
                                board[bunnyI - 1][bunnyA] = 'F';
                            }
                        }
                        if (bunnyI + 1 < board.length) {
                            if (board[bunnyI + 1][bunnyA]=='P'){
                                dead=true;
                            }
                            if(board[bunnyI + 1][bunnyA] != 'B'){
                                board[bunnyI + 1][bunnyA] = 'F';
                            }

                        }
                        if (bunnyA - 1 >= 0) {
                            if (board[bunnyI ][bunnyA-1]=='P'){
                                dead=true;
                            }
                            if(board[bunnyI][bunnyA - 1] != 'B'){
                                board[bunnyI][bunnyA - 1] = 'F';
                            }
                        }
                        if (bunnyA + 1 < board[bunnyI].length) {
                            if (board[bunnyI ][bunnyA+1]=='P'){
                                dead=true;
                            }
                            if(board[bunnyI][bunnyA + 1] != 'B'){
                                board[bunnyI][bunnyA + 1] = 'F';
                            }

                        }

                    }
                }
            }
            for (int p = 0; p <= board.length - 1; p++) {
                for (int a = 0; a <= board[p].length - 1; a++) {
                    if (board[p][a] == 'F') {
                        board[p][a] = 'B';
                    }
                }
            }
            if (won){
                break;
            }
            if (dead) {
                break;
            }
        }
        for (int i = 0; i <= board.length - 1; i++) {
            for (int a = 0; a <= board[i].length - 1; a++) {
                System.out.print(board[i][a]);
            }
            System.out.println();
        }
        if (dead) {
            System.out.println("dead: " + row + " " + col);
        } else if(won) {
            System.out.println("won: " + row + " " + col);
        }

    }
}
