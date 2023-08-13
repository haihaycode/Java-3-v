package lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextArea textArea;
	private JRadioButton rdbtnnam;
	private JRadioButton rdbtnnu;
	private JComboBox comboBox;
	private JCheckBox chckbxNewCheckBox_1,chckbxNewCheckBox_2,chckbxNewCheckBox_3;
	private final ButtonGroup btnGsex = new ButtonGroup();

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

	public void thongBao() {
		String txtname = txtName.getText();
		String txtadd = textArea.getText();
		String nam_nu="";
		String QualifiCation="";
		String hobbies="";
		if(rdbtnnam.isSelected()) {
			nam_nu=rdbtnnam.getActionCommand();
		}
		if(rdbtnnu.isSelected()) {
			nam_nu=rdbtnnu.getActionCommand();
		}
		
		 QualifiCation  = (String) comboBox.getSelectedItem();
		
		if(chckbxNewCheckBox_1.isSelected()) {
			hobbies=chckbxNewCheckBox_1.getActionCommand();
		}
		if(chckbxNewCheckBox_2.isSelected()) {
			hobbies=chckbxNewCheckBox_2.getActionCommand();
		}
		if(chckbxNewCheckBox_3.isSelected()) {
			hobbies=chckbxNewCheckBox_3.getActionCommand();
		}
		JOptionPane.showMessageDialog(this, txtname+"\n"+txtadd+"\n"+nam_nu+"\n"+QualifiCation+"\n"+hobbies+"\n");
	}
	public void reset() {
		txtName.setText("");
		textArea.setText("");
		rdbtnnam.setSelected(true);
		rdbtnnu.setSelected(false);
		chckbxNewCheckBox_1.setSelected(false);
		chckbxNewCheckBox_2.setSelected(false);
		chckbxNewCheckBox_3.setSelected(false);
		comboBox.setSelectedIndex(0);
		
	}

	/**
	 * Create the frame.
	 */
	public bai1() {
		setTitle("Student Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 20, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("Tên");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);

		txtName = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtName, 2, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, txtName, 229, SpringLayout.EAST, lblNewLabel);
		panel.add(txtName);
		txtName.setColumns(10);

		JLabel lblAddress = new JLabel("Address : ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblAddress, 18, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblAddress, 0, SpringLayout.WEST, lblNewLabel);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblAddress);

		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 12, SpringLayout.EAST, lblAddress);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtName, 0, SpringLayout.WEST, panel_2);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, lblAddress);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 182, SpringLayout.NORTH, lblAddress);
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblSex = new JLabel("Sex : ");
		sl_panel.putConstraint(SpringLayout.WEST, lblSex, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblSex, -124, SpringLayout.SOUTH, panel);
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblSex);

		JPanel panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 28, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 40, SpringLayout.EAST, lblSex);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, -330, SpringLayout.EAST, panel);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 1, 20, 20));

		 rdbtnnam = new JRadioButton("Male");
		 rdbtnnam.setSelected(true);
		rdbtnnam.setHorizontalAlignment(SwingConstants.CENTER);
		btnGsex.add(rdbtnnam);
		panel_3.add(rdbtnnam);

		 rdbtnnu = new JRadioButton("Female");
		rdbtnnu.setHorizontalAlignment(SwingConstants.CENTER);
		btnGsex.add(rdbtnnu);
		panel_3.add(rdbtnnu);

		JPanel panel_4 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, -440, SpringLayout.NORTH, panel_4);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_4);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_4, 453, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_4, 20, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel_4);

		JButton btnNewButton_1 = new JButton("validate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongBao();
			}
		});
		panel_4.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panel_4.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -6, SpringLayout.WEST, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, -274, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 13, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_4);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblQualification = new JLabel("QualifiCation : ");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblQualification, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblQualification, 10, SpringLayout.WEST, panel_1);
		lblQualification.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblQualification);

		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Graduate", "Student" }));
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 6, SpringLayout.EAST, lblQualification);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox, 163, SpringLayout.EAST, lblQualification);
		panel_1.add(comboBox);

		JLabel lblHobby = new JLabel("Hobby : ");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblHobby, 34, SpringLayout.SOUTH, lblQualification);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblHobby, 0, SpringLayout.WEST, lblQualification);
		lblHobby.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblHobby);

		JPanel panel_5 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_5, 0, SpringLayout.NORTH, lblHobby);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_5, 6, SpringLayout.EAST, lblHobby);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_5, 197, SpringLayout.SOUTH, comboBox);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_5, 129, SpringLayout.EAST, lblHobby);
		panel_1.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 20, 20));

		 chckbxNewCheckBox_1 = new JCheckBox("Reading");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(chckbxNewCheckBox_1);

		 chckbxNewCheckBox_2 = new JCheckBox("Singing");
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(chckbxNewCheckBox_2);

		 chckbxNewCheckBox_3 = new JCheckBox("Dancing");
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(chckbxNewCheckBox_3);
	}
}
