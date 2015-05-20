package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;


import java.awt.Component;
import java.awt.EventQueue;

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

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginScreen {

	private JFrame frmPrijavaKorisnika;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	private Restoran handler;

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
		initialize();
		handler = r;
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

		
		JButton btnLogIn = new JButton("Prijavi se ");
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnLogIn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent event) {
				 boolean dobri_podaci = false;
				 try 
				 {
					char[] pass = txtPassword.getPassword();
					String passString = new String(pass);
					dobri_podaci = handler.PrijavaKorisnika(txtUsername.getText(), passString);
				 } catch (Exception e) 
				 {
					e.printStackTrace();
				 }
				 
				 if(dobri_podaci)
				 {
					 if(handler.getPristup() == 1) //otvori formu sefa
					 {
						 frmPrijavaKorisnika.dispose();
						 Radnici f = new Radnici();
						 f.getRadnici().setVisible(true);
							
					 }
					 else if(handler.getPristup()==2)//otvori formu radnika
					 {
						 frmPrijavaKorisnika.dispose();
						 NapraviRezervaciju f = new NapraviRezervaciju();
						 f.getNapraviRezervaciju().setVisible(true); 
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
		GroupLayout groupLayout = new GroupLayout(getFrmPrijavaKorisnika().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(125)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsername, 219, 219, 219)
								.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(112)
							.addComponent(lblUZmajevomGnijezdu)))
					.addContainerGap(121, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(lblUZmajevomGnijezdu)
					.addGap(49)
					.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		getFrmPrijavaKorisnika().getContentPane().setLayout(groupLayout);
	}

	public JFrame getFrmPrijavaKorisnika() {
		return frmPrijavaKorisnika;
	}

	public void setFrmPrijavaKorisnika(JFrame frmPrijavaKorisnika) {
		this.frmPrijavaKorisnika = frmPrijavaKorisnika;
	}
}
