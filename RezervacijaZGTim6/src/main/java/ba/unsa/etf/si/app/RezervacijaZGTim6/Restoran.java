package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Restoran
{	
	private static volatile Restoran restoran = null;
	ArrayList<Gost> gosti;//treba new Gosti
	ArrayList<Rezervacija> rezervacije;
	ArrayList<Sto> stolovi;
	ArrayList<ZauzetiSto> rezervisanistolovi;
	Korisnik korisnik;
	
	private Restoran() 
	{
		gosti = new ArrayList<Gost>();
		gosti = Gost.listaGostiju();
		rezervacije = new ArrayList<Rezervacija>();
		stolovi = new ArrayList<Sto>();
		stolovi = Sto.listaStolova();
		rezervisanistolovi = new ArrayList<ZauzetiSto>();
	}
	
	//Singleton
	public static Restoran getInstance()
	{
		if(restoran == null)  restoran = new Restoran();
		return restoran;
	}
	
	
	public boolean PrijavaKorisnika(String username, String password) throws Exception
	{
		korisnik = new Korisnik();
		korisnik.ocitajKorisnka(username);
		if(korisnik.KorisnickoIme == null) return false;
		else return Password.check(password, korisnik.getHashSifre());
	}
	
	public boolean OdjavaKorisnika()
	{
		korisnik = new Korisnik();
		return true;
	}
	
	public void DodajGosta(String ime, String prezime, String telefon) throws Exception
	{
		Gost g = new Gost(ime, prezime, telefon);
		g.dodajGosta();
		gosti.add(g);
	}
	
	public boolean NapraviRezervaciju(Date datumvrijeme, Integer trajanje, Sto s, Gost g, Korisnik k)
	{
		if(SlobodanSto(s, datumvrijeme))
		{
			Rezervacija r = new Rezervacija();
			rezervacije.add(r);
		}
		return false;
	}

	private boolean SlobodanSto(Sto s, Date datumvrijeme)
	{
		
		return false;
	}
	
	public Integer getPristup()
	{
		if(korisnik.KorisnickoIme == null) return -1;
		else return korisnik.getStepenPristupa();
	}
}
