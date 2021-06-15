import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
    }

    private static String printRhombusOfStars(int count) {
        StringBuilder print = new StringBuilder();
        print.append(UpperTriangle(count, false));
        print.append(UpperTriangle(count - 1, true));
        return print.toString();
    }

    private static String UpperTriangle(int count, boolean checker) {
        StringBuilder print = new StringBuilder();
        if (!checker) {
            for (int i = 1; i <= count; i++) {
                print.append(linePrinter(i, count - i));
            }
        } else {
            int spaces=1;
            for (int i = count; i >= 1; i--) {
                print.append(linePrinter(i, spaces));
                spaces++;
            }
        }
        return print.toString();
    }

    private static String linePrinter(int stars, int spaces) {
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < spaces; i++) {
            print.append(" ");
        }
        for (int i = 0; i <stars; i++) {
            print.append("* ");
        }
        for (int i = 0; i < spaces-1; i++) {
            print.append(" ");
        }
        return print.append(System.lineSeparator()).toString();
    }
}
