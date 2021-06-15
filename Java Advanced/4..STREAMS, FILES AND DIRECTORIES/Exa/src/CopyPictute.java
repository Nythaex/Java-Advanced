import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CopyPictute {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        Path output = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\picture-copy.jpg");
        Path path = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\Заснемане.PNG");
        FileInputStream reader=new FileInputStream(String.valueOf(path));
        FileOutputStream writer=new FileOutputStream(String.valueOf(output));
        int bytes=reader.read();
        while (bytes!=0){
            writer.write(bytes);
            bytes=reader.read();
        }


    }
}
