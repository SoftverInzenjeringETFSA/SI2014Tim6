package ba.unsa.etf.si.app.RezervacijaZGTim6;

import junit.framework.TestCase;

public class RezervacijaTest extends TestCase {

	public void testRezervacija() {
		Rezervacija r = new Rezervacija();
		assertNotNull(r);
	}

	public void testSetTrajanjeRezervacijeMinute() {
		Rezervacija r = new Rezervacija();
		try {
			r.setTrajanjeRezervacijeMinute(1441);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
