package lab4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class list extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JList list, list_1;
	private DefaultListModel model1, model2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list frame = new list();
					frame.initList1();
					frame.initList2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initList1() {
		model1 = new DefaultListModel();
		String[] items = { "Item1", "Item2", "Item3","Item4" };
		for (String it : items) {
			model1.addElement(it);
		}
		list.setModel(model1);
	}

	public void initList2() {
		model2 = new DefaultListModel();
		list_1.setModel(model2);
	}

	private void hamchon() {
		Object[] selectedValues = list.getSelectedValuesList().toArray();

		for (Object object : selectedValues) {
			model1.removeElement(object);
			model2.addElement(object);
		}
	}

	private void hamchon1() {
		Object[] selectedValues = list_1.getSelectedValuesList().toArray();
		for (Object object : selectedValues) {
			model2.removeElement(object);
			model1.addElement(object);
		}
	}

	/**
	 * Create the frame.
	 */
	public list() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 179, SpringLayout.WEST, contentPane);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, -179, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, 0, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, contentPane);
		contentPane.add(panel_1);

		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 0, SpringLayout.NORTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, 0, SpringLayout.SOUTH, panel);
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");

		list = new JList();

		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "hêlo", "ha", "môyo" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -6, SpringLayout.WEST, panel_1);
		panel_1.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, "cell 0 0,grow");

		list_1 = new JList();

		scrollPane_1.setViewportView(list_1);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(4, 1, 20, 20));

		JButton btnNewButton_1 = new JButton("->");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamchon();
			}
		});
		panel_2.add(btnNewButton_1);

		JButton btnNewButton = new JButton("->>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamchon();

			}
		});
		panel_2.add(btnNewButton);

		JButton btnNewButton_2_1 = new JButton("<<-");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamchon1();
			}
		});
		panel_2.add(btnNewButton_2_1);

		JButton btnNewButton_2 = new JButton("<-");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hamchon1();
			}
		});
		panel_2.add(btnNewButton_2);
	}

}
