package DETHIJAVA3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

public class formQuanLySanPham extends JFrame {

	private JPanel contentPane;
	private JTextField txtmaSp;
	private JTextField txtHoTen;
	private JTextField txtLop;
	private JTable tblSinhVien;
	private DefaultTableModel modelSanPham;

	// tạo list sanPham
	private List<SanPham> list = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	// Hàm main chạy chương trình
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formQuanLySanPham frame = new formQuanLySanPham();
					frame.setVisible(true);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	// Tạo một hàm connect dùng chung cho các hàm còn lại --
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection connection = null;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		String url = "jdbc:sqlserver://localhost:1433;databaseName=DETHI;encrypt=true;trustServerCertificate=true;";
		connection = DriverManager.getConnection(url, "sa", "123");
		System.out.println("Kết nối thành công đến cơ sở dữ liệu!");
		return connection;
	}

	// phần chức năng
	// :-------------------------------------------------------------------------------------------------------://
	private void reset() {
		// xóa trắng các nút
		txtmaSp.setText("");
		txtHoTen.setText("");
		txtLop.setText("");
	}

	private void exit() {
		this.dispose();
		// đóng class đang chạy hiện hành
	}

	private void open() throws ClassNotFoundException, SQLException {
		// nút open - có 2 chức năng đổ dữ liệu vào list và từ list đổ vào table
		Connection con = getConnection();
		Statement stm = con.createStatement();
		String sql = "select * from sanPham ";
		ResultSet data = stm.executeQuery(sql);
		list.removeAll(list);
		// Load List
		while (data.next()) {
			list.add(new SanPham(data.getString(1), data.getString(2), data.getInt(3)));
		}
		System.out.println("Dữ Liệu Đã Vào List");

		// Load table
		modelSanPham = (DefaultTableModel) tblSinhVien.getModel();
		modelSanPham.setColumnIdentifiers(new Object[] { "Mã Sản Phẩm ", "Tên Sản Phẩm", "Số Lượng" });// tạo tên cột
		modelSanPham.setRowCount(0);
		for (SanPham sanpham : list) {
			modelSanPham.addRow(new Object[] { sanpham.getmasp(), sanpham.getTensanpham(), sanpham.getSoluong() });
		}
		tblSinhVien.setModel(modelSanPham);
		System.out.println("Dữ Liệu Đã Vào Table");
	}

	private void xoa() throws ClassNotFoundException, SQLException {
		// nút xóa theo hàm chọn --(chọn hàng nào xóa hàng đó)

		Connection con = getConnection();
		String xoaSanPhamSql = "delete from sanPham where masv = ?";
		PreparedStatement preparedStatements = con.prepareStatement(xoaSanPhamSql);
		preparedStatements.setString(1, hamChon());
		int xacNhanXoa = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa đi Sản Phẩm " + hamChon() + " không ?",
				"xóa hay không ?", 0);
		if (xacNhanXoa == JOptionPane.YES_OPTION) {
			int rs = preparedStatements.executeUpdate();
			if (rs > 0) {
				JOptionPane.showMessageDialog(this, "Xóa Thành công!\n Row =" + rs);
				open();
			} else {
				JOptionPane.showMessageDialog(this, "Xóa Thất Bại");
			}
		} else {
			System.out.println("Tạm ngưng tác vụ xóa");
			return;
		}
	}

	private String hamChon() {
		SanPham sp = list.get(tblSinhVien.getSelectedRow());
		txtHoTen.setText(sp.getTensanpham());
		txtLop.setText(Integer.toString(sp.getSoluong()));
		txtmaSp.setText(sp.getmasp());
		return sp.getmasp();
	}

	private void sapXepTheoThuTuTanDan() {
		this.modelSanPham.setRowCount(0);
		Collections.sort(this.list, new Comparator<SanPham>() {
			public int compare(SanPham sanPham1, SanPham sanPham2) {
				return Integer.compare(sanPham1.getSoluong(), sanPham2.getSoluong());
			}
		});
		for (SanPham sanpham : list) {
			modelSanPham.addRow(new Object[] { sanpham.getmasp(), sanpham.getTensanpham(), sanpham.getSoluong() });
		}
		tblSinhVien.setModel(modelSanPham);
	}

	/**
	 * Create the frame.
	 */

	// tạo giao diện :
	public formQuanLySanPham() {
		setTitle("Quản Lí Sinh Viên");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 634);

		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lí Sản Phẩm");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 624, 50);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Sinh Viên ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 70, 171, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 112, 171, 25);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Lớp ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(20, 156, 171, 25);
		contentPane.add(lblNewLabel_1_2);

		txtmaSp = new JTextField();
		txtmaSp.setBounds(201, 80, 232, 19);
		contentPane.add(txtmaSp);
		txtmaSp.setColumns(10);

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
		panel.setLayout(new GridLayout(4, 1, 10, 10));

		JButton btnNewButton_1 = new JButton("New ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					xoa();
				} catch (ClassNotFoundException | SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
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
					JOptionPane.showMessageDialog(null, e1.getMessage());
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
				int vitri = tblSinhVien.getSelectedRow();
				hamChon();

			}
		});

		scrollPane.setViewportView(tblSinhVien);

		JButton btnNewButton_4_1 = new JButton("Sắp Xếp Thứ Tự Tăng Dần");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sapXepTheoThuTuTanDan();
			}
		});
		btnNewButton_4_1.setBackground(Color.WHITE);
		btnNewButton_4_1.setBounds(20, 268, 459, 42);
		contentPane.add(btnNewButton_4_1);
	}
}
