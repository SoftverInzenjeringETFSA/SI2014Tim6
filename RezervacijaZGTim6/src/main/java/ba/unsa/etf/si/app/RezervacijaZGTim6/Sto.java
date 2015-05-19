package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Sto implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	String OznakaStola;
	Integer Kapacitet;
	String OpisMjesta;
	Boolean ZaPusace, VIP;
	
	//Konstruktori
	public Sto() {}
	public Sto(String oznaka, Integer kapacitet, String opis, Boolean zapusace, Boolean vip) throws Exception 
	{
		setKapacitet(kapacitet);
		setOznakaStola(oznaka);
		setOpisMjesta(opis);
		setZaPusace(zapusace);
		setVIP(vip);
	}
	
	//Geteri
	public long getID() {  return ID;  }
	public Boolean getVIP() {  return VIP;  }
	public Boolean getZaPusace() {  return ZaPusace;  }
	public Integer getKapacitet() {  return Kapacitet;  }
	public String getOpisMjesta() {  return OpisMjesta; }
	public String getOznakaStola() {  return OznakaStola;  }
	
	//Sto
	public void setID(long iD) {  ID = iD;  }
	public void setVIP(Boolean vIP) {  VIP = vIP;  }
	public void setZaPusace(Boolean zaPusace) {  ZaPusace = zaPusace;  }
	public void setKapacitet(Integer kapacitet) throws Exception
	{  
		if(kapacitet < 1) throw new Exception("Kapacitet stola ne moze biti manji od jedan!");
		Kapacitet = kapacitet;  
	}
	public void setOznakaStola(String oznakaStola) { OznakaStola = oznakaStola;  }
	public void setOpisMjesta(String opisMjesta) {  OpisMjesta = opisMjesta;  }
	
	//DB operations
	public void dodajSto() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		setID(id);
		t.commit();
		session.close();
	}
	
	public void ocitajSto(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Sto temp = (Sto) session.get(Sto.class, id);
		ID = temp.ID;
		Kapacitet = temp.Kapacitet;
		OznakaStola = temp.OznakaStola;
		OpisMjesta = temp.OpisMjesta;
		ZaPusace = temp.ZaPusace;
		VIP = temp.VIP;
		session.close();
	}
	
	@Override
	public String toString() {
		return "Sto [ID=" + ID + ", OznakaStola=" + OznakaStola
				+ ", Kapacitet=" + Kapacitet + ", OpisMjesta=" + OpisMjesta
				+ ", ZaPusace=" + ZaPusace + ", VIP=" + VIP + "]";
	}
	
}