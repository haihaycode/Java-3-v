package lab4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class bai2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSanPham;
	private JTextField txtDonGia;
	private JTextField txtNhaCungCap;
	private JTextField txtTenSanPham;
	private JComboBox comboBoxDVT;
	private List<sanPham> list = new ArrayList<>();
	private DefaultTableModel newTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2 frame = new bai2();
					frame.innitTable();
					frame.demoData();
					frame.fillTable();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void innitTable() {
		newTable = (DefaultTableModel) table.getModel();
		newTable.setColumnIdentifiers(
				new String[] { "Mã Sản Phẩm", "Tên Sản Phẩm", "DVT", "Đơn Giá Bán", "Nhà Cung Cấp" });
	}

	public void demoData() {
		for (int i = 0; i < 10; i++) {
			sanPham product = new sanPham();
			product.setMaSanPham("SP" + i); // Set the product code
			product.setTenSanPham("Product " + i); // Set the product name
			product.setDVT("Piece"); // Set the product unit of measurement
			product.setDonGia(100); // Set the product price
			product.setNhaCungCap("Supplier " + i); // Set the product supplier

			list.add(product);
		}

	}

	public void fillTable() {
		while (newTable.getRowCount() > 0) {
			newTable.removeRow(0);
		}
		for (sanPham sanPham : list) {
			NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
			String formattedWage = format.format(sanPham.getDonGia());

			newTable.addRow(new Object[] { sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDVT(),
					formattedWage, sanPham.getNhaCungCap() });
			newTable.fireTableDataChanged();
		}
	}

	public void adds() {
		boolean check = true;
		if (txtMaSanPham.getText().equals("") || txtTenSanPham.getText().equals("") || txtDonGia.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Nhập đầy đủ", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
			check = false;
		} else {
			try {
				int dongia = Integer.parseInt(txtDonGia.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "đơn giá phải là số !", "Thông Báo",
						JOptionPane.INFORMATION_MESSAGE);
				check = false;
			}
			for (sanPham sanPham : list) {
				if (sanPham.getMaSanPham().equals(txtMaSanPham.getText())) {
					JOptionPane.showMessageDialog(this, "Mã sản Phẩm đã tồn tại !", "Thông Báo",
							JOptionPane.INFORMATION_MESSAGE);
					check = false;
				}
			}
			if (check == true) {
				sanPham sanPhamNew = new sanPham();
				sanPhamNew.setMaSanPham(txtMaSanPham.getText());
				sanPhamNew.setTenSanPham(txtTenSanPham.getText());
				sanPhamNew.setDVT((String) comboBoxDVT.getSelectedItem());
				sanPhamNew.setDonGia(Integer.parseInt(txtDonGia.getText()));
				sanPhamNew.setNhaCungCap(txtNhaCungCap.getText());
				list.add(sanPhamNew);
				JOptionPane.showMessageDialog(this, "Thành Công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
				fillTable();
			}
		}
	}

	public void hamchon() {
		int vitri = table.getSelectedRow();
		for (sanPham sanPham : list) {
			String maSp = (String) table.getValueAt(vitri, 0);
			if (maSp.equals(sanPham.getMaSanPham())) {

				NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
				String formattedWage = format.format(sanPham.getDonGia());

				txtMaSanPham.setText(sanPham.getMaSanPham());
				txtTenSanPham.setText(sanPham.getTenSanPham());
				txtNhaCungCap.setText(sanPham.getNhaCungCap());
				txtDonGia.setText((String) formattedWage);
				comboBoxDVT.setSelectedItem(sanPham.getDVT());
			}
		}
	}

	private void delete() {
		String masp = txtMaSanPham.getText();
		if (masp.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Nhân Viên !", " lỗi!", JOptionPane.PLAIN_MESSAGE);

		} else {
			boolean check = true;
			for (sanPham sinhVien : list) {
				if (sinhVien.getMaSanPham().trim().equals(masp)) {
					int hoi = JOptionPane.showConfirmDialog(this, "Bạn Có Chắc Muốn Xóa Nhân Viên ID : " + masp + " ? ",
							"Thông Báo ", JOptionPane.YES_NO_OPTION);
					if (hoi == JOptionPane.YES_OPTION) {

						list.remove(sinhVien);

						fillTable();
						return;

					} else {
						return;
					}
				}

			}
			check = false;
			if (check == false) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy  !", " .. !", JOptionPane.PLAIN_MESSAGE);
			}
		}

	}

	private void updates() {
		int selectRow = table.getSelectedRow();
		boolean checks = false;

		if (selectRow >= 0) {
			String id = (String) table.getValueAt(selectRow, 0);// lấy id được chọn

			for (sanPham nhanViencheck : list) {
				if (nhanViencheck.getMaSanPham().equals(txtMaSanPham.getText()) && id.equals(txtMaSanPham.getText())) {
					checks = false;// ID LIST == SC && ID LIST == SC THÌ K SAO
				}
				if (nhanViencheck.getMaSanPham().equals(txtMaSanPham.getText()) && !id.equals(txtMaSanPham.getText())) {
					checks = true;
				}

			}

			if (checks == false) {
				int hoi = JOptionPane.showConfirmDialog(null,
						"Bạn Có Chắc Muốn thay đổi đi Sinh viên : ' " + id + " 'Không ?", "Thông Báo ",
						JOptionPane.YES_NO_OPTION);
				if (hoi == JOptionPane.YES_OPTION) {
					for (int i = 0; i < list.size(); i++) {
					    sanPham nhanViena = list.get(i);
					    if (nhanViena.getMaSanPham().equals(id)) {
					        String masp = txtMaSanPham.getText();
					        String tensp = txtTenSanPham.getText();
					        String donvitinh = (String) comboBoxDVT.getSelectedItem();
					        String ncc = txtNhaCungCap.getText();
					        String dongia = txtDonGia.getText();
					        if (masp.trim().equals("") || tensp.trim().equals("") || dongia.trim().equals("")
					                || ncc.trim().equals("")) {
					            JOptionPane.showMessageDialog(null, "Nhập đầy đủ thông tin", "ERROR",
					                    JOptionPane.INFORMATION_MESSAGE);
					            return;
					        } else {
					            boolean check = false;
					            try {
					                int dongias = Integer.parseInt(dongia);
					                check = true;
					            } catch (NumberFormatException e) {
					                JOptionPane.showMessageDialog(null, "Lỗi định dạng đơn giá", "Lỗi",
					                        JOptionPane.INFORMATION_MESSAGE);
					                check = false;
					                return;
					            }

					            if (check) {
					                nhanViena.setDonGia(Integer.parseInt(dongia));
					                nhanViena.setDVT(donvitinh);
					                nhanViena.setMaSanPham(masp);
					                nhanViena.setTenSanPham(tensp);
					                nhanViena.setNhaCungCap(ncc);
					                JOptionPane.showMessageDialog(null, "Thay thế Nhân viên thành công!",
					                        "Thành công!", JOptionPane.PLAIN_MESSAGE);
					                fillTable();
					                list.set(i, nhanViena);
					            }
					        }
					    }
					}

				} else {

					return;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Lỗi sản phẩm Tồn Tại !", "Thông Báo",
						JOptionPane.INFORMATION_MESSAGE);

			}

		} else {
			JOptionPane.showMessageDialog(null, "Lỗi Chưa Chọn Đối tượng từ Bảng", "Thông Báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 * Create the frame.
	 */
	public bai2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 822, 606);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		panel.setBackground(new Color(255, 128, 64));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh S\u00E1ch S\u1EA3n Ph\u1EA9m", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, contentPane);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hamchon();
			}
		});
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, contentPane);
		panel_1.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel_1.setBackground(new Color(255, 255, 128));
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 4, 10, 10));

		JLabel lblNewLabel_1 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtMaSanPham);
		txtMaSanPham.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Đơn Giá");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_3);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtDonGia);
		txtDonGia.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		txtTenSanPham = new JTextField();
		txtTenSanPham.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtTenSanPham);
		txtTenSanPham.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Nhà Cung Cấp");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblNewLabel_4);

		txtNhaCungCap = new JTextField();
		txtNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(txtNhaCungCap);
		txtNhaCungCap.setColumns(10);

		JLabel lblNewLabel = new JLabel("Đơn vị tính");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel);

		comboBoxDVT = new JComboBox();
		comboBoxDVT.setModel(new DefaultComboBoxModel(new String[] { "chai", "thùng", "kg", "lon" }));
		panel_1.add(comboBoxDVT);

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, -98, SpringLayout.NORTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_2);
		panel_2.setBackground(new Color(0, 128, 64));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, -51, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(panel_2);

		JButton btnNewButton_2 = new JButton("Thêm Sản Phẩm");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adds();
			}
		});
		panel_2.add(btnNewButton_2);

		JButton btnNewButton_1 = new JButton("Xóa Sản Phẩm");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		panel_2.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Điều Chỉnh Thông Tin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updates();
			}
		});
		panel_2.add(btnNewButton);
	}
}
