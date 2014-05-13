package GUI;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class infoPanel extends JPanel{

	public infoPanel(){
		
		setPreferredSize(new Dimension(540,800));
		
		add( new JLabel( "Vis info her" ) );
	}
}
