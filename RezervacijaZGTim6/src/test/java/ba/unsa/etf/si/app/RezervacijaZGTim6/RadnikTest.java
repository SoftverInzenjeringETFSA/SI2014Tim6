package ba.unsa.etf.si.app.RezervacijaZGTim6;


import junit.framework.TestCase;

public class RadnikTest extends TestCase {

	public void testRadnik() {
		Radnik r = new Radnik();
		assertNotNull(r);
	}

	public void testSetJMBG() {
		Radnik r = new Radnik();
		try {
			r.setJMBG("jmbg");
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
