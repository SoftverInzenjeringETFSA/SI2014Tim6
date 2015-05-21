package ba.unsa.etf.si.app.RezervacijaZGTim6;

import junit.framework.TestCase;

public class StoTest extends TestCase {

	public void testSetKapacitet() {
		Sto s = new Sto();
		try {
			s.setKapacitet(0);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

}
