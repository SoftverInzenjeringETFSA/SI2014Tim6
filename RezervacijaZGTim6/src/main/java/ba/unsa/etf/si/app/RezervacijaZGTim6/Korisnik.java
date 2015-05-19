package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;


public class Korisnik implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	long IdRadnika;
	String KorisnickoIme, HashSifre;
	Integer StepenPristupa;
	
	//Konstruktori
	public Korisnik() {}
	
	public Korisnik(String user, String pass) throws Exception 
	{
		setHashSifre(Password.getSaltedHash(pass));
		setKorisnickoIme(user);
	}
	
	public Korisnik(long idradnika, String korisnickoime, String hashsifre, Integer stepenpristupa) 
	{
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
	
	//DB operations
	public void dodajKorisnika() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		setID(id);
		t.commit();
		session.close();
	}
		
	public void ocitajKorisnka(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Korisnik temp = (Korisnik) session.get(Korisnik.class, id);
		ID = temp.ID;
		IdRadnika = temp.IdRadnika;
		KorisnickoIme = temp.KorisnickoIme;
		HashSifre = temp.KorisnickoIme;
		StepenPristupa = temp.StepenPristupa;
		session.close();
	}
	
	public void ocitajKorisnka(String user) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		String hql = "FROM Korisnik K WHERE K.KorisnickoIme = :user";
		Query query = session.createQuery(hql);
		query.setParameter("user", user);
		Korisnik temp = (Korisnik)query.uniqueResult();
		
		if(temp != null)
		{
			ID = temp.ID;
			IdRadnika = temp.IdRadnika;
			KorisnickoIme = temp.KorisnickoIme;
			HashSifre = temp.HashSifre;
			StepenPristupa = temp.StepenPristupa;
		}
		
		session.close();
	}
	@Override
	public String toString() {
		return "Korisnik [ID=" + ID + ", IdRadnika=" + IdRadnika
				+ ", KorisnickoIme=" + KorisnickoIme + ", HashSifre="
				+ HashSifre + ", StepenPristupa=" + StepenPristupa + "]";
	}
	
}
