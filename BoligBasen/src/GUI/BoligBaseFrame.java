package GUI;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class BoligBaseFrame extends JFrame{
	
	private JTextField header;
	
	 public BoligBaseFrame()
		{
		super("BoligBasen");

		 // Legger til Fil meny
		JMenu filemenu = new JMenu("Fil");
		filemenu.setMnemonic('F');
		
		// plaserer menylinjen i framen
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		menu.add(filemenu);
		
		
		
		header = new JTextField( 18 );
		
		newBoligPanel bpan = new newBoligPanel();
		
		 Container c = getContentPane();
		  c.setLayout( new FlowLayout() );
		  c.add( new JLabel( "Legg til ny bolig" ) );
		  c.add(bpan);
		  
		  
		  
		  setSize( 850, 800 );
		  setVisible( true );
		}
}
