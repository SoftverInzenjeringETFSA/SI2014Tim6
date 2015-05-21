package ba.unsa.etf.si.app.RezervacijaZGTim6;

import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Validacija {
	
	public boolean textboxEmpty(JTextField t)
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
	}

}
