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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.border.BevelBorder;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;

import org.apache.tools.ant.types.selectors.modifiedselector.PropertiesfileCache;

import ba.unsa.etf.si.app.RezervacijaZGTim6.IzvjestajiPDF;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;


//import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;

import javax.swing.SwingConstants;



public class Izvjestaji {

	private JFrame frame;
	private Restoran handler;
	JList list_1 = new JList();
	
	
	/**
	 * @wbp.nonvisual location=428,169
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Izvjestaji window = new Izvjestaji();
					window.getIzvjestaji().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Izvjestaji() {
		initialize();
	}
	
	public Izvjestaji(Restoran r) {
		handler = r;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIzvjestaji(new JFrame());
		getIzvjestaji().setResizable(false);
		getIzvjestaji().setBounds(100, 100, 624, 427);
		getIzvjestaji().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
				
		JLabel lblNewLabel = new JLabel("Izvje\u0161taji");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
		
		JLabel lblGenerisatiPo = new JLabel("Generisati izvještaje za:");
		lblGenerisatiPo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblZaMjesec = new JLabel("Period:");
		lblZaMjesec.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		final JDateChooser dateChooser = new JDateChooser();
		
		final JDateChooser dateChooser_1 = new JDateChooser();
		
		final JLabel lblDatumOd = new JLabel("");
		
		ImageIcon errImg = new ImageIcon("Slike/alert.png");
		
		final JLabel lbl_Od = new JLabel("", errImg, SwingConstants.LEFT);
		lbl_Od.setForeground(Color.RED);
		lbl_Od.setFont(new Font("Tahoma", Font.PLAIN, 9));
		final JPanel pnlOd = new JPanel();
		pnlOd.add( lbl_Od, BorderLayout.WEST );
		pnlOd.setVisible(false);
		
		final JLabel lbl_Do = new JLabel("", errImg, SwingConstants.LEFT);
		lbl_Do.setForeground(Color.RED);
		lbl_Do.setFont(new Font("Tahoma", Font.PLAIN, 9));
		final JPanel pnlDo = new JPanel();
		pnlDo.add( lbl_Do, BorderLayout.WEST );
		pnlDo.setVisible(false);
		
		
		
		JButton btnGenerisi = new JButton("Generiši");
		btnGenerisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean validna_forma = true, radioButton_checked = true;
			    //Date date = new Date();
			    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			    Calendar now = Calendar.getInstance();
	            
				java.sql.Date sqldate = null;
				java.sql.Date sqldate_1 = null;
				java.sql.Date MIN_DATUM = java.sql.Date.valueOf("2015-01-01");
				java.sql.Date TODAY_DATE = java.sql.Date.valueOf(dateFormat.format(now.getTime()));
						
				java.util.Date d = dateChooser.getDate();
				java.util.Date dt = dateChooser_1.getDate();
				
				if (d == null && dt == null)
				{
					pnlOd.setVisible(true);
					lbl_Od.setText("Popunite polje!");
					pnlDo.setVisible(true);
					lbl_Do.setText("Popunite polje!");
					validna_forma = false;
				}
				else if (d == null && dt != null)
				{
					pnlDo.setVisible(false);
					sqldate_1 = new java.sql.Date(dt.getTime());
					
					pnlOd.setVisible(true);
					lbl_Od.setText("Popunite polje!");
					validna_forma = false;
					
					if (sqldate_1.before(MIN_DATUM))
					{
						pnlDo.setVisible(true);
						lbl_Do.setText("Nevalidna godina");
						validna_forma = false;
					}
					else
					{
						pnlDo.setVisible(false);
						lbl_Do.setText("");
						//validna_forma = true;
					}
					
					
					if (sqldate_1.after(TODAY_DATE))
					{
						pnlDo.setVisible(true);
						lbl_Do.setText("Budući datum");
						validna_forma = false;
					}
					else
					{
						pnlDo.setVisible(false);
						lbl_Do.setText("");
						//validna_forma = true;
					}	
					
				}
				else if (d != null && dt == null)
				{
					pnlOd.setVisible(false);
					sqldate = new java.sql.Date(d.getTime());
					
					pnlDo.setVisible(true);
					lbl_Do.setText("Popunite polje!");
					validna_forma = false;
					
					if (sqldate.before(MIN_DATUM))
					{
						pnlOd.setVisible(true);
						lbl_Od.setText("Nevalidna godina");
						validna_forma = false;
					}
					else
					{
						pnlOd.setVisible(false);
						lbl_Od.setText("");
						//validna_forma = true;
					}
					
					
					if (sqldate.after(TODAY_DATE))
					{
						pnlOd.setVisible(true);
						lbl_Od.setText("Budući datum");
						validna_forma = false;
					}
					else
					{
						pnlOd.setVisible(false);
						lbl_Od.setText("");
						//validna_forma = true;
					}
					
				}
				else
				{
					pnlOd.setVisible(false);
					sqldate = new java.sql.Date(d.getTime());
					pnlDo.setVisible(false);
					sqldate_1 = new java.sql.Date(dt.getTime());
					
					if (sqldate.before(MIN_DATUM) && sqldate_1.before(MIN_DATUM))
					{
						pnlOd.setVisible(true);
						lbl_Od.setText("Nevalidna godina");
						pnlDo.setVisible(true);
						lbl_Do.setText("Nevalidna godina");
						validna_forma = false;
					}
					else if (sqldate.before(MIN_DATUM) && sqldate_1.after(MIN_DATUM))
					{
						pnlDo.setVisible(false);
						lbl_Do.setText("");
						pnlOd.setVisible(true);
						lbl_Od.setText("Nevalidna godina");
						validna_forma = false;
					}
					else if (sqldate.after(MIN_DATUM) && sqldate_1.before(MIN_DATUM))
					{
						pnlOd.setVisible(false);
						lbl_Od.setText("");
						pnlDo.setVisible(true);
						lbl_Do.setText("Nevalidna godina");
						validna_forma = false;
					}
					else
					{
						if (sqldate.after(TODAY_DATE) && sqldate_1.after(TODAY_DATE) && sqldate.getDate() != TODAY_DATE.getDate() && sqldate_1.getDate() != TODAY_DATE.getDate())
						{
							pnlOd.setVisible(true);
							lbl_Od.setText("Budući datum");
							pnlDo.setVisible(true);
							lbl_Do.setText("Budući datum");
							validna_forma = false;
						}
						else if (sqldate.after(TODAY_DATE) && sqldate.getDate() != TODAY_DATE.getDate())
						{
							pnlDo.setVisible(false);
							lbl_Do.setText("");
							pnlOd.setVisible(true);
							lbl_Od.setText("Budući datum");
							validna_forma = false;
						}
						else if (sqldate_1.after(TODAY_DATE) && sqldate_1.getDate() != TODAY_DATE.getDate())
						{
							pnlOd.setVisible(false);
							lbl_Od.setText("");
							pnlDo.setVisible(true);
							lbl_Do.setText("Budući datum");
							validna_forma = false;
						}
						else
						{
							if (sqldate.getDate() == sqldate_1.getDate())
							{
								pnlDo.setVisible(true);
								lbl_Do.setText("Nevalidan opseg");
								validna_forma = false;
							}
							
							else if(sqldate_1.before(sqldate))
							{
								pnlDo.setVisible(true);
								lbl_Do.setText("Nevalidan opseg");
								validna_forma = false;
							}
							else
							{
								pnlDo.setVisible(false);
								validna_forma = true;
							}
	
						}
					}
				}
				
				
				
				if (validna_forma)
				{
					System.out.println("Validna forma");
	                IzvjestajiPDF p = new IzvjestajiPDF();
	                try{
	                p.NapraviIzvjestaj(d, dt, (Integer)(list_1.getSelectedIndex()+1));
	                }catch(Exception e)
	                {
	                	e.printStackTrace();
	                }
				}
					else
					System.out.println("Nevalidna forma");
			}
		});
		btnGenerisi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		//validacija radioButtona-ButtonGroup

			ButtonGroup bg1 = new ButtonGroup( );
		

				
		JLabel lblOd = new JLabel("Od:");
		lblOd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDo = new JLabel("Do:");
		lblDo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JList list = new JList();
		
		list_1 = new JList();
		list_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Statistika", "Broj gostiju po danima", "Broj rezervacija po gostima"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list_1.setSelectedIndex(0);
		
		
		
		GroupLayout groupLayout = new GroupLayout(getIzvjestaji().getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGenerisatiPo)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
													.addGap(18)
													.addComponent(lblDo)))
											.addGap(2))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addComponent(lblOd)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(50)
											.addComponent(lblZaMjesec))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
											.addGap(4)
											.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(dateChooser, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(dateChooser_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
												.addComponent(btnGenerisi))
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(pnlDo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(pnlOd, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
											.addPreferredGap(ComponentPlacement.RELATED)))))
							.addGap(66))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDatumOd)
							.addGap(210))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNewLabel)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGenerisatiPo)
						.addComponent(lblZaMjesec))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblOd)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pnlOd, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(18)
												.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
											.addComponent(dateChooser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGap(27)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(pnlDo, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
										.addComponent(dateChooser_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblDo)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(list_1, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
							.addGap(27)
							.addComponent(btnGenerisi)
							.addGap(46)
							.addComponent(lblDatumOd)
							.addGap(107))))
		);
		panel.setLayout(null);
		
		JButton btnOdjava = new JButton("Odjavi se");
		btnOdjava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginScreen f = new LoginScreen(handler);
				f.getFrmPrijavaKorisnika().setVisible(true);
			}
		});
		btnOdjava.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdjava.setBackground(UIManager.getColor("Button.background"));
		btnOdjava.setBounds(10, 328, 119, 23);
		panel.add(btnOdjava);
		
		JButton btnRadnici = new JButton("Radnici");
		btnRadnici.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Radnici f = new Radnici(handler);
				f.getRadnici().setVisible(true);
			}
		});
		btnRadnici.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRadnici.setBounds(0, 0, 139, 34);
		panel.add(btnRadnici);
		
		JButton btnKlijenti = new JButton("Klijenti");
		btnKlijenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Klijenti f = new Klijenti(handler);
				f.getKlijenti().setVisible(true);
			}
		});
		btnKlijenti.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnKlijenti.setBounds(0, 34, 139, 34);
		panel.add(btnKlijenti);
		
		JButton btnIzvjestaji = new JButton("Izvještaji");
		btnIzvjestaji.setEnabled(false);
		btnIzvjestaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnIzvjestaji.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIzvjestaji.setBounds(0, 68, 139, 34);
		panel.add(btnIzvjestaji);
		getIzvjestaji().getContentPane().setLayout(groupLayout);
	}
	

	public JFrame getIzvjestaji() {
		return frame;
	}

	public void setIzvjestaji(JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
	}
}
