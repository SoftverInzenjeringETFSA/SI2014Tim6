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
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Rezervacija;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Sto;


public class OkupiranSto{

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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setOkupiranSto(new JFrame());
		getOkupiranSto().setResizable(false);
		getOkupiranSto().setBounds(100, 100, 451, 303);
		getOkupiranSto().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblKlijentKlijentic = new JLabel("Klijent Klijentic");
		lblKlijentKlijentic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTermin = new JLabel("Zauzet od:");
		lblTermin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label = new JLabel("15:00 12/12/2012");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		JLabel lblDoIstekaRezervacije = new JLabel("Proteklo vremena:");
		lblDoIstekaRezervacije.setFont(new Font("Tahoma", Font.BOLD, 13));

		try {
			
			ArrayList<Rezervacija> rezervacije= handler.ListaRezervacija(dateChooser.getDate(), sati, minute);
			
			
			for(Iterator j= rezervacije.iterator(); j.hasNext();)
			{
				Rezervacija r =(Rezervacija)j.next();
				if(r.getIdStola()==clickedTable.getID())
				{
					clickedReservation=r;
				/*	Calendar currentTime= Calendar.getInstance();
					Calendar databaseTime= Calendar.getInstance();
			     		
					Time t = r.getVrijemeRezervacije();
					t.setHours(t.getHours()+r.getTrajanjeRezervacijeMinute()/60);
					//System.out.println("Vrijeme t: "+t.getHours() +"h, "+ t.getMinutes()+"m");
					
					Date d = new Date();
				    Date d1 = r.getDatumRezervacije();
				    //System.out.println("Vrijeme d1: "+ d1.getHours()+"h, "+d1.getMinutes()+"m.");
				    
				    
				    databaseTime.setTime(d1);
				    databaseTime.set(Calendar.HOUR_OF_DAY,t.getHours()+r.getTrajanjeRezervacijeMinute()/60);
				    databaseTime.set(Calendar.MINUTE,t.getMinutes());
				    
				    System.out.println("Baza vrijeme: "+ databaseTime.HOUR_OF_DAY+" sati, "+ databaseTime.MINUTE+"minuta");
				    
				  //  System.out.println("Vrijeme u bazi : sati: "+t.getHours()+", minute: "+t.getMinutes());
					System.out.println("Trenutno vrijeme: sati: "+d.getHours()+", minute: "+d.getMinutes());
					
					Date d3= new Date();
					d3.setTime(databaseTime.getTimeInMillis()-d.getTime());
					
					Calendar differenceTime = Calendar.getInstance();
					differenceTime.setTime(d3);
					
				    System.out.println("Do isteka rezervacije "+ (d3.getHours()-r.getTrajanjeRezervacijeMinute()/60)+"h, "+d3.getMinutes()+"m.");			
				    lblDoIstekaRezervacije = new JLabel("Do isteka rezervacije: " +(d3.getHours()-r.getTrajanjeRezervacijeMinute()/60)+"h, "+ d3.getMinutes()+"m.");
					lbldh= new JLabel(""+d3.getDay()+" dana, "+(d3.getHours()-r.getTrajanjeRezervacijeMinute()/60)+" sati, "+d3.getMinutes()+" minuta.");
				    
				  */  
				}
			}
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				getOkupiranSto().dispose();
				 		 
				
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
		
		JLabel lbldh = new JLabel("1d : 12h : 30m : 45s");
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
