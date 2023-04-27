package model;

import java.util.Objects;
import java.io.Serializable;
import java.util.ArrayList;

public class Faculty implements Serializable {
	private String maKhoa;
	private String tenKhoa;
	
	public Faculty(String maKhoa, String tenKhoa) {
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}

	public String getMaKhoa() {
		return maKhoa;
	}

	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}

	public String getTenKhoa() {
		return tenKhoa;
	}

	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}

	@Override
	public String toString() {
		return "Faculty [maKhoa=" + maKhoa + ", tenKhoa=" + tenKhoa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maKhoa, tenKhoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(maKhoa, other.maKhoa) && Objects.equals(tenKhoa, other.tenKhoa);
	}
	
	public static ArrayList<Faculty> getFacultyList(){
		String[] arr_FacultyName = {"TT. Đào tạo Bảo dưỡng Công nghiệp",
				"Cơ khí",
				"Kỹ thuật Địa chất và Dầu khí",
				"Điện - Điện tử",
				"Khoa học & Kỹ thuật Máy tính",
				"Kỹ thuật Hóa học",
				"Quản lý Công nghiệp",
				"Kỹ thuật Xây dựng",
				"Môi trường và Tài nguyên",
				"Kỹ thuật Giao thông",
				"Khoa học Ứng dụng",
				"Công nghệ Vật liệu"};
		String[] arr_MaKhoa = {"BD",
				"CK",
				"DC",
				"ĐĐ",
				"MT",
				"HH",
				"QL",
				"XD",
				"MO",
				"GT",
				"UD",
				"VL"};
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();
		for (int i = 0; i < arr_FacultyName.length;i++) {
			Faculty Khoa = new Faculty(arr_MaKhoa[i], arr_FacultyName[i]);
			facultyList.add(Khoa);
		}
		return facultyList;
	}

	public static Faculty getFacultybyName(String nameFaculty) {
		ArrayList<Faculty> dsKhoa = getFacultyList();
		for (int i =0; i < dsKhoa.size(); i++) {
			Faculty khoa = dsKhoa.get(i);
			if(nameFaculty.equals(khoa.tenKhoa)) {
				return khoa;
			}
		}
		return null;
	}
}
