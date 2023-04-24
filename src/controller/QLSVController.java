package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.Faculty;
import model.Student;
import view.QLSVLogin;
import view.QLSVView;

public class QLSVController implements Action{

	public QLSVView view;
	public QLSVLogin login;
	
	public QLSVController(QLSVLogin login) {
		this.login = login;
	}
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("Đăng nhập")) {
			this.login.loginView();
		}
		if(actionCommand.equals("Thêm")) {
			this.view.deleteForm();
		}
		else if(actionCommand.equals("Lưu")) {
			try {
				//GetData
				String MSSV = this.view.textField_MSSV.getText();
				String hoTen = this.view.textField_Name.getText();
				Faculty Khoa = Faculty.getFacultybyName(this.view.comboBox_Khoa_info.getSelectedItem().toString() + "");
				Date ngaySinh = new Date(this.view.textField_Birth.getText());
				boolean gioiTinh = true;
				if(this.view.RadioButton_Nam.isSelected()) {
					gioiTinh = true;
				}
				else {
					gioiTinh = false;
				}
				int TCTL = Integer.valueOf(this.view.textField_TCTL.getText());
				float gpa_10 = Float.valueOf(this.view.textField_GPA10.getText());
				float gpa_4 = Float.valueOf(this.view.textField_GPA4.getText());
				
				Student sinhvien = new Student(MSSV, hoTen, Khoa, ngaySinh, gioiTinh, TCTL, gpa_10, gpa_4);

				if(gpa_4 < 0.0 || gpa_4 > 4.0) {
					JOptionPane.showMessageDialog(view, "GPA(hệ 4.0) phải nằm trong khoảng 0 - 4.0");
				}
				else if(gpa_10 < 0.0 || gpa_10 > 10.0) {
					JOptionPane.showMessageDialog(view, "GPA(hệ 10.0) phải nằm trong khoảng 0 - 10.0");
				}
				else if(TCTL < 0) {
					JOptionPane.showMessageDialog(view, "Tín chỉ tích lũy phải lớn hơn bằng 0");
				}
				else {
					this.view.insertOrUpdate(sinhvien);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		else if(actionCommand.equals("Cập nhật")) {
			this.view.display();
		}
		else if(actionCommand.equals("Xóa")) {
			this.view.delete();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
