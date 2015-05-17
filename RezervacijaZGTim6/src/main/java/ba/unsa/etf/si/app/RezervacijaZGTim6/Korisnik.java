package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;

public class Korisnik implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	long IdRadnika;
	String KorisnickoIme, HashSifre;
	Integer StepenPristupa;
	
	//Konstruktori
	public Korisnik() {}
	public Korisnik(long id, long idradnika, String korisnickoime, String hashsifre, Integer stepenpristupa) 
	{
		setID(id);
		setIdRadnika(idradnika);
		setHashSifre(hashsifre);
		setKorisnickoIme(korisnickoime);
		setStepenPristupa(stepenpristupa);
	}
	
	//Geteri
	public long getID() {  return ID;  }
	public long getIdRadnika() {  return IdRadnika;  }
	public String getHashSifre() {  return HashSifre;  }
	public String getKorisnickoIme() {  return KorisnickoIme;  }
	public Integer getStepenPristupa() {  return StepenPristupa;  }	
	
	//Seteri
	public void setID(long iD) {  ID = iD;  }
	public void setIdRadnika(long idRadnika) {  IdRadnika = idRadnika;  }
	//zabraniti
	public void setHashSifre(String hashSifre) {  HashSifre = hashSifre;  }
	public void setKorisnickoIme(String korisnickoIme) {  KorisnickoIme = korisnickoIme;  }
	public void setStepenPristupa(Integer stepenPristupa) {  StepenPristupa = stepenPristupa;  }

}
