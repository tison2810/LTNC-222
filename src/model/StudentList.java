package model;

import java.util.ArrayList;

public class StudentList {
	private ArrayList<Student> StudentL;
	
	//Constructor//
	public StudentList() {
		this.StudentL = new ArrayList<Student>();
	}
	
	public StudentList(ArrayList<Student> studentL) {
		StudentL = studentL;
	}
	//GET and SET//
	public void setList(ArrayList<Student> StudentL) {
		this.StudentL = StudentL;
	}
	public ArrayList<Student> getList() {
		return StudentL;
	}
	
	public void addStd(Student std) {
		this.StudentL.add(std);
	}
	
	public void delStd(Student std) {
		this.StudentL.remove(std);
	}
	
	public void updateStd(Student std) {
		this.StudentL.remove(std);
		this.StudentL.add(std);
	}
	
}
