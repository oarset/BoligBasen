package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MatchPanel extends JPanel{
	
	private JButton matchSeekerButton , matchBoligButton;
	private JPanel buttonPanel;
	public JComboBox<String> boligvelger, brukervelger;
	private String[] boligStringListe, brukerStringListe;
	
	public MatchPanel(){
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
				
		headerPanel.add( new JLabel( "Bruker informasjon" ), BorderLayout.PAGE_START );
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(30,50,0,10);
		add(headerPanel, c);

		
		// label og valg av Utleier
		JPanel boligPanel = new JPanel();
		BorderLayout bl = new BorderLayout();
		bl.setHgap(10);
		bl.setVgap(5);
		boligPanel.setLayout(bl);	
		
		
		boligStringListe = new String[1]; 
		boligStringListe[0] = "---";

		boligvelger = new JComboBox<>(boligStringListe);
		boligvelger.setSelectedIndex(0);
		
		boligPanel.add( new JLabel( "Bolig" ), BorderLayout.PAGE_START );
		boligPanel.add(boligvelger, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 1;
		add(boligPanel, c);
		
		// label og valg av Utleier
		JPanel brukerPanel = new JPanel();
		BorderLayout bl7 = new BorderLayout();
		bl7.setHgap(10);
		bl7.setVgap(5);
		brukerPanel.setLayout(bl7);	
		
		brukerStringListe = new String[1]; 
		brukerStringListe[0] = "---";
	
		brukervelger = new JComboBox<>(brukerStringListe);
		brukervelger.setSelectedIndex(0);
	
		brukerPanel.add( new JLabel( "Utleier" ), BorderLayout.PAGE_START );
		brukerPanel.add(brukervelger, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 2;
		add(brukerPanel, c);
		
		// legger til knapper for å lagre boligsøker/utleier
		
		buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(fl);
		
		matchSeekerButton = new JButton("Fin Bolig");
		matchBoligButton = new JButton("Finn Boligsøker");
		
		buttonPanel.add(matchSeekerButton);
		buttonPanel.add(matchBoligButton);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,50,0,10);
		add(buttonPanel, c);
		
		
		// label som fyller bunn
		JPanel bottomFillPanel = new JPanel( new BorderLayout());
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 4;
		add(bottomFillPanel, c);

		//newBoligSeekerButton.addActionListener(new BoligBaseFrame());
		//newUtleierButton.addActionListener(new BoligBaseFrame());

		
		
	}
	
	public void newSeekerActionListener(ActionListener al) {  
	    matchSeekerButton.addActionListener(al);  
	  }  
	
	public void newUtlActionListener(ActionListener al) {  
	    matchBoligButton.addActionListener(al);  
	  } 
}

