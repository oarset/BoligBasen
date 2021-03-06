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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bolig.Boligs�ker;

public class SeekerPanel extends JLabel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6027996351493350976L;
	private JFormattedTextField maxmndpris, minmndpris, rom, size;
	public JButton saveSeekerButton, backButton;
	public JPanel buttonPanel;
	private Boligs�ker seeker;
	private JComboBox<String> antromvelger, hagevelger, balkongvelger;
	private String[] antromListe = {"1","2","3","4","5","6","7"};
	private String[] hageListe = {"ja", "nei"};
	private String[] balkongListe = {"ja","nei"};
	
	
	public SeekerPanel(){
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
					
			headerPanel.add( new JLabel( "Informasjon om Boligs�kerens preferanser" ), BorderLayout.PAGE_START );
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

					
			maxprisPanel.add( new JLabel( "Max M�neds Pris" ), BorderLayout.PAGE_START );
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
			
			minprisPanel.add( new JLabel( "Min M�neds Pris" ), BorderLayout.PAGE_START );
			minprisPanel.add(minmndpris, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 2;
			add(minprisPanel, c);
			
			// label og inputfelt for antall rom
			JPanel romPanel = new JPanel();
			BorderLayout bl3 = new BorderLayout();
			bl3.setHgap(10);
			bl3.setVgap(5);
			romPanel.setLayout(bl3);
			rom = new JFormattedTextField(  );
			rom.setColumns(8);
			
			antromvelger = new JComboBox<>(antromListe);
			antromvelger.setSelectedIndex(0);
			
			romPanel.add( new JLabel( "Antall soverom" ), BorderLayout.PAGE_START );
			romPanel.add(antromvelger, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.ipadx = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 3;
			add(romPanel, c);
			
			// label og inputfelt for kvm st�rrelse
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
			c.ipadx = 0;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 4;
			add(sizePanel, c);
			
			// label og inputfelt for balkong
			JPanel balkongPanel = new JPanel();
			BorderLayout bl5 = new BorderLayout();
			bl5.setHgap(10);
			bl5.setVgap(5);
			balkongPanel.setLayout(bl5);
			
			balkongvelger = new JComboBox<>(balkongListe);
			balkongvelger.setSelectedIndex(0);
			
			balkongPanel.add( new JLabel( "�nsker Brukeren Balkong?" ), BorderLayout.PAGE_START );
			balkongPanel.add(balkongvelger, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 5;
			add(balkongPanel, c);
			
			// label og inputfelt for hage
			JPanel hagePanel = new JPanel();
			BorderLayout bl6 = new BorderLayout();
			bl6.setHgap(10);
			bl6.setVgap(5);
			hagePanel.setLayout(bl6);
			
			hagevelger = new JComboBox<>(hageListe);
			hagevelger.setSelectedIndex(0);
			
			hagePanel.add( new JLabel( "�nsker Brukeren Hage?" ), BorderLayout.PAGE_START );
			hagePanel.add(hagevelger, BorderLayout.LINE_START);

			c.fill = GridBagConstraints.NONE;
			c.ipady = 10;
			c.weightx = 1;
			c.weighty = 0;
			c.gridx = 0;
			c.gridy = 6;
			add(hagePanel, c);
			
			// legger til knapper for � lagre boligs�ker eller g� tilbake til bruker info
			
			buttonPanel = new JPanel();
			FlowLayout fl = new FlowLayout();
			fl.setAlignment(FlowLayout.RIGHT);
			buttonPanel.setLayout(fl);
			
			saveSeekerButton = new JButton("Lagre info");
			backButton = new JButton("Tilbake");
			
			buttonPanel.add(saveSeekerButton);
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
			c.gridy = 8;
			add(bottomFillPanel, c);
			
			
	}
	
	public void saveSeekerActionListener(ActionListener al) {  
	    saveSeekerButton.addActionListener(al);  
	  } 
	public void seekerBackActionListener(ActionListener al) {  
	    backButton.addActionListener(al);  
	  }
	
	public void setSeeker(Boligs�ker seek){
		seeker = seek;
	}
	
	public Boligs�ker getSeeker(){
		return seeker;
	}
	
	public void oppdaterBoligSeeker(){
		try{
			int seekmaxpris = Integer.parseInt(maxmndpris.getText());
			seeker.setMaxPris(seekmaxpris);
			int seekminpris = Integer.parseInt(minmndpris.getText());
			seeker.setMinPris(seekminpris);
			
			int antrom = Integer.parseInt(antromListe[(antromvelger.getSelectedIndex())]);
			seeker.setAntRom(antrom);
			
			int seeksize = Integer.parseInt(size.getText());
			seeker.setSt�rrelse(seeksize);
			
			String seekbalkong = balkongListe[(balkongvelger.getSelectedIndex())];
			if (seekbalkong == "ja"){
				seeker.setBalkong(true);
			}
			else{
				seeker.setBalkong(false);
			}
			
			String seekhage = hageListe[(hagevelger.getSelectedIndex())];
			if (seekhage == "ja"){
				seeker.setHage(true);
			}
			else{
				seeker.setHage(false);
			}
		
		}
		catch(NumberFormatException e){
			
		}
	}
	
	
}

