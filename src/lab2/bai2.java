package lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class bai2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtKetQua;
	private double duLieu;
	private String phepTinh;
	private double duLieu1;
	private boolean amDuong = false; // fasle : la so duong

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2 frame = new bai2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void nhanDuLieu(String i) {

		String txtCu = txtKetQua.getText();

		if (amDuong == true) {
			Double x = -Double.parseDouble(txtCu + i);
			this.duLieu = x;
			System.out.println(this.duLieu);
			String am = "-";
			txtKetQua.setText(txtCu + i);
		} else {
			Double x = Double.parseDouble(txtCu + i);
			this.duLieu = x;
			System.out.println(this.duLieu);
			txtKetQua.setText(txtCu + i);
		}

	}

	public void nhanPhepTinh(String Pheptinh) {

		txtKetQua.setText("");
		this.phepTinh = Pheptinh;
		System.out.println(this.phepTinh);

		this.duLieu1 = this.duLieu;

	}

	public void amDuong() {
		if (this.amDuong == false) {
			this.amDuong = true;
		} else {
			this.amDuong = false;
		}
	}

	public void tinhToan() {

		try {
			switch (this.phepTinh) {
			case "+":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(this.duLieu1 + Integer.parseInt(txtKetQua.getText()));
				Double cu = this.duLieu1 + Double.parseDouble(txtKetQua.getText());
				txtKetQua.setText(Double.toString(this.duLieu1 + Double.parseDouble(txtKetQua.getText())));
				this.duLieu = cu;
				break;
			case "-":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(this.duLieu1 - Integer.parseInt(txtKetQua.getText()));
				Double cu1 = this.duLieu1 - Integer.parseInt(txtKetQua.getText());
				txtKetQua.setText(Double.toString(this.duLieu1 - Double.parseDouble(txtKetQua.getText())));
				this.duLieu = cu1;
				break;
			case "*":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(this.duLieu1 * Integer.parseInt(txtKetQua.getText()));
				Double cu2 = this.duLieu1 * Integer.parseInt(txtKetQua.getText());
				txtKetQua.setText(Double.toString(this.duLieu1 * Double.parseDouble(txtKetQua.getText())));
				this.duLieu = cu2;
				break;
			case "/":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(this.duLieu1 / Integer.parseInt(txtKetQua.getText()));
				Double cu3 = this.duLieu1 / Integer.parseInt(txtKetQua.getText());
				txtKetQua.setText(Double.toString(this.duLieu1 / Double.parseDouble(txtKetQua.getText())));
				this.duLieu = cu3;
				break;
			case "%":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(this.duLieu1 % Integer.parseInt(txtKetQua.getText()));
				Double cu4 = this.duLieu1 % Integer.parseInt(txtKetQua.getText());
				txtKetQua.setText(Double.toString(this.duLieu1 % Double.parseDouble(txtKetQua.getText())));
				this.duLieu = cu4;
				break;
			case "1/x":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(1 / this.duLieu1);
				Double cu5 = 1 / this.duLieu1;
				txtKetQua.setText(Double.toString(1 / (double) this.duLieu1));
				this.duLieu = cu5;
				break;
			case "sqrt":
				System.out.println(txtKetQua.getText() + duLieu1);
				System.out.println(Math.sqrt(this.duLieu1));
				Double cu6 = Math.sqrt(this.duLieu1);
				txtKetQua.setText(Double.toString(Math.sqrt(this.duLieu1)));
				this.duLieu = cu6;
				break;

			}
		} catch (Exception e) {
			System.out.println("bo qua");
		}

	}

	/**
	 * Create the frame.
	 */
	public bai2() {
		setTitle("Caculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNewLabel = new JLabel("CASIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -10, SpringLayout.EAST, contentPane);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 47, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 89, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(2, 2, 2, 2));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		txtKetQua = new JLabel();
		sl_panel.putConstraint(SpringLayout.NORTH, txtKetQua, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, txtKetQua, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtKetQua, 0, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtKetQua, -12, SpringLayout.EAST, panel);
		txtKetQua.setHorizontalAlignment(SwingConstants.RIGHT);
		txtKetQua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtKetQua.setForeground(new Color(64, 0, 64));
		panel.add(txtKetQua);

		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 5, 5, 5));

		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(233, 233, 233));

		panel_1.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(233, 233, 233));
		panel_1.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(233, 233, 233));
		panel_1.add(btn3);

		JButton btnChia = new JButton("/");
		btnChia.setBackground(new Color(233, 233, 233));
		panel_1.add(btnChia);

		JButton btnSqrt = new JButton("Sqrt");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("sqrt");
			}
		});
		btnSqrt.setBackground(new Color(233, 233, 233));
		panel_1.add(btnSqrt);

		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(233, 233, 233));
		panel_1.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(233, 233, 233));
		panel_1.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(233, 233, 233));
		panel_1.add(btn6);

		JButton btnNhan = new JButton("*");
		btnNhan.setBackground(new Color(233, 233, 233));
		panel_1.add(btnNhan);

		JButton btnChiaLayDu = new JButton("%");
		btnChiaLayDu.setBackground(new Color(233, 233, 233));
		panel_1.add(btnChiaLayDu);

		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(233, 233, 233));
		panel_1.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(233, 233, 233));
		panel_1.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(233, 233, 233));
		panel_1.add(btn9);

		JButton btnTru = new JButton("-");
		btnTru.setBackground(new Color(233, 233, 233));
		panel_1.add(btnTru);

		JButton btnMotPhanX = new JButton("1/x");
		btnMotPhanX.setBackground(new Color(233, 233, 233));
		panel_1.add(btnMotPhanX);

		JButton btn0 = new JButton("0");
		btn0.setBackground(new Color(233, 233, 233));
		panel_1.add(btn0);

		JButton btnCong_Tru = new JButton("+/-");
		btnCong_Tru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amDuong();
			}
		});
		btnCong_Tru.setBackground(new Color(233, 233, 233));
		panel_1.add(btnCong_Tru);

		JButton C = new JButton("C");
		C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				duLieu = 0;
				duLieu1 = 0;
				txtKetQua.setText("");
			}
		});
		C.setBackground(new Color(233, 233, 233));
		panel_1.add(C);

		JButton btnCong = new JButton("+");
		btnCong.setBackground(new Color(233, 233, 233));
		panel_1.add(btnCong);

		JButton btnBang = new JButton("=");
		btnBang.setBackground(new Color(233, 233, 233));
		panel_1.add(btnBang);

		btn0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("0");

			}
		});

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("1");

			}
		});

		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("2");

			}
		});

		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("3");

			}
		});

		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("4");

			}
		});

		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("5");

			}
		});

		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("6");

			}
		});

		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("7");

			}
		});

		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("8");

			}
		});

		btn9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanDuLieu("9");

			}
		});

		btnCong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("+");

			}
		});
		btnTru.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("-");

			}
		});
		btnChia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("/");

			}
		});
		btnChiaLayDu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("%");

			}
		});
		btnNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("*");

			}
		});
		btnMotPhanX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nhanPhepTinh("1/x");

			}
		});
		btnBang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tinhToan();

			}
		});

	}

}
