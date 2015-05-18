package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;


public class DodavanjeKlijentaRadnik {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DodavanjeKlijentaRadnik window = new DodavanjeKlijentaRadnik();
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
	public DodavanjeKlijentaRadnik() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label = new JLabel("Ime:");
		
		JLabel label_1 = new JLabel("Prezime:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("Broj telefona:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("VIP klijent");
		
		JButton btnDodajKlijenta = new JButton("Dodaj Klijenta");
		
		JLabel lblDodavanjeKlijenta = new JLabel("Dodavanje Klijenta");
		lblDodavanjeKlijenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnDodajKlijenta))
						.addGroup(Alignment.LEADING, groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblDodavanjeKlijenta, Alignment.TRAILING)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addContainerGap(67, Short.MAX_VALUE)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(label_1)
									.addComponent(label)
									.addComponent(label_2))
								.addGap(22)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
									.addComponent(checkBox, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
					.addContainerGap(148, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblDodavanjeKlijenta)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(checkBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDodajKlijenta)
					.addGap(64))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
