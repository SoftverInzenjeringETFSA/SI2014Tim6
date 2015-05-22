package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Sto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.LayoutManager;


public class LoginScreen {

	private JFrame frmPrijavaKorisnika;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private Restoran handler;
	JLabel labelaUsername = new JLabel();
	JLabel labelaPassword = new JLabel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen();
					window.getFrmPrijavaKorisnika().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		initialize();
	}
	
	public LoginScreen(Restoran r) {
		handler = r;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setFrmPrijavaKorisnika(new JFrame());
		getFrmPrijavaKorisnika().setTitle("Prijava korisnika");
		getFrmPrijavaKorisnika().setBounds(100, 100, 515, 356);
		getFrmPrijavaKorisnika().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.setResizable(false);
		frmPrijavaKorisnika.setTitle("Prijava korisnika");
		frmPrijavaKorisnika.setBounds(100, 100, 515, 356);
		frmPrijavaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ImageIcon icon = new ImageIcon("Slike/error.png"); 
		
		JButton btnLogIn = new JButton("Prijavi se ");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				if (txtUsername.getText().isEmpty()) {
					labelaUsername.setText("Popunite polje!");
				} else 
					labelaUsername.setText("");
				
				 boolean dobri_podaci = false;
				 try 
				 {
					char[] pass = txtPassword.getPassword();
					String passString = new String(pass);
					
					if(passString.equals("")) labelaPassword.setText("Popunite polje!");
					dobri_podaci = handler.PrijavaKorisnika(txtUsername.getText(), passString);
				 } catch (Exception e) 
				 {
					labelaPassword.setText("User ne postoji!");
					e.printStackTrace();
				 }
				 
				 if(dobri_podaci)
				 {
					 if(handler.getPristup() == 1) //otvori formu sefa
					 {
						 frmPrijavaKorisnika.dispose();
						 Radnici f = new Radnici(handler);
						 f.getRadnici().setVisible(true);
							
					 }
					 else if(handler.getPristup()==2) //otvori formu radnika
					 {
						 
						 frmPrijavaKorisnika.dispose();
						 RezervacijaRadnik f = new RezervacijaRadnik(handler);
						 f.getRezervacijaRadnik().setVisible(true); 
					 }
					 else //error cudna greska
					 {
						
					 }
				 }
				 else
				 {
					 //Iskoci error
					 
				 }
				 
		}
		});

		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setText("password");
		txtPassword.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsername.setText("username");
		txtUsername.setColumns(10);
		
		JLabel lblUZmajevomGnijezdu = new JLabel("ZMAJEVO GNIJEZDO");
		lblUZmajevomGnijezdu.setFont(new Font("Castellar", Font.BOLD, 22));
		labelaUsername.setToolTipText("");
		labelaUsername.setForeground(Color.RED);
		
		labelaUsername.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		
<<<<<<< HEAD
		JPanel panel = new JPanel();
	
		labelaPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
=======
		ImageIcon errImg = new ImageIcon("Slike/error.png");
		
		JLabel lblUsr = new JLabel("", errImg, JLabel.CENTER);
		JPanel pnlUsername = new JPanel();
		pnlUsername.add( lblUsr, BorderLayout.WEST );
		
		JLabel lblPsw = new JLabel("", errImg, JLabel.CENTER);
		JPanel pnlPassword = new JPanel();
		pnlPassword.add( lblPsw, BorderLayout.WEST );
		
		
>>>>>>> bc3ab1e90951db65faba977b6d5e4f184f94158e
		
		GroupLayout groupLayout = new GroupLayout(getFrmPrijavaKorisnika().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtUsername, 219, 219, 219)
<<<<<<< HEAD
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(labelaPassword, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(labelaUsername, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(lblUZmajevomGnijezdu)))
					.addContainerGap())
=======
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pnlPassword, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(40)
									.addComponent(labelaUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(labelaPassword)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(lblUZmajevomGnijezdu)))
					.addContainerGap(67, Short.MAX_VALUE))
>>>>>>> bc3ab1e90951db65faba977b6d5e4f184f94158e
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lblUZmajevomGnijezdu)
					.addGap(49)
<<<<<<< HEAD
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelaUsername, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelaPassword, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(62))
=======
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
							.addComponent(labelaUsername, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(198, Short.MAX_VALUE)
					.addComponent(labelaPassword)
					.addGap(119))
>>>>>>> bc3ab1e90951db65faba977b6d5e4f184f94158e
		);
		getFrmPrijavaKorisnika().getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmPrijavaKorisnika() {
		return frmPrijavaKorisnika;
	}

	public void setFrmPrijavaKorisnika(JFrame frmPrijavaKorisnika) {
		this.frmPrijavaKorisnika = frmPrijavaKorisnika;
	}
	
	public Boolean ValidacijaIme(String ime) {
        return ime.matches("^[A-Z]{1}[a-z]{2,}$");
}
}
