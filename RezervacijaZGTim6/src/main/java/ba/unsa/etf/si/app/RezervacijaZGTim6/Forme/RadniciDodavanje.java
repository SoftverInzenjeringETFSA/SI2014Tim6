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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;


public class RadniciDodavanje {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	
	JLabel lblIme_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPrezime_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblUsr = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPsw = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlIme = new JPanel();
	JPanel pnlPrezime = new JPanel();
	JPanel pnlUsername = new JPanel();
	JPanel pnlPassword = new JPanel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadniciDodavanje window = new RadniciDodavanje();
					window.getRadniciDodavanje().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RadniciDodavanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setRadniciDodavanje(new JFrame());
		getRadniciDodavanje().setResizable(false);
		getRadniciDodavanje().setBounds(100, 100, 624, 427);
		getRadniciDodavanje().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("A\u017Euriranje / Dodavanje radnika");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnSpasi = new JButton("Spasi ");
		btnSpasi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean validna_forma = true;
				// validacija
				if (textField.getText().isEmpty()) {
					lblIme_Validacija.setText("Popunite polje!");
					pnlIme.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaImePrezime(textField.getText())) {
					lblIme_Validacija.setText("Nedozvoljen format!");
					pnlIme.setVisible(true);
					validna_forma = false;
				}
				else { 
					lblIme_Validacija.setText("");
					pnlIme.setVisible(false);
					validna_forma = true;
				}
				
				if (textField_1.getText().isEmpty()) {
					lblPrezime_Validacija.setText("Popunite polje!");
					pnlPrezime.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaImePrezime(textField_1.getText())) {
					lblPrezime_Validacija.setText("Nedozvoljen format!");
					pnlPrezime.setVisible(true);
					validna_forma = false;
				}
				else { 
					lblPrezime_Validacija.setText("");
					pnlPrezime.setVisible(false);
					validna_forma = true;
				}
				
				if(textField_2.getText().isEmpty()) {
					lblUsr.setText("Popunite polje!");
					pnlUsername.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaUserPass(textField_2.getText())) {
					lblUsr.setText("Nedozvoljen format!");
					pnlUsername.setVisible(true);
					validna_forma = false;
				} else {
					lblUsr.setText("");
					pnlUsername.setVisible(false);
					validna_forma = true;
				}
				
				if(textField_3.getText().isEmpty()) {
					lblPsw.setText("Popunite polje!");
					pnlPassword.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaUserPass(textField_3.getText())) {
					lblPsw.setText("Nedozvoljen format!");
					pnlPassword.setVisible(true);
					validna_forma = false;
				} else {
					lblPsw.setText("");
					pnlPassword.setVisible(false);
					validna_forma = true;
				}
				
				boolean dobri_podaci = false;
				
				try {
					if(dobri_podaci) {
						
						//logika za unos radnika
					}
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
			/*	if (validna_forma)
					System.out.println("Validna forma");
				else
					System.out.println("Nevalidna forma");*/
			}
		});
		btnSpasi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		pnlIme.add( lblIme_Validacija, BorderLayout.WEST );
		pnlIme.setVisible(false);
		
		pnlPrezime.add( lblPrezime_Validacija, BorderLayout.WEST );
		pnlPrezime.setVisible(false);
		
		pnlPassword.add( lblPsw, BorderLayout.WEST );
		pnlPassword.setVisible(false);
		
		pnlUsername.add( lblUsr, BorderLayout.WEST );
		pnlUsername.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(getRadniciDodavanje().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPassword)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblIme)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblPrezime)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnSpasi))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
					.addGap(25))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
							.addGap(24))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(96)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField)
									.addComponent(lblIme)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPrezime)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblUsername)
									.addComponent(textField_2)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(textField_3)
									.addComponent(lblPassword)))
							.addGap(59)
							.addComponent(btnSpasi)
							.addGap(91))))
		);
		lblUsr.setForeground(Color.RED);
		
		pnlUsername.add(lblUsr);
		pnlPrezime.add(lblPrezime_Validacija);
		
		lblPrezime_Validacija.setForeground(Color.RED);
		pnlIme.add(lblIme_Validacija);
		
		lblIme_Validacija.setForeground(Color.RED);
		lblPsw.setForeground(Color.RED);
		
		pnlPassword.add(lblPsw);
		panel.setLayout(null);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		btnOdjava.setBackground(UIManager.getColor("Button.background"));
		btnOdjava.setBounds(10, 329, 119, 23);
		panel.add(btnOdjava);
		
		JButton btnRadnici = new JButton("Radnici");
		btnRadnici.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRadnici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				Radnici f = new Radnici();
				f.getRadnici().setVisible(true);
			}
		});
		btnRadnici.setBounds(0, 0, 139, 34);
		panel.add(btnRadnici);
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKlijenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Klijenti f = new Klijenti();
				f.getKlijenti().setVisible(true);
			}
		});
		btnKlijenti.setBounds(0, 34, 139, 34);
		panel.add(btnKlijenti);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Izvjestaji f = new Izvjestaji();
				f.getIzvjestaji().setVisible(true);
			}
		});
		btnIzvjestaji.setBounds(0, 68, 139, 34);
		panel.add(btnIzvjestaji);
		getRadniciDodavanje().getContentPane().setLayout(groupLayout);
	}

	public JFrame getRadniciDodavanje() {
		return frame;
	}

	public void setRadniciDodavanje(JFrame frame) {
		this.frame = frame;
	}
	
	public Boolean ValidacijaImePrezime(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z\u0161\u0111\u010D\u0107\u017E-]+$");
    }
	
	public Boolean ValidacijaUserPass(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z0-9\u0161\u0111\u010D\u0107\u017E]+$");
    }

}
