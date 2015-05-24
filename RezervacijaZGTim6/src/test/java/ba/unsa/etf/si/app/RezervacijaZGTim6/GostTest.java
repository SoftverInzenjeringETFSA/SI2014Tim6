package ba.unsa.etf.si.app.RezervacijaZGTim6;

import junit.framework.TestCase;


public class GostTest extends TestCase {

	public void testGostStringStringString() {
		try {
			Gost g = new Gost("Test", "Testic", "061/061-061");
			assertNotNull(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testSetBrojTelefona() {
		try {
			Gost g = new Gost("Test", "Testic", "061061-061");
			fail("Izuzetak nije bacen");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testToString() {
		try {
			Gost g = new Gost("Test", "Testic", "061/061-061");
			assertEquals("Gost [ID=0, Ime=Test, Prezime=Testic, BrojTelefona=061/061-061, VIP=false]", (String)g.toString());
		} catch (Exception e) {
			fail("Bacen izuzetak");
		}
	}

}
