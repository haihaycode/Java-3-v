package lab8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;

public class Bai1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername, txtTo, txtSubject, txtFile;
	private JTextArea taraMess;
	private String duongDan = "";
	private JPasswordField txtPassword;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bai1 frame = new Bai1();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void send() {
	    try {
	        Properties p = new Properties();
	        p.put("mail.smtp.auth", "true");
	        p.put("mail.smtp.starttls.enable", "true");
	        p.put("mail.smtp.host", "smtp.gmail.com");
	        p.put("mail.smtp.port", 587);
	        String accountName = txtUsername.getText();
	        String accountPassword = new String(txtPassword.getPassword()); // Lấy mật khẩu từ JPasswordField
	        Session s = Session.getInstance(p, new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(accountName, accountPassword);
	            }
	        });
	        String from = txtUsername.getText();
	        String[] toAddresses = txtTo.getText().split(","); // Tách các địa chỉ email bằng dấu phẩy
	        String subject = txtSubject.getText();
	        String body = taraMess.getText();
	        
	        for (String to : toAddresses) {
	            Message msg = new MimeMessage(s);
	            msg.setFrom(new InternetAddress(from));
	            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to.trim())); // Loại bỏ khoảng trắng
	            msg.setSubject(subject);
	            msg.setText(body);
	            Transport.send(msg);
	        }
	        
	        JOptionPane.showMessageDialog(null, "Mail was sent successfully.", "Message",
	                javax.swing.JOptionPane.INFORMATION_MESSAGE);
	    } catch (MessagingException ex) {
	        Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}

	
//	public void send() {
//		try {
//			Properties p = new Properties();
//			p.put("mail.smtp.auth", "true");
//			p.put("mail.smtp.starttls.enable", "true");
//			p.put("mail.smtp.host", "smtp.gmail.com");
//			p.put("mail.smtp.port", 587);
//			String accountName = txtUsername.getText();
//			String accountPassword = txtPassword.getText();
//			// email: thuonghuynh240@gmail.com
//			// pass: eajnazpwxumckwgi
//			Session s = Session.getInstance(p, new javax.mail.Authenticator() {
//				protected PasswordAuthentication getPasswordAuthentication() {
//					return new PasswordAuthentication(accountName, accountPassword);
//				}
//			});
//			String from = txtUsername.getText();
//			String to = txtTo.getText();
//			String subject = txtSubject.getText();
//			String body = txtTo.getText();
//			Message msg = new MimeMessage(s);
//			msg.setFrom(new InternetAddress(from));
//			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
//			msg.setSubject(subject);
//			msg.setText(body);
//			Transport.send(msg);
//			JOptionPane.showMessageDialog(null, "Mail was sent successfully.", "Message",
//					javax.swing.JOptionPane.INFORMATION_MESSAGE);
//		} catch (MessagingException ex) {
//			Logger.getLogger(Bai1.class.getName()).log(Level.SEVERE, null, ex);
//		}
//	}

	public void chonFile() {
	    JFileChooser f = new JFileChooser();
	    f.setDialogTitle("Mở file");
	    int result = f.showOpenDialog(null); // Lưu kết quả của việc chọn tập tin
	    if (result == JFileChooser.APPROVE_OPTION) { // Kiểm tra xem người dùng đã chọn tập tin hay chưa
	        File file = f.getSelectedFile();
	        duongDan = file.getAbsolutePath();
	        txtFile.setText(duongDan);
	    }
	}

	
	public Bai1() {
		setFont(new Font("Times New Roman", Font.PLAIN, 13));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pn = new JPanel();
		pn.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Send",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pn.setBounds(27, 20, 467, 140);
		contentPane.add(pn);
		pn.setLayout(null);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUsername.setBounds(55, 30, 67, 16);
		pn.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setText("haippd07906@fpt.edu.vn");
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtUsername.setBounds(145, 27, 277, 33);
		pn.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(55, 84, 67, 16);
		pn.add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setText("ooyeeejkvtpxqkxa");
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtPassword.setBounds(145, 83, 277, 31);
		pn.add(txtPassword);

		JPanel pn1 = new JPanel();
		pn1.setBorder(new TitledBorder(null, "Receive", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pn1.setBounds(27, 174, 467, 348);
		contentPane.add(pn1);
		pn1.setLayout(null);

		JLabel lblTo = new JLabel("To:");
		lblTo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTo.setBounds(56, 33, 67, 16);
		pn1.add(lblTo);

		txtTo = new JTextField();
		txtTo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtTo.setColumns(10);
		txtTo.setBounds(146, 30, 277, 33);
		pn1.add(txtTo);

		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSubject.setBounds(56, 84, 67, 16);
		pn1.add(lblSubject);

		txtSubject = new JTextField();
		txtSubject.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtSubject.setColumns(10);
		txtSubject.setBounds(146, 81, 277, 33);
		pn1.add(txtSubject);

		JLabel lblMessage = new JLabel("Message:");
		lblMessage.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMessage.setBounds(56, 181, 67, 16);
		pn1.add(lblMessage);

		taraMess = new JTextArea();
		taraMess.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		taraMess.setBounds(146, 177, 277, 89);
		pn1.add(taraMess);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
		btnSend.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSend.setBounds(146, 293, 85, 21);
		pn1.add(btnSend);

		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chonFile();
			}
		});
		btnChooseFile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnChooseFile.setBounds(263, 293, 106, 21);
		pn1.add(btnChooseFile);

		JLabel lblFile = new JLabel("File:");
		lblFile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFile.setBounds(56, 127, 67, 16);
		pn1.add(lblFile);

		txtFile = new JTextField();
		txtFile.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtFile.setColumns(10);
		txtFile.setBounds(146, 124, 277, 33);
		pn1.add(txtFile);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(146, 175, 277, 77);
		pn1.add(scrollBar);
	}
}
