package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ba.unsa.etf.si.app.RezervacijaZGTim6.Radnik;
import ba.unsa.etf.si.app.RezervacijaZGTim6.Restoran;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class AzurirajRadnika {

	private JFrame frame;
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	Radnik handler;
	Restoran res;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JTextPane textPane;
	DefaultListModel<Radnik> lista;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AzurirajRadnika window = new AzurirajRadnika();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public AzurirajRadnika() {
		initialize();
	}
	
	public AzurirajRadnika(Restoran z, Radnik rad, DefaultListModel<Radnik> m) {
		handler = rad;
		res = z;
		lista = m;
		initialize();
		textField.setText(handler.getIme());
		textField_1.setText(handler.getPrezime());
		textField_2.setText(handler.getJMBG());
		textField_3.setText(handler.getNazivPosla());
		textPane.setText(handler.getOpisPosla());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBounds(131, 52, 26, 14);
		frame.getContentPane().add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setBounds(116, 88, 41, 14);
		frame.getContentPane().add(lblPrezime);
		
		JLabel lblNewLabel = new JLabel("JMBG:");
		lblNewLabel.setBounds(123, 119, 34, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNazivPosla = new JLabel("Naziv posla:");
		lblNazivPosla.setBounds(99, 154, 58, 14);
		frame.getContentPane().add(lblNazivPosla);
		
		textField = new JTextField();
		textField.setBounds(167, 49, 185, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(167, 85, 185, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(167, 116, 185, 20);
		frame.getContentPane().add(textField_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(167, 151, 185, 20);
		frame.getContentPane().add(textField_3);
		
		JLabel lblOpisPosla = new JLabel("Opis posla:");
		lblOpisPosla.setBounds(99, 187, 58, 14);
		frame.getContentPane().add(lblOpisPosla);
		
		
		JButton btnOdustani = new JButton("Odustani");
		btnOdustani.setBounds(263, 248, 89, 23);
		frame.getContentPane().add(btnOdustani);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 187, 185, 50);
		frame.getContentPane().add(scrollPane);
		
		textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnSpremi = new JButton("Spremi");
		btnSpremi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lista.removeElement(handler);
					handler.setIme(textField.getText());
					handler.setPrezime(textField_1.getText());
					handler.setJMBG(textField_2.getText());
					handler.setNazivPosla(textField_3.getText());
					handler.setOpisPosla(textPane.getText());
					res.azurirajRadnika(handler);
					lista.addElement(handler);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.dispose();
			}
		});
		btnSpremi.setBounds(164, 248, 89, 23);
		frame.getContentPane().add(btnSpremi);
	}
}