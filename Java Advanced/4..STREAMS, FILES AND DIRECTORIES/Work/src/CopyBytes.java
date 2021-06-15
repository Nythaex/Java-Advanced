import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) {
        String path="D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream fileInputStream=new FileInputStream(path)){
            FileOutputStream fileOutputStream=new FileOutputStream(("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\kra.txt"));
            int reader=fileInputStream.read();

            while (reader>=0){
                if (reader==10||reader==32){
                    fileOutputStream.write(reader);
                }else {
                    String digit=String.valueOf(reader);
                    fileOutputStream.write(digit.getBytes(StandardCharsets.UTF_8));
                }
                reader=fileInputStream.read();
            }

        }catch (Exception ex){

        }
    }
}
