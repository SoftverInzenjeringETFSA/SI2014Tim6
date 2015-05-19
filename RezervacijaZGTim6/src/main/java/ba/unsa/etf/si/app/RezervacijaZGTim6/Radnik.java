package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Radnik implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	String Ime, Prezime;
	Date DatumZaposlenja;
	String JMBG;
	String NazivPosla, OpisPosla;
	long Nadredjeni;
	
	//Konstruktori
	public Radnik() {}
	public Radnik(long id, String ime, String prezime, Date datumzaposlenja, String jmbg, String nazivposla, String opisposla, long nadredjeni) throws Exception
	{
		setJMBG(jmbg);
		setId(id);
		setIme(ime);
		setPrezime(prezime);
		setDatumZaposlenja(datumzaposlenja);
		setNazivPosla(nazivposla);
		setOpisPosla(opisposla);
		setNadredjeni(nadredjeni);
	}

	//Geteri
	public long getId() {  return ID;  }
	public String getIme() {  return Ime;  }
	public String getJMBG() {  return JMBG;  }
	public String getPrezime() {  return Prezime;  }
	public String getOpisPosla() {  return OpisPosla;  }
	public long getNadredjeni() {  return Nadredjeni;  }
	public String getNazivPosla() {  return NazivPosla;  }
	public Date getDatumZaposlenja() {  return DatumZaposlenja;  }
	
	//Seteri
	public void setId(long iD) {  ID = iD;  }
	public void setIme(String ime) {  Ime = ime;  }
	public void setJMBG(String jMBG) throws Exception
	{  
		if(jMBG.length() != 13) throw new Exception("Broj znakova JMBG-a mora biti tacno 13");
		Pattern p = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]");
		Matcher m = p.matcher(jMBG);
		if(!m.matches()) throw new Exception("Nije validan format JMBGa!");
		JMBG = jMBG;  
	}
	public void setPrezime(String prezime) {  Prezime = prezime;  }
	public void setOpisPosla(String opisPosla) {  OpisPosla = opisPosla;  }
	public void setNadredjeni(long nadredjeni) {  Nadredjeni = nadredjeni;}	
	public void setNazivPosla(String nazivPosla) {  NazivPosla = nazivPosla;  }
	public void setDatumZaposlenja(Date datumZaposlenja) {  DatumZaposlenja = datumZaposlenja;  }
	
	//DB operations
	public void dodajRadnika() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		this.setId(id);
		t.commit();
		session.close();
	}
	
	public void ocitajRadnika(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Radnik temp = (Radnik) session.get(Radnik.class, id);
		ID = temp.ID;
		Ime = temp.Ime;
		Prezime = temp.Prezime; 
		DatumZaposlenja = temp.DatumZaposlenja;
		JMBG = temp.JMBG;
		NazivPosla = temp.NazivPosla;
		OpisPosla = temp.OpisPosla;
		Nadredjeni = temp.Nadredjeni;
		session.close();
		//System.out.println(this.toString());
	}
}
