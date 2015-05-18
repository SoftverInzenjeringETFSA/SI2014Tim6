package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;

import java.awt.EventQueue;

import javax.swing.JDialog;
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


public class OkupiranSto{

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
					OkupiranSto window = new OkupiranSto();
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
	public OkupiranSto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 303);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblKlijent = new JLabel("Klijent:");
		lblKlijent.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblKlijentKlijentic = new JLabel("Klijent Klijentic");
		
		JLabel lblTermin = new JLabel("Zauzet od:");
		lblTermin.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel label = new JLabel("15:00 12/12/2012");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		
		JLabel lblDoIstekaRezervacije = new JLabel("Proteklo vremena");
		
		JButton btnOtkaiReyervaciju = new JButton("Oslobo\u0111en sto");
		btnOtkaiReyervaciju.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				prikazStolovaButton.setBackground(Color.green);
				prikazStolovaButton.revalidate();
				prikazStolovaButton.repaint();
				frame.dispose();
				//Sad bi trebalo otici u bazu putem neke klase i tamo promijeniti stanje
				
			}
			
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTermin)
						.addComponent(lblKlijent))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKlijentKlijentic)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(262, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addGap(113))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(172, Short.MAX_VALUE)
					.addComponent(lblDoIstekaRezervacije)
					.addGap(163))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(165, Short.MAX_VALUE)
					.addComponent(btnOtkaiReyervaciju)
					.addGap(151))
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
					.addGap(18)
					.addComponent(lblDoIstekaRezervacije)
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnOtkaiReyervaciju)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		
		JLabel lbldh = new JLabel("1d : 12h : 30m : 45s");
		lbldh.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(22, Short.MAX_VALUE)
					.addComponent(lbldh)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(lbldh)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}	

}
