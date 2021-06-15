package Students;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudent() {
        return this.studentsByName;
    }

    public void studentCommand(String[] token) {
        if (token[0].equals("Create")) {
            createStudent(token);
        } else if (token[0].equals("Show")) {
            String info =studentInfo(token[1]);
            if (info != null){
                System.out.println(studentInfo(token[1]));
            }

        }
    }

    private String studentInfo(String s) {
        String name = s;
        if (studentsByName.containsKey(name)) {
            Student student = studentsByName.get(name);
            String printStudent = String.format("%s is %s years old.", student.getName(), student.getAge());

            if (student.getGrade() >= 5.00) {
                printStudent += " Excellent student.";
            } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                printStudent += " Average student.";
            } else {
                printStudent += " Very nice person.";
            }
            return printStudent;
        }
      return null;
    }

    private void createStudent(String[] token) {
        String name = token[1];
        int age = Integer.parseInt(token[2]);
        double grade = Double.parseDouble(token[3]);
        if (!studentsByName.containsKey(name)) {
            Student student = new Student(name, age, grade);
            studentsByName.put(name, student);
        }
    }
}
