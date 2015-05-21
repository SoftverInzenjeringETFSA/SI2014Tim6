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
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;

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

import javax.swing.JList;


public class RezervacijaRadnik {

	private JFrame frame;
	private JPanel panel_1;

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
		
		JList list = new JList();
		list.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnOsvjei = new JButton("Osvježi");
		btnOsvjei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				loadButtons();
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getRezervacijaRadnik().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
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
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
									.addComponent(btnOsvjei)
									.addGap(10)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPromjeniDan)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnOsvjei))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
					.addContainerGap())
		);
		/*GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 451, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 299, Short.MAX_VALUE)
		);*/
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
		btnOdjava.setBounds(10, 335, 119, 23);
		panel.add(btnOdjava);
		
		JButton btnRezervacije = new JButton("Rezervacije");
		btnRezervacije.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				NapraviRezervaciju f = new NapraviRezervaciju();
				f.getNapraviRezervaciju().setVisible(true);
			}
		});
		btnRezervacije.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRezervacije.setBounds(0, 0, 139, 34);
		panel.add(btnRezervacije);
		
		JButton btnKlijenti = new JButton("Klijenti");
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
		
		panel_1.removeAll(); // da ukloni postojece stolove, ako ih ima
		
		JPanel panelOrdinaryTables= new JPanel();
		panelOrdinaryTables.setLayout(new FlowLayout());
		panelOrdinaryTables.setBackground(Color.LIGHT_GRAY);
		for(int i=0;i<50;i++)
		{
			JButton b = new JButton("" +(i+1));
			b.setBackground(Color.red);
			b.setPreferredSize(new Dimension(70, 60));
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JButton button = (JButton)e.getSource();
					Color background= button.getBackground();
					int number= Integer.parseInt(button.getText());
					//button.setBackground(Color.green);
					if(background==Color.red)
					{
						
					 OkupiranSto sto= new OkupiranSto();
						sto.showWindow(number,button, panel_1);
					}
					else if(background==Color.green)
					{
						
					}
					
				}
				
			});
			panelOrdinaryTables.add(b);
			
		}
		panelOrdinaryTables.setBorder(BorderFactory.createEmptyBorder(10, 10, 200, 10));
		
		panel_1.add(panelOrdinaryTables);
		
		
		JPanel panelVipTables= new JPanel();
		panelVipTables.setLayout(new FlowLayout());
		panelVipTables.setBackground(Color.LIGHT_GRAY);
		//panel_1.add(panel2);
		
		for(int i=0;i<10;i++)
		{
			JButton b = new JButton("" +(i+1));
			b.setBackground(Color.red);
			b.setPreferredSize(new Dimension(70, 60));
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JButton button = (JButton)e.getSource();
					Color background= button.getBackground();
					int number= Integer.parseInt(button.getText());
					//button.setBackground(Color.green);
					if(background==Color.red)
					{
						
					 OkupiranSto sto= new OkupiranSto();
						sto.showWindow(number,button, panel_1);
					}
					else if(background==Color.green)
					{
						
					}
					//panel.revalidate();
				}
				
			});
			panelVipTables.add(b);
		}
		
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
