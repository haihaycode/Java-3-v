package lab4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.SpringLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.awt.event.InputEvent;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import lab3.bai3;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

public class bai1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txtText;
	private JTextArea textArea;
	private String pathSave;
	private Date LastUpdate;
	private JSlider slider;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	final PopupMenu popupmenu = new PopupMenu("Edit");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai1 frame = new bai1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void textColor() {
		int rgb = 0;
		JColorChooser colorChooser = new JColorChooser();
		Color selectedColor = colorChooser.showDialog(null, "TextColor", Color.BLACK);
		if (selectedColor != null) {
			System.out.println(selectedColor.getRGB());
			txtText.setForeground(selectedColor);
		} else {
			System.out.println("break-TextColor");
		}

	}

	public void getBtnGroupColor(String rgb) {
		txtText.setForeground(new Color(Integer.parseInt(rgb)));
	}

	public void openFile() throws IOException {
		JFileChooser jfc = new JFileChooser(pathSave);
		int returnVal = jfc.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String path = jfc.getSelectedFile().getAbsolutePath();
			pathSave = path;
			FileInputStream fis = new FileInputStream(path);
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			String content = new String(buffer);
			textArea.setText(content);
		} else {
			System.out.println("Mở file bị hủy.");
		}
	}

	public void saveFile() throws IOException {
		String content = textArea.getText();//

		JFileChooser jfc = new JFileChooser();
		int returnVal = jfc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String path = jfc.getSelectedFile().getAbsolutePath();
			pathSave = path;
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(content.getBytes());
			fos.close();
			JOptionPane.showMessageDialog(null, "Lưu File Thành công vào đường dẫn " + path);

			Date currentDate = new Date();
			System.out.println("time: " + currentDate);
			LastUpdate = currentDate;
			System.out.println(pathSave);

		} else {
			System.out.println("Lưu file bị hủy.");
		}
	}

	public void aboutus() {
		String mess = "Program demo menu";
		mess += "\n Another: haingu";
		mess += "\n LastUpdate: " + LastUpdate;
		mess += "\n Education : POlY";
		JOptionPane.showMessageDialog(null, mess);
	}

	public int getValue() {
		int value = slider.getValue();
		System.out.println(value);
		return value;
	}
	public void setValue() {
		txtText.setFont(new Font("Serif", Font.PLAIN, getValue()));
		
	}

	/**
	 * Create the frame.
	 */
	public bai1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 636);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		MenuItem textSize = new MenuItem("textSize");
		textSize.setActionCommand("textSize");
		textSize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JDialog dialog = new JDialog();
				dialog.setSize(200, 200);
				dialog.setLocationRelativeTo(null);
				dialog.setTitle("SetFont Size");

				JPanel p1 = new JPanel();

				p1.setLayout(new GridLayout(2, 1, 10, 10));
				JPanel p1_2 = new JPanel();
				p1_2.setLayout(new FlowLayout());
				
				slider = new JSlider();
				

				slider.setPaintTicks(true);
				slider.setPaintLabels(true);
				slider.setMinorTickSpacing(2);
				slider.setMajorTickSpacing(25);

				slider.addChangeListener(new ChangeListener() {

					@Override
					public void stateChanged(ChangeEvent e) {
						getValue();

					}
				});
				
				JButton btnok= new JButton();
				btnok.setIcon(new ImageIcon("D:\\\\JAVA\\\\JAVA3\\\\src\\\\lab4\\\\img\\\\mark.png"));
				JButton btnCancel= new JButton();
				btnCancel.setIcon(new ImageIcon("D:\\\\JAVA\\\\JAVA3\\\\src\\\\lab4\\\\img\\\\prohibition.png"));
				btnCancel.setBackground(Color.white);
				btnok.setBackground(Color.white);
				p1_2.add(btnok);
				p1_2.add(btnCancel);

				p1.add(slider);
				p1.add(p1_2);
				dialog.add(p1);
				btnok.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
					  setValue();
						
					}
				});
				btnCancel.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
						System.out.println("break");
						
					}
				});

				dialog.setVisible(true);

			}
		});
		MenuItem copy = new MenuItem("Copy");
		copy.setActionCommand("Copy");
		MenuItem paste = new MenuItem("Paste");
		paste.setActionCommand("Paste");
		popupmenu.add(textSize);
		popupmenu.add(copy);
		popupmenu.add(paste);
		contentPane.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				popupmenu.show(contentPane, e.getX(), e.getY());
			}
		});
		contentPane.add(popupmenu);

		JMenuBar menuBar = new JMenuBar();
		sl_contentPane.putConstraint(SpringLayout.EAST, menuBar, 804, SpringLayout.WEST, contentPane);
		menuBar.setEnabled(false);
		menuBar.setBackground(new Color(255, 255, 255));
		sl_contentPane.putConstraint(SpringLayout.NORTH, menuBar, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, menuBar, 10, SpringLayout.WEST, contentPane);
		contentPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem(
				"<html><span style=\"text-decoration: underline;\">N</span>ew\r\n" + "\r\n" + "    </html>");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");

			}
		});
		mntmNewMenuItem.setBackground(Color.WHITE);
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
		ImageIcon icon = new ImageIcon("D:\\JAVA\\JAVA3\\src\\lab4\\img\\new-document.png");
		Image scaledImage = icon.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		icon.setImage(scaledImage);
		mntmNewMenuItem.setIcon(icon);
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem1 = new JMenuItem(
				"<html><span style=\"text-decoration: underline;\">O</span>pen\r\n" + "\r\n" + "    </html>");
		mntmNewMenuItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					openFile();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		mntmNewMenuItem1.setBackground(Color.WHITE);
		mntmNewMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		ImageIcon icon1 = new ImageIcon("D:\\JAVA\\JAVA3\\src\\lab4\\img\\open.png");
		Image scaledImage1 = icon1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		icon1.setImage(scaledImage1);
		mntmNewMenuItem1.setIcon(icon1);
		mnNewMenu.add(mntmNewMenuItem1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem(
				"<html><span style=\"text-decoration: underline;\">S</span>ave\r\n" + "\r\n" + "    </html>");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					saveFile();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		});
		mntmNewMenuItem_2.setBackground(Color.WHITE);
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

		ImageIcon icon2 = new ImageIcon("D:\\JAVA\\JAVA3\\src\\lab4\\img\\save-file.png");
		Image scaledImage2 = icon2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
		icon2.setImage(scaledImage2);
		mntmNewMenuItem_2.setIcon(icon2);
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_1 = new JMenu("Color");
		mnNewMenu_1.setBackground(Color.WHITE);
		menuBar.add(mnNewMenu_1);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("Red");
		rdbtnmntmNewRadioItem.setForeground(Color.RED);
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBtnGroupColor("-65501");
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem);
		mnNewMenu_1.add(rdbtnmntmNewRadioItem);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("Green");
		rdbtnmntmNewRadioItem_1.setForeground(Color.GREEN);
		rdbtnmntmNewRadioItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBtnGroupColor("-16711936");
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_1);
		mnNewMenu_1.add(rdbtnmntmNewRadioItem_1);

		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("Blue");
		rdbtnmntmNewRadioItem_2.setForeground(Color.BLUE);
		rdbtnmntmNewRadioItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getBtnGroupColor("-16776961");
			}
		});
		buttonGroup.add(rdbtnmntmNewRadioItem_2);
		mnNewMenu_1.add(rdbtnmntmNewRadioItem_2);
		mnNewMenu_1.setBorder(new EmptyBorder(10, 10, 10, 10));

		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Text Color");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textColor();
			}
		});
		mntmNewMenuItem_6.setBackground(Color.WHITE);
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.ITALIC, 13));
		mnNewMenu_1.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_2 = new JMenu("System");
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("About Us");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutus();
			}
		});
		mntmNewMenuItem_7.setBackground(Color.WHITE);
		mnNewMenu_2.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Exit");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_8.setBackground(Color.WHITE);
		mntmNewMenuItem_8.setForeground(Color.RED);
		mnNewMenu_2.add(mntmNewMenuItem_8);

		JToolBar toolBar = new JToolBar();
		sl_contentPane.putConstraint(SpringLayout.EAST, toolBar, -123, SpringLayout.EAST, menuBar);
		toolBar.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, toolBar, 12, SpringLayout.SOUTH, menuBar);
		sl_contentPane.putConstraint(SpringLayout.WEST, toolBar, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, toolBar, 50, SpringLayout.SOUTH, menuBar);
		contentPane.add(toolBar);

		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("D:\\JAVA\\JAVA3\\src\\lab4\\img\\document.png"));
		btnNewButton.setBorderPainted(false);
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutus();
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("D:\\JAVA\\JAVA3\\src\\lab4\\img\\user.png"));
		btnNewButton_1.setBorderPainted(false);
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("D:\\JAVA\\JAVA3\\src\\lab4\\img\\exit.png"));
		btnNewButton_2.setBorderPainted(false);
		toolBar.add(btnNewButton_2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 6, SpringLayout.SOUTH, toolBar);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, menuBar);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 405, SpringLayout.SOUTH, toolBar);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, menuBar);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 0,grow");

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane.setViewportView(textArea);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_1, 3, SpringLayout.SOUTH, panel);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, menuBar);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_1, -8, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, menuBar);
		contentPane.add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		txtText = new JLabel("POLY JAVA 3");
		txtText.setFont(new Font("Tahoma", Font.PLAIN, 21));
		txtText.setHorizontalAlignment(SwingConstants.CENTER);
		sl_panel_1.putConstraint(SpringLayout.NORTH, txtText, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, txtText, 10, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, txtText, 65, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, txtText, 784, SpringLayout.WEST, panel_1);
		panel_1.add(txtText);

	}

}
