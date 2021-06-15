package Animal_;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Animal cat=new Dog("Oscar","dogs");
        System.out.println(cat.explainSelf());
    }
}
