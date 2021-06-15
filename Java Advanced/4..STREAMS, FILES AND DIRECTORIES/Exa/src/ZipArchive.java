import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipArchive {
    public static void main(String[] args) throws IOException {
        Path first = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\inputTwo.txt");
        Path second = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\words.txt");
        Path third = Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\text.txt");
        Path result = Path.of("resources\\Kuram.zip");{
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(String.valueOf(result)))) {
                addToZipFile(String.valueOf(first), zos);
                addToZipFile(String.valueOf(second), zos);
                addToZipFile(String.valueOf(third), zos);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void addToZipFile(String one, ZipOutputStream zos) throws IOException {
        File file = new File(String.valueOf(one));
        FileInputStream fis = new FileInputStream(file);

        String[] tokens = one.split("\\\\");
        String fileName = tokens[tokens.length - 1];

        ZipEntry zipEntry = new ZipEntry(fileName);
        zos.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zos.write(bytes, 0, length);
        }
        zos.closeEntry();
        fis.close();
    }

}
