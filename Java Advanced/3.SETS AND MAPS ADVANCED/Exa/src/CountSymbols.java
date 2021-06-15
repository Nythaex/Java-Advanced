import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Map<Character,Integer> symbols=new TreeMap<>();
        char [] symbol=scanner.nextLine().toCharArray();
        for (int i = 0; i <= symbol.length - 1; i++) {
            if (!symbols.containsKey(symbol[i])) {
                symbols.put(symbol[i], 0);
            }
            symbols.put(symbol[i],symbols.get(symbol[i])+1);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : symbols.entrySet()) {
            System.out.println(String.format("%c: %d time/s",characterIntegerEntry.getKey(),characterIntegerEntry.getValue()));
        }


    }
}
