import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Stream;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<String,Map<String,Integer>> addreses=new TreeMap<>();
        String command=scanner.nextLine();
        while (!command.equals("end")){
            String[] tokens=command.split(" ");
            String IP=tokens[0].split("=")[1];
            String name=tokens[2].split("=")[1];
            addreses.putIfAbsent(name,new LinkedHashMap<>());
            addreses.get(name).putIfAbsent(IP,0);
            addreses.get(name).put(IP,addreses.get(name).get(IP)+1);
            command=scanner.nextLine();
        }
        StringBuilder p=new StringBuilder();
        addreses.entrySet().stream()
                .forEach(s->{
                    System.out.println(s.getKey()+": ");
                    s.getValue().entrySet().stream().forEach((k)->{
                        p.append(k.getKey()+" => "+k.getValue());
                        p.append(", ");
                    });
                    p.delete(p.length()-2,p.length());
                    p.append(".");
                    System.out.println(p);
                    p.delete(0,p.length());
                });
    }
}
