import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LogsAgregator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> durationMap=new TreeMap<>();
        Map<String, Set<String>> IPs=new TreeMap<>();
        int count=Integer.parseInt(reader.readLine());
        for (int i = 0; i <count; i++) {
            String []tokens=reader.readLine().split("\\s+");
            int duration=Integer.parseInt(tokens[2]);
            durationMap.putIfAbsent(tokens[1],0);
            durationMap.put(tokens[1],durationMap.get(tokens[1])+duration);
            IPs.putIfAbsent(tokens[1],new TreeSet<>());
            IPs.get(tokens[1]).add(tokens[0]);
        }
        durationMap.entrySet().stream().forEach(dur->{
            System.out.printf("%s: %d ",dur.getKey(),dur.getValue());
            String value=String.join(", ",IPs.get(dur.getKey()));
            System.out.println("["+value+"]");
        });


    }
}
