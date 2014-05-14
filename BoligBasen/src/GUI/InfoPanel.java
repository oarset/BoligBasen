package GUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel{

	public InfoPanel(String s){
		
		setPreferredSize(new Dimension(540,800));
		
		add( new JLabel( "Vis info her" ) );
		add( new JLabel ( s ) );
	}
}
