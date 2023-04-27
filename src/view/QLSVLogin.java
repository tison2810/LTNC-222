package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.QLSVController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class QLSVLogin extends JFrame {

	private JPanel contentPane;
	public JTextField textField_username;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVLogin frame = new QLSVLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Action action = new QLSVController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HỆ THỐNG QUẢN LÝ THÔNG TIN SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(164, 39, 541, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cổng đăng nhập");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(350, 101, 195, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tài khoản:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(126, 178, 102, 40);
		contentPane.add(lblNewLabel_2);
		
		textField_username = new JTextField();
		textField_username.setBounds(269, 182, 343, 40);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(126, 265, 102, 40);
		contentPane.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(269, 268, 343, 43);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(action);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(350, 351, 143, 40);
		contentPane.add(btnLogin);
		
		
		this.setVisible(true);
	}

	//Kiem tra thong tin dang nhap, neu dung thi dang nhap vao he thong
	public void loginView() {
		String username = this.textField_username.getText();
		char[] passwordChar = this.passwordField.getPassword();
		String password = new String(passwordChar);
		try {
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1","root","");
			
			Statement stm = con.createStatement();
			String query = "SELECT * FROM qlsv WHERE MSSV = '"+username+"'  AND Pass = '"+password+"'";
		    ResultSet rs = stm.executeQuery(query);
		    if (rs.next()) {
		       	new QLSVView();
		       	dispose();
		       
		    } else {
		    	JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu sai. Vui lòng kiểm tra lại");
		    }
		    rs.close();
		    stm.close();
		    con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
