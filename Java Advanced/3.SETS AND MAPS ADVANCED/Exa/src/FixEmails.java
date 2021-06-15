import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Pattern regex=Pattern.compile("^[\\w\\d]+@[\\w\\d]+.[^us|uk|com]+$");
        String command=scanner.nextLine();
        while (!command.equals("stop")){
            String email=scanner.nextLine();
            Matcher matcher= regex.matcher(email);
            if (matcher.find()){
                System.out.println(command+" -> "+email);
            }
            command=scanner.nextLine();
        }
    }
}
