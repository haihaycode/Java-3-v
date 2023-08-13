package lab5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class bai2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtMasv;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtHoTen;
	private JTextArea txtDiaChi;
	private JRadioButton rdoBtnNu, rdoBtnNam;
	public static Connection connection;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private List<students> listStudent = new ArrayList<>();
	private int select = 0;
	public String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
			+ "A-Z]{2,7}$";
	public String fullNameRegex = "^[\\p{L}]+([\\p{Zs}\\p{L}]+)*$";
	private JTextField txtTimKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2 frame = new bai2();
					frame.setVisible(true);
					frame.hamGoiDauApp();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void hamGoiDauApp() {
		fillDuLieuVaoList();
	}

	public static Connection getConnection() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=kisZoneSchool;encrypt=true;trustServerCertificate=true;";
			connection = DriverManager.getConnection(url, "sa", "123");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public void fillDuLieuVaoList() {
		listStudent.clear();
		Connection con = getConnection();
		try {
			Statement stm = con.createStatement();// TẠO CONNECT ĐẾN SQL
			String sql = "select * from Lab5_table_Students";

			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				students data = new students();
				data.setMaSv(rs.getString("maSv"));
				data.setHoten(rs.getString("hoten"));
				data.setEmail(rs.getString("email"));
				data.setDiachi(rs.getString("diachi"));
				data.setPhone(rs.getInt("phone"));
				data.setGioiTinh(rs.getString("gioiTinh"));

				listStudent.add(data);
			}
			con.close();
			hamchon();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void hamchon() {
		if (listStudent.isEmpty()) {
			System.out.println("List Rỗng");
		} else {
			txtMasv.setText(listStudent.get(select).getMaSv());
			txtHoTen.setText(listStudent.get(select).getHoten());
			txtEmail.setText(listStudent.get(select).getEmail());
			txtDiaChi.setText(listStudent.get(select).getDiachi());

			if (listStudent.get(select).getGioiTinh().equalsIgnoreCase("nam")) {
				rdoBtnNam.setSelected(true);
			} else {
				rdoBtnNu.setSelected(true);
			}
			txtPhone.setText(Integer.toString(listStudent.get(select).getPhone()));
		}

	}

	private void first() {
		select = 0;
		hamchon();
	}

	private void last() {
		select = listStudent.size() - 1;
		hamchon();
	}

	private void next() {
		select += 1;
		if (select == listStudent.size()) {
			select = 0;
		}
		hamchon();
	}

	private void prev() {

		if (select == 0) {
			select = listStudent.size();
		}
		select -= 1;
		hamchon();
	}

	private void deleteStudent() throws SQLException {
		if (txtMasv.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng Nhập Mã Sinh viên !");
		} else {
			String maSv = txtMasv.getText().trim();
			Connection con = getConnection();
			String sql = "delete  FROM Lab5_table_Students WHERE maSv = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maSv);
			int hoi = JOptionPane.showConfirmDialog(this, "Xác nhận xóa sinh viên" + maSv, "",
					JOptionPane.YES_NO_OPTION);
			if (hoi == JOptionPane.YES_OPTION) {
				int rs = preparedStatement.executeUpdate();
				if (rs == 0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy sinh viên : " + maSv + "để xóa");
					return;
				} else {
					System.out.println("xóa được:" + rs);
					JOptionPane.showMessageDialog(this, "Đã xóa " + rs + "dòng");
					fillDuLieuVaoList();
					hamchon();
				}
			} else {
				return;
			}
			con.close();
		}

	}

	private void updateStudent() throws SQLException {
		if (txtMasv.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng Nhập Mã Sinh viên để update !");
			return;
		} else {
			boolean check = true;
			int phone = 0;
			try {
				phone = Integer.parseInt(txtPhone.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại !");
				check = false;
			}
			if (!txtEmail.getText().matches(emailRegex)) {
				JOptionPane.showMessageDialog(this, "Sai định dạng email !");
				check = false;
			} else {
				if (!txtHoTen.getText().matches(fullNameRegex)) {
					JOptionPane.showMessageDialog(this, "Sai định dạng họ tên !");
					check = false;
				}
			}
			if (check == true) {
				Connection con = getConnection();
				String sql = "Update Lab5_table_Students set hoten = ? ,email =? ,phone =? , gioiTinh =? ,diachi=? where maSv =?";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, txtHoTen.getText());
				preparedStatement.setString(2, txtEmail.getText());
				preparedStatement.setInt(3, phone);
				String gioiTinh = "";
				if (rdoBtnNam.isSelected()) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}
				preparedStatement.setString(4, gioiTinh);
				preparedStatement.setString(5, txtDiaChi.getText());
				preparedStatement.setString(6, txtMasv.getText().trim());
				int rs = preparedStatement.executeUpdate();
				if (rs == 0) {
					JOptionPane.showMessageDialog(this, "không tìm thấy mã sinh viên");
				} else {
					JOptionPane.showMessageDialog(this, "Update Thành công ! " + rs + " dòng");
				}

				fillDuLieuVaoList();

			}
		}
	}

	private void insertDulieu() throws SQLException {
		if (txtMasv.getText().trim().equals("") || txtDiaChi.getText().equals("") || txtHoTen.getText().equals("")
				|| txtPhone.getText().equals("") || txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng Nhập Đầy đủ !");
			return;
		} else {
			boolean check = true;
			int phone = 0;
			try {
				phone = Integer.parseInt(txtPhone.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại !");
				check = false;
			}
			if (!txtEmail.getText().matches(emailRegex)) {
				JOptionPane.showMessageDialog(this, "Sai định dạng email !");
				check = false;
			} else {
				if (!txtHoTen.getText().matches(fullNameRegex)) {
					JOptionPane.showMessageDialog(this, "Sai định dạng họ tên !");
					check = false;
				} else {
					if (txtMasv.getText().length() > 7) {
						JOptionPane.showMessageDialog(this, "Mã sinh viên bao gồm 7 ký tự!");
						check = false;
					}
				}
			}

			if (check == true) {
				Connection con = getConnection();
				String sql = "Insert into Lab5_table_Students values(?,?,?,?,?,?)";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(2, txtHoTen.getText());
				preparedStatement.setString(3, txtEmail.getText());
				preparedStatement.setInt(4, phone);
				String gioiTinh = "";
				if (rdoBtnNam.isSelected()) {
					gioiTinh = "Nam";
				} else {
					gioiTinh = "Nữ";
				}
				preparedStatement.setString(5, gioiTinh);
				preparedStatement.setString(6, txtDiaChi.getText());
				preparedStatement.setString(1, txtMasv.getText().trim());
				int rs = preparedStatement.executeUpdate();
				if (rs == 0) {
					JOptionPane.showMessageDialog(this, "không tìm thấy mã sinh viên ");
				} else {
					JOptionPane.showMessageDialog(this, "Thêm Thành công ! " + rs + " dòng");
				}

				fillDuLieuVaoList();

			}
		}

	}

	private void addXoaTrang() {
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtHoTen.setText("");
		txtMasv.setText("");
		txtPhone.setText("");
		rdoBtnNam.setSelected(true);
	}

	private void timKiem() {
		if (txtTimKiem.getText().trim().equals("")) {
			System.out.println("bỏ qua");
		} else {

			if (listStudent.isEmpty()) {
				System.out.println("List Rỗng");
			} else {
				String masv = txtTimKiem.getText().trim();
				for (int i = 0; i < listStudent.size(); i++) {
					if (masv.equals(listStudent.get(i).getMaSv().trim())) {
						txtMasv.setText(listStudent.get(i).getMaSv());
						txtHoTen.setText(listStudent.get(i).getHoten());
						txtEmail.setText(listStudent.get(i).getEmail());
						txtDiaChi.setText(listStudent.get(i).getDiachi());
						if (listStudent.get(i).getGioiTinh().equalsIgnoreCase("nam")) {
							rdoBtnNam.setSelected(true);
						} else {
							rdoBtnNu.setSelected(true);
						}
						txtPhone.setText(Integer.toString(listStudent.get(i).getPhone()));
					}
				}

			}
		}

	}

	/**
	 * Create the frame.
	 */
	public bai2() {
		setTitle("Quản lí Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 593, 631);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 72, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 559, SpringLayout.WEST, contentPane);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("QUẢN LÍ USERS ");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 54, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, panel);
		panel_1.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(5, 3, 10, 5));

		JLabel lblNewLabel_2 = new JLabel("Mã Sinh Viên ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_2);

		txtMasv = new JTextField();
		panel_1.add(txtMasv);
		txtMasv.setColumns(10);

		JButton btnNewButton_1_1 = new JButton("Add");
		btnNewButton_1_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addXoaTrang();
			}
		});
		panel_1.add(btnNewButton_1_1);

		JLabel lblNewLabel_3 = new JLabel("Họ Tên");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_3);

		txtHoTen = new JTextField();
		panel_1.add(txtHoTen);
		txtHoTen.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteStudent();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		panel_1.add(btnDelete);

		JLabel lblNewLabel_4 = new JLabel("Email ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_4);

		txtEmail = new JTextField();
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateStudent();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_5 = new JLabel("Số điện Thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_5);

		txtPhone = new JTextField();
		panel_1.add(txtPhone);
		txtPhone.setColumns(10);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertDulieu();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
					JOptionPane.showMessageDialog(null, e1.getMessage() + "\n" + "Có lẽ mã sinh viên đã tồn tại");
				}
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		panel_1.add(btnNewButton);
//		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 78, SpringLayout.SOUTH, panel_2);
//		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -152, SpringLayout.EAST, contentPane);

		JLabel lblNewLabel_1 = new JLabel("Giới Tính ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_1.add(lblNewLabel_1);

		rdoBtnNu = new JRadioButton("Nữ");
		buttonGroup.add(rdoBtnNu);
		rdoBtnNu.setFont(new Font("Consolas", Font.PLAIN, 15));
		panel_1.add(rdoBtnNu);

		rdoBtnNam = new JRadioButton("Nam");
		rdoBtnNam.setSelected(true);
		buttonGroup.add(rdoBtnNam);
		rdoBtnNam.setFont(new Font("Consolas", Font.PLAIN, 15));
		panel_1.add(rdoBtnNam);

		JLabel lblNewLabel_1_1 = new JLabel("Địa Chỉ");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -12, SpringLayout.NORTH, lblNewLabel_1_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel_1_1, 32, SpringLayout.WEST, contentPane);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1_1);

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 371, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel_1_1, 0, SpringLayout.NORTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 192, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -30, SpringLayout.EAST, contentPane);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 0 0,grow");

		txtDiaChi = new JTextArea();
		txtDiaChi.setLineWrap(true);
		scrollPane.setViewportView(txtDiaChi);

		JPanel panel_3 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -29, SpringLayout.NORTH, panel_3);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_3, -78, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_3, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_3, -5, SpringLayout.EAST, contentPane);
		contentPane.add(panel_3);

		JButton btnNewButton_5 = new JButton("First");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		panel_3.add(btnNewButton_5);

		JButton btnNewButton_4 = new JButton("Prev");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		panel_3.add(btnNewButton_4);

		JButton btnNewButton_3 = new JButton("Next");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		panel_3.add(btnNewButton_3);

		JButton btnNewButton_2 = new JButton("Last");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		panel_3.add(btnNewButton_2);

		JPanel panel_4 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_4, 157, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_4, -160, SpringLayout.EAST, panel);
		panel_4.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 10, 10));

		txtTimKiem = new JTextField();
		panel_4.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JButton btnNewButton_6 = new JButton("Tìm kiếm");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
			}
		});
		panel_4.add(btnNewButton_6);
	}
}
