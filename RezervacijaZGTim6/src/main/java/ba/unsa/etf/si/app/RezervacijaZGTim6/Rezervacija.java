package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Rezervacija implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	long IdGosta;
	long IdRadnika;
	long IdStola;
	Integer BrojGostiju;
	String StatusRezervacije;
	Date DatumRezervacije;
	Time VrijemeRezervacije;
	Integer TrajanjeRezervacijeMinute;
	
	final static Logger logger = Logger.getLogger(Rezervacija.class);
	
	//Konstruktori
	public Rezervacija() {}
	
	public Rezervacija(long id, long idgosta, long idradnika, long idstola ,Integer brojgostiju, String status, Date datum, Time vrijeme, Integer trajanje) throws Exception
	{
		setID(id);
		setIdGosta(idgosta);
		setIdStola(idstola);
		setIdRadnika(idradnika);
		setBrojGostiju(brojgostiju);
		setDatumRezervacije(datum);
		setVrijemeRezervacije(vrijeme);
		setStatusRezervacije(status);
		setTrajanjeRezervacijeMinute(trajanje);
	}
	
	public Rezervacija(long idgosta, long idradnika, long idstola ,Integer brojgostiju, String status, Date datum, Time vrijeme, Integer trajanje) throws Exception
	{
		setIdGosta(idgosta);
		setIdStola(idstola);
		setIdRadnika(idradnika);
		setBrojGostiju(brojgostiju);
		setDatumRezervacije(datum);
		setVrijemeRezervacije(vrijeme);
		setStatusRezervacije(status);
		setTrajanjeRezervacijeMinute(trajanje);
	}
	
	//Geteri
	public long getID() {  return ID;  }
	public long getIdStola() {  return IdStola;  }
	public long getIdGosta() {  return IdGosta;  }
	public long getIdRadnika() {  return IdRadnika;  }
	public Integer getBrojGostiju() {  return BrojGostiju;  }
	public Date getDatumRezervacije() {  return DatumRezervacije;  }
	public Time getVrijemeRezervacije() {  return VrijemeRezervacije;  }
	public String getStatusRezervacije() {  return StatusRezervacije;  }
	public Integer getTrajanjeRezervacijeMinute() {  return TrajanjeRezervacijeMinute;  }

	//Seteri
	public void setID(long iD) {  ID = iD;  }
	public void setIdStola(long idStola) {  IdStola = idStola;  }
	public void setIdGosta(long idGosta) {  IdGosta = idGosta;  }
	public void setIdRadnika(long idRadnika) {  IdRadnika = idRadnika;  }
	public void setBrojGostiju(Integer brojGostiju) {  BrojGostiju = brojGostiju;  }
	public void setDatumRezervacije(Date datumRezervacije) {  DatumRezervacije = datumRezervacije;  }
	public void setStatusRezervacije(String statusRezervacije) {  StatusRezervacije = statusRezervacije;  }
	public void setVrijemeRezervacije(Time vrijemeRezervacije) {  VrijemeRezervacije = vrijemeRezervacije;  }
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
	
	public static ArrayList<Rezervacija> listaRezervacijaDatum(java.util.Date datum) throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		ArrayList<Rezervacija> lista = new ArrayList<Rezervacija>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
		String hql = "FROM Rezervacija R WHERE R.DatumRezervacije = '" + sdf.format(datum) + "'";
		Query query = session.createQuery(hql);
		List rezultati = query.list();
		
		for (Iterator iterator1 = rezultati.iterator(); iterator1.hasNext();)
        {
           Rezervacija r = (Rezervacija)iterator1.next(); 
           lista.add(r);
        }
		
        tx.commit();
		session.close();
		return lista;
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
		DatumRezervacije = temp.DatumRezervacije;
		VrijemeRezervacije = temp.VrijemeRezervacije;
		TrajanjeRezervacijeMinute = temp.TrajanjeRezervacijeMinute;
	}
	public void promijeniStatusRezervacije(long id, String status)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx =null;
		try{
			tx= session.beginTransaction();
			Rezervacija temp = (Rezervacija) session.get(Rezervacija.class, id);
			temp.setStatusRezervacije(status);
			session.update(temp);
			tx.commit();
			System.out.println("Status rezervacije "+ id+ " promijenjen na "+ status);
		}
		catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         logger.info(e.getMessage());
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
		
		
	}
	
	
	@Override
	public String toString() {
		return "Rezervacija [ID=" + ID + ", IdGosta=" + IdGosta
				+ ", IdRadnika=" + IdRadnika + ", BrojGostiju=" + BrojGostiju
				+ ", StatusRezervacije=" + StatusRezervacije
				+ ", DatumRezervacije=" + DatumRezervacije
				+ ", VrijemeRezervacije=" + VrijemeRezervacije
				+ ", TrajanjeRezervacijeMinute=" + TrajanjeRezervacijeMinute
				+ "]";
	}

	
}
