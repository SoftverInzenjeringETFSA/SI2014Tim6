package ba.unsa.etf.si.app.RezervacijaZGTim6;

import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.*;

public abstract class AbstractValidacija extends InputVerifier implements KeyListener {
	
	protected JDialog popup;
    protected Object parent;
    private JLabel messageLabel;
    private JLabel image;
    private Color color;
    private Point point;
    private Dimension dimension;
	
    private AbstractValidacija() {
        color = new Color(255, 224, 255);
    }
    
    public AbstractValidacija(JFrame frame, Component component, String message) {
		// TODO Auto-generated constructor stub
    	this(component, message);
        this.parent = frame;
        popup = new JDialog(frame);
        initComponents();
	}
    
	private AbstractValidacija(JComponent c, String message) {
        this();
        c.addKeyListener(this);
        messageLabel = new JLabel(message + " ");
        image = new JLabel(new ImageIcon("exception_16x16.png"));
    }
    
    public AbstractValidacija(JDialog parent, JComponent c, String message) {		
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }
	
    protected AbstractValidacija(JFrame parent, JComponent c, String message) {
        this(c, message);
        this.parent = parent;
        popup = new JDialog(parent);
        initComponents();
    }

	public AbstractValidacija(Component component, String message) {
		this();
	    component.addKeyListener(this);
	    messageLabel = new JLabel(message + " ");
	    image = new JLabel(new ImageIcon("exception_16x16.png"));
		
	}

	protected abstract Boolean ValidacijaDefinition(JComponent c);
	protected abstract Boolean ValidacijaPolje(String polje);
	protected abstract Boolean ValidacijaTekst(String tekst);
    protected abstract Boolean ValidacijaIme(String ime);
    protected abstract Boolean ValidacijaPrezime(String prezime);
    protected abstract Boolean ValidacijaTelefon(String mail);
    protected abstract Boolean ValidacijaJMBG(String JMBG);
    
    protected void initComponents() {
        popup.getContentPane().setLayout(new FlowLayout());
        popup.setUndecorated(true);
        popup.getContentPane().setBackground(color);
        popup.getContentPane().add(image);
        popup.getContentPane().add(messageLabel);
        popup.setFocusableWindowState(false);
    }
    
    public boolean verify(JComponent c) {		
        if (!ValidacijaDefinition(c)) {
            c.setBackground(Color.RED);
            popup.setSize(0, 0);
            popup.setLocationRelativeTo(c);
            point = popup.getLocation();
            dimension = c.getSize();
            popup.setLocation(point.x-(int)dimension.getWidth()/2, point.y+(int)dimension.getHeight()/2);
            popup.pack();
            popup.setVisible(true);
            return false;
        }
        
        c.setBackground(Color.WHITE);
        return true;
    }
}
