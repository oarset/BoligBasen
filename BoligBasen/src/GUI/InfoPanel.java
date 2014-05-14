package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel{

	public InfoPanel(){
		
		setPreferredSize(new Dimension(540,800));
		BorderLayout bl = new BorderLayout();
		bl.setVgap(5);
		setLayout(bl);

		add( new JLabel( "Vis info her" ),BorderLayout.PAGE_START );
	
	}
	
	public void addContent(String s){
		
		removeAll();
		
		JLabel output = new JLabel( s );
		output.setBackground(Color.white);
		add( new JLabel( "Vis info her" ),BorderLayout.PAGE_START );
		add( output, BorderLayout.LINE_START );
	}
}
