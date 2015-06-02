package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
import javax.swing.JCheckBox;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Gost;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;


public class PregledKlijenataRadnik {

	final static Logger logger = Logger.getLogger(PregledKlijenataRadnik.class);
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private Restoran handler;
	private DodavanjeKlijentaRadnik k;
	private TableRowSorter<TableModel> rowSorter;
	
	ImageIcon alImg = new ImageIcon("Slike/alert.png");
	JLabel lblIzmijeni = new JLabel("", alImg, SwingConstants.LEFT);
	JPanel pnlIzmijeni = new JPanel();
	
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PregledKlijenataRadnik window = new PregledKlijenataRadnik();
					window.getPregledKlijenataRadnik().setVisible(true);
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
	public PregledKlijenataRadnik() {
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		setPregledKlijenataRadnik(new JFrame());
		getPregledKlijenataRadnik().setResizable(false);
		getPregledKlijenataRadnik().setBounds(100, 100, 473, 390);
		getPregledKlijenataRadnik().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Pregled klijenata");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		JButton btnDodaj = new JButton("Dodaj novog klijenta");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DodavanjeKlijentaRadnik f = new DodavanjeKlijentaRadnik(handler, frame);
				f.getDodavanjeKlijentaRadnik().setVisible(true);
				f.setParent(frame);
				frame.setEnabled(false);
			}
		});
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDodaj.setIcon(new ImageIcon("C:\\Users\\LavaGolem\\Downloads\\1430011244_678092-sign-add-16.png"));
		
		JLabel lblIme = new JLabel("Ime: ");
		lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		textField = new JTextField();
		textField.setColumns(10);
		JLabel lblNewLabel_1 = new JLabel("");	
		
		tableModel = new DefaultTableModel(new String[] {
				"ID", "Ime", "Prezime", "Br Telefona", "VIP"
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
           String Ime = g.getIme();
           String Prezime = g.getPrezime();
           String brTel = g.getBrojTelefona();
           String Vip;
           boolean IsVip = g.getVIP();
           if (IsVip) Vip="DA";
           else Vip="NE";
           long Id = g.getID();
           
           Object[] data = {Id, Ime, Prezime, brTel, Vip};
           System.out.println(data);
           tableModel.addRow(data);
        }
		
		table = new JTable();
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(180, 180, 180), null, SystemColor.activeCaptionBorder, null));
		table.setBackground(SystemColor.inactiveCaptionBorder);
		table.setForeground(Color.BLACK);
	
		table.setModel(tableModel);
		
		scrollPane = new JScrollPane(table);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
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
		
		JButton btnIzmjeni = new JButton("Izmijeni");
		btnIzmjeni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnIzmjeni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validno = true;
				
				if (table.getSelectedRow() == -1)
					validno = false;
				
				if(validno)
				{
					if(table.getSelectedRowCount() == 1)
					{
						System.out.println("Selektovano");
						long idGosta = Long.parseLong(table.getValueAt(table.getSelectedRow(), 0).toString());
						
						System.out.println(idGosta);
						
						Gost g = new Gost();
						try
						{
							g.ocitajGosta(idGosta);
						}
						catch (Exception e1) {
							logger.info(e1.getMessage());
							e1.printStackTrace();
						}
						k = new DodavanjeKlijentaRadnik(g, handler, frame);
						System.out.println("Stigo!");
						k.getDodavanjeKlijentaRadnik().setVisible(true);
						k.setParent(frame);
						frame.setEnabled(false);
					}
					else
						JOptionPane.showMessageDialog(null, "Odaberite samo jednog klijenta");
				}
				else
					JOptionPane.showMessageDialog(null, "Odaberite klijenta");			
			}
		});
		
		JPanel pnlIzmijeni = new JPanel();
		
		
		GroupLayout groupLayout = new GroupLayout(getPregledKlijenataRadnik().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnIzmjeni)
							.addPreferredGap(ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
							.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
							.addGap(26))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(155)
											.addComponent(lblNewLabel_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblIme)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblNewLabel))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btnPretrazi)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(pnlIzmijeni, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 432, 432))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblIme)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
											.addComponent(lblNewLabel))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnPretrazi))
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 432, 432)))
							.addContainerGap(30, Short.MAX_VALUE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIme)
								.addComponent(btnPretrazi))
							.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1))
						.addComponent(pnlIzmijeni, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDodaj)
						.addComponent(btnIzmjeni, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		

		lblIzmijeni.setForeground(Color.RED);
		pnlIzmijeni.add(lblIzmijeni);
		pnlIzmijeni.setVisible(false);
		//panel.setLayout(null);
		
		JButton btnradnici = new JButton("Radnici");
		getPregledKlijenataRadnik().getContentPane().setLayout(groupLayout);
		
	}
	
	public DefaultTableModel getModel(){
		return tableModel;
	}
	
	public JFrame getPregledKlijenataRadnik() {
		return frame;
	}

	public void setPregledKlijenataRadnik(JFrame frame) {
		this.frame = frame;
	}
	
	public void loadClients(){
		
	}
	
	public void showWindow(Restoran handler) {
		
		this.handler=handler;
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					getPregledKlijenataRadnik().setVisible(true);
				} catch (Exception e) {
					logger.info(e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}
}
