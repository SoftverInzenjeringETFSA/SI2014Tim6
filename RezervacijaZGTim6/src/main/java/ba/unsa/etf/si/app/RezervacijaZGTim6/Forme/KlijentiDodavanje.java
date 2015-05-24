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
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.JCheckBox;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;


public class KlijentiDodavanje {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private Restoran handler;
    

    ImageIcon alImg = new ImageIcon("Slike/alert.png");
    
    JLabel lblIme_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
    JLabel lblPrezime_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
    JLabel lblTelefon_Validacija = new JLabel("", alImg, SwingConstants.LEFT);
    
    JPanel pnlIme = new JPanel();
    JPanel pnlPrezime = new JPanel();
    JPanel pnlTelefon = new JPanel();
    JCheckBox chckbxVipKlijent = new JCheckBox("VIP klijent");

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    KlijentiDodavanje window = new KlijentiDodavanje();
                    window.getKlijentiDodavanje().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public KlijentiDodavanje() {
        initialize();
    }
    
    public KlijentiDodavanje(Restoran r) {
        initialize();
        handler = r;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setKlijentiDodavanje(new JFrame());
        getKlijentiDodavanje().setResizable(false);
        getKlijentiDodavanje().setBounds(100, 100, 471, 342);
        getKlijentiDodavanje().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblNewLabel = new JLabel("A\u017Euriranje / Dodavanje klijenta");
        lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 20));
        
        textField = new JTextField();
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        MaskFormatter mfTel = new MaskFormatter();
        try {
            mfTel = new MaskFormatter("###/###-###");
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        mfTel.setPlaceholderCharacter('_');
        final JFormattedTextField textField_2 = new JFormattedTextField(mfTel);
        
        JLabel lblIme = new JLabel("Ime:");
        lblIme.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JLabel lblPrezime = new JLabel("Prezime:");
        lblPrezime.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JLabel lblUsername = new JLabel("Broj telefona:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        JButton btnSpasi = new JButton("Spasi ");
        btnSpasi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                boolean validna_forma = true;
                
                // validacija
                if (textField.getText().isEmpty()) {
                    lblIme_Validacija.setText("Popunite polje!");
                    pnlIme.setVisible(true);
                    validna_forma = false;
                } else if (!ValidacijaImePrezime(textField.getText())) {
                    lblIme_Validacija.setText("Nedozvoljen format!");
                    pnlIme.setVisible(true);
                    validna_forma = false;
                }
                else { 
                    lblIme_Validacija.setText("");
                    pnlIme.setVisible(false);
                    validna_forma = true;
                }
                
                if (textField_1.getText().isEmpty()) {
                    lblPrezime_Validacija.setText("Popunite polje!");
                    pnlPrezime.setVisible(true);
                    validna_forma = false;
                } else if (!ValidacijaImePrezime(textField_1.getText())) {
                    lblPrezime_Validacija.setText("Nedozvoljen format!");
                    pnlPrezime.setVisible(true);
                    validna_forma = false;
                }
                else { 
                    lblPrezime_Validacija.setText("");
                    pnlPrezime.setVisible(false);
                    validna_forma = true;
                }
                
                if(textField_2.getText().equals("___/___-___")) // telefon
                {
                    lblTelefon_Validacija.setText("Popunite polje!");
                    pnlTelefon.setVisible(true);
                    validna_forma = false;
                }
                else
                {
                    lblTelefon_Validacija.setText("");
                    pnlTelefon.setVisible(false);
                    validna_forma = true;
                }
                
                
                /*try {
                        boolean vipVrijednost = false;
                        
                        if (chckbxVipKlijent.isSelected()) vipVrijednost = true;
                        else vipVrijednost = false;
                        
                        if(validna_forma){
                            handler.DodajGosta(textField.getText(), textField_1.getText(), textField_2.getText());
                        }
                    //handler.DodajGostaSef(textField.getText(), textField_1.getText(), textField_2.getText(), vipVrijednost);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                
                if (validna_forma) {
                    System.out.println("Validna forma");
                    frame.dispose();
                } else
                    System.out.println("Nevalidna forma");
                // zakomentarisano zbog testa validacije
                 */
                
                try {
                    if(validna_forma) {
                        //handler.DodajGosta("Nesto", "Proba", "061/859-785");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                
                if (validna_forma) {
                    System.out.println("Validna forma");
                    frame.dispose();
                } else
                    System.out.println("Nevalidna forma");               
            }
        });
        
        btnSpasi.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        chckbxVipKlijent.setFont(new Font("Tahoma", Font.PLAIN, 13));
        
        GroupLayout groupLayout = new GroupLayout(getKlijentiDodavanje().getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(90)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblIme)
        						.addComponent(lblPrezime)
        						.addComponent(lblUsername))
        					.addGap(10)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        							.addGroup(groupLayout.createSequentialGroup()
        								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        									.addComponent(btnSpasi))
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        									.addComponent(pnlTelefon, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        									.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        							.addGroup(groupLayout.createSequentialGroup()
        								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.UNRELATED)
        								.addComponent(pnlIme, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(chckbxVipKlijent, Alignment.LEADING)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(74)
        					.addComponent(lblNewLabel)))
        			.addContainerGap(97, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel)
        			.addGap(74)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(pnlIme, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblIme)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblPrezime)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(pnlTelefon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblUsername)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(chckbxVipKlijent)
        			.addGap(18)
        			.addComponent(btnSpasi)
        			.addContainerGap(247, Short.MAX_VALUE))
        );
        
        lblTelefon_Validacija.setForeground(Color.RED);
        pnlTelefon.add(lblTelefon_Validacija);
        pnlTelefon.setVisible(false);
        
        lblPrezime_Validacija.setForeground(Color.RED);
        pnlPrezime.add(lblPrezime_Validacija);
        pnlPrezime.setVisible(false);
        
        lblIme_Validacija.setForeground(Color.RED);
        pnlIme.add(lblIme_Validacija);
        pnlIme.setVisible(false);
        getKlijentiDodavanje().getContentPane().setLayout(groupLayout);
    }

    public JFrame getKlijentiDodavanje() {
        return frame;
    }

    public void setKlijentiDodavanje(JFrame frame) {
        this.frame = frame;
    }
    
    public Boolean ValidacijaImePrezime(String user) {
        if (user.length() < 3) return false;
        return user.matches("^[a-zA-Z\u0161\u0111\u010D\u0107\u017E-]+$");
    }
    
}
