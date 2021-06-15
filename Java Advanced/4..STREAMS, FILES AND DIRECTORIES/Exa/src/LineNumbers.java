import java.io.*;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        Path output = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\OutPut.txt");
        Path path = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\inputLineNumbers.txt");
        BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(path)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(output)));
        int count = 1;
        String line = reader.readLine();
        while (line != null) {
            writer.write(count+". "+line);
            writer.newLine();

            count++;
            line = reader.readLine();
        }
        writer.close();

    }
}
