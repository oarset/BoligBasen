package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewBoligPanel extends JPanel{
	
	
	
	public NewBoligPanel(){
		
		setPreferredSize(new Dimension(500,800));
		setBackground(Color.cyan);
		
		add( new JLabel( "Legg til en ny bolig" ) );
		
		
		
	}
}
