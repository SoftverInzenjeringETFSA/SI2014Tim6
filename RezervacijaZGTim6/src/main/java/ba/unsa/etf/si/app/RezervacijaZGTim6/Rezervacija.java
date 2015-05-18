package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Rezervacija implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	long IdGosta;
	long IdRadnika;
	Integer BrojGostiju;
	String StatusRezervacije;
	Date DatumIVrijemeRezervacije;
	Integer TrajanjeRezervacijeMinute;
	
	//Konstruktori
	public Rezervacija() {}
	public Rezervacija(long id, long idgosta, long idradnika, Integer brojgostiju, String status, Date datumivrijeme, Integer trajanje) throws Exception
	{
		setID(id);
		setIdGosta(idgosta);
		setIdRadnika(idradnika);
		setBrojGostiju(brojgostiju);
		setStatusRezervacije(status);
		setDatumIVrijemeRezervacije(datumivrijeme);
		setTrajanjeRezervacijeMinute(trajanje);
	}
	
	//Geteri
	public long getID() {  return ID;  }
	public long getIdGosta() {  return IdGosta;  }
	public long getIdRadnika() {  return IdRadnika;  }
	public Integer getBrojGostiju() {  return BrojGostiju;  }
	public String getStatusRezervacije() {  return StatusRezervacije;  }
	public Date getDatumIVrijemeRezervacije() {  return DatumIVrijemeRezervacije;  }
	public Integer getTrajanjeRezervacijeMinute() {  return TrajanjeRezervacijeMinute;  }
	
	//Seteri
	public void setID(long iD) {  ID = iD;  }
	public void setIdGosta(long idGosta) {  IdGosta = idGosta;  }
	public void setIdRadnika(long idRadnika) {  IdRadnika = idRadnika;  }
	public void setBrojGostiju(Integer brojGostiju) {  BrojGostiju = brojGostiju;  }
	public void setStatusRezervacije(String statusRezervacije) {  StatusRezervacije = statusRezervacije;  }
	public void setDatumIVrijemeRezervacije(Date datumIVrijemeRezervacije) {  DatumIVrijemeRezervacije = datumIVrijemeRezervacije;  }
	public void setTrajanjeRezervacijeMinute(Integer trajanjeRezervacijeMinute) throws Exception
	{
		if(trajanjeRezervacijeMinute > 1440) throw new Exception("Nemoguce izvrsiti rezervaciju za vise od 24 sata!");
		TrajanjeRezervacijeMinute = trajanjeRezervacijeMinute;  
	}
	
	//DB operations
	public void dodajRezervaciju() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		this.setID(id);
		t.commit();
		session.close();
	}
	
	public void ocitajRezervaciju(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Rezervacija temp = (Rezervacija) session.get(Rezervacija.class, id);
		ID = temp.ID;
		IdGosta = temp.IdGosta;
		IdRadnika = temp.IdRadnika;
		BrojGostiju = temp.BrojGostiju;
		StatusRezervacije = temp.StatusRezervacije;
		DatumIVrijemeRezervacije = temp.DatumIVrijemeRezervacije;
		TrajanjeRezervacijeMinute = temp.TrajanjeRezervacijeMinute;
	}
	@Override
	public String toString() {
		return "Rezervacija [ID=" + ID + ", IdGosta=" + IdGosta
				+ ", IdRadnika=" + IdRadnika + ", BrojGostiju=" + BrojGostiju
				+ ", StatusRezervacije=" + StatusRezervacije
				+ ", DatumIVrijemeRezervacije=" + DatumIVrijemeRezervacije
				+ ", TrajanjeRezervacijeMinute=" + TrajanjeRezervacijeMinute
				+ "]";
	}
	
}
