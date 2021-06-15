import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class SerializeCustomOject {
    public static void main(String[] args) throws IOException, Exception   {

        Path path=Path.of("D:\\Softtuni\\3.Java Advanced\\Java Advanced\\4..STREAMS, FILES AND DIRECTORIES\\Exa\\src\\resources\\list.ser");
        Course course=new Course("Mama vi stara",130);
        FileOutputStream sere=new FileOutputStream(String.valueOf(path));
        ObjectOutputStream ser=new ObjectOutputStream(sere);
        ser.writeObject(course);

        FileInputStream fis=new FileInputStream(String.valueOf(path));
        ObjectInputStream print= new ObjectInputStream(fis);
        Course theCourse= (Course) print.readObject();
        theCourse.printera(theCourse);




    }
    private static class Course implements Serializable{
       public String name;
       private int studentsCount;

        public Course(String name, int studenstCount) {
            this.name = name;
            this.studentsCount = studenstCount;
        }
        public void printera(Course course){
            System.out.println(course.getName()+"->"+course.getStudenstCount());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getStudenstCount() {
            return studentsCount;
        }

        public void setStudenstCount(int studenstCount) {
            this.studentsCount = studenstCount;
        }
    }
}
