package Generic_Swap_Method;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Box<String> list= new Box<String>();
        int n=Integer.parseInt(reader.readLine());
        for (int i = 0; i <n; i++) {
           list.addElement((reader.readLine()));
        }
        String[] tokens=reader.readLine().split("\\s+");
        list.swap(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
        System.out.println(list.toString());
    }
}
