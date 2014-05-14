package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeekerInfoPanel extends JLabel{

	private JFormattedTextField sivilstatus, hhs, smoke, yrke, husdyr; 
	
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
				
		headerPanel.add( new JLabel( "Informasjon om Boligs�keren" ), BorderLayout.PAGE_START );
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
		
		// label og inputfelt st�rrelse p� husholdningen
		JPanel hhsPanel = new JPanel();
		BorderLayout bl2 = new BorderLayout();
		bl2.setHgap(10);
		bl2.setVgap(5);
		hhsPanel.setLayout(bl2);
		hhs = new JFormattedTextField(  );
		hhs.setColumns(8);

				
		hhsPanel.add( new JLabel( "St�rrelse p� Husholdningn" ), BorderLayout.PAGE_START );
		hhsPanel.add(hhs, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10,50,0,10);
		add(hhsPanel, c);
		
		
		// label som fyller bunn
		JPanel bottomFillPanel = new JPanel( new BorderLayout());
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 3;
		add(bottomFillPanel, c);
		
	}
}
