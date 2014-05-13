package GUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class newBoligPanel extends JPanel{
	
	
	
	public newBoligPanel(){
		
		setPreferredSize(new Dimension(300,300));
		
		add( new JLabel( "Legg til ny bolig" ) );
		
	}
}
