package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JButton;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import com.toedter.calendar.JDateChooser;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Gost;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Rezervacija;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Sto;


public class OkupiranSto{
	
	final static Logger logger = Logger.getLogger(OkupiranSto.class);
	private JFrame frame;
	private JButton prikazStolovaButton;
	private JPanel prikazStolovaPanel;
	private Restoran handler;
    private Sto clickedTable;
    private Rezervacija reservation;
	private JDateChooser dateChooser;
    private int sati;
    private int minute;
    JLabel lbldh= new JLabel();
    private Rezervacija clickedReservation;
    JLabel label = new JLabel();
    JLabel lblKlijentKlijentic = new JLabel();
    
    private JFrame parentFrame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OkupiranSto window = new OkupiranSto();
					window.getOkupiranSto().setVisible(true);
				} catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OkupiranSto() {
		initialize();
	}

	
	public void setParent(JFrame f)
	{
		parentFrame=f;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setOkupiranSto(new JFrame());
		getOkupiranSto().setResizable(false);
		getOkupiranSto().setBounds(100, 100, 451, 303);
		getOkupiranSto().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent)
			{
			parentFrame.setEnabled(true);
			parentFrame.setVisible(true);
			}
		});
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setFont(new Font("Tahoma", Font.BOLD, 14));
		
	
		lblKlijentKlijentic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTermin = new JLabel("Zauzet od:");
		lblTermin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		
		JLabel lblDoIstekaRezervacije = new JLabel("Do isteka rezervacije:");
		lblDoIstekaRezervacije.setFont(new Font("Tahoma", Font.BOLD, 13));

try {
			
			ArrayList<Rezervacija> rezervacije= handler.ListaRezervacija(dateChooser.getDate(), sati, minute);
           ArrayList<Gost> gosti= handler.DajGoste();
           Gost gost =null;
			
			for(Iterator j= rezervacije.iterator(); j.hasNext();)
			{
				Rezervacija r =(Rezervacija)j.next();
				if(r.getIdStola()==clickedTable.getID())
				{
					clickedReservation=r;
				}
				}
			
			if(clickedReservation!=null)
			{
				for(Iterator j= gosti.iterator(); j.hasNext();)
				{
					Gost r =(Gost)j.next();
					if(clickedReservation.getIdGosta()==r.getID())
					{
						gost= r;
					}
					}
			}
			
					if(clickedReservation!=null && gost!=null)
					{
					Date date1= new java.util.Date(clickedReservation.getDatumRezervacije().getTime());
					Time time1=clickedReservation.getVrijemeRezervacije();
					
					String myTime= time1.toString();
	                   
					
					time1.setHours(time1.getHours()+clickedReservation.getTrajanjeRezervacijeMinute()/60);
					
                    
					java.util.Date utilDate = new java.util.Date();
					
					java.util.Date utilDate1 =new java.util.Date();
					utilDate1.setYear(clickedReservation.getDatumRezervacije().getYear());
					utilDate1.setMonth(clickedReservation.getDatumRezervacije().getMonth());
					utilDate1.setHours(time1.getHours());
					utilDate1.setMinutes(time1.getMinutes());
				    utilDate1.setDate(clickedReservation.getDatumRezervacije().getDate());
					
					DateTime dateTimeNow = new DateTime(utilDate); 
					DateTime dateTimeDatabase = new DateTime(utilDate1);
					System.out.println("Trenutno: "+dateTimeNow.toString());
					System.out.println("Iz baze: "+dateTimeDatabase.toString());
					
					String datum = dateTimeDatabase.getDayOfMonth()+". "+dateTimeDatabase.getMonthOfYear()+". "+dateTimeDatabase.getYear()+" "+myTime;
					
					label= new JLabel(datum);
					
					Period p= new Period(dateTimeNow,dateTimeDatabase);
					PeriodFormatter daysHoursMinutes = new PeriodFormatterBuilder()
				    .appendDays()
				    .appendSuffix(" dan", " dana")
				    .appendSeparator(" , ")
				    .appendHours()
				    .appendSuffix(" sati"," sati")
				    .appendSeparator(" i ")
				    .appendMinutes()
				    .appendSuffix(" minute", " minuta")
				    .appendSeparator(" i ")
				    .appendSeconds()
				    .appendSuffix(" sekundi", " sekundi")
				    .toFormatter();
					
					System.out.println("Do isteka rezervacije "+daysHoursMinutes.print(p));	
					
					if(dateTimeDatabase.isBefore(dateTimeNow)) lbldh = new JLabel("Rezervacija istekla");
					else
					lbldh = new JLabel(daysHoursMinutes.print(p));
					lblKlijentKlijentic=new JLabel(gost.getIme()+" "+gost.getPrezime());
					}
				
			
			
			
		} catch (Exception e1) {
			logger.info(e1.getMessage());
			e1.printStackTrace();
		}
		
		
		JButton btnOtkaiReyervaciju = new JButton("Oslobo\u0111en sto");
		btnOtkaiReyervaciju.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnOtkaiReyervaciju.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				clickedReservation.setStatusRezervacije("SLOBODNO");
				try {
					ArrayList<Rezervacija> rezervacije= handler.ListaRezervacija(dateChooser.getDate(), sati, minute);
					clickedReservation.setStatusRezervacije("SLOBODNO");
					clickedReservation.promijeniStatusRezervacije(clickedReservation.getID(), "SLOBODNO");
					prikazStolovaButton.setBackground(Color.green);
					prikazStolovaButton.revalidate();
					prikazStolovaButton.repaint();
						
				} catch (Exception e1) {
					logger.info(e1.getMessage());
					e1.printStackTrace();
				}
				
				getOkupiranSto().dispose();
				 		 
				frame.setVisible(false);
				 frame.dispose();
				 parentFrame.setEnabled(true);
			     parentFrame.setVisible(true);
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(getOkupiranSto().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTermin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKlijent)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblKlijentKlijentic)))
					.addContainerGap(220, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(162)
					.addComponent(lblDoIstekaRezervacije)
					.addContainerGap(163, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(120))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addComponent(btnOtkaiReyervaciju)
					.addGap(160))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKlijent)
						.addComponent(lblKlijentKlijentic))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTermin, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(49)
					.addComponent(lblDoIstekaRezervacije)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOtkaiReyervaciju)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		
		lbldh.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(lbldh)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(lbldh)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getOkupiranSto().getContentPane().setLayout(groupLayout);
	}
	
	public void showWindow(Restoran r,int tableNumber,JButton button, JPanel panel,JDateChooser dateChooser,int sati,int minute, Sto s)
	{
		System.out.println("Stol "+tableNumber);
		this.prikazStolovaButton=button;
		this.handler=r;
		this.prikazStolovaPanel=panel;
		this.dateChooser=dateChooser;
		this.sati=sati;
		this.minute=minute;
		this.clickedTable=s;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					getOkupiranSto().setVisible(true);
				} catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	
	}

	public JFrame getOkupiranSto() {
		return frame;
	}

	public void setOkupiranSto(JFrame frame) {
		this.frame = frame;
	}	

}
