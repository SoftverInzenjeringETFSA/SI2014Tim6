
package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ZauzetiSto implements Serializable
{
	private static final long serialVersionUID = -2723446500566528020L;
	long ID;
	long IdRezervacije;
	long IdStola;
	ZauzetiSto() {}
	
	//Geteri
	public long getID() {  return ID;  }
	public long getIdStola() {  return IdStola;  }
	public long getIdRezervacije() {  return IdRezervacije;  }
	
	//Seteri
	public void setID(long iD) {  ID = iD;  }
	public void setIdStola(long idStola) {  IdStola = idStola;  }
	public void setIdRezervacije(long idRezervacije) {  IdRezervacije = idRezervacije;  }
	
	//DB operations
	public void dodajZauzetiSto() throws Exception 
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		Long id = (Long) session.save(this);
		setID(id);
		t.commit();
		session.close();
	}
		
	public void ocitajZauzetiSto(long id) throws Exception 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		ZauzetiSto temp = (ZauzetiSto) session.get(ZauzetiSto.class, id);
		ID = temp.ID;
		IdRezervacije = temp.IdRezervacije;
		IdStola = temp.IdStola;
		session.close();
	}

}