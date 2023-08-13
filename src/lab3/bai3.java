package lab3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JSplitPane;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bai3 extends JFrame {

	private JPanel contentPane;
	private JTextField txtFontSize;
	private JSlider slider;
	private JLabel JlabelFontSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai3 frame = new bai3();
					frame.setVisible(true);
					frame.getValue();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int getValue() {
		int value = slider.getValue();
		System.out.println(slider.getValue());
		txtFontSize.setText(Integer.toString(value));
		JlabelFontSize.setFont(new Font("Serif", Font.PLAIN, value));
		return value;
	    
	}

	public void setValue() {
		int value = Integer.parseInt(txtFontSize.getText());
		slider.setValue(value);
	}

	/**
	 * Create the frame.
	 */
	public bai3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 221);
		setLocationRelativeTo(null);
		setTitle("JSlider trong Java Swing");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		//
		slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				getValue();
			}
		});

		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(10);

		//
		sl_contentPane.putConstraint(SpringLayout.NORTH, slider, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, slider, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, slider, -10, SpringLayout.EAST, contentPane);
		contentPane.add(slider);

		JLabel lblNewLabel = new JLabel("Giá Trị Hiện Tại : ");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, slider);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNewLabel, -10, SpringLayout.SOUTH, contentPane);
		contentPane.add(lblNewLabel);

		txtFontSize = new JTextField();
		txtFontSize.setForeground(new Color(0, 0, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtFontSize, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtFontSize, 19, SpringLayout.EAST, lblNewLabel);
		contentPane.add(txtFontSize);
		txtFontSize.setColumns(10);

		JButton btnSetValue = new JButton("Set Value");
		btnSetValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValue();
			}
		});
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSetValue, 7, SpringLayout.EAST, txtFontSize);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSetValue, 0, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(btnSetValue);

		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, slider);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, slider);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 83, SpringLayout.SOUTH, slider);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, slider);
		contentPane.add(panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JlabelFontSize = new JLabel("Font Size");
		JlabelFontSize.setForeground(new Color(0, 0, 255));
		JlabelFontSize.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, JlabelFontSize, 0, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, JlabelFontSize, 0, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, JlabelFontSize, 77, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, JlabelFontSize, 406, SpringLayout.WEST, panel);
		panel.add(JlabelFontSize);
	}
}
