import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bee {
    private static int currentRows = -1;
    private static int currentCols = -1;
    private static int flowers = 0;
    private static boolean left = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String[][] field = new String[size][];
        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            field[i] = line.split("");
            if (line.contains("B")) {
                for (int a = 0; a < field[i].length; a++) {
                    if (field[i][a].equals("B")) {
                        currentCols = a;
                        currentRows = i;

                    }
                }
            }
        }
        String command = reader.readLine();
        while (!command.equals("End")) {
            move(command, field);
            if (left) {
                break;
            }
            command = reader.readLine();
        }
        if (left) {
            System.out.println("The bee got lost!");
        }
        if (flowers < 5) {
            System.out.println(String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - flowers));
        } else {
            System.out.println(String.format("Great job, the bee manage to pollinate %d flowers!", flowers));
        }
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
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = ".";
                        if (currentRows - 1 >= 0) {
                            currentRows--;
                        } else {
                            left = true;
                            break;
                        }
                    }
                    if (field[currentRows][currentCols].equals("f")) {
                        flowers++;
                    }
                    field[currentRows][currentCols] = "B";
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
            case "down":
                if (currentRows + 1 < field.length) {
                    field[currentRows][currentCols] = ".";
                    currentRows++;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = ".";
                        if (currentRows + 1 < field.length) {
                            currentRows++;

                        } else {
                            left = true;
                            break;
                        }
                    }
                    if (field[currentRows][currentCols].equals("f")) {
                        flowers++;
                    }
                    field[currentRows][currentCols] = "B";
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
            case "left":
                if (currentCols - 1 >= 0) {
                    field[currentRows][currentCols] = ".";
                    currentCols--;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = ".";
                        if (currentCols - 1 >= 0) {
                            currentCols--;

                        } else {
                            left = true;
                            break;
                        }
                    }
                    if (field[currentRows][currentCols].equals("f")) {
                        flowers++;
                    }
                    field[currentRows][currentCols] = "B";
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
            case "right":
                if (currentCols + 1 < field[currentRows].length) {
                    field[currentRows][currentCols] = ".";
                    currentCols++;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = ".";
                        if (currentCols + 1 < field[currentRows].length) {
                            currentCols++;

                        } else {
                            left = true;
                            break;
                        }
                    }
                    if (field[currentRows][currentCols].equals("f")) {
                        flowers++;
                    }
                    field[currentRows][currentCols] = "B";
                } else {
                    left = true;
                    field[currentRows][currentCols] = ".";
                }
                break;
        }
    }

}
