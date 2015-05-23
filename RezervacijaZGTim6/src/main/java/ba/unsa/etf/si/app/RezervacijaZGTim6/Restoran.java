package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class Restoran
{	
	private static volatile Restoran restoran = null;
	ArrayList<Gost> gosti;
	ArrayList<Rezervacija> rezervacije;
	ArrayList<Sto> stolovi;
	ArrayList<Radnik> radnici;
	Korisnik korisnik;
	
	private Restoran() throws Exception
	{
		gosti = new ArrayList<Gost>();
		gosti = Gost.listaGostiju();
		rezervacije = new ArrayList<Rezervacija>();
		rezervacije = Rezervacija.listaRezervacijaDatum(new java.util.Date());
		stolovi = new ArrayList<Sto>();
		stolovi = Sto.listaStolova();
		radnici = new ArrayList<Radnik>();
	}
	
	//Singleton
	public static Restoran getInstance() throws Exception
	{
		if(restoran == null)  restoran = new Restoran();
		return restoran;
	}
	
	public Korisnik getKorisnik()
	{
		return korisnik;
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
	
	public ArrayList<Gost> DajGoste()
	{
		return gosti;
	}
	
	public ArrayList<Sto> DajStolove()
	{
		return stolovi;
	}
	
	public void DodajGosta(String ime, String prezime, String telefon) throws Exception
	{
		Gost g = new Gost(ime, prezime, telefon);
		g.dodajGosta();
		gosti.add(g);
	}
	
	public void DodajRadnika(String ime, String prezime, Date datumZaposlenja, String jmbg, String nazivPosla, String opisPosla, long id) throws Exception
	{
		Radnik r = new Radnik(ime, prezime, datumZaposlenja, jmbg, nazivPosla, opisPosla, id);
		r.dodajRadnika();
		radnici.add(r);
	}
	
	public void NapraviRezervaciju(long idgosta, long idradnika, long idstola ,Integer brojgostiju, String status, Date datum, Time vrijeme, Integer trajanje) throws Exception
	{
		Sto s = new Sto();
		s.ocitajSto(idstola);
		Rezervacija r = new Rezervacija(idgosta, idradnika,idstola, s.getKapacitet(), status, datum, vrijeme, trajanje);
		r.dodajRezervaciju();
		rezervacije.add(r);	
	}
	
	public ArrayList<Rezervacija> ListaRezervacija(java.util.Date datum, Integer sati, Integer minute) throws Exception
	{
		rezervacije = Rezervacija.listaRezervacijaDatum(datum);
		ArrayList<Rezervacija> uOpsegu = new ArrayList<Rezervacija>();
		
		datum.setHours(sati);
		datum.setMinutes(minute);
		datum.setSeconds(0);

		java.util.Date od_ = new java.util.Date();
        java.util.Date _do = new java.util.Date();
        od_ = datum;
        _do = (java.util.Date)od_.clone();
		_do.setHours(sati + 3);

		for (Iterator iterator1 = rezervacije.iterator(); iterator1.hasNext();)
        {
			
           Rezervacija r = (Rezervacija)iterator1.next(); 
        
           java.util.Date od_r = new java.util.Date();
           java.util.Date r_do = new java.util.Date();
           
           od_r = (java.util.Date)datum.clone();
           od_r.setHours(r.getVrijemeRezervacije().getHours());
           od_r.setMinutes(r.getVrijemeRezervacije().getMinutes());
           
           r_do = (java.util.Date)datum.clone();
           r_do.setHours(r.getVrijemeRezervacije().getHours() + r.getTrajanjeRezervacijeMinute() / 60);
           r_do.setMinutes(r.getVrijemeRezervacije().getMinutes() + r.getTrajanjeRezervacijeMinute() % 60);
           
           
           if((od_r.before(od_) && r_do.after(od_)) || (od_r.after(od_) && od_r.before(_do)))
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
