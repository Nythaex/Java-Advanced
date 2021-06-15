import java.io.*;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) throws IOException {
        Path output = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\OutPut.txt");
        Path pathOfWords = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\words.txt");
        Path pathText = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\text.txt");
        BufferedReader readerWords = new BufferedReader(new FileReader(String.valueOf(pathOfWords)));
        BufferedReader readerText= new BufferedReader(new FileReader(String.valueOf(pathText)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(output)));

        Map<String,Integer> map=new HashMap<>();
        String [] line = readerWords.readLine().split(" ");
        for (int i = 0; i <= line.length - 1; i++) {
            map.putIfAbsent(line[i],0);
        }
        String [] theText=readerText.readLine().split(" ");
        for (int i = 0; i <= theText.length - 1; i++) {
            if (map.containsKey(theText[i])){
                map.put(theText[i],map.get(theText[i])+1);
            }

        }
        map.entrySet().stream()
                .sorted((p,a)->Integer.compare(a.getValue(),p.getValue()))
                .forEach(p-> {
                    try {
                        writer.write(p.getKey()+" - "+p.getValue());
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        writer.close();
    }
}
