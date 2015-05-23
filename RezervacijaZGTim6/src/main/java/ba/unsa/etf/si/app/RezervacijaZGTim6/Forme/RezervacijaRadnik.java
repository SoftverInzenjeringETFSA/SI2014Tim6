package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import java.awt.List;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JList;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Rezervacija;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Sto;

import com.toedter.calendar.JDateChooser;

import javax.swing.JSpinner;


public class RezervacijaRadnik {

	private JFrame frame;
	private JPanel panel_1;
	private Restoran handler;
	private JSpinner spinner;
	JDateChooser dateChooser;
	private ArrayList<Sto> stolovi;
	private ArrayList<Rezervacija> rezervacije;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervacijaRadnik window = new RezervacijaRadnik();
					window.getRezervacijaRadnik().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RezervacijaRadnik() {
		initialize();
	}
	
	public RezervacijaRadnik(Restoran r) {
		handler = r;
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setRezervacijaRadnik(new JFrame());
		getRezervacijaRadnik().setResizable(false);
		getRezervacijaRadnik().setBounds(100, 100, 624, 427);
		getRezervacijaRadnik().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    frame.setBounds(300, 50, 950, 630);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Pregled stolova");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblPromjeniDan = new JLabel("Promijeni dan:");
		lblPromjeniDan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnOsvjei = new JButton("Osvježi");
		btnOsvjei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loadButtons();
				
				
			}
		});
		
		 dateChooser = new JDateChooser();
		 dateChooser.getJCalendar().setMinSelectableDate(new Date());
		 dateChooser.setDate(new Date());
		 spinner = new JSpinner( new SpinnerDateModel() );
		 JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, "HH:mm");
		 spinner.setEditor(timeEditor);
		 spinner.setValue(new Date()); // will only show the current time
		
		 if ( spinner.getEditor() instanceof JSpinner.DefaultEditor ) {
			   JSpinner.DefaultEditor editor = ( JSpinner.DefaultEditor ) spinner.getEditor();
			   editor.getTextField().setEnabled( true );
			   editor.getTextField().setEditable( false );
			}
		 
		 
		 JLabel lblhhmm = new JLabel("(HH:mm)");
		
		 GroupLayout groupLayout = new GroupLayout(getRezervacijaRadnik().getContentPane());
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
		 			.addGap(18)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 				.addComponent(lblNewLabel)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addPreferredGap(ComponentPlacement.RELATED)
		 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 777, Short.MAX_VALUE)
		 						.addGroup(groupLayout.createSequentialGroup()
		 							.addComponent(lblPromjeniDan)
		 							.addPreferredGap(ComponentPlacement.RELATED)
		 							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
		 							.addGap(18)
		 							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 							.addPreferredGap(ComponentPlacement.RELATED)
		 							.addComponent(lblhhmm)
		 							.addPreferredGap(ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
		 							.addComponent(btnOsvjei)
		 							.addGap(10)))))
		 			.addContainerGap())
		 );
		 groupLayout.setVerticalGroup(
		 	groupLayout.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		 				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addComponent(lblNewLabel)
		 					.addGap(18)
		 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 							.addComponent(lblPromjeniDan)
		 							.addComponent(btnOsvjei))
		 						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		 							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		 							.addComponent(lblhhmm)))
		 					.addGap(18)
		 					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)))
		 			.addContainerGap())
		 );
	
		panel_1.setLayout(new BoxLayout(panel_1,BoxLayout.Y_AXIS));
		panel.setLayout(null);
		
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdjava.setBackground(UIManager.getColor("Button.background"));
		btnOdjava.setBounds(10, 533, 119, 23);
		panel.add(btnOdjava);
		
		JButton btnRezervacije = new JButton("Rezervacije");
		btnRezervacije.setEnabled(false);
		btnRezervacije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRezervacije.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRezervacije.setBounds(0, 0, 139, 34);
		panel.add(btnRezervacije);
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PregledKlijenataRadnik f = new PregledKlijenataRadnik();
				f.getPregledKlijenataRadnik().setVisible(true);
			}
		});
		btnKlijenti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKlijenti.setBounds(0, 34, 139, 34);
		panel.add(btnKlijenti);
		getRezervacijaRadnik().getContentPane().setLayout(groupLayout);
		
		loadButtons();
		
	}
	
	public void loadButtons()
	{
		// Ideja je da se ovdje pozove klasa koja ce iz baze dobaviti stolove kao listu klasa
		//Dalje se na osnovu broja stolova i njihovog stanja dinamicki kreiraju buttoni, text buttona
		// je redni broj stola, a boja se postavlja ovisno od trenutnog stanja stola
		//Ispod je hardcoded primjer
		
		Date d =(Date)spinner.getValue();
		rezervacije = new ArrayList<Rezervacija>();
		stolovi = new ArrayList<Sto>();
	    Integer numberOfTables;
		try
		{
	   
			rezervacije = handler.ListaRezervacija(dateChooser.getDate(),(Integer)d.getHours(), (Integer)d.getMinutes());
		    stolovi= handler.DajStolove();
			
		}catch(Exception e)
		{
		  System.out.println(e.getMessage());	
		}
		JLabel label1 = new JLabel("Obični stolovi");
		JLabel label2 = new JLabel("VIP stolovi");
		label1.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		label2.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		for(Iterator i =rezervacije.iterator();i.hasNext();)
			System.out.println(i.next());
		
		panel_1.removeAll(); // da ukloni postojece stolove, ako ih ima
		

		JPanel panelOrdinaryTables= new JPanel();
		panelOrdinaryTables.setLayout(new FlowLayout());
		panelOrdinaryTables.setBackground(Color.LIGHT_GRAY);
		
		JPanel panelVipTables= new JPanel();
		panelVipTables.setLayout(new FlowLayout());
		panelVipTables.setBackground(Color.LIGHT_GRAY);
				
		
		for(Iterator i =stolovi.iterator();i.hasNext();)
		{
			Sto s = (Sto)i.next();
			String details=null;
			JButton b = new JButton("" +(s.getID()));
			b.setPreferredSize(new Dimension(70, 60));
			for(Iterator j= rezervacije.iterator(); j.hasNext();)
			{
				Rezervacija r =(Rezervacija)j.next();
				if(r.getIdStola()==s.getID())
				{
					if(r.getStatusRezervacije().equals("REZERVISANO"))
						details="REZERVISANO";
					else if(r.getStatusRezervacije().equals("OKUPIRANO"))
						details="OKUPIRANO";
				}
				
			}
			
			if(details==null) b.setBackground(Color.green); // nije nasao rezervaciju za taj stol po proslijedjenim parametrima
			else if(details.equals("REZERVISANO")) b.setBackground(Color.red); // stol je rezervisan
			else b.setBackground(Color.orange); // stol je okupiran
			
			String html =
		            "<html><body>" +
		            "<p>Broj mjesta: " + s.getKapacitet() + "</p>";
		            	
			if(s.getZaPusace())
			b.setToolTipText(html +"<p> Stol za pušače </p> </body> </html>" );
			else 
				b.setToolTipText(html + "<p>Stol za nepušače </p> </body> </html>");
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JButton button = (JButton)e.getSource();
					Color background= button.getBackground();
					int number= Integer.parseInt(button.getText());

					if(background==Color.red)
					{
						
						Date d= (Date)spinner.getValue();
						int sati = (Integer)d.getHours();
						int minute= (Integer)d.getMinutes();
					 RezervisanSto sto= new RezervisanSto();
					 sto.showWindow(handler,number,button, panel_1,dateChooser,sati,minute,stolovi.get(number-1));
					}
					else if(background==Color.green)
					{
						Date d= (Date)spinner.getValue();
						int sati = (Integer)d.getHours();
						int minute= (Integer)d.getMinutes();
						
					   NapraviRezervaciju r = new NapraviRezervaciju(handler);
					   r.showWindow(handler, number, button, panel_1, dateChooser, sati, minute,stolovi.get(number-1)); 
						   
					}
					else if(background==Color.orange)
					{
						OkupiranSto sto = new OkupiranSto();
						sto.showWindow(number, button,panel_1);
						
					}
							
				}
				
			});
			
			if(s.getVIP()) panelVipTables.add(b);
			else panelOrdinaryTables.add(b);
					
		}
		panelOrdinaryTables.setBorder(BorderFactory.createEmptyBorder(10, 10, 250, 10));

		
		panel_1.add(label1);
		panel_1.add(panelOrdinaryTables);
		panel_1.add(label2);
		panel_1.add(panelVipTables);
		
		panel_1.revalidate();
		panel_1.repaint();
		
		
	}
	
	
	

	public JFrame getRezervacijaRadnik() {
		return frame;
	}

	public void setRezervacijaRadnik(JFrame frame) {
		this.frame = frame;
	}
}
