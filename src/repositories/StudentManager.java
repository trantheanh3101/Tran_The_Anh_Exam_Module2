package repositories;

import model.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class StudentManager {
    private static final String FILE_PATH = "C:\\Users\\admin\\Desktop\\TheanhCode\\Tran_The_Anh_Exam_Module2_C0324H1\\src\\data\\dataStudent.csv";

    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] attributes = line.split(",");
                if (attributes.length == 5) {
                    int code = Integer.parseInt(attributes[0]);
                    String name = attributes[1];
                    LocalDate dateOfBirth = LocalDate.parse(attributes[2], formatter);
                    String gender = attributes[3];
                    String phoneNumber = attributes[4];

                    Student student = new Student(code, name, dateOfBirth, gender, phoneNumber);
                    students.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            // File not found, return empty list
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student student) {
        ArrayList<Student> students = getAllStudents();
        students.add(student);
        saveAllStudents(students);
    }

    private void saveAllStudents(ArrayList<Student> students) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student s : students) {
                bw.write(s.getCode() + "," + s.getName() + "," + s.getDateOfBirth().format(formatter) + "," + s.getGender() + "," + s.getPhoneNumber());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int codeStudent) {
        ArrayList<Student> students = getAllStudents();
        students.removeIf(student -> student.getCode() == codeStudent);
        saveAllStudents(students);
    }
}
