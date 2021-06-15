package SevenTeen_Dec_TwentyNineteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PresentDelivery {
    private static int currentRows = -1;
    private static int currentCols = -1;
    private static int goodKids = 0;
    private static int presentsCount = 0;
    private static boolean left = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        presentsCount = Integer.parseInt(reader.readLine());
        int size = Integer.parseInt(reader.readLine());
        String[][] field = new String[size][];

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            field[i] = line.split("\\s+");
            if (line.contains("S") || line.contains("V")) {
                currentRows = i;
                for (int a = 0; a < field[i].length; a++) {
                    if (field[i][a].equals("S")) {
                        currentCols = a;
                    } else if (field[i][a].equals("V")) {
                        goodKids++;
                    }
                }
            }
        }
        int happyOnes = goodKids;
        String command = reader.readLine();
        while (!command.equals("Christmas morning")) {
            move(command, field);
            if (presentsCount<=0){
                break;
            }
            command = reader.readLine();
        }
        if (presentsCount <= 0 ) {
            System.out.println("Santa ran out of presents!");
        }
        for (int i = 0; i <= field.length - 1; i++) {
            for (int a = 0; a <= field[i].length - 1; a++) {
                if (i == currentRows && a == currentCols) {
                    System.out.print("S");
                } else {
                    System.out.print(field[i][a]);
                }
                System.out.print(" ");

            }
            System.out.println();
        }
        if (goodKids == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", happyOnes);
        } else {
            System.out.printf("No presents for %d nice kid/s.", goodKids);
        }
    }

    private static void ExtraPresents(String[][] field) {
        if (currentRows - 1 >= 0) {
            if (field[currentRows - 1][currentCols].equals("V")) {
                goodKids--;
                presentsCount--;
                field[currentRows+1][currentCols] = "-";
            } else if (field[currentRows - 1][currentCols].equals("X")) {
                presentsCount--;
                field[currentRows-1][currentCols] = "-";
            }
        }
        if (currentRows + 1 < field.length) {
            if (field[currentRows + 1][currentCols].equals("V")) {
                goodKids--;
                presentsCount--;
                field[currentRows][currentCols + 1] = "-";
            } else if (field[currentRows + 1][currentCols].equals("X")) {
                presentsCount--;
                field[currentRows+1][currentCols ] = "-";
            }
        }
        if (currentCols - 1 >= 0) {
            if (field[currentRows][currentCols - 1].equals("V")) {
                goodKids--;
                presentsCount--;
                field[currentRows][currentCols - 1] = "-";
            } else if (field[currentRows][currentCols - 1].equals("X")) {
                presentsCount--;
                field[currentRows][currentCols - 1] = "-";
            }
        }
        if (currentCols + 1 < field[currentRows].length) {
            if (field[currentRows][currentCols + 1].equals("V")) {
                goodKids--;
                presentsCount--;
                field[currentRows][currentCols + 1] = "-";
            }
            if (field[currentRows][currentCols + 1].equals("X")) {
                presentsCount--;
                field[currentRows][currentCols + 1] = "-";
            }
        }
    }

    private static void move(String command, String[][] field) {
        switch (command) {
            case "up":
                if (currentRows - 1 >= 0) {
                    field[currentRows][currentCols] = "-";
                    currentRows--;
                    if (field[currentRows][currentCols].equals("V")) {
                        goodKids--;
                        presentsCount--;

                    } else if (field[currentRows][currentCols].equals("C")) {
                        ExtraPresents(field);
                    }
                } else {
                    left = true;
                    currentRows--;
                }
                break;
            case "down":
                if (currentRows + 1 < field.length) {
                    field[currentRows][currentCols] = "-";
                    currentRows++;
                    if (field[currentRows][currentCols].equals("V")) {
                        goodKids--;
                        presentsCount--;

                    } else if (field[currentRows][currentCols].equals("C")) {
                        ExtraPresents(field);
                    }
                } else {
                    left = true;
                    currentRows++;
                }
                break;
            case "left":
                if (currentCols - 1 >= 0) {
                    field[currentRows][currentCols] = "-";
                    currentCols--;
                    if (field[currentRows][currentCols].equals("V")) {
                        goodKids--;
                        presentsCount--;

                    } else if (field[currentRows][currentCols].equals("C")) {
                        ExtraPresents(field);
                    }
                } else {
                    left = true;
                    currentCols--;
                }
                break;
            case "right":
                if (currentCols + 1 < field[currentRows].length) {
                    field[currentRows][currentCols] = "-";
                    currentCols++;
                    if (field[currentRows][currentCols].equals("V")) {
                        goodKids--;
                        presentsCount--;

                    } else if (field[currentRows][currentCols].equals("C")) {
                        ExtraPresents(field);
                    }
                } else {
                    left = true;
                    currentCols++;
                }
                break;
        }
    }
}
