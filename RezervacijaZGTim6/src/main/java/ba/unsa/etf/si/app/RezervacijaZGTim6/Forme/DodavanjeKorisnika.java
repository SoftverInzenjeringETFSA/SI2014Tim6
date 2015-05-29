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
import ba.unsa.etf.si.app.RezervacijaZGTim6.Gost;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Rezervacija;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;


public class DodavanjeKorisnika {


	private JFrame frame;
	private JTextField textField;
	
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	
	JLabel lblIme = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPrezime = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlIme = new JPanel();
	JPanel pnlPrezime = new JPanel();
	boolean izmjenaGosta = false;
	
	private Gost gost;
	private Restoran handler;
	private long ID;
	private JPasswordField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKorisnika window = new DodavanjeKorisnika();
					window.getDodavanjeKorisnika().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeKorisnika() {
		initialize();
	}
	
	public DodavanjeKorisnika(Restoran r) {
		handler = r;
		initialize();
		
	}
	
	public DodavanjeKorisnika(Restoran r, long id) {
		handler = r;
		this.ID = id;
		initialize();
	}
	
	public DodavanjeKorisnika(Gost g, Restoran r){
		izmjenaGosta=true;
		gost=g;
		handler=r;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDodavanjeKorisnika(new JFrame());
		getDodavanjeKorisnika().setResizable(false);
		getDodavanjeKorisnika().setBounds(100, 100, 500, 300);
		getDodavanjeKorisnika().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblKorisnickoIme = new JLabel("Korisnicko ime:");
		lblKorisnickoIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblifra = new JLabel("Šifra:");
		lblifra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		MaskFormatter mfTel = new MaskFormatter();
		try {
			mfTel = new MaskFormatter("###/###-###");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    mfTel.setPlaceholderCharacter('_');
		
		String NazivDugmeta = "Dodaj korisnika";
		String NazivForme = "Dodavanje korisnika";

		
		final JButton btnDodajKlijenta = new JButton(NazivDugmeta);
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean validna_forma = true;
				// validacija
				if (textField.getText().isEmpty()) {
					lblIme.setText("Popunite polje!");
					pnlIme.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaUsername(textField.getText())) {
					lblIme.setText("Nedozvoljen format!");
					//lblIme.setVisible(true);
					pnlIme.setVisible(true);
					validna_forma = false;
				}
				else { 
					lblIme.setText("");
					pnlIme.setVisible(false);
					//validna_forma = true;
					//lblIme.setVisible(false);
				}
				
				if (textField_1.getText().isEmpty()) {
					lblPrezime.setText("Popunite polje!");
					pnlPrezime.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaPassword(textField_1.getText())) {
					lblPrezime.setText("Nedozvoljen format!");
					//lblIme.setVisible(true);
					pnlPrezime.setVisible(true);
					validna_forma = false;
				}
				else { 
					lblPrezime.setText("");
					pnlPrezime.setVisible(false);
					//validna_forma = true;
					//lblIme.setVisible(false);
				}
				
				
				try {
					if(validna_forma) {
						try {
							handler.DodajKorisnika(ID, textField.getText(), textField_1.getText());
						} catch (Exception e1) {
							e1.printStackTrace();
						}
						
					}
					else{
						System.out.println("nisam dodo!");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				if (validna_forma) {
					System.out.println("Validna forma");
					frame.dispose();
				} else
					System.out.println("Nevalidna forma");
				// zakomentarisano zbog testa validacije
			}
		});
		
		btnDodajKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblIme.setForeground(Color.RED);
		pnlIme.add( lblIme, BorderLayout.WEST );
		pnlIme.setVisible(false);
		
		lblPrezime.setForeground(Color.RED);
		pnlPrezime.add( lblPrezime, BorderLayout.WEST );
		pnlPrezime.setVisible(false);

		JLabel lblDodavanjeKlijenta = new JLabel(NazivForme);
		lblDodavanjeKlijenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel = new JLabel("<html>Ispravan format:"
				                       + "<br>Korisničko ime: Samo mala slova i veće od 5 znakova!</br>"
				                       + "<br> Šifra: 1 broj, 1 veliko, 1 malo slovo i veće od 5 znakova!</br> </html>");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		textField_1 = new JPasswordField();
		
		GroupLayout groupLayout = new GroupLayout(getDodavanjeKorisnika().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDodajKlijenta))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblDodavanjeKlijenta)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblifra)
										.addComponent(lblKorisnickoIme))
									.addGap(22)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
								.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
							.addGap(13))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblDodavanjeKlijenta)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
							.addComponent(lblKorisnickoIme))
						.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblifra)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblNewLabel)
					.addGap(7)
					.addComponent(btnDodajKlijenta)
					.addGap(44))
		);
		getDodavanjeKorisnika().getContentPane().setLayout(groupLayout);
		
		
		  
	}

	public JFrame getDodavanjeKorisnika() {
		return frame;
	}

	public void setDodavanjeKorisnika(JFrame frame) {
		this.frame = frame;
	}
	
	public Boolean ValidacijaUsername(String user) {
		if (user.length() < 5) return false;
        return user.matches("^[a-z]+$");
    }
	
	public Boolean ValidacijaPassword(String user)
	{
		if(user.length() < 5) return false;
		String pattern = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=\\S+$).{5,})";

        return user.matches(pattern);
	}
}
