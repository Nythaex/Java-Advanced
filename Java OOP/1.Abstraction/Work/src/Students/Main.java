package Students;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        String input = scanner.nextLine();
        while (!input.equals("Exit"))
        {
            String[] token = input.split(" ");
            studentSystem.studentCommand(token);
            input = scanner.nextLine();
        }
    }
}
