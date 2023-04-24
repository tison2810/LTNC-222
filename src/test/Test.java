package test;

import javax.swing.UIManager;

import view.QLSVLogin;

public class Test{
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new QLSVLogin();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
