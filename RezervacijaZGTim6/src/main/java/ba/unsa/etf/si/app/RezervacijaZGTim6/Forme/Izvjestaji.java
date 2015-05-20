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

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;


public class Izvjestaji {

	private JFrame frame;

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
		
		JLabel lblZaMjesec = new JLabel("Za mjesec:");
		lblZaMjesec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Januar", "Februar", "Mart", "April", "Maj", "Juni ", "Juli ", "August", "Septembar", "Oktorab", "Novembar", "Decembar"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JButton btnGenerisi = new JButton("Generiši");
		btnGenerisi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(getIzvjestaji().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGenerisatiPo)
								.addComponent(rdbtnSvimKlijentima)
								.addComponent(rdbtnVipKlijentima))
							.addGap(70)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblZaMjesec)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnGenerisi)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(156, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenerisatiPo)
						.addComponent(lblZaMjesec))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(rdbtnSvimKlijentima)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnVipKlijentima))
						.addComponent(list))
					.addGap(26)
					.addComponent(btnGenerisi)
					.addContainerGap(45, Short.MAX_VALUE))
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
		btnOdjava.setBounds(22, 328, 89, 23);
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
