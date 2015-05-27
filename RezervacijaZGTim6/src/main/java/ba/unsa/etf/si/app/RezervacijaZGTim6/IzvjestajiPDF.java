package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class IzvjestajiPDF {
	
	public static void main(String[] args)
	{
		IzvjestajiPDF i = new IzvjestajiPDF();
		try {
			i.NapraviIzvjestaj(new Date(), new Date(), 3);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public IzvjestajiPDF() {}
	
	private String getDir()
	{
		String put = "";
		JFileChooser j = new JFileChooser();
		j.setDialogTitle("Izaberite direktorij za čuvanje izvještaja");
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		j.showSaveDialog(null);
		put = j.getSelectedFile().getPath();
		
		return put;
	}
	
	private String vrstaIzvjestaja(Integer i)
	{	
		String s = "XXX";
		if(i.equals(1)) s = "Statistika";
		else if(i.equals(2)) s = "BrojGostijuPoDanima";
		else if(i.equals(3)) s = "BrojRezervacijaPoGostima";
		return s;
	}

	
	
	public void NapraviIzvjestaj(java.util.Date od_, java.util.Date _do, Integer vrsta) throws JRException, SQLException
	{
		
		String s = vrstaIzvjestaja(vrsta);
		
		if(!s.equals("XXX"))
		{
			String put = getDir();
			HashMap parametri = new HashMap();
			java.sql.Date p_datum_od = new java.sql.Date(od_.getTime());
			java.sql.Date p_datum_do = new java.sql.Date(_do.getTime());
			parametri.put("P_DATUM_OD", p_datum_od);//eventualno formatirati datum
			parametri.put("P_DATUM_DO", p_datum_do);
			Date d = new Date();
			InputStream inputstream = (InputStream) ClassLoader.getSystemResourceAsStream(s + ".jrxml");
			JasperReport jr = JasperCompileManager.compileReport(inputstream);
			Connection dbcon = (Connection)DriverManager.getConnection("jdbc:mysql://localhost/restoran", "root", "root");
			JasperPrint jp = JasperFillManager.fillReport(jr, parametri, dbcon);
			JasperExportManager.exportReportToPdfFile(jp, put + "\\" + s + "_" + d.hashCode() + ".pdf"); //dodati da se kreira jedinstven naziv
			JasperViewer.viewReport(jp, false);
			dbcon.close();
		}
	}
	

}	