package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.QLSVController;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class QLSVChoose extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVChoose frame = new QLSVChoose();
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
	public QLSVChoose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		Action action = new QLSVController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HỆ THỐNG QUẢN LÝ SINH VIÊN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(163, 27, 420, 62);
		contentPane.add(lblNewLabel);
		
		JButton btnCSDL = new JButton("Cơ sở dữ liệu thông tin sinh viên");
		btnCSDL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCSDL.addActionListener(action);
		btnCSDL.setBounds(208, 148, 289, 47);
		contentPane.add(btnCSDL);
		
		JButton btnTraCuu = new JButton("Tra cứu thông tin sinh viên");
		btnTraCuu.addActionListener(action);
		btnTraCuu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTraCuu.setBounds(208, 279, 289, 47);
		contentPane.add(btnTraCuu);
		
		this.setVisible(true);
	}

	public void truycapCSDL() {
		new QLSVView();
		dispose();
	}

//	public void truycapTracuu() {
//		new QLSVViewStudent();
//		dispose();
//	}
}
