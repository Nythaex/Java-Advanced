import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PPhonebook {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,String> contacts=new HashMap<>();
        String phoneNumber=scanner.nextLine();
        while (!phoneNumber.equals("search")){
            String []tokens=phoneNumber.split("-");
            contacts.put(tokens[0],tokens[1]);
            phoneNumber=scanner.nextLine();
        }
        phoneNumber=scanner.nextLine();
        while (!phoneNumber.equals("stop")){
           if (contacts.containsKey(phoneNumber)){
               System.out.println(phoneNumber+" -> "+contacts.get(phoneNumber));
           }
           else {
               System.out.printf("Contact %s does not exist.%n",phoneNumber);
           }
            phoneNumber=scanner.nextLine();
        }
    }
}
