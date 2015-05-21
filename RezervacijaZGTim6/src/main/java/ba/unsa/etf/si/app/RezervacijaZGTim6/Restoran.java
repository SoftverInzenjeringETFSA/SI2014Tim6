package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Restoran
{	
	private static volatile Restoran restoran = null;
	ArrayList<Gost> gosti;
	ArrayList<Rezervacija> rezervacije;
	ArrayList<Sto> stolovi;
	Korisnik korisnik;
	
	private Restoran() 
	{
		gosti = new ArrayList<Gost>();
		gosti = Gost.listaGostiju();
		rezervacije = new ArrayList<Rezervacija>();
		try {
			rezervacije = Rezervacija.listaRezervacijaDatum(new java.util.Date());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stolovi = new ArrayList<Sto>();
		stolovi = Sto.listaStolova();
		/*for (Iterator iterator1 = rezervacije.iterator(); iterator1.hasNext();)
        {
         x  System.out.println(iterator1.next()); 
        }*/
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
	
	public ArrayList<Rezervacija> ListaRezervacija(java.util.Date datum, Integer sati, Integer minute) throws Exception
	{
		rezervacije = Rezervacija.listaRezervacijaDatum(datum);
		ArrayList<Rezervacija> uOpsegu = new ArrayList<Rezervacija>();
		
		datum.setHours(sati);
		datum.setMinutes(minute);
		datum.setSeconds(0);
		
		for (Iterator iterator1 = rezervacije.iterator(); iterator1.hasNext();)
        {
           Rezervacija r = (Rezervacija)iterator1.next(); 
           java.util.Date od_ = new java.util.Date();
           java.util.Date _do = new java.util.Date();
           od_ = datum;
           _do = datum;
           
			od_.setHours(r.getVrijemeRezervacije().getHours());
			od_.setMinutes(r.getVrijemeRezervacije().getMinutes());
			od_.setSeconds(0);
			
			_do.setHours(r.getVrijemeRezervacije().getHours() + r.getTrajanjeRezervacijeMinute()/60);
			_do.setMinutes(r.getVrijemeRezervacije().getMinutes()+ r.getTrajanjeRezervacijeMinute()%60);
			_do.setSeconds(0);
           
           if(od_.before(datum) && _do.after(datum))
           {
        	   uOpsegu.add(r);
           }
        }	
		return uOpsegu;
	}

	
	public Integer getPristup()
	{
		if(korisnik.KorisnickoIme == null) return -1;
		else return korisnik.getStepenPristupa();
	}
}
