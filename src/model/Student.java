package model;

public class Student{
    private int id;
    private String name;
    private String email;
    private String phone;
    private Grade grade;

    public Student(int id, String name, String email, String phone, Grade grade){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.grade = grade;
    }

    public int getID() { 
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setGrade(Grade grade){
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }

}
