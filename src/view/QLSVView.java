package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


import model.Faculty;
import model.QLSVSystem;
import model.Student;
import controller.QLSVController;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.text.Normalizer;
import java.text.ParseException;

import java.util.regex.Pattern;

import java.util.Scanner;

import java.text.SimpleDateFormat;


public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVSystem system;
	private JTable table;
	private JTextField MSSV_find;
	private JTextField textField_Name;
	private JTextField textField_Birth;
	private JTextField textField_MSSV;
	private JTextField textField_TCTL;
	private JTextField textField_GPA4;
	private JTextField textField_GPA10;
	private ButtonGroup btn_gioiTinh;
	private JComboBox comboBox_Khoa_info;
	private JRadioButton RadioButton_Nam;
	private JRadioButton RadioButton_Nu;
	private JComboBox comboBox_Khoa_find;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
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
	public QLSVView() {
		this.system = new QLSVSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 699);
		
		Action action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuSave);
		

		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(415, 11, 210, 38);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"H\u1ECD v\u00E0 t\u00EAn", "Khoa", "MSSV", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "T\u00EDn ch\u1EC9 t\u00EDch l\u0169y", "GPA(h\u1EC7 4)", "GPA (h\u1EC7 10)"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(30, 53, 935, 187);
		contentPane.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 245, 952, 21);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("KHOA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(76, 265, 94, 28);
		contentPane.add(lblNewLabel_1);
		
		comboBox_Khoa_find = new JComboBox();
		comboBox_Khoa_find.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ArrayList<Faculty> facultyList = Faculty.getFacultyList();
		comboBox_Khoa_find.addItem("");
		for (Faculty faculty : facultyList) {
			comboBox_Khoa_find.addItem(faculty.getTenKhoa());
		}
		comboBox_Khoa_find.setBounds(156, 265, 274, 28);
		contentPane.add(comboBox_Khoa_find);
		
		JLabel lblNewLabel_2 = new JLabel("MSSV");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(486, 265, 70, 28);
		contentPane.add(lblNewLabel_2);
		
		MSSV_find = new JTextField();
		MSSV_find.setFont(new Font("Tahoma", Font.PLAIN, 14));
		MSSV_find.setBounds(546, 267, 215, 28);
		contentPane.add(MSSV_find);
		MSSV_find.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin sinh viên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(46, 301, 162, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Họ và tên");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(57, 334, 113, 21);
		contentPane.add(lblNewLabel_4);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Name.setBounds(156, 328, 274, 38);
		contentPane.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Ngày sinh");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_1.setBounds(538, 334, 113, 21);
		contentPane.add(lblNewLabel_4_1);
		
		textField_Birth = new JTextField();
		textField_Birth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Birth.setColumns(10);
		textField_Birth.setBounds(650, 328, 274, 38);
		contentPane.add(textField_Birth);
		
		JLabel lblNewLabel_4_2 = new JLabel("MSSV");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2.setBounds(57, 382, 113, 21);
		contentPane.add(lblNewLabel_4_2);
		
		textField_MSSV = new JTextField();
		textField_MSSV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_MSSV.setColumns(10);
		textField_MSSV.setBounds(156, 376, 274, 38);
		contentPane.add(textField_MSSV);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Giới tính");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_1.setBounds(538, 382, 113, 21);
		contentPane.add(lblNewLabel_4_2_1);
		
		RadioButton_Nam = new JRadioButton("Nam");
		RadioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RadioButton_Nam.setBounds(650, 376, 111, 32);
		contentPane.add(RadioButton_Nam);
		
		RadioButton_Nu = new JRadioButton("Nữ");
		RadioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RadioButton_Nu.setBounds(759, 376, 111, 32);
		contentPane.add(RadioButton_Nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(RadioButton_Nam);
		btn_gioiTinh.add(RadioButton_Nu);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Khoa");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2.setBounds(57, 432, 113, 21);
		contentPane.add(lblNewLabel_4_2_2);
		
		comboBox_Khoa_info = new JComboBox();
		comboBox_Khoa_info.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_Khoa_info.addItem("");
		for (Faculty faculty : facultyList) {
			comboBox_Khoa_info.addItem(faculty.getTenKhoa());
		}
		comboBox_Khoa_info.setBounds(156, 426, 274, 38);
		contentPane.add(comboBox_Khoa_info);
		
		JLabel lblNewLabel_4_2_2_1 = new JLabel("Tín chỉ TL");
		lblNewLabel_4_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2_1.setBounds(538, 432, 128, 21);
		contentPane.add(lblNewLabel_4_2_2_1);
		
		textField_TCTL = new JTextField();
		textField_TCTL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_TCTL.setColumns(10);
		textField_TCTL.setBounds(650, 426, 274, 38);
		contentPane.add(textField_TCTL);
		
		JLabel lblNewLabel_4_2_2_2 = new JLabel("GPA(hệ 4)");
		lblNewLabel_4_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2_2.setBounds(57, 481, 113, 21);
		contentPane.add(lblNewLabel_4_2_2_2);
		
		textField_GPA4 = new JTextField();
		textField_GPA4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_GPA4.setColumns(10);
		textField_GPA4.setBounds(156, 475, 274, 38);
		contentPane.add(textField_GPA4);
		
		JLabel lblNewLabel_4_2_2_2_1 = new JLabel("GPA(hệ 10)");
		lblNewLabel_4_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4_2_2_2_1.setBounds(538, 481, 113, 21);
		contentPane.add(lblNewLabel_4_2_2_2_1);
		
		textField_GPA10 = new JTextField();
		textField_GPA10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_GPA10.setColumns(10);
		textField_GPA10.setBounds(650, 475, 274, 38);
		contentPane.add(textField_GPA10);
		
		JButton btnFind = new JButton("Tìm");
		btnFind.addActionListener(action);
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFind.setBounds(779, 260, 79, 38);
		contentPane.add(btnFind);
		
		JButton btnFindCancel = new JButton("Hủy tìm");
		btnFindCancel.addActionListener(action);
		btnFindCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFindCancel.setBounds(868, 260, 97, 38);
		contentPane.add(btnFindCancel);
		
		JButton btnInsert = new JButton("Thêm");
		btnInsert.addActionListener(action);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBounds(47, 559, 123, 44);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(action);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(218, 559, 123, 44);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(401, 559, 123, 44);
		contentPane.add(btnDelete);
		
		JButton btnStored = new JButton("Lưu");
		btnStored.addActionListener(action);
		btnStored.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStored.setBounds(595, 559, 123, 44);
		contentPane.add(btnStored);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(action);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(779, 559, 123, 44);
		contentPane.add(btnCancel);
		
		JButton btnBack = new JButton("Quay về");
		btnBack.addActionListener(action);
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setBounds(0, 0, 113, 38);
		contentPane.add(btnBack);
		
		
		this.setVisible(true);
		
	}
	
	public void deleteForm() {
		textField_Name.setText("");
		textField_Birth.setText("");
		textField_MSSV.setText("");
		textField_TCTL.setText("");
		textField_GPA4.setText("");
		textField_GPA10.setText("");
		comboBox_Khoa_info.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}
	
	//Thuc hien luu thong tin sinh vien
	public void store() {
		//GetData
		String MSSV = this.textField_MSSV.getText();
		String hoTen = this.textField_Name.getText();
		Faculty Khoa = Faculty.getFacultybyName(this.comboBox_Khoa_info.getSelectedItem().toString() + "");
		Date ngaySinh = new Date(this.textField_Birth.getText());
		boolean gioiTinh = true;
		if(this.RadioButton_Nam.isSelected()) {
			gioiTinh = true;
		}
		else {
			gioiTinh = false;
		}
		int TCTL = Integer.valueOf(this.textField_TCTL.getText());
		float gpa_10 = Float.valueOf(this.textField_GPA10.getText());
		float gpa_4 = Float.valueOf(this.textField_GPA4.getText());
		
		Student sinhvien = new Student(MSSV, hoTen, Khoa, ngaySinh, gioiTinh, TCTL, gpa_10, gpa_4);

		if(gpa_4 < 0.0 || gpa_4 > 4.0) {
			JOptionPane.showMessageDialog(this, "GPA(hệ 4.0) phải nằm trong khoảng 0 - 4.0");
		}
		else if(gpa_10 < 0.0 || gpa_10 > 10.0) {
			JOptionPane.showMessageDialog(this, "GPA(hệ 10.0) phải nằm trong khoảng 0 - 10.0");
		}
		else if(TCTL < 0) {
			JOptionPane.showMessageDialog(this, "Tín chỉ tích lũy phải lớn hơn bằng 0");
		}
		else {
			this.insertOrUpdate(sinhvien);
		}
		
	}
	
	//Them sinh vien vao bang
	public void insert(Student sinhvien) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {sinhvien.getHoTen(), sinhvien.getKhoa().getTenKhoa(), 
				sinhvien.getMSSV()+"", (sinhvien.getNgaySinh().getMonth()+1)+"/"+(sinhvien.getNgaySinh().getDate())+"/"+(sinhvien.getNgaySinh().getYear()+1900),
				(sinhvien.isGioiTinh()?"Nam":"Nữ"),sinhvien.getTCTL()+"",
				sinhvien.getGpa_4()+"",sinhvien.getGpa_10()+""});
	}
	
	//Neu sinh vien chua ton tai thi them vao he thong. Nguoc lai thi ta cap nhat thong tin sinh vien.
	public void insertOrUpdate(Student sinhvien) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.system.checkExist(sinhvien)) {
			this.system.insert(sinhvien);
			this.insert(sinhvien);
			this.addStudentToMySQL(sinhvien);
		}
		else {
			this.system.update(sinhvien);
			int numOfRow = table.getRowCount();
			for(int i = 0; i < numOfRow; i++) {
				String mSSV = model_table.getValueAt(i, 2)+"";
				if(mSSV.equals(sinhvien.getMSSV())){
					model_table.setValueAt(sinhvien.getHoTen(), i, 0);
					model_table.setValueAt(sinhvien.getKhoa().getTenKhoa(), i, 1);
					model_table.setValueAt(sinhvien.getMSSV(), i, 2);
					model_table.setValueAt((sinhvien.getNgaySinh().getMonth()+1) + "/" + (sinhvien.getNgaySinh().getDate()) + "/"
							+ (sinhvien.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((sinhvien.isGioiTinh()?"Nam":"Nữ"), i, 4);
					model_table.setValueAt(sinhvien.getTCTL(), i, 5);
					model_table.setValueAt(sinhvien.getGpa_4(), i, 6);
					model_table.setValueAt(sinhvien.getGpa_10(), i, 7);
				}
			}
			this.deleteStudentFromMySQL(sinhvien);
			this.addStudentToMySQL(sinhvien);
		}
	}
	
	//Hien thi thong tin sinh vien
	public void display() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String hoTen = tableModel.getValueAt(row, 0)+"";
		String MSSV = tableModel.getValueAt(row, 2)+"";
		Faculty Khoa = Faculty.getFacultybyName(tableModel.getValueAt(row, 1)+"");
		String ngaySinh_s = tableModel.getValueAt(row, 3)+"";
		Date ngaySinh = new Date(ngaySinh_s);
		String chon_gioiTinh = tableModel.getValueAt(row, 4)+ "";
		boolean gioiTinh = chon_gioiTinh.equals("Nam");
		int TCTL = Integer.valueOf(tableModel.getValueAt(row, 5)+"");
		float gpa_10 = Float.valueOf(tableModel.getValueAt(row, 7)+"");
		float gpa_4 = Float.valueOf(tableModel.getValueAt(row, 6)+"");
		
		this.textField_MSSV.setText(MSSV+"");
		this.textField_Name.setText(hoTen+"");
		this.comboBox_Khoa_info.setSelectedItem(Khoa.getTenKhoa());
		this.textField_Birth.setText(ngaySinh_s+"");
		this.textField_TCTL.setText(TCTL+"");
		this.textField_GPA10.setText(gpa_10+"");
		this.textField_GPA4.setText(gpa_4+"");
		
		if(gioiTinh) {
			RadioButton_Nam.setSelected(true);
		}
		else
			RadioButton_Nu.setSelected(true);
	}

	//Lay thong tin sinh vien dang chon
	public Student getStudent() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		
		String hoTen = tableModel.getValueAt(row, 0)+"";
		String MSSV = tableModel.getValueAt(row, 2)+"";
		Faculty Khoa = Faculty.getFacultybyName(tableModel.getValueAt(row, 1)+"");
		String ngaySinh_s = tableModel.getValueAt(row, 3)+"";
		Date ngaySinh = new Date(ngaySinh_s);
		String chon_gioiTinh = tableModel.getValueAt(row, 4)+ "";
		boolean gioiTinh = chon_gioiTinh.equals("Nam");
		int TCTL = Integer.valueOf(tableModel.getValueAt(row, 5)+"");
		float gpa_10 = Float.valueOf(tableModel.getValueAt(row, 7)+"");
		float gpa_4 = Float.valueOf(tableModel.getValueAt(row, 6)+"");
		
		Student sinhvien = new Student(MSSV, hoTen, Khoa, ngaySinh, gioiTinh, TCTL, gpa_10, gpa_4);
		return sinhvien;
	}
	
	//Xoa sinh vien khoi he thong
	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int select = JOptionPane.showConfirmDialog(this, "Bạn xác nhận muốn xóa dòng đang chọn?");
		if(select == JOptionPane.YES_OPTION) {
			Student sinhvien = getStudent();
			this.system.delete(sinhvien);
			tableModel.removeRow(row);
			this.deleteStudentFromMySQL(sinhvien);
		}
	}

	//Tim kiem sinh vien trong he thong
	public void find() {
		//Huy tim dang co truoc khi thuc hien tim
		this.loadData();
		//Thuc hien tim
		String tenKhoa_find = this.comboBox_Khoa_find.getSelectedItem().toString() + "";
		String MSSV_find = this.MSSV_find.getText();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		int numOfRow = tableModel.getRowCount();
		Set<String> deleteStudentsID = new TreeSet<String>();
		if(!tenKhoa_find.equals("")) {
			for(int i = 0; i < numOfRow; i++ ) {
				String tenkhoa = tableModel.getValueAt(i, 1) + "";
				String MSSV = tableModel.getValueAt(i, 2) + "";
				if(!tenkhoa.equals(tenKhoa_find)) {
					deleteStudentsID.add(MSSV);
				}
			}
		}
		
		if(MSSV_find.length() > 0) {
			for(int i = 0; i < numOfRow; i++) {
				String MSSV = tableModel.getValueAt(i, 2) + "";
				if(!MSSV.equals(MSSV_find)) {
					deleteStudentsID.add(MSSV);
				}
			}
		}
		
		for(String MSSVdelete : deleteStudentsID) {
			numOfRow = tableModel.getRowCount();
			for(int i = 0; i < numOfRow; i++) {
				String MSSV = tableModel.getValueAt(i, 2) + "";
				if(MSSV.equals(MSSVdelete)) {
					try {
						tableModel.removeRow(i);
					} catch (Exception e){
						e.printStackTrace();
					}
					break;
				}
			}
		}
	}

	public void loadData() {
		while (true) {
			DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			int numOfRow = tableModel.getRowCount();
			if(numOfRow == 0)
				break;
			else
				try {
					tableModel.removeRow(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		for (Student sinhvien : this.system.getDsSinhVien()) {
			this.insert(sinhvien);
		}
		
	}

	public void back() {
		int luaChon = JOptionPane.showConfirmDialog(
			    this,
			    "Bạn có muốn quay lại menu",
			    "Back",
			    JOptionPane.YES_NO_OPTION);
		if (luaChon == JOptionPane.YES_OPTION) {
			new QLSVChoose();
			dispose();
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
	
//	public void openFile() {
//		JFileChooser fc = new JFileChooser();
//		int returnVal = fc.showOpenDialog(this);
//		if (returnVal == JFileChooser.APPROVE_OPTION) {
//			File file = fc.getSelectedFile();
//			open(file);
//			loadData();
//		} 
//	}

	
	public void open() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select a CSV file");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));
		int result = fileChooser.showOpenDialog(null);
		ArrayList<Student> ds = new ArrayList<Student>();
		if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String dateString = data[3];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                    Date date = null;
                    try {
                        date = dateFormat.parse(dateString);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Student sinhvien = new Student(data[2], data[0], Faculty.getFacultybyName(data[1]), date, (data[4].equals("Nam")), Integer.parseInt(data[5]), Float.parseFloat(data[7]),Float.parseFloat(data[6]));
                    ds.add(sinhvien);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            this.system.setDsSinhVien(ds);
		}
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		for (Student row : ds) {
            this.insert(row);
        }
//		ArrayList ds = new ArrayList();
//		try {
//			this.system.setFileName(file.getAbsolutePath());
//			FileInputStream fis = new FileInputStream(file);
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			Student sinhvien = null;
//			while((sinhvien = (Student) ois.readObject())!=null) {
//				ds.add(sinhvien);
//			}
//			ois.close();
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		this.system.setDsSinhVien(ds);
	}
	
	public void saveFile() {
		if(this.system.getFileName().length()>0) {
			save(this.system.getFileName());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				save(file.getAbsolutePath());
			} 
		}
	}

	private void save(String path) {
		try {
			this.system.setFileName(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (Student sinhvien : this.system.getDsSinhVien()) {
				oos.writeObject(sinhvien);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean addStudentToMySQL(Student stu) {
		String sqlQuery = "INSERT INTO qlsv (`Họ và tên`, Khoa, MSSV, `Ngày sinh`, `Giới tính`, `Tín chỉ tích lũy`, `GPA (hệ 4)`, `GPA (hệ 10)`, Pass, Mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1","root","");
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, stu.getHoTen());
			ps.setString(2, stu.getKhoa().getTenKhoa());
			ps.setString(3, stu.getMSSV());
			ps.setString(4, (stu.getNgaySinh().getMonth()+1)+"/"+(stu.getNgaySinh().getDate())+"/"+(stu.getNgaySinh().getYear()+1900));
			ps.setString(5, stu.isGioiTinh()?"Nam":"Nữ");
			ps.setInt(6, stu.getTCTL());
			ps.setFloat(7, stu.getGpa_4());
			ps.setFloat(8, stu.getGpa_10());
			ps.setString(9, (stu.getNgaySinh().getMonth()+1)+stu.getMSSV()+(stu.getNgaySinh().getDate())+(stu.getNgaySinh().getYear()+1900));
			ps.setString(10, email(stu.getHoTen()));
			return ps.executeUpdate()>0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteStudentFromMySQL(Student stu) {
		String sqlQuery = "DELETE FROM qlsv WHERE MSSV = '" + stu.getMSSV() +"'";
		try {
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1","root","");
			PreparedStatement ps = con.prepareStatement(sqlQuery);
			ps.setString(1, stu.getMSSV());
			return ps.executeUpdate()>0;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	 public String email(String s) {
		  
		  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  String name = pattern.matcher(temp).replaceAll("");
		  return name.toLowerCase().replaceAll("\\s", ".") + "@hcmut.edu.vn";
		 }

}
