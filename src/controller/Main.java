package controller;

import view.StudentView;

public class Main {
    public static void main(String[] args) {
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentView);
        studentController.run();
    }
}
