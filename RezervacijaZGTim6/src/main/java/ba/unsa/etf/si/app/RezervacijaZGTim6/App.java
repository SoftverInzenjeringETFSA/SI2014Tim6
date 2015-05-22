package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Forme.LoginScreen;

public class App {
	
public static void main(String[] args)
{

	try {
		final Restoran ZmajevoGnijezdo = Restoran.getInstance();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
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
