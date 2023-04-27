package model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
	private String MSSV;
	private String hoTen;
	private Faculty Khoa;
	private Date ngaySinh;
	private boolean gioiTinh;
	private int TCTL;
	private float gpa_10, gpa_4;
	
	public Student() {
	}


	public Student(String mSSV, String hoTen, Faculty khoa, Date ngaySinh, boolean gioiTinh, int tCTL, float gpa_10,
			float gpa_4) {
		MSSV = mSSV;
		this.hoTen = hoTen;
		Khoa = khoa;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		TCTL = tCTL;
		this.gpa_10 = gpa_10;
		this.gpa_4 = gpa_4;
	}

	
	public String getMSSV() {
		return MSSV;
	}


	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public Faculty getKhoa() {
		return Khoa;
	}


	public void setKhoa(Faculty khoa) {
		Khoa = khoa;
	}


	public Date getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public boolean isGioiTinh() {
		return gioiTinh;
	}


	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}


	public int getTCTL() {
		return TCTL;
	}


	public void setTCTL(int tCTL) {
		TCTL = tCTL;
	}


	public float getGpa_10() {
		return gpa_10;
	}


	public void setGpa_10(float gpa_10) {
		this.gpa_10 = gpa_10;
	}


	public float getGpa_4() {
		return gpa_4;
	}


	public void setGpa_4(float gpa_4) {
		this.gpa_4 = gpa_4;
	}
	
}
