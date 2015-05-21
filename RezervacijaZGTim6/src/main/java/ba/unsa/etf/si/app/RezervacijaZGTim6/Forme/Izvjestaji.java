package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.util.Properties;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

import org.apache.tools.ant.types.selectors.modifiedselector.PropertiesfileCache;

import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.DateComponentFormatter;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilCalendarModel;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import net.sourceforge.jdatepicker.util.JDatePickerUtil;
import com.toedter.calendar.JCalendar;


public class Izvjestaji {

	private JFrame frame;
	private JDatePicker datum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Izvjestaji window = new Izvjestaji();
					window.getIzvjestaji().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Izvjestaji() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIzvjestaji(new JFrame());
		getIzvjestaji().setResizable(false);
		getIzvjestaji().setBounds(100, 100, 624, 427);
		getIzvjestaji().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
				
		JLabel lblNewLabel = new JLabel("Izvje\u0161taji");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		JLabel lblGenerisatiPo = new JLabel("Generisati po:");
		lblGenerisatiPo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnSvimKlijentima = new JRadioButton("Klijentima");
		rdbtnSvimKlijentima.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton rdbtnVipKlijentima = new JRadioButton("VIP klijentima");
		rdbtnVipKlijentima.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblZaMjesec = new JLabel("Za period:");
		lblZaMjesec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnGenerisi = new JButton("Generiši");
		btnGenerisi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Od:");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Do:");
		lblNewJgoodiesLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JDateChooser dateChooser = new JDateChooser();
		
		JDateChooser dateChooser_1 = new JDateChooser();
		GroupLayout groupLayout = new GroupLayout(getIzvjestaji().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(49)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel)
												.addComponent(lblGenerisatiPo))
											.addGap(139))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewJgoodiesLabel_1)
												.addComponent(lblNewJgoodiesLabel))
											.addGap(18)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
										.addComponent(btnGenerisi, Alignment.TRAILING))
									.addContainerGap(92, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblZaMjesec)
									.addGap(196))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnVipKlijentima)
								.addComponent(rdbtnSvimKlijentima))
							.addGap(358))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addComponent(lblZaMjesec))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblNewLabel)
							.addGap(29)
							.addComponent(lblGenerisatiPo)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addComponent(rdbtnSvimKlijentima)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(rdbtnVipKlijentima))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewJgoodiesLabel))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewJgoodiesLabel_1)
								.addComponent(dateChooser_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(btnGenerisi)))
					.addGap(185))
		);
		panel.setLayout(null);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdjava.setBackground(UIManager.getColor("Button.background"));
		btnOdjava.setBounds(22, 328, 107, 23);
		panel.add(btnOdjava);
		
		JButton btnRadnici = new JButton("Radnici");
		btnRadnici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Radnici f = new Radnici();
				f.getRadnici().setVisible(true);
			}
		});
		btnRadnici.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRadnici.setBounds(0, 0, 139, 34);
		panel.add(btnRadnici);
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Klijenti f = new Klijenti();
				f.getKlijenti().setVisible(true);
			}
		});
		btnKlijenti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKlijenti.setBounds(0, 34, 139, 34);
		panel.add(btnKlijenti);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnIzvjestaji.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIzvjestaji.setBounds(0, 68, 139, 34);
		panel.add(btnIzvjestaji);
		getIzvjestaji().getContentPane().setLayout(groupLayout);
	}

	public JFrame getIzvjestaji() {
		return frame;
	}

	public void setIzvjestaji(JFrame frame) {
		this.frame = frame;
	}
}
