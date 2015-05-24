package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Gost;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Radnik;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;


public class Radnici {

	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private Restoran handler;
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	JLabel lblRadnik = new JLabel("", alImg, SwingConstants.LEFT);
	JLabel lblObrisiIzmijeni = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlRadnik = new JPanel();
	JPanel pnlObrisiIzmijeni = new JPanel();
	private TableRowSorter<TableModel> rowSorter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Radnici window = new Radnici();
					window.getRadnici().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Radnici() {
		initialize();
	}
	
	public Radnici(Restoran r) {
		handler = r;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setRadnici(new JFrame());
		getRadnici().setResizable(false);
		getRadnici().setBounds(100, 100, 624, 427);
		getRadnici().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Pregled radnika");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		JButton btnDodaj = new JButton("Dodaj radnika");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getRadnici().dispose();
				RadniciDodavanje f = new RadniciDodavanje();
				f.getRadniciDodavanje().setVisible(true);
			}
		});
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDodaj.setIcon(new ImageIcon("C:\\Users\\LavaGolem\\Downloads\\1430011244_678092-sign-add-16.png"));
		
		JLabel lblIme = new JLabel("Ime: ");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setColumns(10);
		
				
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LavaGolem\\Downloads\\1430011618_698627-icon-111-search-16.png"));
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(180, 180, 180), null, SystemColor.activeCaptionBorder, null));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setForeground(Color.BLACK);
		
		DefaultTableModel tableModel = new DefaultTableModel(new String[] {
				"ID", "Ime", "Prezime", "Naziv posla", "Datum zaposlenja"
			}, 0){
			private static final long serialVersionUID = 1L;

			@Override
		    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		};
		ArrayList<Radnik> radnici;
		radnici=handler.DajRadnike();
		
		
		for (Iterator iterator1 = radnici.iterator(); iterator1.hasNext();)
        {
           Radnik r = (Radnik)iterator1.next(); 
           long idRadnika = r.getId();
           String Ime = r.getIme();
           String Prezime = r.getPrezime();
           String posao = r.getNazivPosla(); 
           String datumZap = r.getDatumZaposlenja().toLocaleString();
           
           Object[] data = {idRadnika, Ime, Prezime, posao, datumZap};
           System.out.println(r);
           tableModel.addRow(data);
        }
		
		table.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		rowSorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(rowSorter);
		
		JButton btnPretrazi = new JButton("Pretraži");
		btnPretrazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 boolean validna_forma = true;
	                
	                // validacija
	                if (!ValidacijaImePrezime(textField.getText())) {
	                    lblRadnik.setText("Nedozvoljen format!");
	                    pnlRadnik.setVisible(true);
	                    validna_forma = false;
	                }
	                else { 
	                    lblRadnik.setText("");
	                    pnlRadnik.setVisible(false);
	                    validna_forma = true;
	                }
	                
	                try {
	                    if(validna_forma) {
	                    	String text = textField.getText();

	                        if (text.trim().length() == 0) {
	                            rowSorter.setRowFilter(null);
	                        } else {
	                            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
	                        }
	                    }
	                } catch (Exception e1) {
	                    e1.printStackTrace();
	                }
	                
	                if (validna_forma) {
	                    System.out.println("Validna forma");
	                } else
	                    System.out.println("Nevalidna forma");               
	            }
			
		});
		
		JButton btnIzmjeni = new JButton("Izmijeni");
		btnIzmjeni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// kad se doda logika za Izmijeni i Obrisi, dodat cemo pojavu errora za sl da se ne moze to izvrsiti
			}
		});
		
		JButton btnObrisi = new JButton("Obriši");
		btnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRowCount() == 1){
					long idRadnika = Long.parseLong(table.getValueAt(table.getSelectedRow(), 0).toString());
					ArrayList<Radnik> radnici = handler.DajRadnike();
					 Radnik r = new Radnik();
					for (Iterator iterator1 = radnici.iterator(); iterator1.hasNext();)
			        {
			          Radnik temp = (Radnik)iterator1.next(); 
			           if(temp.getId() == idRadnika)
						r = temp;
			        }
					try {
						handler.obrisiRadnika(r);
						((DefaultTableModel) table.getModel()).removeRow(table.getSelectedRow());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnDodajKorisnika = new JButton("Dodaj korisnika");
		btnDodajKorisnika.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeKorisnika dk = new DodavanjeKorisnika(handler);
				dk.getDodavanjeKorisnika().setVisible(true);
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getRadnici().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel, Alignment.LEADING)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(pnlObrisiIzmijeni, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnObrisi, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addGap(9)
											.addComponent(btnIzmjeni)))
									.addComponent(btnDodajKorisnika)
									.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblIme)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pnlRadnik, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
										.addComponent(btnPretrazi))))))
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDodajKorisnika)
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIme)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPretrazi))
							.addGap(2)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnlRadnik, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIzmjeni)
						.addComponent(btnObrisi))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(pnlObrisiIzmijeni, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addGap(25))
		);
		
		lblObrisiIzmijeni.setForeground(Color.RED);
		pnlObrisiIzmijeni.add(lblObrisiIzmijeni);
		pnlObrisiIzmijeni.setVisible(false);
		
		lblRadnik.setForeground(Color.RED);
		pnlRadnik.add(lblRadnik);
		panel.setLayout(null);
		pnlRadnik.setVisible(false);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen();
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		btnOdjava.setBackground(UIManager.getColor("Button.background"));
		btnOdjava.setBounds(10, 328, 119, 23);
		panel.add(btnOdjava);
		
		JButton btnRadnici = new JButton("Radnici");
		btnRadnici.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRadnici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRadnici.setBounds(0, 0, 139, 34);
		panel.add(btnRadnici);
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKlijenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Klijenti f = new Klijenti(handler);
				f.getKlijenti().setVisible(true);
			}
		});
		btnKlijenti.setBounds(0, 34, 139, 34);
		panel.add(btnKlijenti);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Izvjestaji f = new Izvjestaji();
				f.getIzvjestaji().setVisible(true);
			}
		});
		btnIzvjestaji.setBounds(0, 68, 139, 34);
		panel.add(btnIzvjestaji);
		getRadnici().getContentPane().setLayout(groupLayout);
	}

	public JFrame getRadnici() {
		return frame;
	}

	public void setRadnici(JFrame frame) {
		this.frame = frame;
	}
	
	public Boolean ValidacijaImePrezime(String user) {
        return user.matches("^[a-zA-Z\u0161\u0111\u010D\u0107\u017E ]*");
    }
}
