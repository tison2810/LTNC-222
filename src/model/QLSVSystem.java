package model;

import java.util.ArrayList; 

public class QLSVSystem {
	private ArrayList<Student> dsSinhVien;
	String choosen;

	public QLSVSystem() {
		this.dsSinhVien = new ArrayList<Student>();
	}



	public QLSVSystem(ArrayList<Student> dsSinhVien, String choosen) {
		this.dsSinhVien = dsSinhVien;
		this.choosen = choosen;
	}


	public ArrayList<Student> getDsSinhVien() {
		return dsSinhVien;
	}
	


	public void setDsSinhVien(ArrayList<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}



	public String getChoosen() {
		return choosen;
	}



	public void setChoosen(String choosen) {
		this.choosen = choosen;
	}



	public void insert(Student SinhVien) {
		this.dsSinhVien.add(SinhVien);
	}
	
	public void delete(Student SinhVien) {
		this.dsSinhVien.remove(SinhVien);
	}
	
	public void update(Student SinhVien) {
		this.dsSinhVien.remove(SinhVien);
		this.dsSinhVien.add(SinhVien);
	}

	//Kiem tra sinh vien co ton tai trong he thong hay chua
	public boolean checkExist(Student sinhvien) {
		for(Student sv : dsSinhVien) {
			if(sv.getMSSV().equals(sinhvien.getMSSV())) {
				return true;
			}
		}
		return false;
	}
}
