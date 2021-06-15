import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        Path path=Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path path1=Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\kra.txt");
        FileWriter writer=new FileWriter(String.valueOf(path1));
        List<String> list = Files.readAllLines(path);
        List<String> printList=new ArrayList<>();
        for (int i = 2; i <= list.size() - 1; i+=3) {
          printList.add(list.get(i));
        }
        Files.write(path1,printList);
    }
}
