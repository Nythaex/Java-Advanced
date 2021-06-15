import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        FileWriter writer= new FileWriter(("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\kra.txt"));
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int nextInt=scanner.nextInt();
                writer.write(String.valueOf(nextInt));
                writer.write(System.lineSeparator());
            }
           scanner.next();

        }
        inputStream.close();
        writer.close();

    }
}
