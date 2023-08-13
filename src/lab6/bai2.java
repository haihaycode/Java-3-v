package lab6;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date.*;
import java.util.List;
import java.awt.SystemColor;

public class bai2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtName;
	private JTextField txtParentName;
	private JTextField txtContactNo;
	private JTextArea txtAddress;
	private JComboBox cbbStandArd;
	private DefaultTableModel modelTable;
	private DefaultComboBoxModel listCombobox;
	public static Connection connection;
	private JTextField txtPeer;
	private JButton btnEdit, btnUpdate, btnInsert, btnDelete;
	private int select = 0;
	private boolean check = false;
	private List<students> list = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2 frame = new bai2();
					frame.setVisible(true);
					frame.hamGoi();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void setEnableFalseall() {
		txtName.setEnabled(false);
		txtContactNo.setEnabled(false);
		txtPeer.setEnabled(false);
		txtParentName.setEnabled(false);
		txtAddress.setEnabled(false);
		cbbStandArd.setEnabled(false);

		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		btnInsert.setEnabled(false);

	}

	private void btnEditSetTrueAll() {

		txtName.setEnabled(true);
		txtContactNo.setEnabled(true);
		txtPeer.setEnabled(true);
		txtParentName.setEnabled(true);
		txtAddress.setEnabled(true);
		cbbStandArd.setEnabled(true);

		btnUpdate.setEnabled(true);
		btnDelete.setEnabled(true);
		btnInsert.setEnabled(true);

	}

	private void hamGoi() {
		innitTable();
		fillList();
		innitCbbStandard();
		setEnableFalseall();

		try {
			hamChon();
		} catch (SQLException e) {
			System.out.println("bo qua");
		}

	}

	public static Connection getConnection() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;databaseName=lab6Bai2;encrypt=true;trustServerCertificate=true;";
			connection = DriverManager.getConnection(url, "sa", "123");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}

		return connection;
	}

	private void innitCbbStandard() {

		listCombobox = (DefaultComboBoxModel) cbbStandArd.getModel();

		listCombobox.removeAllElements();

		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();// TẠO CONNECT ĐẾN SQL
			String sql = "select * from Standars";
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				listCombobox.addElement(rs.getString("standardID"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private void innitTable() {
		modelTable = (DefaultTableModel) table.getModel();
		modelTable.setColumnIdentifiers(new String[] { "Name", "Standard","id" });
		int columnIndex = 2;
		TableColumn column = table.getColumnModel().getColumn(columnIndex);
		column.setPreferredWidth(0); // Đặt kích thước ưu tiên của cột thành 0
		column.setMinWidth(0); // Đặt kích thước tối thiểu của cột thành 0
		column.setMaxWidth(0); // Đặt kích thước tối đa của cột thành 0
		table.getTableHeader().getColumnModel().getColumn(columnIndex).setWidth(0); // Đặt kích thước của header cột thành 0
		table.getTableHeader().getColumnModel().getColumn(columnIndex).setMinWidth(0); // Đặt kích thước tối thiểu của header cột thành 0
		table.getTableHeader().getColumnModel().getColumn(columnIndex).setMaxWidth(0); // Đặt kích thước tối đa của header cột thành 0
	}

	private void fillList() {
		list.removeAll(list);
		modelTable.setRowCount(0);
		try {
			Connection con = getConnection();
			Statement stm = con.createStatement();// TẠO CONNECT ĐẾN SQL

			String sql = "select * from Student";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {

				list.add(new students(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getString(6), rs.getDate(7)));

			}
			for (students students : list) {
				modelTable.addRow(new Object[] { students.getName(), students.getStandard(),students.getRegID() });
			}
			table.setModel(modelTable);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private String hamChon() throws SQLException {
		String regid ="";
	    if (select >= 0) {
	        table.setSelectionBackground(Color.yellow);
	        table.setRowSelectionInterval(select, select);
	        String standrad = (String) table.getValueAt(select, 1);
	       
	        students st = list.get(table.getSelectedRow());
	        regid=st.getRegID();
	    }
	    System.out.println(regid);
	    return regid;
	}

	private void newStudent() {
		txtAddress.setText("");
		txtContactNo.setText("");
		txtPeer.setText("");
		txtName.setText("");
		txtParentName.setText("");
		cbbStandArd.setSelectedItem("...");

	}

	private boolean checkVal() {
		if (txtAddress.getText().equals("") || txtName.getText().equals("") || txtContactNo.getText().equals("")) {
			return false;
		}
		return true;
	}

	private void insertStudent() throws SQLException, ParseException {

		

		if (!checkVal()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ");
		} else {
			boolean check = true;
			try {
				int sdt = Integer.parseInt(txtContactNo.getText());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi định dạng contactNo");
				check = false;
			}
			if (check == true) {
				Connection con = getConnection();
			

				String sql = "INSERT INTO Student VALUES (?,?,?,?,?,'')";
				PreparedStatement preparedStatement = con.prepareStatement(sql);
			

				preparedStatement.setString(1, txtName.getText());
				preparedStatement.setString(2, txtAddress.getText());
				preparedStatement.setString(3, txtParentName.getText());
				preparedStatement.setInt(4, Integer.parseInt(txtContactNo.getText()));
				preparedStatement.setString(5, (String) cbbStandArd.getSelectedItem());
				int rs = preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(this, "Thêm Thành công ! ");
				fillList();

			}

		}
		setEnableFalseall();
	}

	private void updateStudent() throws SQLException, ParseException {
		

		if (!checkVal()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ");
		} else {
			boolean check = true;
			try {
				int sdt = Integer.parseInt(txtContactNo.getText());
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Lỗi định dạng contactNo");
				check = false;
			}
			if (check == true) {
				Connection con = getConnection();

				String sql = "Update Student set name = ? ,address =? ,parentName =? , phone =? ,standard=? where RegID =?";
				PreparedStatement preparedStatement = con.prepareStatement(sql);

				preparedStatement.setString(1, txtName.getText());
				preparedStatement.setString(2, txtAddress.getText());
				preparedStatement.setString(3, txtParentName.getText());
				preparedStatement.setInt(4, Integer.parseInt(txtContactNo.getText()));
				preparedStatement.setString(5, (String) cbbStandArd.getSelectedItem());
		        
				preparedStatement.setInt(6, Integer.parseInt(hamChon()));
				int rs = preparedStatement.executeUpdate();
				JOptionPane.showMessageDialog(this, "Update Thành công ! ");
				fillList();

			}

		}
		setEnableFalseall();
	}

	private void deleteStudent() {

		try {

			Connection con = getConnection();
			String sql = "delete  FROM Student WHERE regid = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1,Integer.parseInt( hamChon()));
			int hamChon =Integer.parseInt( hamChon());
			int hoi = JOptionPane.showConfirmDialog(this, "Xác nhận xóa", "", JOptionPane.YES_NO_OPTION);
			if (hoi == JOptionPane.YES_OPTION) {
				int rs = preparedStatement.executeUpdate();
				if (rs == 0) {
					System.out.println("loi không tìm thấy");

				} else {

					System.out.println("xóa được:" + rs);
					JOptionPane.showMessageDialog(this, "Đã xóa " + rs + "dòng");
					fillList();

				}
			} else {
				return;
			}

			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "vui lòng chọn hàng để xóa !");
		}

		setEnableFalseall();

	}

	private void next() {
		select += 1;
		if (select == table.getRowCount()) {
			select = 0;
		}
		try {
			hamChon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void prev() {

		if (select == 0) {
			select = table.getRowCount();
		}
		select -= 1;
		try {
			hamChon();
		} catch (SQLException e) {
			System.out.println("bỏ qua");
		}

	}

	/**
	 * Create the frame.
	 */
	public bai2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 525);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 15, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 15, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 473, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 409, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				select = table.getSelectedRow();
				try {
					hamChon();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel = new JLabel("Name ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Address : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 23, SpringLayout.SOUTH, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ParentName");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 87, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ConTactNo ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 28, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("StandArd ");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -184, SpringLayout.SOUTH, panel_1);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Peer ");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 15, SpringLayout.SOUTH, lblNewLabel_4);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0, SpringLayout.WEST, lblNewLabel);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.add(lblNewLabel_5);

		JPanel panel_2 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_2, -110, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_2, 398, SpringLayout.WEST, panel_1);
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 4, 10, 10));

		JButton btnnext = new JButton("New ");
		btnnext.setForeground(SystemColor.textHighlightText);
		btnnext.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnnext.setBackground(SystemColor.activeCaption);
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newStudent();
			}
		});
		panel_2.add(btnnext);

		btnInsert = new JButton("Insert ");
		btnInsert.setForeground(SystemColor.textHighlightText);
		btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnInsert.setBackground(SystemColor.activeCaption);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insertStudent();
				} catch (SQLException | ParseException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		panel_2.add(btnInsert);

		btnEdit = new JButton("Edit ");
		btnEdit.setForeground(SystemColor.textHighlightText);
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnEdit.setBackground(SystemColor.activeCaption);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (check == false) {
					btnEditSetTrueAll();
					check = true;
				} else {
					check = false;
					setEnableFalseall();
				}
			}
		});
		panel_2.add(btnEdit);

		btnUpdate = new JButton("Update ");
		btnUpdate.setForeground(SystemColor.textHighlightText);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnUpdate.setBackground(SystemColor.activeCaption);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateStudent();
				} catch (SQLException | ParseException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		panel_2.add(btnUpdate);

		JButton btnNewButton = new JButton("Next");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBackground(SystemColor.activeCaption);
		panel_2.add(btnNewButton);

		JButton btnNewButton_5 = new JButton("Prev ");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev();
			}
		});
		btnNewButton_5.setForeground(SystemColor.textHighlightText);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_5.setBackground(SystemColor.activeCaption);
		panel_2.add(btnNewButton_5);

		btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent();
			}
		});
		btnDelete.setForeground(SystemColor.textHighlightText);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBackground(SystemColor.activeCaption);
		panel_2.add(btnDelete);

		JButton btnNewButton_3 = new JButton("Exit ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setForeground(SystemColor.textHighlightText);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_3.setBackground(SystemColor.activeCaption);
		panel_2.add(btnNewButton_3);

		txtName = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtName, 10, SpringLayout.NORTH, panel_1);
		panel_1.add(txtName);
		txtName.setColumns(10);

		JPanel panel_3 = new JPanel();
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_3, 25, SpringLayout.SOUTH, txtName);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_3, 42, SpringLayout.EAST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_2);
		panel_1.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, "cell 0 0,grow");

		txtAddress = new JTextArea();
		txtAddress.setLineWrap(true);
		scrollPane_1.setViewportView(txtAddress);

		txtParentName = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_3, -10, SpringLayout.NORTH, txtParentName);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtName, 0, SpringLayout.WEST, txtParentName);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtName, 0, SpringLayout.EAST, txtParentName);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtParentName, 164, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtParentName, 10, SpringLayout.WEST, panel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtParentName, -10, SpringLayout.EAST, panel_3);
		panel_1.add(txtParentName);
		txtParentName.setColumns(10);

		txtContactNo = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtContactNo, 28, SpringLayout.SOUTH, txtParentName);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtContactNo, 0, SpringLayout.WEST, txtName);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtContactNo, 0, SpringLayout.EAST, txtName);
		txtContactNo.setColumns(10);
		panel_1.add(txtContactNo);

		cbbStandArd = new JComboBox();
		cbbStandArd.setModel(new DefaultComboBoxModel(new String[] { "..." }));
		sl_panel_1.putConstraint(SpringLayout.NORTH, cbbStandArd, 18, SpringLayout.SOUTH, txtContactNo);
		sl_panel_1.putConstraint(SpringLayout.WEST, cbbStandArd, 0, SpringLayout.WEST, txtName);
		sl_panel_1.putConstraint(SpringLayout.EAST, cbbStandArd, 0, SpringLayout.EAST, txtName);
		panel_1.add(cbbStandArd);

		txtPeer = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, txtPeer, 0, SpringLayout.WEST, txtName);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtPeer, 0, SpringLayout.SOUTH, lblNewLabel_5);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtPeer, 0, SpringLayout.EAST, txtName);
		panel_1.add(txtPeer);
		txtPeer.setColumns(10);
	}
}
