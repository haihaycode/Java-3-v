package lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//phương thức setlineWrap(true) tự động xuống dòng cho textArea
public class bai2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblBDanh;
	private JTextField txtBiDanh;
	private JTextField txtHo;
	private JLabel lblTn;
	private JLabel lblMtM;
	private JTextField txtTen;
	private JPasswordField txtMatMa;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblQuQun;
	private JLabel lblSThch;
	private JCheckBox CbNhayMua;
	private JCheckBox cbNguNghi;
	private JCheckBox cbAnChoi;
	private JLabel lblGhiCh;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnExit;
	private JButton btnReset;
	private JButton btnOk;
	private JTextArea txtNote;
	private JComboBox<?> cbbQueQuan ;
	private JRadioButton rdoNam, rdoNu, rdoKxd;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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

	public void okShow() {
		String ho = txtHo.getText();
		String ten = txtTen.getText();
		String bidanh= txtBiDanh.getText();
		String matma= txtMatMa.getText();
		String note =  txtNote.getText();
		String quequan= (String) cbbQueQuan.getSelectedItem();
		String soThich="" ;
		String gioitinh ="";
		if(rdoNam.isSelected()==true) {
			gioitinh=rdoNam.getActionCommand();
		}
		if(rdoNu.isSelected()==true) {
			gioitinh=rdoNu.getActionCommand();
		}
		if(rdoKxd.isSelected()==true) {
			gioitinh=rdoKxd.getActionCommand();
		}
		if(cbAnChoi.isSelected()==true) {
			soThich= soThich+cbAnChoi.getActionCommand();
		}
		if(CbNhayMua.isSelected()==true) {
			soThich= soThich+CbNhayMua.getActionCommand();
		}
		if(cbNguNghi.isSelected()==true) {
			soThich= soThich+cbNguNghi.getActionCommand();
		}
		String message = "Ho: " + ho + "\nTen: " + ten + "\nBidanh: " + bidanh + "\nMatma: " + matma +
				"\nNote: " + note + "\nQuequan: " + quequan + "\nSo thich: " + soThich + "\nGioitinh: " + gioitinh;

		
		JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
		
		
		
	}
	public void reset() {
		txtHo.setText("");
		txtBiDanh.setText("");
		txtMatMa.setText("");
		txtNote.setText("");
		txtTen.setText("");
		cbbQueQuan.setSelectedIndex(1);
		buttonGroup.clearSelection();
		
		cbAnChoi.setSelected(false);
		cbNguNghi.setSelected(false);
		CbNhayMua.setSelected(false);
	}
	

	/**
	 * Create the frame.
	 */
	public bai2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 656);
		contentPane = new JPanel();
	    setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(new Color(0, 242, 121));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, -10, SpringLayout.EAST, contentPane);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 3, true), "<html><h2 style=\"color: red\";>H\u1ECD T\u00EAn</h2></html>", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 0, 128)));
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		lblNewLabel = new JLabel("Họ : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel);
		panel.add(lblNewLabel);

		lblBDanh = new JLabel("Bí Danh : ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblBDanh, 13, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblBDanh, 0, SpringLayout.WEST, lblNewLabel);
		lblBDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblBDanh);

		txtBiDanh = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtBiDanh, 2, SpringLayout.NORTH, lblBDanh);
		sl_panel.putConstraint(SpringLayout.WEST, txtBiDanh, 6, SpringLayout.EAST, lblBDanh);
		sl_panel.putConstraint(SpringLayout.EAST, txtBiDanh, 194, SpringLayout.EAST, lblBDanh);
		txtBiDanh.setColumns(10);
		panel.add(txtBiDanh);

		txtHo = new JTextField();
		sl_panel.putConstraint(SpringLayout.WEST, txtHo, -188, SpringLayout.EAST, txtBiDanh);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtHo, 0, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.EAST, txtHo, 0, SpringLayout.EAST, txtBiDanh);
		panel.add(txtHo);
		txtHo.setColumns(10);

		lblTn = new JLabel("Tên : ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblTn, 0, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblTn, 6, SpringLayout.EAST, txtHo);
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblTn);

		lblMtM = new JLabel("Mật Mã : ");
		sl_panel.putConstraint(SpringLayout.NORTH, lblMtM, 0, SpringLayout.NORTH, lblBDanh);
		sl_panel.putConstraint(SpringLayout.WEST, lblMtM, 6, SpringLayout.EAST, txtBiDanh);
		lblMtM.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblMtM);

		txtTen = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtTen, 2, SpringLayout.NORTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, txtTen, 6, SpringLayout.EAST, lblTn);
		sl_panel.putConstraint(SpringLayout.EAST, txtTen, -104, SpringLayout.EAST, panel);
		panel.add(txtTen);
		txtTen.setColumns(10);

		txtMatMa = new JPasswordField();
		sl_panel.putConstraint(SpringLayout.NORTH, txtMatMa, 2, SpringLayout.NORTH, lblBDanh);
		sl_panel.putConstraint(SpringLayout.WEST, txtMatMa, 78, SpringLayout.EAST, lblMtM);
		sl_panel.putConstraint(SpringLayout.EAST, txtMatMa, 0, SpringLayout.EAST, txtTen);
		panel.add(txtMatMa);
		txtMatMa.setColumns(10);

		panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 123, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, contentPane);
		panel_1.setBackground(new Color(249, 249, 0));
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(15);
		flowLayout.setHgap(20);
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179), 3, true),
				"<html><h2 style=\"color: blue\";>Giới Tính</h2></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		contentPane.add(panel_1);

		rdoNam = new JRadioButton("Nam");
		rdoNam.setSelected(true);
		buttonGroup.add(rdoNam);
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(rdoNam);

		rdoNu = new JRadioButton("Nữ");
		buttonGroup.add(rdoNu);
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(rdoNu);

		rdoKxd = new JRadioButton("Không Xác Định");
		buttonGroup.add(rdoKxd);
		rdoKxd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_1.add(rdoKxd);

		panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -11, SpringLayout.NORTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -75, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -15, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 245, SpringLayout.NORTH, contentPane);
		panel_2.setBackground(new Color(255, 176, 176));
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(192, 192, 192), 3, true),
				"<html><h2>Thông Tin Khác</h2></html>", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		contentPane.add(panel_2);
		SpringLayout sl_panel_2 = new SpringLayout();
		panel_2.setLayout(sl_panel_2);

		lblQuQun = new JLabel("Quê Quán : ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblQuQun, 0, SpringLayout.NORTH, panel_2);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblQuQun, 10, SpringLayout.WEST, panel_2);
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblQuQun);

		cbbQueQuan = new JComboBox();
		cbbQueQuan.setModel(new DefaultComboBoxModel(new String[] { "Quảng Nam ", "Ninh Thuận ", "Quãng Ngãi" }));
		cbbQueQuan.setSelectedIndex(1);
		sl_panel_2.putConstraint(SpringLayout.NORTH, cbbQueQuan, 0, SpringLayout.NORTH, lblQuQun);
		sl_panel_2.putConstraint(SpringLayout.WEST, cbbQueQuan, 6, SpringLayout.EAST, lblQuQun);
		sl_panel_2.putConstraint(SpringLayout.EAST, cbbQueQuan, 127, SpringLayout.EAST, lblQuQun);
		panel_2.add(cbbQueQuan);

		lblSThch = new JLabel("Sở Thích : ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblSThch, 12, SpringLayout.SOUTH, lblQuQun);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblSThch, 0, SpringLayout.WEST, lblQuQun);
		lblSThch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblSThch);

		 cbAnChoi = new JCheckBox("Ăn Chơi ");
		sl_panel_2.putConstraint(SpringLayout.WEST, cbAnChoi, 0, SpringLayout.WEST, cbbQueQuan);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, cbAnChoi, 0, SpringLayout.SOUTH, lblSThch);
		panel_2.add(cbAnChoi);

		CbNhayMua = new JCheckBox("Nhảy Múa");
		sl_panel_2.putConstraint(SpringLayout.WEST, CbNhayMua, 6, SpringLayout.EAST, cbAnChoi);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, CbNhayMua, 0, SpringLayout.SOUTH, lblSThch);
		panel_2.add(CbNhayMua);

		cbNguNghi = new JCheckBox("Ngủ Nghỉ");
		sl_panel_2.putConstraint(SpringLayout.WEST, cbNguNghi, 6, SpringLayout.EAST, CbNhayMua);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, cbNguNghi, 0, SpringLayout.SOUTH, lblSThch);
		panel_2.add(cbNguNghi);

		lblGhiCh = new JLabel("Ghi Chú : ");
		sl_panel_2.putConstraint(SpringLayout.NORTH, lblGhiCh, 14, SpringLayout.SOUTH, lblSThch);
		sl_panel_2.putConstraint(SpringLayout.WEST, lblGhiCh, 0, SpringLayout.WEST, lblQuQun);
		lblGhiCh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_2.add(lblGhiCh);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		sl_panel_2.putConstraint(SpringLayout.NORTH, panel_3, 0, SpringLayout.NORTH, lblGhiCh);
		sl_panel_2.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, cbbQueQuan);
		sl_panel_2.putConstraint(SpringLayout.SOUTH, panel_3, 86, SpringLayout.NORTH, lblGhiCh);
		sl_panel_2.putConstraint(SpringLayout.EAST, panel_3, 437, SpringLayout.WEST, cbbQueQuan);
		panel_2.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, "cell 0 0,grow");

		txtNote = new JTextArea();
		txtNote.setLineWrap(true);
		scrollPane.setViewportView(txtNote);

		panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setVgap(24);
		flowLayout_1.setHgap(20);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_4, 6, SpringLayout.SOUTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_4, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_4, 0, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel);
		contentPane.add(panel_4);

		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okShow();
			}
		});
		panel_4.add(btnOk);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		panel_4.add(btnReset);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_4.add(btnExit);
	}
}
