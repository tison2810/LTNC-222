package test;

import javax.swing.UIManager;

import view.studentManageView;

public class Test{
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new studentManageView();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
