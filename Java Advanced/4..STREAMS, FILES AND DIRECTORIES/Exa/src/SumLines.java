import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) throws Exception {
        Path path=Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\input.txt");
        BufferedReader reader= new BufferedReader(new FileReader(String.valueOf(path)));
        String line=reader.readLine();
        int sum=0;
        while (line!=null){
            for (int i = 0; i <= line.length() - 1; i++) {
             sum+=line.charAt(i);
            }
            line= reader.readLine();
        }
        System.out.println(sum);
        reader.close();
    }
}
