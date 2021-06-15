import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RootSquare {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int num=Integer.parseInt(reader.readLine());
        }catch (IOException | NumberFormatException ex){
            System.out.println("Invalid number");
        }finally {
            System.out.println("Good bye");
        }

    }
}
