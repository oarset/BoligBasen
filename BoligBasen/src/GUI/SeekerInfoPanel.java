package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeekerInfoPanel extends JLabel{

	private JFormattedTextField sivilstatus, hhs, smoke, yrke, husdyr; 
	public JPanel buttonPanel;
	public JButton saveInfoButton, backButton;
	
	public SeekerInfoPanel(){

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
				
		headerPanel.add( new JLabel( "Informasjon om Boligsøkeren" ), BorderLayout.PAGE_START );
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(30,50,0,10);
		add(headerPanel, c);
		
		// label og inputfelt for sivil status
		JPanel sivilPanel = new JPanel();
		BorderLayout bl = new BorderLayout();
		bl.setHgap(10);
		bl.setVgap(5);
		sivilPanel.setLayout(bl);
		sivilstatus = new JFormattedTextField(  );
		sivilstatus.setColumns(8);

				
		sivilPanel.add( new JLabel( "Sivilstatus" ), BorderLayout.PAGE_START );
		sivilPanel.add(sivilstatus, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,50,0,10);
		add(sivilPanel, c);
		
		// label og inputfelt størrelse på husholdningen
		JPanel hhsPanel = new JPanel();
		BorderLayout bl2 = new BorderLayout();
		bl2.setHgap(10);
		bl2.setVgap(5);
		hhsPanel.setLayout(bl2);
		hhs = new JFormattedTextField(  );
		hhs.setColumns(8);

				
		hhsPanel.add( new JLabel( "Størrelse på Husholdningen" ), BorderLayout.PAGE_START );
		hhsPanel.add(hhs, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,50,0,10);
		add(hhsPanel, c);
		
		
		// label og inputfelt røyking/ikke-røyk
		JPanel smokePanel = new JPanel();
		BorderLayout bl3 = new BorderLayout();
		bl3.setHgap(10);
		bl3.setVgap(5);
		smokePanel.setLayout(bl3);
		smoke = new JFormattedTextField(  );
		smoke.setColumns(8);

				
		smokePanel.add( new JLabel( "Røyker" ), BorderLayout.PAGE_START );
		smokePanel.add(smoke, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,50,0,10);
		add(smokePanel, c);
		
		// label og inputfelt yrke
		JPanel yrkePanel = new JPanel();
		BorderLayout bl4 = new BorderLayout();
		bl4.setHgap(10);
		bl4.setVgap(5);
		yrkePanel.setLayout(bl4);
		yrke = new JFormattedTextField(  );
		yrke.setColumns(8);

				
		yrkePanel.add( new JLabel( "Yrke" ), BorderLayout.PAGE_START );
		yrkePanel.add(yrke, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(10,50,0,10);
		add(yrkePanel, c);
		
		// label og inputfelt størrelse på husholdningen
		JPanel husdyrPanel = new JPanel();
		BorderLayout bl5 = new BorderLayout();
		bl5.setHgap(10);
		bl5.setVgap(5);
		husdyrPanel.setLayout(bl5);
		husdyr = new JFormattedTextField(  );
		husdyr.setColumns(8);

				
		husdyrPanel.add( new JLabel( "Huysdyr?" ), BorderLayout.PAGE_START );
		husdyrPanel.add(husdyr, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(10,50,0,10);
		add(husdyrPanel, c);
		
		
		// legger til knapper for å lagre boligsøker eller gåt tilbake til bruker info
		
		buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(fl);
		
		saveInfoButton = new JButton("Lagre info");
		backButton = new JButton("Tilbake");
		
		buttonPanel.add(saveInfoButton);
		buttonPanel.add(backButton);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(10,50,0,10);
		add(buttonPanel, c);
		
		// label som fyller bunn
		JPanel bottomFillPanel = new JPanel( new BorderLayout());
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 6;
		add(bottomFillPanel, c);
		
	}
	
	public void setCompleetSeeker(){
		
	}
	
	
	public void saveSeekerInfoActionListener(ActionListener al) {  
	    saveInfoButton.addActionListener(al);  
	  } 
	public void seekerBackActionListener(ActionListener al) {  
	    backButton.addActionListener(al);  
	  }
}
