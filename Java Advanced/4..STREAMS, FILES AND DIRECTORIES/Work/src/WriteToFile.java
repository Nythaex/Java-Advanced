import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String path="D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try (FileInputStream fileInputStream=new FileInputStream(path)){
            FileOutputStream fileOutputStream=new FileOutputStream(("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\kra.txt"));
            int reader=fileInputStream.read();
            Set<Character> chars=new HashSet<>();
            chars.add('.');
            chars.add(',');
            chars.add('!');
            chars.add('?');
            while (reader>=0){
                if (!chars.contains((char)reader)){
                    fileOutputStream.write(reader);
                }
                reader=fileInputStream.read();
            }

        }catch (Exception ex){

        }

    }
}
