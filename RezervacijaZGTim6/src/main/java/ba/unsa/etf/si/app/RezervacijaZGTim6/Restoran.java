package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.util.Date;
import java.util.Vector;

public class Restoran
{	
	private static volatile Restoran restoran = null;
	Vector<Gost> gosti;
	Vector<Rezervacija> rezervacije;
	Vector<Sto> stolovi;
	Vector<Korisnik> korisnici;
	
	private Restoran() {}
	
	//Singleton
	public static Restoran getInstance()
	{
		if(restoran == null) restoran = new Restoran();
		return restoran;
	}
	
	
	public boolean PrijavaKorisnika(String username, String password) throws Exception
	{
		Korisnik k = new Korisnik();
		//Get from database korisnik with username username
		String hash_u_bazi = null;
		if(Password.check(password, hash_u_bazi)) 
		{
			//Pull trriger for log in DB
			//set parameters for korisnik
			k.setStepenPristupa(null);//obavezno polje
			korisnici.add(k);
			return true;
		}
		return false;
	}
	
	
	public boolean OdjavaKorisnika(Korisnik k) throws Exception
	{
		if(korisnici.contains(k)) 
		{
			korisnici.remove(k);
			return true;
		}
		return false;
	}
	
	
	public void DodajGosta(String ime, String prezime, String telefon)
	{
		Gost g = new Gost();//TODO napravi konstruktor sa tri parametra
		//Upisi u bazu podataka
		//refresh spisak gostiju
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
		//nece biti ovako imacemo klasu rezervisani stolovi;
		//for(Rezervacija r : rezervacije)
		//{
			//Date d1 = r.getDatumIVrijemeRezervacije();
			//Dodaj minute rezervacije
			//Date d2 = r.getDatumIVrijemeRezervacije();
		//}
		return false;
	}
}
