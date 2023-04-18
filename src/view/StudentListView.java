package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.StudentList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class StudentListView extends JFrame {

	private JPanel contentPane;
	StudentList List;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentListView frame = new StudentListView();
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
	public StudentListView() {
		this.List = new StudentList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 426);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu File = new JMenu("File");
		menuBar.add(File);
		
		JMenuItem Open = new JMenuItem("Open");
		File.add(Open);
		
		JMenuItem Exit = new JMenuItem("Exit");
		File.add(Exit);
		
		JMenu About = new JMenu("About");
		menuBar.add(About);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		menuBar.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 10, 788, 45);
		contentPane.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel(" Name ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		horizontalBox.add(lblNewLabel);
		
		textField = new JTextField();
		horizontalBox.add(textField);
		textField.setColumns(10);
	}
}
