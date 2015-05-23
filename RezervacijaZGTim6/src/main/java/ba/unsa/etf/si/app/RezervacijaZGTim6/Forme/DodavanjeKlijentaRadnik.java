	package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.Color;


public class DodavanjeKlijentaRadnik {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	
	JLabel lblIme = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPrezime = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblBrTel = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlIme = new JPanel();
	JPanel pnlPrezime = new JPanel();
	JPanel pnlBrTel = new JPanel();
	
	private Restoran handler;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKlijentaRadnik window = new DodavanjeKlijentaRadnik();
					window.getDodavanjeKlijentaRadnik().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeKlijentaRadnik() {
		initialize();
	}
	
	public DodavanjeKlijentaRadnik(Restoran r) {
		initialize();
		handler = r;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDodavanjeKlijentaRadnik(new JFrame());
		getDodavanjeKlijentaRadnik().setResizable(false);
		getDodavanjeKlijentaRadnik().setBounds(100, 100, 450, 300);
		getDodavanjeKlijentaRadnik().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("Ime:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel label_1 = new JLabel("Prezime:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("Broj telefona:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnDodajKlijenta = new JButton("Dodaj Klijenta");
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// validacija
				if (textField.getText().isEmpty()) {
					lblIme.setText("Popunite polje!");
					pnlIme.setVisible(true);
				} else if (!ValidacijaImePrezime(textField.getText())) {
					lblIme.setText("Nedozvoljen format!");
					pnlIme.setVisible(true);
				}
				else { 
					lblIme.setText("");
					pnlIme.setVisible(false);
				}
				
				if (textField_1.getText().isEmpty()) {
					lblPrezime.setText("Popunite polje!");
					pnlPrezime.setVisible(true);
				} else if (!ValidacijaImePrezime(textField_1.getText())) {
					lblPrezime.setText("Nedozvoljen format!");
					pnlPrezime.setVisible(true);
				}
				else { 
					lblPrezime.setText("");
					pnlPrezime.setVisible(false);
				}
				
				if (textField_2.getText().isEmpty()) {
					lblBrTel.setText("Popunite polje!");
					pnlBrTel.setVisible(true);
				} else if (!ValidacijaTelefon(textField_1.getText())) {
					lblBrTel.setText("Nedozvoljen format!");
					pnlBrTel.setVisible(true);
				}
				else { 
					lblBrTel.setText("");
					pnlBrTel.setVisible(false);
				}
				
				try {
					handler.DodajGosta(textField.getText(), textField_1.getText(), textField_2.getText());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				// zakomentarisano zbog testa validacije
				// frame.dispose();
			}
		});
		
		btnDodajKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIme.setForeground(Color.ORANGE);
		
		pnlIme.add( lblIme, BorderLayout.WEST );
		pnlIme.setVisible(false);
		lblPrezime.setForeground(Color.ORANGE);
		
		pnlPrezime.add( lblPrezime, BorderLayout.WEST );
		pnlPrezime.setVisible(false);
		lblBrTel.setForeground(Color.ORANGE);
		
		pnlBrTel.add( lblBrTel, BorderLayout.WEST );
		pnlBrTel.setVisible(false);
		
		JLabel lblDodavanjeKlijenta = new JLabel("Dodavanje Klijenta");
		lblDodavanjeKlijenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		GroupLayout groupLayout = new GroupLayout(getDodavanjeKlijentaRadnik().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDodavanjeKlijenta)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_1)
										.addComponent(label)
										.addComponent(label_2))
									.addGap(22)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pnlBrTel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(btnDodajKlijenta)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblDodavanjeKlijenta)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlIme, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(label)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1)
							.addComponent(label_1)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlBrTel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_2)
							.addComponent(label_2)))
					.addGap(34)
					.addComponent(btnDodajKlijenta)
					.addGap(64))
		);
		getDodavanjeKlijentaRadnik().getContentPane().setLayout(groupLayout);
	}

	public JFrame getDodavanjeKlijentaRadnik() {
		return frame;
	}

	public void setDodavanjeKlijentaRadnik(JFrame frame) {
		this.frame = frame;
	}
	
	public Boolean ValidacijaImePrezime(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z ]+");
    }
	
	public Boolean ValidacijaTelefon(String telefon) {
        return telefon.matches("(\\d{2})[/]\\d{3}-\\d{3}");
    }
}
