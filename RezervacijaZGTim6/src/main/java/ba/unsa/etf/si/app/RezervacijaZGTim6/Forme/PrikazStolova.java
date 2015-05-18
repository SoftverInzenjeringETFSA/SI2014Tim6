package ba.unsa.etf.si.app.RezervacijaZGTim6.Forme;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrikazStolova {
	
	private JFrame frame;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrikazStolova window = new PrikazStolova();
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
	public PrikazStolova() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 50, 450, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		frame.getContentPane().add(panel,"Center");
		
		
		fillButtons();
		
	}
	
	public void fillButtons()
	{
		// Ideja je da se ovdje pozove klasa koja ce iz baze dobaviti stolove kao listu klasa
		//Dalje se na osnovu broja stolova i njihovog stanja dinamicki kreiraju buttoni, text buttona
		// je redni broj stola, a boja se postavlja ovisno od trenutnog stanja stola
		//Ispod je hardcoded primjer
		
		for(int i=0;i<50;i++)
		{
			JButton b = new JButton("" +(i+1));
			b.setBackground(Color.red);
			b.setPreferredSize(new Dimension(60, 60));
			b.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					JButton button = (JButton)e.getSource();
					int number= Integer.parseInt(button.getText());
					button.setBackground(Color.green);
					panel.revalidate();
				}
				
			});
			panel.add(b);
			
		}
		
		panel.revalidate();
		panel.repaint();
		
	}
	
	

}
