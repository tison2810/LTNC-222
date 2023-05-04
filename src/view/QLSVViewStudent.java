package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Desktop;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URI;

import controller.QLSVController;
import model.Faculty;
import model.QLSVSystem;
import model.Student;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class QLSVViewStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_MSSV_find;
	private JTextField textField_hoTen;
	private JTextField textField_ngaySinh;
	private JTextField textField_MSSV;
	private JTextField textField_gioiTinh;
	private JTextField textField_khoa;
	private JTextField textField_TCTL;
	private JTextField textField_gpa4;
	private JTextField textField_gpa10;
	private QLSVSystem system;
	
	public String id;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					QLSVViewStudent frame = new QLSVViewStudent();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public QLSVViewStudent(String id) {
		this.id = id;
		this.system = new QLSVSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Action action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÔNG TIN SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(376, 25, 240, 36);
		contentPane.add(lblNewLabel);
		
		JButton btn_back = new JButton("Quay lại");
		btn_back.addActionListener(action);
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_back.setBounds(10, 11, 95, 36);
		contentPane.add(btn_back);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(70, 84, 858, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(73, 164, 89, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(165, 164, 268, 36);
		contentPane.add(textField_hoTen);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(527, 164, 89, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(626, 164, 268, 36);
		contentPane.add(textField_ngaySinh);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("MSSV");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(73, 239, 89, 36);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_MSSV = new JTextField();
		textField_MSSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_MSSV.setColumns(10);
		textField_MSSV.setBounds(165, 239, 268, 36);
		contentPane.add(textField_MSSV);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(527, 239, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		textField_gioiTinh = new JTextField();
		textField_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_gioiTinh.setColumns(10);
		textField_gioiTinh.setBounds(626, 239, 268, 36);
		contentPane.add(textField_gioiTinh);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Khoa");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2.setBounds(73, 307, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_2);
		
		textField_khoa = new JTextField();
		textField_khoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_khoa.setColumns(10);
		textField_khoa.setBounds(165, 307, 268, 36);
		contentPane.add(textField_khoa);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Tín chỉ TL");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_1.setBounds(527, 307, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_2_1);
		
		textField_TCTL = new JTextField();
		textField_TCTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_TCTL.setColumns(10);
		textField_TCTL.setBounds(626, 307, 268, 36);
		contentPane.add(textField_TCTL);
		
		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("GPA(hệ 4)");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_2.setBounds(73, 375, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_2_2);
		
		textField_gpa4 = new JTextField();
		textField_gpa4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_gpa4.setColumns(10);
		textField_gpa4.setBounds(165, 375, 268, 36);
		contentPane.add(textField_gpa4);
		
		JLabel lblNewLabel_1_1_2_2_2_1 = new JLabel("GPA(hệ 10)");
		lblNewLabel_1_1_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_2_1.setBounds(527, 375, 95, 36);
		contentPane.add(lblNewLabel_1_1_2_2_2_1);
		
		textField_gpa10 = new JTextField();
		textField_gpa10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_gpa10.setColumns(10);
		textField_gpa10.setBounds(626, 375, 268, 36);
		contentPane.add(textField_gpa10);
		
		JButton btnBKPay = new JButton("Đóng học phí");
		btnBKPay.addActionListener(action);
		btnBKPay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBKPay.setBounds(70, 469, 150, 30);
		contentPane.add(btnBKPay);
		
		JButton btnGitHub = new JButton("GitHub");
		btnGitHub.addActionListener(action);
		btnGitHub.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGitHub.setBounds(744, 469, 150, 30);
		contentPane.add(btnGitHub);
		
		JButton btnMyBK = new JButton("MyBK");
		btnMyBK.addActionListener(action);
		btnMyBK.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMyBK.setBounds(283, 469, 150, 30);
		contentPane.add(btnMyBK);
		
		JButton btnaao = new JButton("P. Đào tạo");
		btnaao.addActionListener(action);
		btnaao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnaao.setBounds(527, 469, 150, 30);
		contentPane.add(btnaao);

		
		this.setVisible(true);
	}

	public void deleteForm() {
		this.textField_hoTen.setText("");
		this.textField_MSSV.setText("");
		this.textField_khoa.setText("");
		this.textField_ngaySinh.setText("");
		this.textField_gioiTinh.setText("");
		this.textField_TCTL.setText("");
		this.textField_gpa10.setText("");
		this.textField_gpa4.setText("");
		
	}

	public void back() {
		new QLSVLogin();
		dispose();
	}
	
	public void openFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			open(file);
		} 
	}

	private void open(File file) {
		ArrayList ds = new ArrayList();
		try {
			this.system.setFileName(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Student sinhvien = null;
			while((sinhvien = (Student) ois.readObject())!=null) {
				ds.add(sinhvien);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.system.setDsSinhVien(ds);;
	}

	public void tracuu() {
		String MSSV = this.id;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1","root","");
			 Statement stm = con.createStatement();
			 String query = "SELECT * FROM qlsv WHERE MSSV = '" + MSSV + "'";
			 ResultSet rs = stm.executeQuery(query);
			 
//		ArrayList<Student> dsSinhVien = new ArrayList<Student>();
//		dsSinhVien = this.system.getDsSinhVien();
//		for(Student sinhvien : dsSinhVien) {
//			if(sinhvien.getMSSV().equals(MSSV)) {
			 if(rs.next()) {
				this.textField_hoTen.setText(rs.getString(1));
				this.textField_ngaySinh.setText(rs.getString(4));
				this.textField_MSSV.setText(MSSV);
				this.textField_khoa.setText(rs.getString(2));
				this.textField_gioiTinh.setText(rs.getString(5));
				this.textField_TCTL.setText(rs.getString(6));
				this.textField_gpa4.setText(rs.getString(7));
				this.textField_gpa10.setText(rs.getString(8));
			 }
//			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void exit() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn thoát khỏi chương trình?",
			    "Exit",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public void pay() {
		try {
            // open a web browser
            Desktop.getDesktop().browse(new URI("https://bkpay.hcmut.edu.vn/bkpay/home.action"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Failed to open web browser");
            ex.printStackTrace();
        }
	}
	public void aao() {
		try {
            // open a web browser
            Desktop.getDesktop().browse(new URI("http://www.aao.hcmut.edu.vn/"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Failed to open web browser");
            ex.printStackTrace();
        }
	}
	public void MyBK() {
		try {
            // open a web browser
            Desktop.getDesktop().browse(new URI("https://mybk.hcmut.edu.vn/my/index.action"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Failed to open web browser");
            ex.printStackTrace();
        }
	}
	public void linkToGitHub() {
		try {
            // open a web browser
            Desktop.getDesktop().browse(new URI("https://github.com/tison2810/LTNC-222"));
        } catch (IOException | URISyntaxException ex) {
            System.out.println("Failed to open web browser");
            ex.printStackTrace();
        }
	}
}
