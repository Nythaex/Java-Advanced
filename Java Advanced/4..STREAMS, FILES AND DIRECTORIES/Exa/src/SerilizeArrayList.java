import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SerilizeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Path path=Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\list.ser");
        List<Double> list=List.of(2.3,3.3,4.3,5.3,3.3);
        FileOutputStream sere=new FileOutputStream(String.valueOf(path));
        ObjectOutputStream ser=new ObjectOutputStream(sere);
        ser.writeObject(list);

        FileInputStream fis=new FileInputStream(String.valueOf(path));
        ObjectInputStream print= new ObjectInputStream(fis);
        List<Double> printer= (List<Double>) print.readObject();
        for (Double d:printer
             ) {
            System.out.println(d);
        }


    }
}
