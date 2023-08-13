package lab1;

import java.awt.Checkbox;
import java.awt.FlowLayout;
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

public class bai2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;

	private JLabel firstNumber;
	private JLabel SecondNumber;
	private JLabel result;

	private JTextField TxtNumber1;
	private JTextField TxtNumber2;
	private JTextField Txtresult;

	private JButton btnCong;
	private JButton btnTru;
	private JButton btnNhan;
	private JButton btnChia;

	public static void main(String[] args) {
		bai2 bai2 = new bai2();
		bai2.setUp();

	}

	public boolean CheckNull() {
		if (TxtNumber1.getText().equals("") || TxtNumber2.getText().equals("")) {
			return false;
		} else {
			return true;
		}
	}

	public void setUp() {
		frame = new JFrame("Calculato");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(4, 1));

		panel1 = new JPanel(new GridLayout(1, 2));
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
		firstNumber = new JLabel("firstNumber");
		TxtNumber1 = new JTextField();

		panel1.add(firstNumber);
		panel1.add(TxtNumber1);
		panel1.setSize(300, 50);
		frame.add(panel1);

		panel2 = new JPanel(new GridLayout(1, 2));
		panel2.setBorder(new EmptyBorder(10, 10, 10, 10));
		SecondNumber = new JLabel("secondNumBer");
		TxtNumber2 = new JTextField();

		panel2.add(SecondNumber);
		panel2.add(TxtNumber2);
		panel2.setSize(300, 50);
		frame.add(panel2);

		panel3 = new JPanel(new GridLayout(1, 2));
		panel3.setBorder(new EmptyBorder(10, 10, 10, 10));
		result = new JLabel("result");
		Txtresult = new JTextField();

		panel3.add(result);
		panel3.add(Txtresult);
		panel3.setSize(300, 50);
		frame.add(panel3);

		panel4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel4.setBorder(new EmptyBorder(0, 0, 0, 10));

		btnCong = new JButton("+");
		btnTru = new JButton("-");
		btnNhan = new JButton("*");
		btnChia = new JButton("/");
		panel4.add(btnCong);
		panel4.add(btnTru);
		panel4.add(btnNhan);
		panel4.add(btnChia);
		frame.add(panel4);

		btnCong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (CheckNull() == true) {
					try {
						int txt1 = Integer.parseInt(TxtNumber1.getText());
						int txt2 = Integer.parseInt(TxtNumber2.getText());
						Txtresult.setText(Integer.toString(txt1 + txt2));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage() + "\n Lỗi Phải là số");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nhập Đầy đủ thông tin");
				}

			}
		});

		btnNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (CheckNull() == true) {
					try {
						int txt1 = Integer.parseInt(TxtNumber1.getText());
						int txt2 = Integer.parseInt(TxtNumber2.getText());
						Txtresult.setText(Integer.toString(txt1 * txt2));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage() + "\n Lỗi Phải là số");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nhập Đầy đủ thông tin");
				}
			}
		});

		btnTru.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (CheckNull() == true) {
					try {
						int txt1 = Integer.parseInt(TxtNumber1.getText());
						int txt2 = Integer.parseInt(TxtNumber2.getText());
						Txtresult.setText(Integer.toString(txt1 - txt2));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage() + "\n Lỗi Phải là số");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nhập Đầy đủ thông tin");
				}

			}
		});
		btnChia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (CheckNull() == true) {
					try {
						int txt1 = Integer.parseInt(TxtNumber1.getText());
						int txt2 = Integer.parseInt(TxtNumber2.getText());
						Txtresult.setText(Integer.toString(txt1 / txt2));
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage() + "\n Lỗi Phải là số");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nhập Đầy đủ thông tin");
				}

			}
		});

		frame.setVisible(true);

	}

}
