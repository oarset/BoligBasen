package GUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel{

	public InfoPanel(){
		
		setPreferredSize(new Dimension(540,800));
		
		add( new JLabel( "Vis info her" ) );
	}
}
