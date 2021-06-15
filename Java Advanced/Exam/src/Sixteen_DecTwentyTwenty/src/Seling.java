import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seling {
    private static int currentRows = -1;
    private static int currentCols = -1;
    private static int money = 0;
    private static boolean left = false;
    private static int[] firstO = new int[]{-1, -1};
    private static int[] secondO = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String[][] field = new String[size][];
        firstO = new int[]{-1, -1};
        secondO = new int[2];
        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            field[i] = line.split("");
            if (line.contains("S") || line.contains("O")) {
                for (int a = 0; a < field[i].length; a++) {
                    if (field[i][a].equals("S")) {
                        currentCols = a;
                        currentRows = i;
                    } else if (field[i][a].equals("O")) {
                        if (firstO[1] == -1) {
                            firstO[0] = i;
                            firstO[1] = a;
                        } else {
                            secondO[0] = i;
                            secondO[1] = a;
                        }
                    }
                }
            }
        }
        String command = reader.readLine();
        while (money < 50) {
            move(command, field);
            if (left) {
                break;
            }
            command = reader.readLine();
        }
        if (left){
            System.out.println("Bad news, you are out of the bakery.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: "+money);
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
                    field[currentRows][currentCols] = "-";
                    currentRows--;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = "-";
                        if (currentCols == firstO[1] && currentRows == firstO[0]) {
                            currentRows = secondO[0];
                            currentCols = secondO[1];
                        } else {
                            currentRows = firstO[0];
                            currentCols = firstO[1];
                        }
                        field[currentRows][currentCols] = "S";

                    } else if (field[currentRows][currentCols].equals("-")) {
                        field[currentRows][currentCols] = "S";
                    }else {
                        money+=Integer.parseInt(field[currentRows][currentCols]);
                        field[currentRows][currentCols]="S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = "-";
                }
                break;
            case "down":
                if (currentRows + 1 < field.length) {
                    field[currentRows][currentCols] = "-";
                    currentRows++;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = "-";
                        if (currentCols == firstO[1] && currentRows == firstO[0]) {
                            currentRows = secondO[0];
                            currentCols = secondO[1];
                        } else {
                            currentRows = firstO[0];
                            currentCols = firstO[1];
                        }
                        field[currentRows][currentCols] = "S";

                    } else if (field[currentRows][currentCols].equals("-")) {
                        field[currentRows][currentCols] = "S";
                    }else {
                        money+=Integer.parseInt(field[currentRows][currentCols]);
                        field[currentRows][currentCols]="S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = "-";
                }
                break;
            case "left":
                if (currentCols - 1 >= 0) {
                    field[currentRows][currentCols] = "-";
                    currentCols--;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = "-";
                        if (currentCols == firstO[1] && currentRows == firstO[0]) {
                            currentRows = secondO[0];
                            currentCols = secondO[1];
                        } else {
                            currentRows = firstO[0];
                            currentCols = firstO[1];
                        }
                        field[currentRows][currentCols] = "-";

                    } else if (field[currentRows][currentCols].equals("-")) {
                        field[currentRows][currentCols] = "S";
                    }else {
                        money+=Integer.parseInt(field[currentRows][currentCols]);
                        field[currentRows][currentCols]="S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = "-";
                }
                break;
            case "right":
                if (currentCols + 1 < field[currentRows].length) {
                    field[currentRows][currentCols] = "-";
                    currentCols++;
                    if (field[currentRows][currentCols].equals("O")) {
                        field[currentRows][currentCols] = "-";
                        if (currentCols == firstO[1] && currentRows == firstO[0]) {
                            currentRows = secondO[0];
                            currentCols = secondO[1];
                        } else {
                            currentRows = firstO[0];
                            currentCols = firstO[1];
                        }
                        field[currentRows][currentCols] = "S";

                    } else if (field[currentRows][currentCols].equals("-")) {
                        field[currentRows][currentCols] = "S";
                    }else {
                        money+=Integer.parseInt(field[currentRows][currentCols]);
                        field[currentRows][currentCols]="S";
                    }
                } else {
                    left = true;
                    field[currentRows][currentCols] = "-";
                }
                break;
        }
    }
}
