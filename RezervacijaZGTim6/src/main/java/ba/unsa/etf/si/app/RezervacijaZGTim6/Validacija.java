package ba.unsa.etf.si.app.RezervacijaZGTim6;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JFrame;

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
   
    public boolean validationCriteria(JComponent c, String tip) {
		if(tip.equals("JMBG")) return ValidacijaJMBG( ((JTextField)c).getText());
	    return ValidacijaTekst( ((JTextField)c).getText());
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
	
	// Validacija polja
	public Boolean ValidacijaPolje(String polje)
	{
		return !polje.isEmpty();
	}
	
	// Validacija teksta
	public static final Pattern validTekst= Pattern.compile("/^[a-z ,.'-]+$/i", Pattern.CASE_INSENSITIVE);
	public Boolean ValidacijaTekst(String tekst)
	{
		if(!ValidacijaPolje(tekst)) return false;
		Matcher matcher = validTekst.matcher(tekst);
        return matcher.find();
	}
	
	// Validacija telefon
	// ToDo - Pattern za telefon promijeniti zbog '\'
	public static final Pattern validanTelefon = Pattern.compile("(0\\d{2})\\d{3}-\\d{3}");
	
	/*public Boolean ValidacijaTelefon(String telefon)
	{
		Matcher matcher = validanTelefon.matcher(telefon);
        return matcher.find();
	}*/
	
	public Boolean ValidacijaJMBG(String jmbg) { return true; } // poslije impl

	@Override
	public boolean verify(JComponent input) {
		// TODO Auto-generated method stub
		return false;
	}
}
