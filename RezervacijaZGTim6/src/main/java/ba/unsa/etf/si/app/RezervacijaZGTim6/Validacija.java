package ba.unsa.etf.si.app.RezervacijaZGTim6;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;
import java.awt.Component;
import java.awt.event.KeyEvent;

public class Validacija extends AbstractValidacija {

	public Validacija(JFrame frame, Component component, String message) {
	    // TODO Auto-generated constructor stub
	    super(frame, component, message);
    }	
	
	public Validacija(JFrame parent, JTextField c, String message) {
        super(parent, c, message);
    }
	
	public Validacija(JFrame parent, JComponent c, String message) {
		super(parent, c, message);
	}	
	
	/*public boolean textboxEmpty(JTextField t)
	{
		if (t.getText().equals(""))
			return false;
		else
			return true;
	}
	
	public boolean passFieldEmpty(JPasswordField p)
	{
		if(p.getPassword().equals(""))
		{
			return false;
		}
		else
			return true;
	}*/
	
	public Boolean ValidacijaPolje(String polje)
	{
		return !polje.isEmpty();
	}
	
	public Boolean ValidacijaTekst(String tekst) {
        return tekst.matches("/^[a-z ,.'-]+$/i");
	}
	
	public Boolean ValidacijaIme(String ime) {
		return ime.matches("^[A-Z]{1}[a-z]{2,}$");
	}
	
	public Boolean ValidacijaPrezime(String prezime) {
		return prezime.matches("^[A-Z]{1}[a-z]{2,}$");
	}
	
	// ToDo - Pattern za telefon promijeniti zbog '\'
	public Boolean ValidacijaTelefon(String telefon) {
		return telefon.matches("(0\\d{2})\\d{3}-\\d{3}");
	}
	
	public Boolean ValidacijaJMBG(String jmbg) { 
		List<Integer> jmbgList = new ArrayList<Integer>();
		for(char ch : jmbg.toCharArray()) {
		    jmbgList.add( Integer.valueOf(String.valueOf(ch)));
		}
		if (jmbgList.size()!= 13)
            return false;
		else {
			Double eval = 0.0;
            for (int i = 0; i < 6; i++)
            {
                eval += (7 - i) * (jmbgList.get(i) + jmbgList.get(i + 6));
            }
            return jmbgList.get(12) == 11 - eval % 11;
		}
	}

	@Override
	public boolean verify(JComponent input) {
		// TODO Auto-generated method stub
		return false;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Boolean ValidacijaDefinition(JComponent c) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
