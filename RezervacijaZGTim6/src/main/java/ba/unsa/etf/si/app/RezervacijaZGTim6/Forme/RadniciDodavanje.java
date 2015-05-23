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
				
				// validacija
				if (textField.getText().isEmpty()) {
					lblIme_Validacija.setText("Popunite polje!");
					pnlIme.setVisible(true);
				} else if (!ValidacijaImePrezime(textField.getText())) {
					lblIme_Validacija.setText("Nedozvoljen format!");
					pnlIme.setVisible(true);
				}
				else { 
					lblIme_Validacija.setText("");
					pnlIme.setVisible(false);
				}
				
				if (textField_1.getText().isEmpty()) {
					lblPrezime_Validacija.setText("Popunite polje!");
					pnlPrezime.setVisible(true);
				} else if (!ValidacijaImePrezime(textField_1.getText())) {
					lblPrezime_Validacija.setText("Nedozvoljen format!");
					pnlPrezime.setVisible(true);
				}
				else { 
					lblPrezime_Validacija.setText("");
					pnlPrezime.setVisible(false);
				}
				
				if(textField_2.getText().isEmpty()) {
					lblUsr.setText("Popunite polje!");
					pnlUsername.setVisible(true);
				} else if (!ValidacijaUserPass(textField_2.getText())) {
					lblUsr.setText("Nedozvoljen format!");
					pnlUsername.setVisible(true);
				} else {
					lblUsr.setText("");
					pnlUsername.setVisible(false);
				}
				
				if(textField_3.getText().isEmpty()) {
					lblPsw.setText("Popunite polje!");
					pnlPassword.setVisible(true);
				} else if (!ValidacijaUserPass(textField_3.getText())) {
					lblPsw.setText("Nedozvoljen format!");
					pnlPassword.setVisible(true);
				} else {
					lblPsw.setText("");
					pnlPassword.setVisible(false);
				}
				
				boolean dobri_podaci = false;
				
				try {
					if(dobri_podaci) {
						
						//logika za unos radnika
					}
					
				} catch (Exception f) {
					f.printStackTrace();
				}
				
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
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
					.addGap(18))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(96)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblIme)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPrezime)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsername)
							.addComponent(textField_2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPassword)))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnSpasi)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		lblUsr.setForeground(Color.ORANGE);
		
		pnlUsername.add(lblUsr);
		pnlPrezime.add(lblPrezime_Validacija);
		
		lblPrezime_Validacija.setForeground(Color.ORANGE);
		pnlIme.add(lblIme_Validacija);
		
		lblIme_Validacija.setForeground(Color.ORANGE);
		lblPsw.setForeground(Color.ORANGE);
		
		pnlPassword.add(lblPsw);
		panel.setLayout(null);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
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
		btnKlijenti.setBounds(0, 34, 139, 34);
		panel.add(btnKlijenti);
		
		JButton btnIzvjestaji = new JButton("Izvjestaji");
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
        return user.matches("^[a-zA-Z ]+");
    }
	
	public Boolean ValidacijaUserPass(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z0-9]+$");
    }

}
