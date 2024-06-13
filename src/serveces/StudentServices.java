package serveces;

import model.Student;
import repositories.StudentManager;
import view.StudentView;

import java.util.ArrayList;

public class StudentServices {
    private StudentView studentView;
    private StudentManager studentManager;

    public StudentServices() {
        this.studentView = new StudentView();
        this.studentManager = new StudentManager();
    }

    public void addStudent(StudentView studentView) {
        while (true) {
            Student student = studentView.getDetailStudent();
            if (!checkCode(student.getCode())) {
                studentManager.addStudent(student);
                studentView.getMessOk();
                break;
            } else {
                studentView.getMessNG();
            }
        }
    }

    private boolean checkCode(int code) {
        ArrayList<Student> students = StudentManager.getAllStudents();
        return students.stream().anyMatch(student -> student.getCode() == code);
    }

    public void displayAllStudent() {
        ArrayList<Student> students = StudentManager.getAllStudents();
        if (students.isEmpty()) {
            studentView.getMessDisplay();
        } else {
            students.forEach(System.out::println);
        }
    }

    public void deleteStudent(StudentView studentView) {
        ArrayList<Student> students = StudentManager.getAllStudents();
        int codeStudent = studentView.getCodeStudent();
        boolean exists = students.stream().anyMatch(student -> student.getCode() == codeStudent);
        if (exists){
            studentManager.deleteStudent(codeStudent);
            studentView.getMessOk();
        } else
            studentView.getMessNG();
    }
}
