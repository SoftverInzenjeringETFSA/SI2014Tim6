package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
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
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Sto;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Gost;

import java.sql.Time;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
    private Sto sto;
    private TableRowSorter<TableModel> rowSorter;
    private JSpinner spinner;
    
    
    ImageIcon alImg = new ImageIcon("Slike/alert.png");
    JLabel lblRezervacija = new JLabel("", alImg, SwingConstants.LEFT);
    JPanel pnlRezervacija = new JPanel();
    
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
		handler = r;
		initialize();
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setNapraviRezervaciju(new JFrame());
		getNapraviRezervaciju().setResizable(false);
		getNapraviRezervaciju().setBounds(100, 100, 624, 470);
		getNapraviRezervaciju().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		if(clickedTableNumber==null)
			reservationText = new JLabel("Napravi rezervaciju");
		else
			reservationText=new JLabel("Napravi rezervaciju za stol "+ clickedTableNumber);
		
		reservationText.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		JButton btnDodajKl = new JButton("Dodaj klijenta");
		btnDodajKl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DodavanjeKlijentaRadnik f = new DodavanjeKlijentaRadnik(handler);
				f.getDodavanjeKlijentaRadnik().setVisible(true);
			}
		});
		btnDodajKl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		JPanel pnlButton = new JPanel();
		JPanel pnlSpace = new JPanel();
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnDodajRezervaciju = new JButton("Dodaj rezervaciju");
		btnDodajRezervaciju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validna_forma = true, VIP = true;
				//Ovdje slijedi logika za dodavanje rezervacije u bazu podataka, te ako je uspjesna rezervacija, da putem
				//referenci za button i panel promijenit boju stola koji je kliknut
				if (table.getSelectedRow() == -1)
					validna_forma= false;
				
				if(validna_forma)
				{
			
					long idGosta = Long.parseLong(table.getValueAt(table.getSelectedRow(), 0).toString());
					Time vrijeme = new Time(hours, minutes, 0);
					Integer trajanje = (Integer)spinner.getValue();
					Long ms = date.getDate().getTime();
					java.sql.Date sqldate = new java.sql.Date(ms);
					Gost g = new Gost();
				
					try {
						g.ocitajGosta(idGosta);
						if(trajanje == 0) trajanje = 180;
						if(idGosta != 0 && trajanje < 1440 && table.getSelectedRowCount() == 1){
							if(!g.getVIP() && sto.getVIP()){
								System.out.println("Ne moze obicni klijent rezervisati VIP sto");
								//logika za error providere
								lblRezervacija.setText("Nije VIP klijent");
								pnlRezervacija.setVisible(true);
								VIP = false;
							}
							else{
								handler.NapraviRezervaciju(idGosta, handler.getKorisnik().getID(), sto.getID(), 
										sto.getKapacitet(), "REZERVISANO", sqldate, vrijeme, trajanje*60);
								prikazStolovaButton.setBackground(Color.red);
								prikazStolovaPanel.revalidate();
								prikazStolovaPanel.repaint();
							}
							
						}

					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();

					}
					if (VIP)
						getNapraviRezervaciju().dispose();
				}

				else
				{
					System.out.println("odaberite klijenta");	
					lblRezervacija.setText("Odaberite klijenta");
					pnlRezervacija.setVisible(true);
				}
			}
		});
		btnDodajRezervaciju.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTrajanje = new JLabel("Trajanje: ");
		lblTrajanje.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		SpinnerModel sm = new SpinnerNumberModel(1,1,5,1);
		spinner = new JSpinner(sm);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		((JSpinner.DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
		
		
		
		groupLayout = new GroupLayout(getNapraviRezervaciju().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKlijent, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addComponent(pnlSpace, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
							.addComponent(pnlButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 281, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner, 5, 50, 150)
						.addComponent(lblTrajanje)
						//.addComponent(pnlTrajanje, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDodajRezervaciju)
						.addComponent(pnlRezervacija, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED))
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
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))
						.addComponent(lblKlijent, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlSpace, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnlButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTrajanje)
					.addComponent(spinner, 5, 20, 20)
					//.addComponent(pnlTrajanje, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(15)
					.addComponent(btnDodajRezervaciju)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
					.addComponent(pnlRezervacija, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
        lblRezervacija.setForeground(Color.RED);
        lblRezervacija.setFont(new Font("Tahoma", Font.PLAIN, 13));
        pnlRezervacija.add(lblRezervacija);
        pnlRezervacija.setVisible(false);
		
		//RAD SA TABELOM I PRETRAGA KORISNIKA
		DefaultTableModel tableModel = new DefaultTableModel(new String[] {
				"ID", "Ime", "Prezime", "Br. telefona", "VIP"
			}, 0){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		ArrayList<Gost> gosti;
		gosti=handler.DajGoste();
		
		
		for (Iterator iterator1 = gosti.iterator(); iterator1.hasNext();)
        {
           Gost g = (Gost)iterator1.next(); 
           long idGosta = g.getID();
           String Ime = g.getIme();
           String Prezime = g.getPrezime();
           String BrTel = g.getBrojTelefona(); 
           Boolean IsVip = g.getVIP();
           String Vip;
           if (IsVip){
        	   Vip="DA";
           }
           else{ Vip="NE"; }
           
           Object[] data = {idGosta, Ime, Prezime, BrTel, Vip};
           tableModel.addRow(data);
        }
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(180, 180, 180), null, SystemColor.activeCaptionBorder, null));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setForeground(Color.BLACK);
		
		table.setModel(tableModel);

		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JLabel lblIme = new JLabel("Pretraga: ");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");		
		
		rowSorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(rowSorter);
		
		JButton btnPretrazi = new JButton("Pretraži");
		btnPretrazi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnPretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
			}
		});	
		//KRAJ RADA SA TABELOM I PRETRAGOM KORISNIKA

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		GroupLayout button_panel = new GroupLayout(pnlButton);
		GroupLayout space_panel = new GroupLayout(pnlSpace);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(165)
							.addComponent(lblNewLabel_1))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblIme)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel_1.createSequentialGroup()
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
						.addComponent(btnPretrazi))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(null);
		pnlButton.setLayout(null);
		pnlSpace.setLayout(null);
		btnDodajKl.setBounds(0, 0, 120, 30);
		pnlButton.add(btnDodajKl);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		getNapraviRezervaciju().getContentPane().setLayout(groupLayout);
	}

	public JFrame getNapraviRezervaciju() {
		return frame;
	}
	public void setNapraviRezervaciju(JFrame frame) {
		this.frame = frame;
	}
	public void showWindow(Restoran r, int tableNumber, JButton button, JPanel panel, JDateChooser date, Integer sati, Integer minute,Sto sto)
	{
		System.out.println("Stol "+tableNumber);
		this.prikazStolovaButton=button;
		this.prikazStolovaPanel=panel;
		this.date=date;
		this.hours=sati;
		clickedTableNumber=tableNumber;
		this.minutes=minute;
		this.sto=sto;
		this.handler = r;
	
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
