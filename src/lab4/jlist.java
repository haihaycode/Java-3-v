package lab4;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class jlist extends JFrame {
	private JList list;
	private JPanel contentPane;
	private DefaultListModel model;
	private JTextField txtadd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jlist frame = new jlist();
					frame.initList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initList() {
		model= new DefaultListModel();
		String[] items= {"thịt","xương"};
		for (String it : items) {
			model.addElement(it);
		}
		list.setModel(model);
	}
	public void addList() {
		model.addElement(txtadd.getText());
	}
	public void hamChon() {
		txtadd.setText((String) list.getSelectedValue());
	}

	/**
	 * Create the frame.
	 */
	public jlist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 20, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 177, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 176, SpringLayout.WEST, contentPane);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");

		list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hamChon();
			}
		});
		scrollPane.setViewportView(list);
		
		txtadd = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtadd, 16, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtadd, 25, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtadd, 158, SpringLayout.WEST, panel);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addList();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAdd, 10, SpringLayout.SOUTH, txtadd);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAdd, 22, SpringLayout.WEST, contentPane);
		contentPane.add(btnAdd);
	}
}
