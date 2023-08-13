package lab6;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bai1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnSearch, btnDelete;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai1 frame = new bai1();
					frame.setVisible(true);
					frame.hamChayBanDau();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void hamChayBanDau() {
		initTable();
		loadTable();
		hamChon();
	}

	public void initTable() {
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(new String[] { "ID", "Title", "Price" });
	}

	public void search() {
		model.setRowCount(0);

		if (txtSearch.getText().length() > 0) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;databaseName=lib;encrypt=true;trustServerCertificate=true;";
				Connection con = DriverManager.getConnection(url, "sa", "123");

				String sql = "SELECT * FROM book WHERE title like ?";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, "%" + txtSearch.getText() + "%");

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					Vector<Object> data = new Vector<>();
					data.add(rs.getInt("ID"));
					data.add(rs.getString("title"));
					data.add(rs.getFloat("price"));
					model.addRow(data);
				}

				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			loadTable();
		}
		hamChon();
	}

	public void loadTable() {
		model.setRowCount(0);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=lib;encrypt=true;trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(url, "sa", "123");
			Statement stm = con.createStatement();// TẠO CONNECT ĐẾN SQL

			String sql = "select * from book";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				Vector data = new Vector<>();
				data.add(rs.getInt("ID"));
				data.add(rs.getString("title"));
				data.add(rs.getString("price"));
				model.addRow(data);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private Integer hamChon() {
		Integer Id = null;
		int row = table.getSelectedRow();
		if (row >= 0) {
			Id = (Integer) table.getValueAt(row, 0);
			btnDelete.setEnabled(true);
		}
		else {
			btnDelete.setEnabled(false);
		}
		System.out.println(Id);
		return Id;

	}

	private void delete() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=lib;encrypt=true;trustServerCertificate=true;";
			Connection con = DriverManager.getConnection(url, "sa", "123");

			String sql = "delete  FROM book WHERE ID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, hamChon());

			int hoi = JOptionPane.showConfirmDialog(this, "Xác nhận xóa", "", JOptionPane.YES_NO_OPTION);
			if (hoi == JOptionPane.YES_OPTION) {
				int rs = preparedStatement.executeUpdate();
				if (rs == 0) {
					System.out.println("loi không tìm thấy");

				} else {

					System.out.println("xóa được:" + rs);
					JOptionPane.showMessageDialog(this, "Đã xóa đi sách có mã sách" + hamChon());
					loadTable();

				}
			} else {
				return;
			}

			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "vui lòng chọn hàng để xóa !");
		}

	}

	/**
	 * Create the frame.
	 */
	public bai1() {
		setTitle("book information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 698);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 100, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -267, SpringLayout.EAST, contentPane);
		panel.setBorder(new TitledBorder(null, "Filter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lblNewLabel = new JLabel("Title : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel);

		txtSearch = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, -119, SpringLayout.WEST, txtSearch);
		sl_panel.putConstraint(SpringLayout.WEST, txtSearch, 135, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtSearch, -52, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 8, SpringLayout.NORTH, txtSearch);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -18, SpringLayout.WEST, txtSearch);
		sl_panel.putConstraint(SpringLayout.NORTH, txtSearch, 20, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtSearch, 50, SpringLayout.NORTH, panel);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(30);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		panel_1.add(btnSearch);

		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 6, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -79, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel_1);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, "cell 0 0,grow");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hamChon();
			}
		});
		scrollPane.setViewportView(table);

		 btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnDelete, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnDelete, 0, SpringLayout.EAST, panel_1);
		contentPane.add(btnDelete);
	}
}
