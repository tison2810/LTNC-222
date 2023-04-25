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
				this.view.store();
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
		else if(actionCommand.equals("Hủy")) {
			this.view.deleteForm();
			if(this.view.system.getChoosen().equals("Tìm")) {
				this.view.cancelFind();
				this.view.system.setChoosen("");
			}
		}
		else if(actionCommand.equals("Tìm")) {
			this.view.find();
			this.view.system.setChoosen("Tìm");
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
