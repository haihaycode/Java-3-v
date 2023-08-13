package lab1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class bai1 {
	public bai1() {
	}
		

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFrame mainFrame;
	private JLabel header;
	private JLabel status;

	
	public static void main(String[] args) {
		bai1 bai1 = new bai1();
		bai1.SwingControlDemo();
		bai1.showCheckBoxDemo();

	}

	public void SwingControlDemo() {
		prepareGUI();
	}

	public void prepareGUI() {
		mainFrame = new JFrame("Ví Dụ Java Swing");
		mainFrame.setSize(400, 400);
		mainFrame.setVisible(true);
		mainFrame.getContentPane().setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Thoát CT");
				System.exit(0);
			}
		});

		header = new JLabel("", JLabel.CENTER);
		status = new JLabel("", JLabel.CENTER);

		contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout());

		mainFrame.getContentPane().add(header);
		mainFrame.getContentPane().add(contentPane);
		mainFrame.getContentPane().add(status);

	}

	public void showCheckBoxDemo() {
		header.setText("Control in action checkBox");
		
		final JCheckBox Apple = new JCheckBox("Apple");
		final JCheckBox Mango = new JCheckBox("Mango");
		final JCheckBox Peer = new JCheckBox("Peer");

		Apple.setMnemonic(KeyEvent.VK_C);
		Mango.setMnemonic(KeyEvent.VK_M);
		Peer.setMnemonic(KeyEvent.VK_P);

		Apple.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				status.setText("Apple checkBox: "+(e.getStateChange()==1?"checked":"Unchecked"));

			}
		});

		Mango.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				status.setText("Mango checkBox: "+(e.getStateChange()==1?"checked":"Unchecked"));

			}
		});
		Peer.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				status.setText("Peer checkBox: "+(e.getStateChange()==1?"checked":"Unchecked"));

			}
		});

		contentPane.add(Apple);
		contentPane.add(Mango);
		contentPane.add(Peer);
		mainFrame.setVisible(true);

	}
}
