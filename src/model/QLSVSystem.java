package model;

import java.util.ArrayList; 

public class QLSVSystem {
	private ArrayList<Student> dsSinhVien;
	private String choose;

	public QLSVSystem() {
		this.dsSinhVien = new ArrayList<Student>();
		this.choose = "";
	}

	public QLSVSystem(ArrayList<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<Student> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
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

	public boolean checkExist(Student sinhvien) {
		for(Student sv : dsSinhVien) {
			if(sv.getMSSV() == sinhvien.getMSSV())
				return true;
		}
		return false;
	}
}
