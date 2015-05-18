package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class LogKorisnik implements Serializable 
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	long IdRadnika;
	Date Pristup, Odjava;
	Integer OtvoreneRezervacije, ZatvoreneRezervacije, EvidentiranihGostiju;
	
	
	//Geteri
	public long getID() {  return ID;  }
	public Date getOdjava() {  return Odjava;  }
	public Date getPristup() {  return Pristup;  }
	public long getIdRadnika() {  return IdRadnika;  }
	public Integer getOtvoreneRezervacije() {  return OtvoreneRezervacije;  }
	public Integer getZatvoreneRezervacije() {  return ZatvoreneRezervacije;  }
	public Integer getEvidentiranihGostiju() {  return EvidentiranihGostiju;  }
	
	//Seteri
	public void setID(long iD) {  ID = iD;  }
	public void setOdjava(Date odjava) {  Odjava = odjava;  }
	public void setPristup(Date pristup) {  Pristup = pristup;  }
	public void setIdRadnika(long idRadnika) { IdRadnika = idRadnika;  }
	public void setOtvoreneRezervacije(Integer otvoreneRezervacije) {  OtvoreneRezervacije = otvoreneRezervacije;  }
	public void setZatvoreneRezervacije(Integer zatvoreneRezervacije) {  ZatvoreneRezervacije = zatvoreneRezervacije;  }
	public void setEvidentiranihGostiju(Integer evidentiranihGostiju) {  EvidentiranihGostiju = evidentiranihGostiju;  }
	
	//DB operations
	public void dodajLogKorisnika() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		setID(id);
		t.commit();
		session.close();
	}
			
	public void ocitajLogKorisnka(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		LogKorisnik temp = (LogKorisnik) session.get(LogKorisnik.class, id);
		ID = temp.ID;
		IdRadnika = temp.IdRadnika;
		Pristup = temp.Pristup;
		Odjava = temp.Odjava;
		OtvoreneRezervacije = temp.OtvoreneRezervacije;
		ZatvoreneRezervacije = temp.ZatvoreneRezervacije; 
		EvidentiranihGostiju = temp.EvidentiranihGostiju;
		session.close();
	}
	
	@Override
	public String toString() {
		return "LogKorisnik [ID=" + ID + ", IdRadnika=" + IdRadnika
				+ ", Pristup=" + Pristup + ", Odjava=" + Odjava
				+ ", OtvoreneRezervacije=" + OtvoreneRezervacije
				+ ", ZatvoreneRezervacije=" + ZatvoreneRezervacije
				+ ", EvidentiranihGostiju=" + EvidentiranihGostiju + "]";
	}
	
}
