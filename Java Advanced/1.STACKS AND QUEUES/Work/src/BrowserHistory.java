import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayDeque<String> stack=new ArrayDeque<>();
        String url=scanner.nextLine();
        while (!url.equals("Home")){
            if (url.equals("back")){
                if (!stack.isEmpty()){
                    url=stack.pop();
                    if (stack.isEmpty()){
                        System.out.println("no previous URLs");
                        stack.push(url);
                    }else {
                        System.out.println(stack.peek());
                    }
                }else {
                    System.out.println("no previous URLs");
                    stack.push(url);
                }

            }else {
                stack.push(url);
                System.out.println(url);
            }
            url=scanner.nextLine();
        }

    }
}
