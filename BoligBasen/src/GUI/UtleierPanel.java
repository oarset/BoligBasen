package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bolig.Boligsøker;
import Bolig.Bruker;
import Bolig.Utleiere;

public class UtleierPanel extends JLabel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1926265705012052374L;
	private JFormattedTextField firma, firmaInfo;
	public JButton saveUtlButton, backButton;
	private JPanel buttonPanel;
	private Utleiere utl;
	
	public UtleierPanel(){
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
					
			headerPanel.add( new JLabel( "Informasjon om Utleier" ), BorderLayout.PAGE_START );
			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(30,50,0,10);
			add(headerPanel, c);
			
			// label og inputfelt Firma
			JPanel firmaPanel = new JPanel();
			BorderLayout bl = new BorderLayout();
			bl.setHgap(10);
			bl.setVgap(5);
			firmaPanel.setLayout(bl);
			firma = new JFormattedTextField(  );
			firma.setColumns(20);

					
			firmaPanel.add( new JLabel( "Firma" ), BorderLayout.PAGE_START );
			firmaPanel.add(firma, BorderLayout.LINE_START);
			
			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 1;
			c.insets = new Insets(10,50,0,10);
			add(firmaPanel, c);
			
			// label og inputfelt for firmainformasjon
			JPanel firmaInfoPanel = new JPanel();
			BorderLayout bl2 = new BorderLayout();
			bl2.setHgap(10);
			bl2.setVgap(5);
			firmaInfoPanel.setLayout(bl2);
			firmaInfo = new JFormattedTextField(  );
			firmaInfo.setColumns(20);
			
			
			firmaInfoPanel.add( new JLabel( "Firma informasjon" ), BorderLayout.PAGE_START );
			firmaInfoPanel.add(firmaInfo, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 2;
			add(firmaInfoPanel, c);
			
			
			
			// legger til knapper for å lagre boligsøker eller gå tilbake til bruker info
			
			buttonPanel = new JPanel();
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.RIGHT);
			buttonPanel.setLayout(fl);
			
			saveUtlButton = new JButton("Lagre info");
			backButton = new JButton("Tilbake");
			
			buttonPanel.add(saveUtlButton);
			buttonPanel.add(backButton);
			
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
			
			
	}
	
	public void saveUtlActionListener(ActionListener al) {  
	    saveUtlButton.addActionListener(al);  
	  } 
	public void utlBackActionListener(ActionListener al) {  
	    backButton.addActionListener(al);
	  }
	
	public void setUtl(Utleiere utleier){
		utl = utleier;
	}
	
	public Utleiere getUtl(){
		return utl;
	}
	
	public void setCompleetUtl(){
		try{
			String firmaInput = firma.getText();
			utl.setFirma(firmaInput);
			String firmaInfoInput = firmaInfo.getText();
			utl.setFirmaInfo(firmaInfoInput);
			
		
		}
		catch(NumberFormatException e){
			
		}
	}
	
	
}

