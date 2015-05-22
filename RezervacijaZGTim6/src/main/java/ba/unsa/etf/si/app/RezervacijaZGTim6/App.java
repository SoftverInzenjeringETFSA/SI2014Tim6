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
		
<<<<<<< HEAD
	EventQueue.invokeLater(new Runnable() {
=======
			EventQueue.invokeLater(new Runnable() {
>>>>>>> 4b3f6c7b0bc6340c09432a482c3088f3477eb62c
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
<<<<<<< HEAD
	
=======

		
>>>>>>> 4b3f6c7b0bc6340c09432a482c3088f3477eb62c
	} 
	catch (Exception e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
