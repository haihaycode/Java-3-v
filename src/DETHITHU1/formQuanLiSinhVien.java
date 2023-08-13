package DETHITHU1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class formQuanLiSinhVien extends JFrame {

	private JPanel contentPane;
	private JTextField txtMaSv;
	private JTextField txtHoTen;
	private JTextField txtLop;
	private JTable tblSinhVien;
	private DefaultTableModel modelSinhVien;

	// tạo list sinh viên
	private List<SinhVien> list = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formQuanLiSinhVien frame = new formQuanLiSinhVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Tạo một hàm connect dùng chung cho các hàm còn lại --
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;databaseName=DETHITHU;encrypt=true;trustServerCertificate=true;";
		connection = DriverManager.getConnection(url, "sa", "123");
		System.out.println("Kết nối thành công đến cơ sở dữ liệu!");

		return connection;
	}

	// phần chức năng :

	private void reset() {
		// xóa trắng các nút
		txtMaSv.setText("");
		txtHoTen.setText("");
		txtLop.setText("");
	}

	private void exit() {
		this.dispose();
		// đóng class đang chạy hiện hành
	}

	private void open() throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement stm = con.createStatement();
		String sql = "select * from students";
		ResultSet data = stm.executeQuery(sql);
		list.removeAll(list);

		while (data.next()) {
			list.add(new SinhVien(data.getString(1), data.getString(2), data.getString(3)));
		}
		System.out.println("Dữ Liệu Đã Vào List");

		modelSinhVien = (DefaultTableModel) tblSinhVien.getModel();
		modelSinhVien.setColumnIdentifiers(new Object[] { "Mã Sinh Viên ", "Họ Tên", "Lớp" });// tạo tên cột
		modelSinhVien.setRowCount(0);
		for (SinhVien sinhVien : list) {
			modelSinhVien.addRow(new Object[] { sinhVien.getMasv(), sinhVien.getHoten(), sinhVien.getLop() });
		}
		tblSinhVien.setModel(modelSinhVien);
		System.out.println("Dữ Liệu Đã Vào Table");
	}

	private boolean checkTonTai(String maSv) {
		boolean check = true;
		for (SinhVien sinhVien : list) {
			if (sinhVien.getMasv().equals(maSv)) {
				check = false;
			}
		}
		return check;
	}

	private void save() {
		if (txtHoTen.getText().equals("") || txtLop.getText().equals("") || txtMaSv.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập đầy đủ !");
		} else {
			boolean check = true;
			if (txtMaSv.getText().length() > 7 || txtMaSv.getText().length() < 7) {
				JOptionPane.showMessageDialog(this, "Mã Sinh viên đầy đủ 7 kí tự  !");
				check = false;
			} else {
				if (checkTonTai(txtMaSv.getText())) {
					// insert
				} else {
					// update
				}
			}
		}
	}

	private void find() {
		String masv = txtMaSv.getText().trim();
		int i = 0;
		for (SinhVien sinhVien : list) {
			if (masv.equals(sinhVien.getMasv())) {
				hamChon(i);
			}
			i++;
		}
	}

	private void hamChon(int viTri) {
		SinhVien st = list.get(viTri);
		tblSinhVien.setRowSelectionInterval(viTri, viTri);
		txtHoTen.setText(st.getHoten());
		txtLop.setText(st.getLop());
		txtMaSv.setText(st.getMasv());
	}

	/**
	 * Create the frame.
	 */

	// tạo giao diện :
	public formQuanLiSinhVien() {
		setTitle("Quản Lí Sinh Viên");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 634);
		
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lí Sinh Viên ");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 624, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 70, 171, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 112, 171, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Lớp ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(20, 156, 171, 25);
		contentPane.add(lblNewLabel_1_2);

		txtMaSv = new JTextField();
		txtMaSv.setBounds(201, 80, 232, 19);
		contentPane.add(txtMaSv);
		txtMaSv.setColumns(10);

		txtHoTen = new JTextField();
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(201, 118, 232, 19);
		contentPane.add(txtHoTen);

		txtLop = new JTextField();
		txtLop.setColumns(10);
		txtLop.setBounds(201, 162, 232, 19);
		contentPane.add(txtLop);

		JPanel panel_1 = new JPanel();

		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(489, 40, 145, 270);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 125, 250);
		panel_1.add(panel);
		panel.setLayout(new GridLayout(5, 1, 10, 10));

		JButton btnNewButton_1 = new JButton("New ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Save ");
		btnNewButton.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton);

		JButton btnNewButton_2 = new JButton("Find ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				find();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Open ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					open();
				} catch (ClassNotFoundException | SQLException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Exit ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 320, 624, 267);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 0 0,grow");

		tblSinhVien = new JTable();
		tblSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int vitri=tblSinhVien.getSelectedRow();
				hamChon(vitri);
				
			}
		});

		scrollPane.setViewportView(tblSinhVien);
	}
}
