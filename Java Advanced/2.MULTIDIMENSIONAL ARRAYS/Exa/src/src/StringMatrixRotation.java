import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("[A-Za-z]+\\((?<num>\\d+)\\)");
        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);
        int n = 0;
        if (matcher.find()) {
            n = Integer.parseInt(matcher.group("num"));
        }
        String command = scanner.nextLine();
        List<String> words = new ArrayList<>();
        while (!command.equals("END")) {
            words.add(command);
            command = scanner.nextLine();
        }
        int lenght = getMaxLenght(words);
        char[][] theMainMatrix = new char[words.size()][lenght];
        for (int i = 0; i <= words.size() - 1; i++) {
            for (int a = 0; a <= lenght-1; a++) {
                if (a<words.get(i).length()) {
                    theMainMatrix[i][a] = words.get(i).charAt(a);
                }else {
                    theMainMatrix[i][a]=' ';
                }

            }
        }
        while (n>=360){
            n=n%360;
        }
        if (n % 360 == 0) {
            pirntArray(theMainMatrix);
        } else if (n % 270 == 0) {
            char[][] finalMatrix = new char[lenght][words.size()];
            for (int i = 0; i <= words.size()-1; i++) {
                for (int a = 0; a <= finalMatrix.length-1; a++) {
                    finalMatrix[a][i]=theMainMatrix[i][theMainMatrix[i].length-a-1];
                }
            }
            pirntArray(finalMatrix);
        } else if (n % 180 == 0) {
            char[][] finalMatrix = new char[words.size()][lenght];
            for (int i = 0; i <= words.size() - 1; i++) {
                for (int a = 0; a <= theMainMatrix[i].length-1; a++) {
                    finalMatrix[i][a]=theMainMatrix[theMainMatrix.length-i-1][theMainMatrix[i].length-a-1];
                }
            }
            pirntArray(finalMatrix);
        } else if (n % 90 == 0) {
            char[][] finalMatrix = new char[lenght][words.size()];
            for (int i = 0; i <= words.size()-1; i++) {
                for (int a = 0; a <= finalMatrix.length-1; a++) {
                    finalMatrix[a][i]=theMainMatrix[theMainMatrix.length-i-1][a];
                }
            }
            pirntArray(finalMatrix);
        }

    }

    private static void pirntArray(char[][] finalMatrix) {
        for (int i = 0; i <= finalMatrix.length - 1; i++) {
            for (int a= 0; a <=finalMatrix[i].length - 1; a++) {
                System.out.print(finalMatrix[i][a]);
            }
            System.out.println();
        }
    }

    private static int getMaxLenght(List<String> words) {
        int max = Integer.MIN_VALUE;
        for (String a : words
        ) {
            if (max < a.length()) {
                max = a.length();
            }
        }
        return max;
    }
}
