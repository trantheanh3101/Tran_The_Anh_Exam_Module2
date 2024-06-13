package model;

public class Classroom {
    private String codeClass;
    private String nameClass;
    private String codeTeacher;

    public Classroom() {
    }

    public Classroom(String codeClass, String nameClass, String codeTeacher) {
        this.codeClass = codeClass;
        this.nameClass = nameClass;
        this.codeTeacher = codeTeacher;
    }

    public String getCodeClass() {
        return codeClass;
    }

    public void setCodeClass(String codeClass) {
        this.codeClass = codeClass;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(String codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "codeClass='" + codeClass + '\'' +
                ", nameClass='" + nameClass + '\'' +
                ", codeTeacher='" + codeTeacher + '\'' +
                '}';
    }
}
