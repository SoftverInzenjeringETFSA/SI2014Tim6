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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class RezervisanSto {

	private JFrame frame;
	private JButton prikazStolovaButton;
	private JPanel prikazStolovaPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RezervisanSto window = new RezervisanSto();
					window.getRezervisanSto().setVisible(true);
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
		setRezervisanSto(new JFrame());
		getRezervisanSto().setResizable(false);
		getRezervisanSto().setBounds(100, 100, 451, 303);
		getRezervisanSto().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
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
		btnOtkaiReyervaciju.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				prikazStolovaButton.setBackground(Color.green);
				prikazStolovaButton.revalidate();
				prikazStolovaButton.repaint();
				getRezervisanSto().dispose();
				//Sad bi trebalo otici u bazu putem neke klase i tamo promijeniti stanje
				 
				 
				
			}});
		
		JButton btnOkupiranStol = new JButton("Okupiran stol");
		btnOkupiranStol.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		GroupLayout groupLayout = new GroupLayout(getRezervisanSto().getContentPane());
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
							.addComponent(lblDoIstekaRezervacije)
							.addGap(37))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOkupiranStol, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOtkaiReyervaciju))
							.addGap(38)))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOkupiranStol, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
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
		getRezervisanSto().getContentPane().setLayout(groupLayout);
	}

	public JFrame getRezervisanSto() {
		return frame;
	}

	public void setRezervisanSto(JFrame frame) {
		this.frame = frame;
	}
	
	public void showWindow(int tableNumber,JButton button, JPanel panel)
	{
		System.out.println("Stol "+tableNumber);
		this.prikazStolovaButton=button;
		this.prikazStolovaPanel=panel;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					getRezervisanSto().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}
}
