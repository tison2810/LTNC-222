package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.Faculty;
import model.Student;
import view.studentManageView;

public class studentManageController implements Action {
	public studentManageView view;
	
	public studentManageController(studentManageView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		JOptionPane.showMessageDialog(view, "Thực hiện thao tác: " + actionCommand);
		if(actionCommand.equals("Thêm")) {
			this.view.deleteForm();
			this.view.system.setFeature("Thêm");
		}
		else if(actionCommand.equals("Lưu")) {
			//getData
			try {
				String hoTen = this.view.textField_hoTen.getText();
				String masoSV = this.view.textField_MSSV.getText();
				String tenKhoa = this.view.comboBox_khoa_info.getSelectedItem().toString();
				Faculty khoa = Faculty.getFacultyByName(tenKhoa);
				Date ngaySinh = new Date(this.view.textField_ngaySinh.getText());
				boolean gioiTinh = true;
				if(this.view.radioButton_Nam.isSelected()) {
					gioiTinh = true;
				}
				else {
					gioiTinh = false;
				}
				int tinchiTL = Integer.valueOf(this.view.textField_TCTL.getText());
				float gpa_4 = Float.valueOf(this.view.textField_GPA4.getText());
				float gpa_10 = Float.valueOf(this.view.textField_GPA10.getText());
				
				Student sinhvien = new Student(hoTen, masoSV, khoa, ngaySinh, gioiTinh, tinchiTL, gpa_4, gpa_10);
				
				if(this.view.system.getFeature().equals("") || this.view.system.getFeature().equals("Thêm")) {
					this.view.insert(sinhvien);
				}
				else if(this.view.system.getFeature().equals("Cập nhật")) {
					this.view.update(sinhvien);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
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
