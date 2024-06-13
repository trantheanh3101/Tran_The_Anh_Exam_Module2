package controller;


import serveces.StudentServices;
import view.StudentView;

public class StudentController {
    StudentServices studentServeces;
    StudentView studentView ;

    public StudentController(StudentView studentView) {
        this.studentServeces = new StudentServices();
        this.studentView = studentView;
    }

    public void run() {
        boolean exist = true;
        while (exist){
            int choice = studentView.getMenuChoice();
            switch (choice){
                case 1:
                    studentServeces.addStudent(studentView);
                    break;
                case 2:
                    studentServeces.deleteStudent(studentView);
                    studentServeces.displayAllStudent();
                    break;
                case 3:
                    studentServeces.displayAllStudent();
                    break;
                case 4:
                    break;
                case 0:
                    exist = false;
                    break;
                default:
                    studentView.displayMessage();
            }
        }
    }
}
