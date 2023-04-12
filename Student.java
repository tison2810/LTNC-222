public class Student{
    private int id;
    private String name;
    private String email;
    private String phone;
    private String faculty;

    public Student(int id, String name, String email, String phone, String faculty){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.faculty = faculty;
    }

    public int getID() { 
        return id;
    }

    public String getName() {
        return name;
    }

}