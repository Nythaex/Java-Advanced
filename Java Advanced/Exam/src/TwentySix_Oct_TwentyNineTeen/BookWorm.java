import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class BookWorm {
    private static int currentRows = -1;
    private static int currentCols = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder letter = new StringBuilder(reader.readLine());
        int size = Integer.parseInt(reader.readLine());
        char[][] field = new char[size][];

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            field[i] = line.toCharArray();
            if (line.contains("P")) {
                currentRows = i;
                for (int a = 0; a < field[i].length; a++) {
                    if (field[i][a] == 'P') {
                        currentCols = a;
                        break;
                    }
                }
            }
        }
        String command = reader.readLine();
        while (!command.equals("end")) {
            move(command, field,letter);
            command = reader.readLine();
        }
        System.out.println(letter);
        System.out.println(String.join("\n", Arrays.stream(field).map(String::valueOf).collect(Collectors.toList())));


    }

    private static void move(String command, char[][] field,StringBuilder letter) {
        switch (command) {
            case "up":
                if (currentRows-1>=0){
                    field[currentRows][currentCols]='-';
                    currentRows--;
                    if (field[currentRows][currentCols]!='-'){
                        letter.append(field[currentRows][currentCols]);
                        field[currentRows][currentCols]='P';
                    }
                }else {
                    if (letter.length()!=0){
                        letter.deleteCharAt(letter.length()-1);
                    }
                }
                break;
            case "down":
                if (currentRows+1< field.length){
                    field[currentRows][currentCols]='-';
                    currentRows++;
                    if (field[currentRows][currentCols]!='-'){
                        letter.append(field[currentRows][currentCols]);
                        field[currentRows][currentCols]='P';
                    }
                }else {
                    if (letter.length()!=0){
                        letter.deleteCharAt(letter.length()-1);
                    }
                }
                break;
            case "left":
                if (currentCols-1>=0){
                    field[currentRows][currentCols]='-';
                    currentCols--;
                    if (field[currentRows][currentCols]!='-'){
                        letter.append(field[currentRows][currentCols]);
                        field[currentRows][currentCols]='P';
                    }
                }else {
                    if (letter.length()!=0){
                        letter.deleteCharAt(letter.length()-1);
                    }
                }
                break;
            case "right":
                if (currentCols+1<field[currentRows].length){
                    field[currentRows][currentCols]='-';
                    currentCols++;
                    if (field[currentRows][currentCols]!='-'){
                        letter.append(field[currentRows][currentCols]);
                        field[currentRows][currentCols]='P';
                    }
                }else {
                    if (letter.length()!=0){
                        letter.deleteCharAt(letter.length()-1);
                    }
                }
                break;
        }
    }
}
