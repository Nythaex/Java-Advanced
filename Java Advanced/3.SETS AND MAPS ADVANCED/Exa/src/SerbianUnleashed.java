import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SerbianUnleashed {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
            Map<String, Map<String, Integer>> places = new LinkedHashMap<>();
            while (!command.equals("End")) {
                String[] firstSplit = command.split(" @");
                String singer = firstSplit[0];
                if (firstSplit.length == 2) {
                    String[] secondSplit = firstSplit[1].split(" ");
                    if (secondSplit.length >= 3) {
                        int priceOfAll=0;
                        try {
                             priceOfAll =Integer.parseInt(secondSplit[secondSplit.length - 2]) * Integer.parseInt(secondSplit[secondSplit.length - 1]);
                        }catch (Exception exception){
                            command = reader.readLine();
                           continue;
                        }

                        StringBuilder place = new StringBuilder();
                        int count = secondSplit.length - 3;
                        for (int i = 0; i <= count; i++) {
                            place.append(secondSplit[i]);
                            if (i != count) {
                                place.append(" ");
                            }
                        }
                        places.putIfAbsent(String.valueOf(place), new LinkedHashMap<>());
                        places.get(String.valueOf(place)).putIfAbsent(singer, 0);
                        places.get(String.valueOf(place)).put(singer, places.get(String.valueOf(place)).get(singer) + priceOfAll);


                    }
                }
                command = reader.readLine();
            }
            places.entrySet().forEach(place -> {
                System.out.println(place.getKey());
                place.getValue().entrySet().stream().sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                        .forEach((singer) -> System.out.printf("#  %s -> %d%n", singer.getKey(), singer.getValue()));
            });


    }
}

