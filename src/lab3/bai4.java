package lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtContact;
	private JTextField txtHQ;
	private JTextField txtSpe;
	private JTextField txtEF;
	private JTextField txtHobbies;
	private JTextField txtSport;
	private JTextArea textAreaAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai4 frame = new bai4();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void save() {
	    if (txtFirstName.getText().equals("") || txtLastName.getText().equals("") || txtContact.getText().equals("") || txtHQ.getText().equals("") || txtSpe.getText().equals("") ||
	            txtEF.getText().equals("") || txtHobbies.getText().equals("") || txtSport.getText().equals("") || textAreaAddress.getText().equals("")) {
	        JOptionPane.showMessageDialog(this, "Please fill in all the fields!");
	    } else {
	        String message = "First Name: " + txtFirstName.getText() + "\n"
	                + "Last Name: " + txtLastName.getText() + "\n"
	                + "Contact: " + txtContact.getText() + "\n"
	                + "HQ: " + txtHQ.getText() + "\n"
	                + "Spe: " + txtSpe.getText() + "\n"
	                + "EF: " + txtEF.getText() + "\n"
	                + "Hobbies: " + txtHobbies.getText() + "\n"
	                + "Sport: " + txtSport.getText() + "\n"
	                + "Address: " + textAreaAddress.getText();
	        
	        JOptionPane.showMessageDialog(this, message);
	        
	  
	    }
	}
	public void reset() {
	    txtFirstName.setText("");
	    txtLastName.setText("");
	    txtContact.setText("");
	    txtHQ.setText("");
	    txtSpe.setText("");
	    txtEF.setText("");
	    txtHobbies.setText("");
	    txtSport.setText("");
	    textAreaAddress.setText("");
	}
	public void exit() {
		System.exit(0);
	}




	
	public bai4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 768);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 74, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRATION");
		lblNewLabel.setForeground(Color.decode("#DB67DC"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 7, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 257, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -15, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 21, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1_1, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Contact");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_1, 19, SpringLayout.SOUTH, lblNewLabel_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_1, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNewLabel_1_1_1, 82, SpringLayout.WEST, panel_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Address");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1_2, 22, SpringLayout.SOUTH, lblNewLabel_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1_1_2, 0, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_1_1_2);
		
		txtFirstName = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtFirstName, 2, SpringLayout.NORTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtFirstName, 34, SpringLayout.EAST, lblNewLabel_1);
		panel_1.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.EAST, txtFirstName, 0, SpringLayout.EAST, txtLastName);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtLastName, 34, SpringLayout.EAST, lblNewLabel_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtLastName, 2, SpringLayout.NORTH, lblNewLabel_1_1);
		panel_1.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtContact = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.EAST, txtLastName, 0, SpringLayout.EAST, txtContact);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtContact, 2, SpringLayout.NORTH, lblNewLabel_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtContact, 34, SpringLayout.EAST, lblNewLabel_1_1_1);
		panel_1.add(txtContact);
		txtContact.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 53, SpringLayout.EAST, lblNewLabel_1_1_2);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, -16, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtContact, 0, SpringLayout.EAST, panel_2);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, lblNewLabel_1_1_2);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -27, SpringLayout.SOUTH, panel_1);
		panel_1.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 0 0,grow");
		
		 textAreaAddress = new JTextArea();
		textAreaAddress.setLineWrap(true);
		scrollPane.setViewportView(textAreaAddress);
		
		JPanel panel_3 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, 132, SpringLayout.SOUTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
		panel_3.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Acamedic Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3_1, 6, SpringLayout.SOUTH, panel_3);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3_1, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3_1, -133, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3_1, 0, SpringLayout.EAST, panel);
		panel_3_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SpringLayout sl_panel_3 = new SpringLayout();
		panel_3.setLayout(sl_panel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Highest Qualification");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2, 10, SpringLayout.NORTH, panel_3);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1_2, 10, SpringLayout.WEST, panel_3);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Specification");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_1, 11, SpringLayout.SOUTH, lblNewLabel_1_2);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_1, 0, SpringLayout.WEST, lblNewLabel_1_2);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Enroll For");
		sl_panel_3.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_2, 10, SpringLayout.SOUTH, lblNewLabel_1_2_1);
		sl_panel_3.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_2, 0, SpringLayout.WEST, lblNewLabel_1_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3.add(lblNewLabel_1_2_2);
		
		txtHQ = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, txtHQ, 2, SpringLayout.NORTH, lblNewLabel_1_2);
		sl_panel_3.putConstraint(SpringLayout.WEST, txtHQ, 6, SpringLayout.EAST, lblNewLabel_1_2);
		sl_panel_3.putConstraint(SpringLayout.EAST, txtHQ, 249, SpringLayout.EAST, lblNewLabel_1_2);
		panel_3.add(txtHQ);
		txtHQ.setColumns(10);
		
		txtSpe = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.NORTH, txtSpe, 2, SpringLayout.NORTH, lblNewLabel_1_2_1);
		sl_panel_3.putConstraint(SpringLayout.WEST, txtSpe, 0, SpringLayout.WEST, txtHQ);
		sl_panel_3.putConstraint(SpringLayout.EAST, txtSpe, 0, SpringLayout.EAST, txtHQ);
		panel_3.add(txtSpe);
		txtSpe.setColumns(10);
		
		txtEF = new JTextField();
		sl_panel_3.putConstraint(SpringLayout.WEST, txtEF, 0, SpringLayout.WEST, txtHQ);
		sl_panel_3.putConstraint(SpringLayout.SOUTH, txtEF, 0, SpringLayout.SOUTH, lblNewLabel_1_2_2);
		sl_panel_3.putConstraint(SpringLayout.EAST, txtEF, 0, SpringLayout.EAST, txtHQ);
		panel_3.add(txtEF);
		txtEF.setColumns(10);
		contentPane.add(panel_3_1);
		SpringLayout sl_panel_3_1 = new SpringLayout();
		panel_3_1.setLayout(sl_panel_3_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Hobbies");
		sl_panel_3_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_3, 10, SpringLayout.NORTH, panel_3_1);
		sl_panel_3_1.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_3, 10, SpringLayout.WEST, panel_3_1);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3_1.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Sport");
		sl_panel_3_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1_2_4, 21, SpringLayout.SOUTH, lblNewLabel_1_2_3);
		sl_panel_3_1.putConstraint(SpringLayout.WEST, lblNewLabel_1_2_4, 0, SpringLayout.WEST, lblNewLabel_1_2_3);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_3_1.add(lblNewLabel_1_2_4);
		
		txtHobbies = new JTextField();
		sl_panel_3_1.putConstraint(SpringLayout.NORTH, txtHobbies, 2, SpringLayout.NORTH, lblNewLabel_1_2_3);
		sl_panel_3_1.putConstraint(SpringLayout.WEST, txtHobbies, 6, SpringLayout.EAST, lblNewLabel_1_2_3);
		sl_panel_3_1.putConstraint(SpringLayout.EAST, txtHobbies, 322, SpringLayout.EAST, lblNewLabel_1_2_3);
		panel_3_1.add(txtHobbies);
		txtHobbies.setColumns(10);
		
		txtSport = new JTextField();
		sl_panel_3_1.putConstraint(SpringLayout.NORTH, txtSport, 0, SpringLayout.NORTH, lblNewLabel_1_2_4);
		sl_panel_3_1.putConstraint(SpringLayout.WEST, txtSport, 0, SpringLayout.WEST, txtHobbies);
		sl_panel_3_1.putConstraint(SpringLayout.EAST, txtSport, 0, SpringLayout.EAST, txtHobbies);
		txtSport.setColumns(10);
		panel_3_1.add(txtSport);
		
		JPanel panel_4 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_3_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_4, -11, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_4, -15, SpringLayout.EAST, contentPane);
		contentPane.add(panel_4);
		
		JButton btnsave = new JButton("Save");
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		panel_4.add(btnsave);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panel_4.add(btnreset);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		panel_4.add(btnexit);
	}
}
