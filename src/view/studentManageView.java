package view;

import java.awt.EventQueue;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Faculty;
import model.Student;
import model.studentManageSystem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.studentManageController;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class studentManageView extends JFrame {

	private JPanel contentPane;
	public studentManageSystem system;
	public JTable table;
	public JTextField textField;
	public JTextField textField_hoTen;
	public JTextField textField_MSSV;
	public JTextField textField_GPA4;
	public JTextField textField_ngaySinh;
	public JTextField textField_TCTL;
	public JTextField textField_GPA10;
	public JRadioButton radioButton_Nam;
	public JRadioButton radioButton_Nu;
	public JComboBox comboBox_khoa_info;
	public ButtonGroup btn_gioiTinh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentManageView frame = new studentManageView();
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
	public studentManageView() {
		this.system = new studentManageSystem();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1122, 719);
		
		Action action = new studentManageController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuClose);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(menuAbout);
		
		JMenuItem aboutMe = new JMenuItem("About Me");
		aboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuAbout.add(aboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Danh sách sinh viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(482, 11, 165, 24);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Họ và tên", "MSSV", "Khoa", "Ngày sinh", "Giới tính", "TCTL", "GPA(hệ 4.0)", "GPA(hệ 10.0)"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(49, 46, 1017, 180);
		contentPane.add(scrollPane);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(44, 237, 1029, 15);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1 = new JLabel("KHOA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(60, 263, 69, 37);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_khoa_find = new JComboBox();
		comboBox_khoa_find.addItem("");
		ArrayList<Faculty> listFaculty = Faculty.getFacultyList();
		for(Faculty faculty : listFaculty) {
			comboBox_khoa_find.addItem(faculty.getTenKhoa());
		}
		comboBox_khoa_find.setBounds(139, 260, 288, 49);
		contentPane.add(comboBox_khoa_find);
		
		JLabel lblNewLabel_1_1 = new JLabel("MSSV");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(578, 263, 69, 37);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(677, 261, 288, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(977, 263, 89, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_2 = new JLabel("Họ và tên");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(67, 325, 89, 37);
		contentPane.add(lblNewLabel_1_2);
		
		textField_hoTen = new JTextField();
		textField_hoTen.setColumns(10);
		textField_hoTen.setBounds(166, 320, 288, 46);
		contentPane.add(textField_hoTen);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("MSSV");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(67, 385, 89, 37);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Khoa");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2.setBounds(67, 433, 89, 37);
		contentPane.add(lblNewLabel_1_2_2);
		
		comboBox_khoa_info = new JComboBox();
		comboBox_khoa_info.addItem("");
		for(Faculty faculty : listFaculty) {
			comboBox_khoa_info.addItem(faculty.getTenKhoa());
		}
		comboBox_khoa_info.setBounds(166, 430, 288, 49);
		contentPane.add(comboBox_khoa_info);
		
		textField_MSSV = new JTextField();
		textField_MSSV.setColumns(10);
		textField_MSSV.setBounds(166, 377, 288, 46);
		contentPane.add(textField_MSSV);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("GPA(hệ 4.0)");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1_1.setBounds(63, 493, 106, 37);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		textField_GPA4 = new JTextField();
		textField_GPA4.setColumns(10);
		textField_GPA4.setBounds(166, 490, 288, 46);
		contentPane.add(textField_GPA4);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Ngày sinh");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_3.setBounds(545, 325, 89, 37);
		contentPane.add(lblNewLabel_1_2_3);
		
		textField_ngaySinh = new JTextField();
		textField_ngaySinh.setColumns(10);
		textField_ngaySinh.setBounds(677, 323, 288, 46);
		contentPane.add(textField_ngaySinh);
		
		JLabel lblNewLabel_1_2_3_1 = new JLabel("Giới tính");
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_3_1.setBounds(545, 385, 89, 37);
		contentPane.add(lblNewLabel_1_2_3_1);
		
		radioButton_Nam = new JRadioButton("Nam");
		radioButton_Nam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_Nam.setBounds(676, 387, 111, 33);
		contentPane.add(radioButton_Nam);
		
		radioButton_Nu = new JRadioButton("Nữ");
		radioButton_Nu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton_Nu.setBounds(792, 387, 111, 33);
		contentPane.add(radioButton_Nu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(radioButton_Nam);
		btn_gioiTinh.add(radioButton_Nu);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Tín chỉ TL");
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2_1.setBounds(545, 433, 89, 37);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		textField_TCTL = new JTextField();
		textField_TCTL.setColumns(10);
		textField_TCTL.setBounds(677, 431, 288, 46);
		contentPane.add(textField_TCTL);
		
		textField_GPA10 = new JTextField();
		textField_GPA10.setColumns(10);
		textField_GPA10.setBounds(677, 491, 288, 46);
		contentPane.add(textField_GPA10);
		
		JLabel lblNewLabel_1_2_2_1_1 = new JLabel("GPA(hệ 10.0)");
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_2_1_1.setBounds(545, 493, 112, 37);
		contentPane.add(lblNewLabel_1_2_2_1_1);
		
		JButton btnInsert = new JButton("Thêm");
		btnInsert.addActionListener(action);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnInsert.setBounds(141, 566, 112, 45);
		contentPane.add(btnInsert);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(action);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(315, 566, 112, 45);
		contentPane.add(btnDelete);
		
		JButton btnUpdate = new JButton("Cập nhật");
		btnUpdate.addActionListener(action);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(482, 566, 112, 45);
		contentPane.add(btnUpdate);
		
		JButton btnStore = new JButton("Lưu");
		btnStore.addActionListener(action);
		btnStore.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnStore.setBounds(634, 566, 112, 45);
		contentPane.add(btnStore);
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(action);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(791, 566, 112, 45);
		contentPane.add(btnCancel);
		
		this.setVisible(true);
	}

	public void deleteForm() {
		textField_hoTen.setText("");
		textField_MSSV.setText("");
		textField_ngaySinh.setText("");
		textField_TCTL.setText("");
		textField_GPA4.setText("");
		textField_GPA10.setText("");
		comboBox_khoa_info.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	public void insert(Student sinhvien) {
		this.system.insert(sinhvien);
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {sinhvien.getHoTen(), sinhvien.getKhoa().getTenKhoa(), 
									sinhvien.getMasoSV()+"", (sinhvien.getNgaySinh().getMonth()+1)+"/"+(sinhvien.getNgaySinh().getDate())+"/"+(sinhvien.getNgaySinh().getYear()+1900),
									(sinhvien.isGioiTinh()?"Nam":"Nữ"),sinhvien.getTinchiTL()+"",
									sinhvien.getGpa_4()+"",sinhvien.getGpa_10()+""});
	}

	public void update(Student sinhvien) {
		// TODO Auto-generated method stub
		
	}
}
