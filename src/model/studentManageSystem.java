package model;

import java.util.ArrayList;

public class studentManageSystem {
	private ArrayList<Student> dsSinhVien;
	private String feature;
	
	public studentManageSystem() {
		this.dsSinhVien = new ArrayList<Student>();
		this.feature = "";
	}

	public studentManageSystem(ArrayList<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	
	public ArrayList<Student> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<Student> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public void insert(Student sinhvien) {
		this.dsSinhVien.add(sinhvien);
	}
	
	public void delete(Student sinhvien) {
		this.dsSinhVien.remove(sinhvien);
	}
	
	public void update(Student sinhvien) {
		this.dsSinhVien.remove(sinhvien);
		this.dsSinhVien.add(sinhvien);
	}
	
}
