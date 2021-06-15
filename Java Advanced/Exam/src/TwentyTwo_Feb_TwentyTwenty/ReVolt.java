import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReVolt {
    private static int currentRows = -1;
    private static int currentCols = -1;
    private static boolean left=false;
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int commandsCount = Integer.parseInt(reader.readLine());
        char[][] field = new char[size][];

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            field[i] = line.toCharArray();
            if (line.contains("f")) {
                currentRows = i;
                for (int a = 0; a < field[i].length; a++) {
                    if (field[i][a] == 'f') {
                        currentCols = a;
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= commandsCount; i++) {
            String command=reader.readLine();
            move(command, field);
            if (left){
                break;
            }
        }
        if (left){
            System.out.println("Player won!");
        }else {
            System.out.println("Player lost!");
        }
        for (int i = 0; i <size; i++) {
            for (int a= 0; a < size; a++) {
                System.out.print(field[i][a]);
            }
            System.out.println();
        }

    }
    private static void move(String command, char[][] field) {
        switch (command) {
            case "up":
                field[currentRows][currentCols]='-';
                currentRows--;
                if (currentRows<0){
                    currentRows= field.length-1;
                }
                while (field[currentRows][currentCols]!='-'){
                    if (field[currentRows][currentCols]=='B'){
                        currentRows--;
                        if (currentRows<0){
                            currentRows= field.length-1;
                        }
                    }else if (field[currentRows][currentCols]=='T'){
                        currentRows++;
                        if (currentRows>=field.length){
                            currentRows= 0;
                        }
                    }else if (field[currentRows][currentCols]=='F'){
                        field[currentRows][currentCols]='f';
                        left=true;
                        break;
                    }
                }
                field[currentRows][currentCols]='f';
                break;
            case "down":
                field[currentRows][currentCols]='-';
                currentRows++;
                if (currentRows>=field.length){
                    currentRows= 0;
                }
                while (field[currentRows][currentCols]!='-'){
                    if (field[currentRows][currentCols]=='B'){
                        currentRows++;
                        if (currentRows>=field.length){
                            currentRows= 0;
                        }
                    }else if (field[currentRows][currentCols]=='T'){
                        currentRows--;
                        if (currentRows<0){
                            currentRows= field.length-1;
                        }
                    }else if (field[currentRows][currentCols]=='F'){
                        field[currentRows][currentCols]='f';
                        left=true;
                        break;
                    }
                }
                field[currentRows][currentCols]='f';
                break;
            case "left":
                field[currentRows][currentCols]='-';
                currentCols--;
                if (currentCols<0){
                    currentCols= field[currentRows].length-1;
                }
                while (field[currentRows][currentCols]!='-'){
                    if (field[currentRows][currentCols]=='B'){
                        currentCols--;
                        if (currentCols<0){
                            currentCols= field[currentRows].length-1;
                        }
                    }else if (field[currentRows][currentCols]=='T'){
                        currentCols++;
                        if (currentCols>=field[currentRows].length){
                            currentCols= 0;
                        }
                    }else if (field[currentRows][currentCols]=='F'){
                        field[currentRows][currentCols]='f';
                        left=true;
                        break;
                    }
                }
                field[currentRows][currentCols]='f';
                break;
            case "right":
                field[currentRows][currentCols]='-';
                currentCols++;
                if (currentCols>=field[currentRows].length){
                    currentCols= 0;
                }
                while (field[currentRows][currentCols]!='-'){
                    if (field[currentRows][currentCols]=='B'){
                        currentCols++;
                        if (currentCols>=field[currentRows].length){
                            currentCols= 0;
                        }
                    }else if (field[currentRows][currentCols]=='T'){
                        currentCols--;
                        if (currentCols<0){
                            currentCols= field[currentRows].length-1;
                        }
                    }else if (field[currentRows][currentCols]=='F'){
                        field[currentRows][currentCols]='f';
                        left=true;
                        break;
                    }
                }
                field[currentRows][currentCols]='f';
                break;
        }
    }
}
