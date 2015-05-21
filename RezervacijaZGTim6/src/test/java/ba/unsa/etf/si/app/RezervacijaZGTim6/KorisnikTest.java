package ba.unsa.etf.si.app.RezervacijaZGTim6;

import junit.framework.TestCase;

public class KorisnikTest extends TestCase {

	public void testKorisnik() {
		Korisnik k = new Korisnik();
		assertNotNull(k);
	}

	public void testKorisnikStringString() {
		
	}

	public void testToString() {
		Korisnik k = new Korisnik(1, "username", "hash", 1);
		assertEquals("Korisnik [ID=0, IdRadnika=1, KorisnickoIme=username, HashSifre=hash, StepenPristupa=1]", k.toString());
	}

}
