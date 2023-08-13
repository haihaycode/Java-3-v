package lab7;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class bai2_Client extends JFrame {

	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtSend;
	private int host = 0;
	private JTextArea txtTinNhan;
	private Socket socket;
	private Scanner sc = new Scanner(System.in);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai2_Client frame = new bai2_Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void Client() throws IOException {
	    if (txtHost.getText().equals("")) {
	        JOptionPane.showMessageDialog(this, "Nhập cổng !");
	    } else {
	        host = Integer.parseInt(txtHost.getText());
	        socket = new Socket("localhost", host);
	        System.out.println("Máy Khách đã kết nối");

	        // Đổi vị trí câu lệnh send vào một luồng riêng
	       
	    }
	}

	private void send() throws IOException {
	    DataOutputStream Dos = new DataOutputStream(socket.getOutputStream()); // Đẩy data đến Server
	    DataInputStream Dis = new DataInputStream(socket.getInputStream());
		
	    while (true) {
	        String tinNhan = txtSend.getText();
	        byte[] tinNhanBytes = tinNhan.getBytes("UTF-8"); // Chuyển đổi từ String sang mảng byte
	        Dos.write(tinNhanBytes); // Gửi đi mảng byte
	        Dos.flush();
	    }
	}



	/**
	 * Create the frame.
	 */
	public bai2_Client() {
		setTitle("Máy Khách");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 506, 52);
		contentPane.add(panel);
		panel.setLayout(null);

		txtHost = new JTextField();
		txtHost.setBounds(0, 0, 390, 52);
		panel.add(txtHost);
		txtHost.setColumns(10);

		JButton btnNewButton = new JButton("Kết Nối");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Client();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(400, 0, 106, 52);
		panel.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 72, 506, 260);
		contentPane.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 0 0,grow");

		txtTinNhan = new JTextArea();
		txtTinNhan.setLineWrap(true);
		scrollPane.setViewportView(txtTinNhan);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 342, 506, 52);
		contentPane.add(panel_2);

		txtSend = new JTextField();
		txtSend.setColumns(10);
		txtSend.setBounds(0, 0, 390, 52);
		panel_2.add(txtSend);

		JButton btnGii = new JButton("Gửi đi ");
		btnGii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					send();
				} catch (IOException e1) {
					System.out.println(e1.getMessage());
				}
			}
		});
		btnGii.setBounds(400, 0, 106, 52);
		panel_2.add(btnGii);
	}
}