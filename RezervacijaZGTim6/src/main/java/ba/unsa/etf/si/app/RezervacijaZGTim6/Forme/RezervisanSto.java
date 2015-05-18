package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;


public class RezervisanSto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervisanSto window = new RezervisanSto();
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
	public RezervisanSto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 451, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblKlijentKlijentic = new JLabel("Klijent Klijentic");
		lblKlijentKlijentic.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblTermin = new JLabel("Termin:");
		lblTermin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label = new JLabel("15:00 12/12/2012");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		
		JLabel lblDoIstekaRezervacije = new JLabel("Do isteka rezervacije:");
		lblDoIstekaRezervacije.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JButton btnOtkaiReyervaciju = new JButton("Otka\u017Ei rezervaciju");
		btnOtkaiReyervaciju.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTermin)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblKlijent)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblKlijentKlijentic)))
					.addContainerGap(218, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(123, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOtkaiReyervaciju)
							.addGap(38))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDoIstekaRezervacije)
							.addGap(37)))
					.addGap(118))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKlijent)
						.addComponent(lblKlijentKlijentic))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTermin, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(34)
					.addComponent(lblDoIstekaRezervacije)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOtkaiReyervaciju)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		
		JLabel lbldh = new JLabel("1d : 12h : 30m : 45s");
		lbldh.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(lbldh)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(16)
					.addComponent(lbldh)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}

}
