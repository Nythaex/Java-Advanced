import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream input=new FileInputStream("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Work\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
           int reader=input.read();
           while (reader>=0){
               System.out.print(Integer.toBinaryString(reader)+" ");
               reader=input.read();
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
