package Generic_Scale;

public class Main {
    public static void main(String[] args) {
        Scale<Character> scale=new Scale<>('a','m');
        System.out.println(scale.getHeavier());
    }
}
