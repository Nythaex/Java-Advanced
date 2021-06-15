import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        Map<String,BankAccount> accounts=new HashMap<>();
        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Deposit":
                    if (accounts.containsKey(tokens[1])){
                        accounts.get(tokens[1]).deposit(Double.parseDouble(tokens[2]));
                        System.out.printf("Deposited %s to ID%s%n",tokens[2],tokens[1]);
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "SetInterest":
                    BankAccount.interest=Double.parseDouble(tokens[1]);
                    break;
                case "GetInterest":
                    if (accounts.containsKey(tokens[1])){
                        System.out.println(String.format("%.2f",accounts.get(tokens[1]).getInterestRate()));
                    }else {
                        System.out.println("Account does not exist");
                    }
                    break;
                case "Create":
                    BankAccount bankAccount=new BankAccount();
                    accounts.put(String.valueOf(BankAccount.IdCounter),bankAccount);
                    System.out.printf("Account ID%d created%n",BankAccount.IdCounter);
                    break;
            }


            command = reader.readLine();
            ;
        }
    }
}
