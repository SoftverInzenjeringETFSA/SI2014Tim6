package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Gost implements Serializable 
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	String Ime, Prezime;
	String BrojTelefona;
	Boolean VIP;
	
	//Konstruktor bez parametara potreban zbog Serializable
	public Gost() {}
	
	public Gost(String ime,String prezime,String brojTelefona) throws Exception 
	{
		setBrojTelefona(brojTelefona);
		setIme(ime);
		setPrezime(prezime);
	}
	
	//Geteri
	public long getID() {  return ID;  }
	public String getIme() {  return Ime;  }
	public String getPrezime() {  return Prezime;  }
	public String getBrojTelefona() {  return BrojTelefona;  }
	public Boolean getVIP() {  return VIP;  }
	
	//Seteri
	public void setID(long iD) {  ID = iD;  }
	public void setIme(String ime) {  Ime = ime;  }
	public void setPrezime(String prezime) {  Prezime = prezime;  }
	public void setBrojTelefona(String brojTelefona) throws Exception
	{  
		Pattern p = Pattern.compile("[0-9][0-9][0-9]/[0-9][0-9][0-9]-[0-9][0-9][0-9]");
		Matcher m = p.matcher(brojTelefona);
		if(!m.matches()) throw new Exception("Nije validan format broja telefona!");
		BrojTelefona = brojTelefona;  
	}
	public void setVIP(Boolean vIP) {  VIP = vIP;  }	
	
	//DB operations
	public void dodajGosta() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		setID(id);
		t.commit();
		session.close();
	}
	
	public void ocitajGosta(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Gost temp = (Gost) session.get(Gost.class, id);
		ID = temp.ID;
		Ime = temp.Ime;
		Prezime = temp.Prezime; 
		BrojTelefona = temp.BrojTelefona;
		session.close();
	}
	
	public static ArrayList<Gost> listaGostiju()
	{
	      Session session = HibernateUtil.getSessionFactory().openSession();
	      ArrayList<Gost> lista = new ArrayList<Gost>();
	      Transaction tx = null;
	      
	      try{
	         tx = session.beginTransaction();
	         List gosti = session.createQuery("FROM Gost").list(); 
	         for (Iterator iterator1 = gosti.iterator(); iterator1.hasNext();)
	         {
	            Gost gost = (Gost)iterator1.next(); 
	            lista.add(gost);
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	         }
	      return lista;
	 }
	
	@Override
	public String toString() {
		return "Gost [ID=" + ID + ", Ime=" + Ime + ", Prezime=" + Prezime
				+ ", BrojTelefona=" + BrojTelefona + ", VIP=" + VIP + "]";
	}
	
}
