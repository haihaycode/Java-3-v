package lab2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai3 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai3 frame = new bai3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public bai3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 10, 10));
		
		JButton btnMessDiaLog = new JButton("showMessageDialog");
		btnMessDiaLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please input your name");
			}
		});
		contentPane.add(btnMessDiaLog);
		
		JButton btnInputDialog = new JButton("showInputDialog");
		btnInputDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=JOptionPane.showInputDialog(null,"Your name is");
				if(Name !=null) {
					 JOptionPane.showMessageDialog(null, "Your name is "+Name); 
				}
				else {
					return;
				}
			}
		});
		contentPane.add(btnInputDialog);
		
		JButton btnComDialog = new JButton("showConfirmDialog");
		btnComDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hoi =JOptionPane.showConfirmDialog(null, "Are You Sure ?" ,"Xác Nhận", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(hoi==JOptionPane.YES_OPTION) {
					 JOptionPane.showMessageDialog(null, "đã nhấn yes");
				}
				else {
					 JOptionPane.showMessageDialog(null, "đã nhấn no ");
				}
				
			}
		});
		contentPane.add(btnComDialog);
		
		JButton btnOptionsDialog = new JButton("ShowOptionDialog");
		btnOptionsDialog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int messageType= JOptionPane.QUESTION_MESSAGE;
				String[] options = {"Java","php","html","css"};
				int code = JOptionPane.showOptionDialog(null,"ngôn ngữ yêu thích của bạn là gì", "Options title", 0, messageType, null, options, "php");
				JOptionPane.showMessageDialog(null, "Bạn đã chọn :  "+options[code]);
			}
		});
		contentPane.add(btnOptionsDialog);
	}

}
