package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.awt.EventQueue;
import java.sql.Date;
import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Forme.LoginScreen;

public class App {
	
public static void main(String[] args)
{
	final Restoran ZmajevoGnijezdo = Restoran.getInstance();
	try {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen window = new LoginScreen(ZmajevoGnijezdo);
					window.getFrmPrijavaKorisnika().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
}

}
