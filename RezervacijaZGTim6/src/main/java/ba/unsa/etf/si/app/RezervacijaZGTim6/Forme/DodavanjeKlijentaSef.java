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

import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import java.awt.Color;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.apache.log4j.Logger;


public class DodavanjeKlijentaSef {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private GroupLayout groupL;
	private JFrame f2;
	private JFrame parentFrame;
	
	final static Logger logger = Logger.getLogger(DodavanjeKlijentaSef.class);
	
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	
	JLabel lblIme = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPrezime = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblTel = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlIme = new JPanel();
	JPanel pnlPrezime = new JPanel();
	JPanel pnlTel = new JPanel();
	boolean izmjenaGosta = false;
	
	private Restoran handler;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKlijentaSef window = new DodavanjeKlijentaSef();
					window.getDodavanjeKlijentaSef().setVisible(true);
				} catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DodavanjeKlijentaSef() {
		initialize();
	}
	
	public DodavanjeKlijentaSef(Restoran r) {
		initialize();
		handler = r;
	}
	public DodavanjeKlijentaSef(Restoran r, JFrame f){
		handler=r;
		f2=f;
		initialize();
	}
	public void setParent(JFrame f)
	{
		parentFrame=f;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDodavanjeKlijentaSef(new JFrame());
		getDodavanjeKlijentaSef().setResizable(false);
		getDodavanjeKlijentaSef().setBounds(100, 100, 450, 300);
		getDodavanjeKlijentaSef().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent)
			{
			parentFrame.setEnabled(true);
			parentFrame.setVisible(true);
			}
		});
		
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
		
		MaskFormatter mfTel = new MaskFormatter();
		try {
			mfTel = new MaskFormatter("###/###-###");
		} catch (ParseException e1) {
			logger.info(e1.getMessage());
			e1.printStackTrace();
		}
	    mfTel.setPlaceholderCharacter('_');
		final JFormattedTextField formattedTelephone = new JFormattedTextField(mfTel);
		
		JButton btnDodajKlijenta = new JButton("Dodaj Klijenta");
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean validna_forma = true;
				// validacija
				if (textField.getText().isEmpty()) {
					lblIme.setText("Popunite polje!");
					pnlIme.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaImePrezime(textField.getText())) {
					lblIme.setText("Nedozvoljen format!");
					pnlIme.setVisible(true);
					validna_forma = false;
				}
				else { 
					lblIme.setText("");
					pnlIme.setVisible(false);
					//validna_forma = true;
				}
				
				if (textField_1.getText().isEmpty()) {
					lblPrezime.setText("Popunite polje!");
					pnlPrezime.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaImePrezime(textField_1.getText())) {
					lblPrezime.setText("Nedozvoljen format!");
					pnlPrezime.setVisible(true);
					validna_forma = false;
				}
				else { 
					lblPrezime.setText("");
					pnlPrezime.setVisible(false);
					//validna_forma = true;
				}
				
				if(formattedTelephone.getText().equals("___/___-___"))
				{
					lblTel.setText("Popunite polje!");
					pnlTel.setVisible(true);
					validna_forma = false;
				}
				else
				{
					lblTel.setText("");
					pnlTel.setVisible(false);
					//validna_forma = true;
				}
				
				try {
					if(validna_forma) System.out.println("Validna forma");
					else System.out.println("Nije validna forma");
					if(validna_forma) {
						handler.DodajGosta(textField.getText(), textField_1.getText(), formattedTelephone.getText());
						f2.dispose();
						Klijenti k = new Klijenti(handler);
						k.getKlijenti().setVisible(true);
					}
					else{
						System.out.println("nisam dodo!");
					}
				} catch (Exception e1) {
					logger.info(e1.getMessage());
					e1.printStackTrace();
				}
				
				if (validna_forma) {
					System.out.println("Validna forma");
					frame.dispose();
					parentFrame.setEnabled(true);
					//parentFrame.setVisible(true);
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
		
		lblTel.setForeground(Color.RED);
		pnlTel.add(lblTel, BorderLayout.WEST);
		pnlTel.setVisible(false);

		JLabel lblDodavanjeKlijenta = new JLabel("Dodavanje klijenta");
		lblDodavanjeKlijenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//JCheckBox VIPCheckBox = new JCheckBox("VIP klijent");
		
		GroupLayout groupLayout = new GroupLayout(getDodavanjeKlijentaSef().getContentPane());
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
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
										.addComponent(formattedTelephone))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnlTel, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
								.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(btnDodajKlijenta)))
					.addGap(13))
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
							.addComponent(label))
						.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlTel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2)
							.addComponent(formattedTelephone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGap(4)
					.addComponent(btnDodajKlijenta)
					.addGap(64))
		);
		getDodavanjeKlijentaSef().getContentPane().setLayout(groupLayout);
		
		
		  
	}

	public JFrame getDodavanjeKlijentaSef() {
		return frame;
	}

	public void setDodavanjeKlijentaSef(JFrame frame) {
		this.frame = frame;
	}
	
	public Boolean ValidacijaImePrezime(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z\u0161\u0111\u010D\u0107\u017E\u0160\u0110\u010C\u0106\u017D-]+$");
    }
}
