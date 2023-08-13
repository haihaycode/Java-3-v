package lab1;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class bai3 extends Frame {
	private JFrame SignUpForm;
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;

	private JTextField txtUser;
	private JTextField txtPass;
	private JTextField txtComirmPass;

	private JButton btnSignUp;
	private JButton btnCanced;

	public static void main(String[] args) {
		bai3 bai3 = new bai3();
		bai3.bai3();
	}

	public boolean checkNull() {
		if (txtPass.getText().equals("") || txtUser.getText().equals("") || txtComirmPass.getText().equals("")) {
			return false;

		} else {
			return true;
		}
	}

	public void cancel() {
		System.out.println("Thoát...");
		System.exit(0);
	}

	public void SignUp() {
		if (checkNull() == true) {
			if (txtPass.getText().equals(txtComirmPass.getText())) {
				JOptionPane.showMessageDialog(this, "Đăng Nhập Thành Công");
			} else {
				JOptionPane.showMessageDialog(this, "mật Khẩu và xác nhận không trùng khớp");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Thiếu dự kiện");
		}
	}

	public void bai3() {
		SignUpForm = new JFrame("Sign Up Form");
		SignUpForm.setSize(400, 200);

		SignUpForm.setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLocation(10, 10);

		panel.setLayout(new GridLayout(4, 2));
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));

		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));

		JLabel lb1 = new JLabel("UserName");
		txtUser = new JTextField();
		panel1.add(lb1);
		panel1.add(txtUser);
		panel.add(panel1);

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1, 2));

		JLabel lb2 = new JLabel("PassWord");
		txtPass = new JTextField();
		panel2.add(lb2);
		panel2.add(txtPass);
		panel.add(panel2);

		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1, 2));

		JLabel lb3 = new JLabel("ComFirm PassWord");
		txtComirmPass = new JTextField();
		panel3.add(lb3);
		panel3.add(txtComirmPass);
		panel.add(panel3);

		panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnSignUp = new JButton("Sign Up");
		btnCanced = new JButton("Cancel");

		panel4.add(btnSignUp);
		panel4.add(btnCanced);
		panel.add(panel4);

		btnCanced.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SignUp();
			}
		});

		SignUpForm.add(panel);

		SignUpForm.setVisible(true);

//	   SignUpForm.add(baHangHaiCot);

	}
}
