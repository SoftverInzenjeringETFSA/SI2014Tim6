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
        getKlijentiDodavanje().setBounds(100, 100, 624, 427);
        getKlijentiDodavanje().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        
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
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(18)
                            .addComponent(lblNewLabel))
                        .addGroup(groupLayout.createSequentialGroup()
                            .addGap(87)
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addComponent(lblIme)
                                .addComponent(lblPrezime)
                                .addComponent(lblUsername))
                            .addGap(10)
                            .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                                .addGroup(groupLayout.createSequentialGroup()
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
                                    .addPreferredGap(ComponentPlacement.RELATED))
                                .addComponent(chckbxVipKlijent, Alignment.LEADING))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(23))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(22)
                    .addComponent(lblNewLabel)
                    .addGap(64)
                    .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
                        .addComponent(pnlIme, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(textField)
                            .addComponent(lblIme)))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(pnlPrezime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(textField_1)
                            .addComponent(lblPrezime)))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(pnlTelefon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                            .addComponent(textField_2)
                            .addComponent(lblUsername)))
                    .addPreferredGap(ComponentPlacement.UNRELATED)
                    .addComponent(chckbxVipKlijent)
                    .addGap(18)
                    .addComponent(btnSpasi)
                    .addContainerGap(131, Short.MAX_VALUE))
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
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                Radnici f = new Radnici();
                f.getRadnici().setVisible(true);
            }
        });
        btnRadnici.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnRadnici.setBounds(0, 0, 139, 34);
        panel.add(btnRadnici);
        
        JButton btnKlijenti = new JButton("Klijenti");
        btnKlijenti.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Klijenti f = new Klijenti();
                f.getKlijenti().setVisible(true);
            }
        });
        btnKlijenti.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnKlijenti.setBounds(0, 34, 139, 34);
        panel.add(btnKlijenti);
        
        JButton btnIzvjestaji = new JButton("Izvještaji");
        btnIzvjestaji.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Izvjestaji f = new Izvjestaji();
                f.getIzvjestaji().setVisible(true);
            }
        });
        btnIzvjestaji.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnIzvjestaji.setBounds(0, 68, 139, 34);
        panel.add(btnIzvjestaji);
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
