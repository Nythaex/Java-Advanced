import javax.sound.midi.Patch;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Scanner;

public class NestedFolders {
    public static void main(String[] args) {
        Path path = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File file = new File(String.valueOf(path));
        ArrayDeque<File> deck = new ArrayDeque<>();
        deck.offer(file);
        int count = 1;
        while (!deck.isEmpty()) {
            File current = deck.poll();
            File[] files = current.listFiles();
            for (File theFile : files
            ) {
                if (theFile.isDirectory()) {
                    deck.offer(theFile);
                    count++;
                    System.out.println(theFile.getName());
                }
            }
        }
        System.out.println("Files-and-Streams");
        System.out.println(count + " folders");
    }
}
