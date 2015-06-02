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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Radnik;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;


public class RadniciEditovanje {
	
	final static Logger logger = Logger.getLogger(RadniciEditovanje.class);
	private JFrame frame;
	private JFrame f2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JFrame parentFrame;
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	private long ID;
	private Radnik radnik;
	
	JLabel lblIme_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPrezime_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblUsr = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblPsw = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlIme = new JPanel();
	JPanel pnlPrezime = new JPanel();
	JPanel pnlUsername = new JPanel();
	JPanel pnlPassword = new JPanel();
	
	private Restoran handler;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RadniciEditovanje window = new RadniciEditovanje();
					window.getRadniciEditovanje().setVisible(true);
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
	public RadniciEditovanje() {
		initialize();
	}
	
	public RadniciEditovanje(Restoran r, long id, JFrame f) {
		ID = id;
		f2=f;
		handler = r;
		ArrayList<Radnik> radnici = handler.DajRadnike();
		radnik = new Radnik();
		for (Iterator iterator1 = radnici.iterator(); iterator1.hasNext();)
        {
          Radnik temp = (Radnik)iterator1.next(); 
           if(temp.getId() == ID)
			radnik = temp;
        }
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
		setRadniciEditovanje(new JFrame());
		getRadniciEditovanje().setResizable(false);
		getRadniciEditovanje().setBounds(100, 100, 451, 324);
		getRadniciEditovanje().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent)
			{
			parentFrame.setEnabled(true);
			parentFrame.setVisible(true);
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Ažuriranje radnika");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setText(radnik.getIme());
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setText(radnik.getPrezime());
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setText(radnik.getNazivPosla());
				
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setText(radnik.getOpisPosla());
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setText(radnik.getJMBG());
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblUsername = new JLabel("Naziv posla:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblPassword = new JLabel("Opis posla:");
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
				//	validna_forma = true;
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
					//validna_forma = true;
				}
				
				if(textField_2.getText().isEmpty()) {
					lblUsr.setText("Popunite polje!");
					pnlUsername.setVisible(true);
					validna_forma = false;
				} else {
					lblUsr.setText("");
					pnlUsername.setVisible(false);
					//validna_forma = true;
				}
				
				if(textField_3.getText().isEmpty()) {
					lblPsw.setText("Popunite polje!");
					pnlPassword.setVisible(true);
					validna_forma = false;
				} else {
					lblPsw.setText("");
					pnlPassword.setVisible(false);
					//validna_forma = true;
				}
				
				if(textField_4.getText().isEmpty()) {
					lblPsw.setText("Popunite polje!");
					pnlPassword.setVisible(true);
					validna_forma = false;
				} else if (!ValidacijaJMBG(textField_4.getText())) {
					lblPsw.setText("Nedozvoljen format!");
					pnlPassword.setVisible(true);
					validna_forma = false;
				} else {
					lblPsw.setText("");
					pnlPassword.setVisible(false);
					//validna_forma = true;
				}
								
				try {
					if(validna_forma) {
						
						radnik.setIme(textField.getText());
						radnik.setPrezime(textField_1.getText());
						radnik.setNazivPosla(textField_2.getText());
						radnik.setOpisPosla(textField_3.getText());
						radnik.setJMBG(textField_4.getText());
						
						handler.azurirajRadnika(radnik);
						frame.dispose();
						Radnici r = new Radnici(handler);
						r.getRadnici().setVisible(true);
					}
					
				} catch (Exception f) {
					logger.info(f.getMessage());
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
		
		JLabel lblJmbg = new JLabel("JMBG:");
		lblJmbg.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		GroupLayout groupLayout = new GroupLayout(getRadniciEditovanje().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(73)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(130)
									.addComponent(lblJmbg)
									.addGap(34)
									.addComponent(textField_4, 0, 0, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(103)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
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
										.addComponent(btnSpasi)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPassword)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(pnlPrezime, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblIme)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPrezime)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsername)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPassword)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblJmbg)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(btnSpasi)
					.addGap(31))
		);
		lblUsr.setForeground(Color.RED);
		
		pnlUsername.add(lblUsr);
		pnlPrezime.add(lblPrezime_Validacija);
		
		lblPrezime_Validacija.setForeground(Color.RED);
		pnlIme.add(lblIme_Validacija);
		
		lblIme_Validacija.setForeground(Color.RED);
		lblPsw.setForeground(Color.RED);
		
		pnlPassword.add(lblPsw);
		getRadniciEditovanje().getContentPane().setLayout(groupLayout);
	}

	public JFrame getRadniciEditovanje() {
		return frame;
	}

	public void setRadniciEditovanje(JFrame frame) {
		this.frame = frame;
	}
	
	public Boolean ValidacijaImePrezime(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z\u0161\u0111\u010D\u0107\u017E\u0160\u0110\u010C\u0106\u017D-]+$");
    }
	
	public Boolean ValidacijaUserPass(String user) {
		if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z\u0161\u0111\u010D\u0107\u017E\u0160\u0110\u010C\u0106\u017D-]+$");
    }
	
	public Boolean ValidacijaJMBG(String jmbg){
		return jmbg.matches("^[0-9]{13}$");
	}
}
