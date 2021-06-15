import java.util.ArrayDeque;
import java.util.Scanner;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String[] robots=scanner.nextLine().split(";");
        String [] name=new String [robots.length];
        int[] timeForCompletingJobs=new int [robots.length];
        for (int i = 0; i <=robots.length - 1; i++) {
            String[]tokens=robots[i].split("-");
            name[i]=tokens[0];
            timeForCompletingJobs[i]=Integer.parseInt(tokens[1]);
        }
        String []timeForSplitting=scanner.nextLine().split(":");
        int finalSeconds=Integer.parseInt(timeForSplitting[0])*3600+Integer.parseInt(timeForSplitting[1])*60
                +Integer.parseInt(timeForSplitting[2]);
        int[]robotsAvailability=new int[robots.length];
        String product=scanner.nextLine();
        ArrayDeque<String>products=new ArrayDeque<>();
        while (!product.equals("End")){
            products.offer(product);
            product=scanner.nextLine();
        }
        while (!products.isEmpty()){
            int index=-1;
            for (int i = 0; i <= robots.length-1 ; i++) {
                if (robotsAvailability[i] == 0) {
                    robotsAvailability[i]=timeForCompletingJobs[i];
                    index=i;
                    break;
                }

            }
            for (int i = 0; i <= robots.length - 1; i++) {
                if (robotsAvailability[i]>0){
                    robotsAvailability[i]--;
                }
            }
            finalSeconds++;
            if (index!=-1){
                String print=printTheRobotWorkingInfo(name[index],products.poll(),finalSeconds);
                System.out.println(print);
            }else {
                products.offer(products.poll());
            }
        }


    }

    private static String printTheRobotWorkingInfo(String s, String pop, int finalSeconds) {
        long seconds = finalSeconds % 60;
        long minutes = (finalSeconds / 60) % 60;
        long hours = (finalSeconds / (60 * 60)) % 24;

        String time=String.format("%02d:%02d:%02d",hours,minutes,seconds);


        return String.format("%s - %s [%s] ",s,pop,time);
    }
}
