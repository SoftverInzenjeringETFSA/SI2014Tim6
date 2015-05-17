package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gost implements Serializable 
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	String Ime, Prezime;
	String BrojTelefona;
	Boolean VIP;
	
	//Konstruktor bez parametara potreban zbog Serializable
	public Gost() {}
	public Gost(long id,String ime,String prezime,String brojTelefona) throws Exception 
	{
		setBrojTelefona(brojTelefona);
		setID(id);
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
}
