package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

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
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;

import java.sql.Time;



import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;


public class NapraviRezervaciju {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private Restoran handler;
	private JButton prikazStolovaButton;
	private JPanel prikazStolovaPanel;
	private JLabel reservationText;
	private Integer clickedTableNumber; // broj kliknutog stola na formi RezervacijaRadnik
    private GroupLayout groupLayout; // glavni grupni layout
    private JDateChooser date;
    private Integer hours;
    private Integer minutes;
    private boolean isVipTable;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NapraviRezervaciju window = new NapraviRezervaciju();
					window.getNapraviRezervaciju().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NapraviRezervaciju() {
		initialize();
	}
	
	public NapraviRezervaciju(Restoran r) {
		initialize();
		handler = r;

	}
	
	private void PopuniTabeluKorisnika()
	{
		String col[] = {"Pos","Team","P", "W", "L", "D", "MP", "GF", "GA", "GD"};

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		                                            // The 0 argument is number rows.

		JTable table = new JTable(tableModel);
/*
		for (int i = 0; i < originalLeagueList.size(); i++){
			   int position = originalLeagueList.get(i).getPosition();
			   String name = originalLeagueList.get(i).getName();
			   int points = originalLeagueList.get(i).getPoinst();
			   int wins = originalLeagueList.get(i).getWins();
			   int defeats = originalLeagueList.get(i).getDefeats();
			   int draws = originalLeagueList.get(i).getDraws();
			   int totalMatches = originalLeagueList.get(i).getTotalMathces();
			   int goalF = originalLeagueList.get(i).getGoalF();
			   int goalA = originalLeagueList.get(i).getGoalA();
			   in ttgoalD = originalLeagueList.get(i).getTtgoalD();

			   Object[] data = {position, name, points, wins, defeats, draws, 
			                               totalMatches, goalF, goalA, ttgoalD};

			   tableModel.add(data);

			}*/
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setNapraviRezervaciju(new JFrame());
		getNapraviRezervaciju().setResizable(false);
		getNapraviRezervaciju().setBounds(100, 100, 624, 427);
		getNapraviRezervaciju().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		if(clickedTableNumber==null)
		 reservationText = new JLabel("Napravi rezervaciju");
		else
			reservationText=new JLabel("Napravi rezervaciju za stol "+ clickedTableNumber);
		
		reservationText.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		/*
		JLabel lblVrijeme = new JLabel("Vrijeme:");
		lblVrijeme.setFont(new Font("Tahoma", Font.BOLD, 14));
		*/
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnDodajRezervaciju = new JButton("Dodaj rezervaciju");
		btnDodajRezervaciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getNapraviRezervaciju().dispose();
			    
				//Ovdje slijedi logika za dodavanje rezervacije u bazu podataka, te ako je uspjesna rezervacija, da putem
				//referenci za button i panel promijenit boju stola koji je kliknut
				
				
				
				
				prikazStolovaButton.setBackground(Color.red);
				prikazStolovaPanel.revalidate();
				prikazStolovaPanel.repaint();
				
				
			}
		});
		btnDodajRezervaciju.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnDodajKlijenta = new JButton("Dodaj klijenta");
		btnDodajKlijenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodavanjeKlijentaRadnik f = new DodavanjeKlijentaRadnik(handler);
				f.getDodavanjeKlijentaRadnik().setVisible(true);
			}
		});
		btnDodajKlijenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		/*
		Format timeFormat = new SimpleDateFormat("HH:mm:ss");
	
		MaskFormatter mF= new MaskFormatter();
		try {
			 mF = new MaskFormatter("##:##:##");
			mF.setPlaceholderCharacter('_');
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JFormattedTextField formattedTextField = new JFormattedTextField(mF);
		*/
		
		 groupLayout = new GroupLayout(getNapraviRezervaciju().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKlijent, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE)
							.addComponent(btnDodajKlijenta, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDodajRezervaciju)
						.addGroup(groupLayout.createSequentialGroup()
							//.addComponent(lblVrijeme)
							.addPreferredGap(ComponentPlacement.UNRELATED))
							//.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addComponent(reservationText, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(reservationText)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						//.addComponent(lblVrijeme)
						//.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))
						.addComponent(lblKlijent, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDodajKlijenta))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnDodajRezervaciju)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(180, 180, 180), null, SystemColor.activeCaptionBorder, null));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setForeground(Color.LIGHT_GRAY);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		JLabel lblIme = new JLabel("Ime: ");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LavaGolem\\Downloads\\1430011618_698627-icon-111-search-16.png"));
		
		JCheckBox chckbxVipKlijenti = new JCheckBox("VIP klijenti");
		chckbxVipKlijenti.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnPretrazi = new JButton("Pretraži");
		btnPretrazi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(165)
							.addComponent(lblNewLabel_1))
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIme)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(6)
								.addComponent(chckbxVipKlijenti)
								.addGap(6)
								.addComponent(btnPretrazi))))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIme)
						.addComponent(chckbxVipKlijenti)
						.addComponent(btnPretrazi))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(null);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		/*
		btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdjava.setBackground(UIManager.getColor("Button.background"));
		btnOdjava.setBounds(10, 336, 119, 23);
		panel.add(btnOdjava);
		
		
		JButton btnRadnici = new JButton("Rezervacije");
		btnRadnici.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRadnici.setBounds(0, 0, 139, 34);
		panel.add(btnRadnici);
		
		
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKlijenti.setBounds(0, 33, 139, 34);
		panel.add(btnKlijenti);
		*/
		getNapraviRezervaciju().getContentPane().setLayout(groupLayout);
		
	}

	public JFrame getNapraviRezervaciju() {
		return frame;
	}

	public void setNapraviRezervaciju(JFrame frame) {
		this.frame = frame;
	}
	
	public void showWindow(int tableNumber,JButton button, JPanel panel,JDateChooser date, Integer sati,Integer minute,boolean isVipTable)
	{
		System.out.println("Stol "+tableNumber);
		this.prikazStolovaButton=button;
		this.prikazStolovaPanel=panel;
		this.date=date;
		this.hours=sati;
		clickedTableNumber=tableNumber;
		this.minutes=minute;
		this.isVipTable=isVipTable;
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					getNapraviRezervaciju().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
