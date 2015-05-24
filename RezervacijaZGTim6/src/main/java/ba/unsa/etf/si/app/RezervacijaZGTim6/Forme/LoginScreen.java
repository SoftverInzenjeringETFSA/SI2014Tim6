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
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class LoginScreen {

	private JFrame frmPrijavaKorisnika;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private Restoran handler;
	JPanel pnlUsername = new JPanel();
	JPanel pnlPassword = new JPanel();
	ImageIcon errImg = new ImageIcon("Slike/error.png");
	JLabel lblUsr = new JLabel("", errImg, SwingConstants.LEFT);
	JLabel lblPsw = new JLabel("", errImg, SwingConstants.LEFT);
	private final JLabel lblUsername = new JLabel("Username:");
	private final JLabel lblPassword = new JLabel("Password:");

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
		getFrmPrijavaKorisnika().setBounds(100, 100, 522, 356);
		getFrmPrijavaKorisnika().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrijavaKorisnika = new JFrame();
		frmPrijavaKorisnika.setResizable(false);
		frmPrijavaKorisnika.setTitle("Prijava korisnika");
		frmPrijavaKorisnika.setBounds(100, 100, 515, 356);
		frmPrijavaKorisnika.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JButton btnLogIn = new JButton("Prijavi se ");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				
				
				boolean dobri_podaci = false;
				 try 
				 { // validacija
						if (txtUsername.getText().isEmpty()) {
							lblUsr.setText("Popunite polje!");
							pnlUsername.setVisible(true);
						} else if (!ValidacijaUserPass(txtUsername.getText())) {
							lblUsr.setText("Nedozvoljen format!");
							pnlUsername.setVisible(true);
						}
						else { 
							lblUsr.setText("");
							pnlUsername.setVisible(false);
						}
					char[] pass = txtPassword.getPassword();
					String passString = new String(pass);
					
					// validacija
					if(passString.equals("")) {
						lblPsw.setText("Popunite polje!");
						pnlPassword.setVisible(true);
					} else if (!ValidacijaUserPass(passString)) {
						lblPsw.setText("Nedozvoljen format!");
						pnlPassword.setVisible(true);
					} else if(!handler.PrijavaKorisnika(txtUsername.getText(), passString)){
						lblPsw.setText("<html>Neispravni username<br>ili password.<br></html>");
						pnlPassword.setVisible(true);
					} else {
						lblPsw.setText("");
						pnlPassword.setVisible(false);
					}
					
					dobri_podaci = handler.PrijavaKorisnika(txtUsername.getText(), passString);
					
				 } catch (Exception e) {

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
					 else if(handler.getPristup()==2)//otvori formu radnika
					 {
						 
						 frmPrijavaKorisnika.dispose();
						 RezervacijaRadnik f = new RezervacijaRadnik(handler);
						 f.getRezervacijaRadnik().setVisible(true); 
					 }
					 else //error cudna greska
					 {
                           System.out.print("Neispravni podaci");
					 }
				 }
				 else
				 {
					 //Iskoci error
					 System.out.print("Neispravni podaci");
				 }
				 
		}
		});

		
		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					boolean dobri_podaci = false;
					 try 
					 {
					
						// validacija
							if (txtUsername.getText().isEmpty()) {
								lblUsr.setText("Popunite polje!");
								pnlUsername.setVisible(true);
							} else if (!ValidacijaUserPass(txtUsername.getText())) {
								lblUsr.setText("Nedozvoljen format!");
								pnlUsername.setVisible(true);
							}
							else { 
								lblUsr.setText("");
								pnlUsername.setVisible(false);
							}
						 char[] pass = txtPassword.getPassword();
						String passString = new String(pass);
						
						// validacija
						if(passString.equals("")) {
							lblPsw.setText("Popunite polje!");
							pnlPassword.setVisible(true);
						} else if (!ValidacijaUserPass(passString)) {
							lblPsw.setText("Nedozvoljen format!");
							pnlPassword.setVisible(true);
						} else if(!handler.PrijavaKorisnika(txtUsername.getText(), passString)){
							lblPsw.setText("<html>Neispravni username<br>ili password.<br></html>");
							pnlPassword.setVisible(true);
						} else {
							lblPsw.setText("");
							pnlPassword.setVisible(false);
						}
						
						dobri_podaci = handler.PrijavaKorisnika(txtUsername.getText(), passString);
						
					 } catch (Exception e) {

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
						 else if(handler.getPristup()==2)//otvori formu radnika
						 {
							 
							 frmPrijavaKorisnika.dispose();
							 RezervacijaRadnik f = new RezervacijaRadnik(handler);
							 f.getRezervacijaRadnik().setVisible(true); 
						 }
						 else //error cudna greska
						 {
                                 System.out.print("Neispravni podaci");
						 }
					 }
					 else
					 {
						 //Iskoci error
						 System.out.print("Neispravni podaci");
					 }
			       
			    }

			}
		});
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPassword.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
					
					
					boolean dobri_podaci = false;
					 try 
					 {
						// validacija
							if (txtUsername.getText().isEmpty()) {
								lblUsr.setText("Popunite polje!");
								pnlUsername.setVisible(true);
							} else if (!ValidacijaUserPass(txtUsername.getText())) {
								lblUsr.setText("Nedozvoljen format!");
								pnlUsername.setVisible(true);
							}
							else { 
								lblUsr.setText("");
								pnlUsername.setVisible(false);
							}
						char[] pass = txtPassword.getPassword();
						String passString = new String(pass);
						
						// validacija
						if(passString.equals("")) {
							lblPsw.setText("Popunite polje!");
							pnlPassword.setVisible(true);
						} else if (!ValidacijaUserPass(passString)) {
							lblPsw.setText("Nedozvoljen format!");
							pnlPassword.setVisible(true);
						} else if(!handler.PrijavaKorisnika(txtUsername.getText(), passString)){
							lblPsw.setText("<html>Neispravni username<br>ili password.<br></html>");
							pnlPassword.setVisible(true);
						} else {
							lblPsw.setText("");
							pnlPassword.setVisible(false);
						}
						
						dobri_podaci = handler.PrijavaKorisnika(txtUsername.getText(), passString);
						
					 } catch (Exception e) {

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
						 else if(handler.getPristup()==2)//otvori formu radnika
						 {
							 
							 frmPrijavaKorisnika.dispose();
							 RezervacijaRadnik f = new RezervacijaRadnik(handler);
							 f.getRezervacijaRadnik().setVisible(true); 
						 }
						 else //error cudna greska
						 {
                                 System.out.print("Neispravni podaci");
						 }
					 }
					 else
					 {
						 //Iskoci error
						 System.out.print("Neispravni podaci");
					 }
			       
			    }
				
			}
		});
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtUsername.setColumns(10);
		
		JLabel lblUZmajevomGnijezdu = new JLabel("ZMAJEVO GNIJEZDO");
		lblUZmajevomGnijezdu.setFont(new Font("Castellar", Font.BOLD, 23));
		lblUsr.setForeground(Color.RED);
		
		pnlUsername.add( lblUsr, BorderLayout.WEST );
		pnlUsername.setVisible(false);
		lblPsw.setForeground(Color.RED);
		
		pnlPassword.add( lblPsw, BorderLayout.WEST );
		pnlPassword.setVisible(false);
		
		GroupLayout groupLayout = new GroupLayout(getFrmPrijavaKorisnika().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(lblUZmajevomGnijezdu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsername)
								.addComponent(lblPassword))
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPassword)
								.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lblUZmajevomGnijezdu)
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlUsername, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
							.addComponent(lblUsername)))
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnlPassword, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
							.addComponent(lblPassword)))
					.addGap(18)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(57))
		);
		getFrmPrijavaKorisnika().getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmPrijavaKorisnika() {
		return frmPrijavaKorisnika;
	}

	public void setFrmPrijavaKorisnika(JFrame frmPrijavaKorisnika) {
		this.frmPrijavaKorisnika = frmPrijavaKorisnika;
	}
	
	public Boolean ValidacijaUserPass(String user) {
		if (user.length() < 5) return false;
        return user.matches("^[a-zA-Z0-9\u0161\u0111\u010D\u0107\u017E]+$");
       
    }
	
	public Boolean ValidacijaPassworda(String user) {
		if (user.length() < 5) return false;
		String pattern = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=\\S+$).{5,})";

        return user.matches(pattern);
       
    }
	
}
