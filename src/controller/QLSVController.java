package controller;

import java.awt.event.ActionEvent;

import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.Faculty;
import model.Student;
import view.QLSVChoose;
import view.QLSVLogin;
import view.QLSVView;
import view.QLSVViewStudent;


public class QLSVController implements Action{

	private QLSVView view;
	
	private QLSVLogin login;
	
	private QLSVChoose chosen;
	
	private QLSVViewStudent viewstu;
	
	public QLSVController(QLSVLogin login) {
		this.login = login;
	}
	
	public QLSVController(QLSVChoose chosen) {
		this.chosen = chosen;
	}
	
	public QLSVController(QLSVViewStudent viewstu) {
		this.viewstu = viewstu;
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
		if(actionCommand.equals("Cơ sở dữ liệu thông tin sinh viên")) {
			this.chosen.truycapCSDL();
		}
//		else if(actionCommand.equals("Tra cứu thông tin sinh viên")) {
//			this.chosen.truycapTracuu();
//			this.viewstu.openFile();
//		}
			
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
		}
		else if(actionCommand.equals("Tìm")) {
			this.view.find();
		}
		else if(actionCommand.equals("Hủy tìm")) {
			this.view.loadData();
		}
		else if(actionCommand.equals("Open")) {
			this.view.open();
		}
		else if(actionCommand.equals("Save")) {
			this.view.saveFile();
		}
		else if(actionCommand.equals("Exit")) {
			this.view.exit();
		}
		else if(actionCommand.equals("Quay về")) {
			this.view.back();
		}
		else if(actionCommand.equals("Lấy dữ liệu")) {
			this.view.getDataMySQL();
		}
		
		if(actionCommand.equals("Tra cứu")) {
			this.viewstu.tracuu();
		}
		else if(actionCommand.equals("Hủy bỏ")) {
			this.viewstu.deleteForm();
		}
		else if(actionCommand.equals("Quay lại")) {
			this.viewstu.back();
		}
		else if(actionCommand.equals("Open File")) {
			this.viewstu.openFile();
		}
		else if(actionCommand.equals("Đóng học phí")) {
			this.viewstu.pay();
		}
		else if(actionCommand.equals("exit")) {
			this.viewstu.exit();
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
