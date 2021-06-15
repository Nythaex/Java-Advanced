import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        Path output = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\OutPut.txt");
        Path pathOfWords = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\inputOne.txt");
        Path pathText = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\inputTwo.txt");
        BufferedReader first = new BufferedReader(new FileReader(String.valueOf(pathOfWords)));
        BufferedReader second= new BufferedReader(new FileReader(String.valueOf(pathText)));
        BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(output)));

        List<String> nums=new ArrayList<>();
        String one=first.readLine();
        String two=second.readLine();
        while (one!=null){
            nums.add(one);
            one=first.readLine();
        }
        while (two!=null){
            nums.add(two);
            two=second.readLine();
        }
        for (String p:nums
             ) {
            writer.write(String.valueOf(p));
            writer.newLine();
        }

        first.close();
        second.close();
        writer.close();
    }
}
