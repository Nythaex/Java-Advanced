import java.util.ArrayDeque;
import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] board = new String[15][15];
        String p = " p p p p p p p p p p p p p p ";
        for (int i = 0; i <= board.length - 1; i++) {
            String[] fill = p.split("p");
            board[i] = fill;
        }
        double damage = Double.parseDouble(scanner.nextLine());
        double bossHealth = 3000000;
        double playerHealth = 18500;
        ArrayDeque<String> cloudQueue = new ArrayDeque<>();
        int days = 0;

        String spell = "";
        String command = scanner.nextLine();
        int[] player = {7, 7};
        Boolean effectOfCloud = false;
        while (bossHealth > 0 && playerHealth > 0) {
            String[] tokens = command.split("\\s+");
            bossHealth -= damage;
            if (bossHealth < 0) {
                if (effectOfCloud) {
                    playerHealth -= 3500;
                    if (playerHealth <= 0) {
                        spell = "Cloud";
                    }
                }
                break;
            }
            if (effectOfCloud) {
                playerHealth -= 3500;
                effectOfCloud = false;
                if (playerHealth <= 0) {
                    spell = "Cloud";
                    break;
                }
            }
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            spell = tokens[0];
            if (spell.equals("Cloud")) {
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int a = col - 1; a <= col + 1; a++) {
                        if (Inside(i, a, board)) {
                            board[i][a] = "d";
                        }
                    }
                }
                if (!board[player[0]][player[1]].equals(" ")) {
                    if (player[0] - 1 >= 0 && board[player[0] - 1][player[1]].equals(" ")) {
                        player[0] = player[0] - 1;
                    } else if (player[1] + 1 < 15 && board[player[0]][player[1] + 1].equals(" ")) {
                        player[1] = player[1] + 1;
                    } else if (player[0] + 1 < 15 && board[player[0] + 1][player[1]].equals(" ")) {
                        player[0] = player[0] + 1;
                    } else if (player[1] - 1 >= 0 && board[player[0]][player[1] - 1].equals(" ")) {
                        player[1] = player[1] - 1;
                    } else {
                        playerHealth -= 3500;
                        effectOfCloud=true;
                        if (playerHealth <= 0) {
                            break;
                        }
                    }
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int a = col - 1; a <= col + 1; a++) {
                            if (Inside(i, a, board)) {
                                board[i][a] = " ";
                            }
                        }
                    }
                }
            } else if (spell.equals("Eruption")) {
                for (int i = row - 1; i <= row + 1; i++) {
                    for (int a = col - 1; a <= col + 1; a++) {
                        if (Inside(i, a, board)) {
                            board[i][a] = "d";
                        }
                    }
                }
                if (!board[player[0]][player[1]].equals(" ")) {
                    if (player[0] - 1 >= 0 && board[player[0] - 1][player[1]].equals(" ")) {
                        player[0] = player[0] - 1;
                    } else if (player[1] + 1 < 15 && board[player[0]][player[1] + 1].equals(" ")) {
                        player[1] = player[1] + 1;
                    } else if (player[0] + 1 < 15 && board[player[0] + 1][player[1]].equals(" ")) {
                        player[0] = player[0] + 1;
                    } else if (player[1] - 1 >= 0 && board[player[0]][player[1] - 1].equals(" ")) {
                        player[1] = player[1] - 1;
                    } else {
                        playerHealth-=6000;
                        if (playerHealth<=0) {
                            break;
                        }
                    }
                    for (int i = row - 1; i <= row + 1; i++) {
                        for (int a = col - 1; a <= col + 1; a++) {
                            if (Inside(i, a, board)) {
                                board[i][a] = " ";
                            }
                        }
                    }
                }
            }
            command=scanner.nextLine();
        }


        if (bossHealth <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f%n" , bossHealth);
        }
        if (playerHealth<= 0) {
            if (spell.equals("Cloud")){
                spell="Plague Cloud";
            }
            System.out.println("Player: Killed by " + spell);
        } else {
            System.out.printf("Player: %.0f%n", playerHealth);
        }
        System.out.println("Final position: " + player[0] + ", " + player[1]);
    }

    private static boolean Inside(int i, int a, String[][] pole) {
        int sizeRow = pole.length;
        return i >= 0 && i < 15 && a >= 0 && a < 15;
    }
}
