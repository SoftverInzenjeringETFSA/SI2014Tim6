package ba.unsa.etf.si.app.RezervacijaZGTim6;

import junit.framework.TestCase;

public class RestoranTest extends TestCase {

	public void testRestoran() throws Exception
	{
		Restoran r= Restoran.getInstance();
		assertNotNull(r);
		
	}
	
	public void testKorisnikNull()
	{
		try {
			Restoran r= Restoran.getInstance();
			assertNull(r.getKorisnik());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void testKorisnikGoodCredentials()
	{
		try {
			Restoran r= Restoran.getInstance();
			r.DodajKorisnika(1, "sefic", "sifra123");
			assertEquals("sefic",r.getKorisnik().getKorisnickoIme());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
