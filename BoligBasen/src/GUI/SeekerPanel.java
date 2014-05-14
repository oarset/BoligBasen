package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bolig.Boligsøker;
import Bolig.Bruker;

public class SeekerPanel extends JLabel{
	
	private JFormattedTextField maxmndpris, minmndpris, rom, size, balkong, hage, husdyr;
	
	public SeekerPanel(Boligsøker seek){
			super();
			setPreferredSize(new Dimension(500,200));
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.anchor = GridBagConstraints.NORTHWEST;
	
			
			// label for "siden"
			JPanel headerPanel = new JPanel();
			BorderLayout blhead = new BorderLayout();
			blhead.setHgap(10);
			blhead.setVgap(5);
			headerPanel.setLayout(blhead);
					
			headerPanel.add( new JLabel( "Informasjon om Boligsøkerens preferanser" ), BorderLayout.PAGE_START );
			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(30,50,0,10);
			add(headerPanel, c);
			
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
			
			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 1;
			c.insets = new Insets(10,50,0,10);
			add(maxprisPanel, c);
			
			// label og inputfelt for min pris
			JPanel minprisPanel = new JPanel();
			BorderLayout bl2 = new BorderLayout();
			bl2.setHgap(10);
			bl2.setVgap(5);
			minprisPanel.setLayout(bl2);
			minmndpris = new JFormattedTextField(  );
			minmndpris.setColumns(8);
			
			minprisPanel.add( new JLabel( "Min Måneds Pris" ), BorderLayout.PAGE_START );
			minprisPanel.add(minmndpris, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 2;
			add(minprisPanel, c);
			
			// label og inputfelt for min pris
			JPanel romPanel = new JPanel();
			BorderLayout bl3 = new BorderLayout();
			bl3.setHgap(10);
			bl3.setVgap(5);
			romPanel.setLayout(bl3);
			rom = new JFormattedTextField(  );
			rom.setColumns(8);
			
			romPanel.add( new JLabel( "Antall rom" ), BorderLayout.PAGE_START );
			romPanel.add(rom, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 3;
			add(romPanel, c);
			
			// label og inputfelt for min pris
			JPanel sizePanel = new JPanel();
			BorderLayout bl4 = new BorderLayout();
			bl4.setHgap(10);
			bl4.setVgap(5);
			sizePanel.setLayout(bl4);
			size = new JFormattedTextField(  );
			size.setColumns(8);
			
			sizePanel.add( new JLabel( "Antall kvadratmeter" ), BorderLayout.PAGE_START );
			sizePanel.add(size, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 4;
			add(sizePanel, c);
			
			// label som fyller bunn
			JPanel bottomFillPanel = new JPanel( new BorderLayout());
			
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 1;
			c.gridheight = 1;
			c.gridx = 0;
			c.gridy = 5;
			add(bottomFillPanel, c);
	}
}

