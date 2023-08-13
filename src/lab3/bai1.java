package lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtChoCcBn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai1 frame = new bai1();
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
	public bai1() {
		setTitle("Demo LayOut");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 157));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 95, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 1, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_2);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNorth = new JButton("North");
		panel_1.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnWest = new JButton("West");
		panel_1.add(btnWest, BorderLayout.WEST);
		
		JButton btnCenter = new JButton("Center");
		panel_1.add(btnCenter, BorderLayout.CENTER);
		
		JButton btnEast = new JButton("East");
		panel_1.add(btnEast, BorderLayout.EAST);
		
		JButton btnSouth = new JButton("South");
		panel_1.add(btnSouth, BorderLayout.SOUTH);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 151, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setForeground(new Color(128, 128, 255));
		panel_3.setBorder(new EmptyBorder(10, 10, 10, 10));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -17, SpringLayout.NORTH, panel_3);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);
		
		txtChoCcBn =\ew JTextField();
		sl_panel_2.putConstraint(SpringLayout.NORTH, txtChoCcBn, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, txtChoCcBn, 0, SpringLayout.WEST, panel_2);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, txtChoCcBn, 0, SpringLayout.SOUTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.EAST, txtChoCcBn, 773, SpringLayout.WEST, panel_2);
		txtChoCcBn.setForeground(new Color(0, 255, 0));
		txtChoCcBn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtChoCcBn.setText("Chào Các Bạn sinh viên Foly , Java 3");
		panel_2.add(txtChoCcBn);
		txtChoCcBn.setColumns(10);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, 331, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel);
		
		JButton btnRed = new JButton("Red");
		panel.add(btnRed);
		
		JButton btnGreen = new JButton("Green");
		panel.add(btnGreen);
		
		JButton btnYellow = new JButton("Yellow");
		panel.add(btnYellow);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 5, 10, 10));
		
		JButton btnNewButton_1 = new JButton("");
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_10 = new JButton("");
		panel_3.add(btnNewButton_10);
		
		JButton btnNewButton_4 = new JButton("");
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("");
		panel_3.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		panel_3.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		panel_3.add(btnNewButton_8);
		
		JButton btnNewButton = new JButton("");
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("");
		panel_3.add(btnNewButton_3);
	}
}
