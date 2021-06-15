import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String url = scanner.nextLine();
        String currentPage = "";
        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (stack.size()<2) {
                    System.out.println("no previous URLs");
                } else {
                    queue.offer(stack.peek());
                    stack.pop();
                    currentPage=stack.peek();
                    System.out.println(currentPage);
                }
                /////////////////////
            } else if (url.equals("forward")) {
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    currentPage = queue.peek();
                    stack.push(currentPage);
                    System.out.println(currentPage);
                    queue.poll();
                    ////////////////////
                }
            } else {
                queue.clear();
                currentPage = url;
                stack.push(currentPage);
                System.out.println(currentPage);
            }
            url = scanner.nextLine();
        }


    }
}
