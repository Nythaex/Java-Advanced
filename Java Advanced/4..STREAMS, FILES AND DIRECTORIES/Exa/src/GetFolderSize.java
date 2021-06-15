import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        Path output = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\OutPut.txt");
        Path path = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\Exercises Resources");
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(output)));
        File file = new File(String.valueOf(path));
        File[] files = file.listFiles();
        int sum = 0;
        for (File f : files
        ) {
            sum +=f.length();
        }
        writer.write("Folder size: " + sum);
        writer.close();

    }
}
