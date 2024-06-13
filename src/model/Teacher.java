package model;

import java.time.LocalDate;

public class Teacher extends Student{
    private String codeClass;

    public Teacher() {
    }

    public Teacher(String codeClass) {
        this.codeClass = codeClass;
    }

    public Teacher(int code, String name, LocalDate dateOfBirth, String gender, String phoneNumber, String codeClass) {
        super(code, name, dateOfBirth, gender, phoneNumber);
        this.codeClass = codeClass;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "codeClass='" + codeClass + '\'' +
                '}';
    }
}
