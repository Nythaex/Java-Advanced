import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        String path=("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        Path path1=Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\kra.txt");
        File file=new File(path);
        File[] files=file.listFiles();
        for (File fil:files
             ) {
            if (!fil.isDirectory()){
                System.out.printf("%s: [%d]%n",fil.getName(),fil.length());
            }
        }

    }
}
