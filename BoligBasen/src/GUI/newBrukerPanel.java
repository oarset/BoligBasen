package GUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class newBrukerPanel extends JPanel{

	public newBrukerPanel(){
		
		setPreferredSize(new Dimension(300,300));
		
		add( new JLabel( "Legg til ny bruker" ) );
	}
		
}
