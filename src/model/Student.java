package model;

import java.util.Date;
import java.util.Objects;

public class Student {
	private String hoTen;
	private String masoSV;
	private Faculty khoa;
	private Date ngaySinh;
	private boolean gioiTinh;
	private int tinchiTL;
	private float gpa_4, gpa_10;
	
	public Student(String hoTen, String masoSV, Faculty khoa, Date ngaySinh, boolean gioiTinh, int tinchiTL,
			float gpa_4, float gpa_10) {
		this.hoTen = hoTen;
		this.masoSV = masoSV;
		this.khoa = khoa;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.tinchiTL = tinchiTL;
		this.gpa_4 = gpa_4;
		this.gpa_10 = gpa_10;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getMasoSV() {
		return masoSV;
	}

	public void setMasoSV(String masoSV) {
		this.masoSV = masoSV;
	}

	public Faculty getKhoa() {
		return khoa;
	}

	public void setKhoa(Faculty khoa) {
		this.khoa = khoa;
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

	public int getTinchiTL() {
		return tinchiTL;
	}

	public void setTinchiTL(int tinchiTL) {
		this.tinchiTL = tinchiTL;
	}

	public float getGpa_4() {
		return gpa_4;
	}

	public void setGpa_4(float gpa_4) {
		this.gpa_4 = gpa_4;
	}

	public float getGpa_10() {
		return gpa_10;
	}

	public void setGpa_10(float gpa_10) {
		this.gpa_10 = gpa_10;
	}

	@Override
	public String toString() {
		return "Student [hoTen=" + hoTen + ", masoSV=" + masoSV + ", khoa=" + khoa + ", ngaySinh=" + ngaySinh
				+ ", gioiTinh=" + gioiTinh + ", tinchiTL=" + tinchiTL + ", gpa_4=" + gpa_4 + ", gpa_10=" + gpa_10 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gioiTinh, gpa_10, gpa_4, hoTen, khoa, masoSV, ngaySinh, tinchiTL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return gioiTinh == other.gioiTinh && Float.floatToIntBits(gpa_10) == Float.floatToIntBits(other.gpa_10)
				&& Float.floatToIntBits(gpa_4) == Float.floatToIntBits(other.gpa_4)
				&& Objects.equals(hoTen, other.hoTen) && Objects.equals(khoa, other.khoa)
				&& Objects.equals(masoSV, other.masoSV) && Objects.equals(ngaySinh, other.ngaySinh)
				&& tinchiTL == other.tinchiTL;
	}
	
	
}
