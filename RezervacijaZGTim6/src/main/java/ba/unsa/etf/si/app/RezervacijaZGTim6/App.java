package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.util.Scanner;

import org.hibernate.Transaction;
import org.hibernate.Session;

public class App {
	
public static void main(String[] args)
{
	Gost g = new Gost();
	try {
		g.ocitajGosta(1);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(g);
}

}
