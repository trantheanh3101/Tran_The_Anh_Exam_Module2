package view;

import model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StudentView {
    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("--------Student View--------");
        System.out.println("1. Add student");
        System.out.println("2. Delete student");
        System.out.println("3. Display all student");
        System.out.println("4. Search student");
        System.out.println("0. End program");
        System.out.print("Input your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public void displayMessage() {
        System.out.println("fill number choice again");
    }

    public Student getDetailStudent() {
        System.out.print("Code: ");
        int code = Integer.parseInt(scanner.nextLine());

        String name;
        do {
            System.out.print("Name (4-50 characters): ");
            name = scanner.nextLine();
            if (name.length() < 4 || name.length() > 50) {
                System.out.println("Name must be between 4 and 50 characters.");
            }
        } while (name.length() < 4 || name.length() > 50);

        System.out.print("Date of Birth (dd/MM/yyyy): ");
        LocalDate dateOfBirth = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();
        Student student = new Student(code, name, dateOfBirth, gender, phoneNumber);
        return student;
    }

    public void getMessOk() {
        System.out.println("Thanh cong");
    }

    public void getMessNG() {
        System.out.println("That bai");
    }

    public void getMessDisplay() {
        System.out.println("khong co hoc sinh nao");
    }

    public int getCodeStudent() {
        System.out.print("Code: ");
        int code = Integer.parseInt(scanner.nextLine());
        return code;
    }
}
