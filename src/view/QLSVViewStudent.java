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
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;

import controller.QLSVController;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVViewStudent frame = new QLSVViewStudent();
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
	public QLSVViewStudent() {
		this.system = new QLSVSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		Action action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem menuOpen = new JMenuItem("Open File");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu.add(menuOpen);
		
		JMenuItem menuExit = new JMenuItem("exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		mnNewMenu.add(menuExit);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRA CỨU SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(376, 25, 218, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MSSV");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(277, 88, 66, 36);
		contentPane.add(lblNewLabel_1);
		
		textField_MSSV_find = new JTextField();
		textField_MSSV_find.setBounds(353, 88, 268, 36);
		contentPane.add(textField_MSSV_find);
		textField_MSSV_find.setColumns(10);
		
		JButton btn_back = new JButton("Quay lại");
		btn_back.addActionListener(action);
		btn_back.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_back.setBounds(10, 11, 95, 36);
		contentPane.add(btn_back);
		
		JButton btn_find = new JButton("Tra cứu");
		btn_find.addActionListener(action);
		btn_find.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_find.setBounds(631, 64, 95, 36);
		contentPane.add(btn_find);
		
		JButton btn_cancel = new JButton("Hủy bỏ");
		btn_cancel.addActionListener(action);
		btn_cancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_cancel.setBounds(631, 109, 95, 36);
		contentPane.add(btn_cancel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(68, 173, 858, 2);
		contentPane.add(separator);
		
		JLabel lblThngTinSinh = new JLabel("THÔNG TIN SINH VIÊN");
		lblThngTinSinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngTinSinh.setBounds(376, 188, 218, 36);
		contentPane.add(lblThngTinSinh);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(71, 253, 89, 36);
		contentPane.add(lblNewLabel_1_1);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(163, 253, 268, 36);
		contentPane.add(textField_hoTen);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(525, 253, 89, 36);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(624, 253, 268, 36);
		contentPane.add(textField_ngaySinh);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("MSSV");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(71, 328, 89, 36);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_MSSV = new JTextField();
		textField_MSSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_MSSV.setColumns(10);
		textField_MSSV.setBounds(163, 328, 268, 36);
		contentPane.add(textField_MSSV);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Giới tính");
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_1.setBounds(525, 328, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		textField_gioiTinh = new JTextField();
		textField_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_gioiTinh.setColumns(10);
		textField_gioiTinh.setBounds(624, 328, 268, 36);
		contentPane.add(textField_gioiTinh);
		
		JLabel lblNewLabel_1_1_2_2 = new JLabel("Khoa");
		lblNewLabel_1_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2.setBounds(71, 396, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_2);
		
		textField_khoa = new JTextField();
		textField_khoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_khoa.setColumns(10);
		textField_khoa.setBounds(163, 396, 268, 36);
		contentPane.add(textField_khoa);
		
		JLabel lblNewLabel_1_1_2_2_1 = new JLabel("Tín chỉ TL");
		lblNewLabel_1_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_1.setBounds(525, 396, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_2_1);
		
		textField_TCTL = new JTextField();
		textField_TCTL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_TCTL.setColumns(10);
		textField_TCTL.setBounds(624, 396, 268, 36);
		contentPane.add(textField_TCTL);
		
		JLabel lblNewLabel_1_1_2_2_2 = new JLabel("GPA(hệ 4)");
		lblNewLabel_1_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_2.setBounds(71, 464, 89, 36);
		contentPane.add(lblNewLabel_1_1_2_2_2);
		
		textField_gpa4 = new JTextField();
		textField_gpa4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_gpa4.setColumns(10);
		textField_gpa4.setBounds(163, 464, 268, 36);
		contentPane.add(textField_gpa4);
		
		JLabel lblNewLabel_1_1_2_2_2_1 = new JLabel("GPA(hệ 10)");
		lblNewLabel_1_1_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2_2_2_1.setBounds(525, 464, 95, 36);
		contentPane.add(lblNewLabel_1_1_2_2_2_1);
		
		textField_gpa10 = new JTextField();
		textField_gpa10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_gpa10.setColumns(10);
		textField_gpa10.setBounds(624, 464, 268, 36);
		contentPane.add(textField_gpa10);

		
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
		new QLSVChoose();
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
		String MSSV = this.textField_MSSV_find.getText();
		ArrayList<Student> dsSinhVien = new ArrayList<Student>();
		dsSinhVien = this.system.getDsSinhVien();
		for(Student sinhvien : dsSinhVien) {
			if(sinhvien.getMSSV().equals(MSSV)) {
				this.textField_hoTen.setText(sinhvien.getHoTen());
				this.textField_ngaySinh.setText((sinhvien.getNgaySinh().getMonth() + 1)+"/"+sinhvien.getNgaySinh().getDate()+"/"+(sinhvien.getNgaySinh().getYear()+1900));
				this.textField_MSSV.setText(MSSV);
				this.textField_khoa.setText(sinhvien.getKhoa().getTenKhoa());
				this.textField_gioiTinh.setText(sinhvien.isGioiTinh()?"Nam":"Nữ");
				this.textField_TCTL.setText(sinhvien.getTCTL()+"");
				this.textField_gpa4.setText(sinhvien.getGpa_4()+"");
				this.textField_gpa10.setText(sinhvien.getGpa_10()+"");
			}
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
}
