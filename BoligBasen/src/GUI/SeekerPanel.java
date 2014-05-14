package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bolig.Person;

public class SeekerPanel extends JLabel{
	
	private JFormattedTextField maxmndpris, minmndpris;
	
	public SeekerPanel(Person p){
			super();
			setPreferredSize(new Dimension(500,200));
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.NORTHWEST;
	
			
			// label og inputfelt for max pris
			JPanel maxprisPanel = new JPanel();
			BorderLayout bl = new BorderLayout();
			bl.setHgap(10);
			bl.setVgap(5);
			maxprisPanel.setLayout(bl);
			maxmndpris = new JFormattedTextField(  );
			maxmndpris.setColumns(8);

					
			maxprisPanel.add( new JLabel( "Max Måneds Pris" ), BorderLayout.PAGE_START );
			maxprisPanel.add(maxmndpris, BorderLayout.LINE_START);
			
			// label og inputfelt for min pris
			JPanel minprisPanel = new JPanel();
			BorderLayout bl2 = new BorderLayout();
			bl2.setHgap(10);
			bl2.setVgap(5);
			minprisPanel.setLayout(bl2);
			minmndpris = new JFormattedTextField(  );
			minmndpris.setColumns(8);
			
			minprisPanel.add( new JLabel( "Main Måneds Pris" ), BorderLayout.PAGE_START );
			minprisPanel.add(minmndpris, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 1;
			c.insets = new Insets(30,50,0,10);
			add(maxprisPanel, c);
	}
}

