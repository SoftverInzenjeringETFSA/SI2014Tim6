package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.util.Date;

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
	
	public void testDodavanjeGostiju()
	{
		try {
			Restoran r= Restoran.getInstance();
			r.DodajGosta("almin", "halilovic", "012345678");
			assertTrue(r.DajGoste().contains(new Gost("almin","halilovic","012345678")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void testDodavanjeRadnika()
	{
		try {
			Restoran r = Restoran.getInstance();
			r.DodajRadnika("almin", "halilovic", (java.sql.Date) new Date(), "2403993161712", "radnik", "radnik", (long)80);
			assertTrue(r.DajRadnike().contains(new Radnik("almin", "halilovic", (java.sql.Date) new Date(), "2403993161712", "radnik", "radnik", (long)80)));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
