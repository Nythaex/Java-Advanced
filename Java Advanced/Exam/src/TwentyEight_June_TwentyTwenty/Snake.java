import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snake {
    private static int currentRows = -1;
    private static int currentCols = -1;
    private static int food = 0;
    private static boolean left = false;
    private static int[] firstB = new int[]{-1, -1};
    private static int[] secondB = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String[][] field = new String[size][];
        firstB = new int[]{-1, -1};
        secondB = new int[2];
        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            field[i] = line.split("");
            if (line.contains("S") || line.contains("B")) {
                for (int a = 0; a < field[i].length; a++) {
                    if (field[i][a].equals("S")) {
                        currentCols = a;
                        currentRows = i;
                    } else if (field[i][a].equals("B")) {
                        if (firstB[1] == -1) {
                            firstB[0] = i;
                            firstB[1] = a;
                        } else {
                            secondB[0] = i;
                            secondB[1] = a;
                        }
                    }
                }
            }
        }
        String command = reader.readLine();
        while (food < 10) {
            move(command, field);
            if (left) {
                break;
            }
            command = reader.readLine();
        }
        if (left) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);

        for (int i = 0; i <= field.length - 1; i++) {
            for (int a = 0; a <= field[i].length - 1; a++) {

                System.out.print(field[i][a]);


            }
            System.out.println();
        }
    }

    private static void move(String command, String[][] field) {
        switch (command) {
            case "up":
                if (currentRows - 1 >= 0) {
                    field[currentRows][currentCols] = ".";
                    currentRows--;
                    if (field[currentRows][currentCols].equals("B")) {
                        field[currentRows][currentCols] = ".";
                        if (currentCols == firstB[1] && currentRows == firstB[0]) {
                            currentRows = secondB[0];
                            currentCols = secondB[1];
                        } else {
                            currentRows = firstB[0];
                            currentCols = firstB[1];
                        }
                        field[currentRows][currentCols] = "S";
                    } else if (field[currentRows][currentCols].equals("*")) {
                        field[currentRows][currentCols] = "S";
                        food++;
                    } else if (field[currentRows][currentCols].equals(".")) {
                        field[currentRows][currentCols] = "S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
            case "down":
                if (currentRows + 1 < field.length) {
                    field[currentRows][currentCols] = ".";
                    currentRows++;
                    if (field[currentRows][currentCols].equals("B")) {
                        field[currentRows][currentCols] = ".";
                        if (currentCols == firstB[1] && currentRows == firstB[0]) {
                            currentRows = secondB[0];
                            currentCols = secondB[1];
                        } else {
                            currentRows = firstB[0];
                            currentCols = firstB[1];
                        }
                        field[currentRows][currentCols] = "S";
                    } else if (field[currentRows][currentCols].equals("*")) {
                        field[currentRows][currentCols] = "S";
                        food++;
                    } else if (field[currentRows][currentCols].equals(".")) {
                        field[currentRows][currentCols] = "S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
            case "left":
                if (currentCols - 1 >= 0) {
                    field[currentRows][currentCols] = ".";
                    currentCols--;
                    if (field[currentRows][currentCols].equals("B")) {
                        field[currentRows][currentCols] = ".";
                        if (currentCols == firstB[1] && currentRows == firstB[0]) {
                            currentRows = secondB[0];
                            currentCols = secondB[1];
                        } else {
                            currentRows = firstB[0];
                            currentCols = firstB[1];
                        }
                        field[currentRows][currentCols] = "S";
                    } else if (field[currentRows][currentCols].equals("*")) {
                        field[currentRows][currentCols] = "S";
                        food++;
                    } else if (field[currentRows][currentCols].equals(".")) {
                        field[currentRows][currentCols] = "S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
            case "right":
                if (currentCols + 1 < field[currentRows].length) {
                    field[currentRows][currentCols] = ".";
                    currentCols++;
                    if (field[currentRows][currentCols].equals("B")) {
                        field[currentRows][currentCols] = ".";
                        if (currentCols == firstB[1] && currentRows == firstB[0]) {
                            currentRows = secondB[0];
                            currentCols = secondB[1];
                        } else {
                            currentRows = firstB[0];
                            currentCols = firstB[1];
                        }
                        field[currentRows][currentCols] = "S";
                    } else if (field[currentRows][currentCols].equals(".")) {
                        field[currentRows][currentCols] = "S";
                    } else if (field[currentRows][currentCols].equals("*")) {
                        field[currentRows][currentCols] = "S";
                        food++;
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
        }
    }
}
