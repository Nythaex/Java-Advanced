import java.io.*;
import java.nio.file.Path;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        Path output = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\OutPut.txt");
        Path path = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(output)));

        Set<Character> vols = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punc = Set.of('!', '.', ',', '?');
        int volsCount = 0;
        int others = 0;
        int punct = 0;
        String line = reader.readLine();
        while (line != null) {
            for (int i = 0; i <= line.length() - 1; i++) {
                if (vols.contains(line.charAt(i))) {
                    volsCount++;
                } else if (punc.contains(line.charAt(i))) {
                 punct++;
                }else if (line.charAt(i)!=' '){
                    others++;
                }
            }
            line=reader.readLine();
        }
        writer.write("Vowels: "+volsCount);
        writer.newLine();
        writer.write("Consonants: "+others);
        writer.newLine();
        writer.write("Punctuation: "+punct);
        writer.close();
        reader.close();
    }
}
