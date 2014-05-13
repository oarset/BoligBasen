package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class newBoligPanel extends JPanel{
	
	
	
	public newBoligPanel(){
		
		setPreferredSize(new Dimension(500,800));
		setBackground(Color.cyan);
		
		add( new JLabel( "Legg til en ny bolig" ) );
		
		
		
	}
}
