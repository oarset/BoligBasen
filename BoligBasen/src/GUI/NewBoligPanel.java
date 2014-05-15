package GUI;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import Bolig.*;

public class NewBoligPanel extends JPanel{
	
	JFormattedTextField adresse,  boa, byggeaar, pris;
	JTextArea beskrivelse;
	private Utleiere utl;
	public JComboBox<String> typevelger;
	public JComboBox<String> utleiervelger;
	private String[] typeListe = {"Leilighet", "Enebolig", "Rekkehus"};
	public Personliste utleierListe;
	private String[] utleierStringListe;
	public JButton newEierButton, saveBoligButton;
	
	
	public NewBoligPanel(){
		super();
		//setBackground(Color.cyan);
		
		utleierListe = new Personliste();
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
				
		headerPanel.add( new JLabel( "Legge til ny Bolig" ), BorderLayout.PAGE_START );
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(30,50,0,10);
		add(headerPanel, c);
		
		// label og inputfelt for adresse
		JPanel adressePanel = new JPanel();
		BorderLayout bl = new BorderLayout();
		bl.setHgap(10);
		bl.setVgap(5);
		adressePanel.setLayout(bl);
		adresse = new JFormattedTextField(  );
		adresse.setColumns(8);

				
		adressePanel.add( new JLabel( "Max Måneds Pris" ), BorderLayout.PAGE_START );
		adressePanel.add(adresse, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,50,0,10);
		add(adressePanel, c);
		
		// label og inputfelt for boligtype
		JPanel typePanel = new JPanel();
		BorderLayout bl6 = new BorderLayout();
		bl6.setHgap(10);
		bl6.setVgap(5);
		typePanel.setLayout(bl6);
		
		typevelger = new JComboBox<>(typeListe);
		typevelger.setSelectedIndex(0);
		
		typePanel.add( new JLabel( "Boligtype" ), BorderLayout.PAGE_START );
		typePanel.add(typevelger, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 2;
		add(typePanel, c);
		
		// label og inputfelt for adresse
		JPanel beskrivelsePanel = new JPanel();
		BorderLayout bl2 = new BorderLayout();
		bl2.setHgap(10);
		bl2.setVgap(5);
		beskrivelsePanel.setLayout(bl2);
		beskrivelse = new JTextArea(10,30);
		JScrollPane scrollPane = new JScrollPane( beskrivelse );
		beskrivelse.setLineWrap (true);

				
		adressePanel.add( new JLabel( "Beskrivelse" ), BorderLayout.PAGE_START );
		adressePanel.add(beskrivelse, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(10,50,0,10);
		add(adressePanel, c);
		
		// label og inputfelt for boareal
		JPanel boaPanel = new JPanel();
		BorderLayout bl3 = new BorderLayout();
		bl3.setHgap(10);
		bl3.setVgap(5);
		boaPanel.setLayout(bl3);
		boa = new JFormattedTextField(  );
		boa.setColumns(8);
		
		boaPanel.add( new JLabel( "Antall kvadratmeter" ), BorderLayout.PAGE_START );
		boaPanel.add(boa, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.ipadx = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 4;
		add(boaPanel, c);
		
		// label og inputfelt for byggeaar
		JPanel byggeaarPanel = new JPanel();
		BorderLayout bl4 = new BorderLayout();
		bl4.setHgap(10);
		bl4.setVgap(5);
		byggeaarPanel.setLayout(bl4);
		byggeaar = new JFormattedTextField(  );
		byggeaar.setColumns(8);
		
		byggeaarPanel.add( new JLabel( "Byggeår" ), BorderLayout.PAGE_START );
		byggeaarPanel.add(byggeaar, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.ipadx = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 5;
		add(byggeaarPanel, c);
		
		// label og inputfelt for pris
		JPanel prisPanel = new JPanel();
		BorderLayout bl5 = new BorderLayout();
		bl5.setHgap(10);
		bl5.setVgap(5);
		prisPanel.setLayout(bl5);
		pris = new JFormattedTextField(  );
		pris.setColumns(8);
		
		prisPanel.add( new JLabel( "Manedsleie" ), BorderLayout.PAGE_START );
		prisPanel.add(pris, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.ipadx = 0;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 6;
		add(prisPanel, c);
		
		// label og valg av Utleier
		JPanel utleierPanel = new JPanel();
		BorderLayout bl7 = new BorderLayout();
		bl7.setHgap(10);
		bl7.setVgap(5);
		utleierPanel.setLayout(bl7);	
		
		
			utleierStringListe = new String[1]; 
			utleierStringListe[0] = "---";
		
		
		utleiervelger = new JComboBox<>(utleierStringListe);
		utleiervelger.setSelectedIndex(0);
		
		utleierPanel.add( new JLabel( "Utleier" ), BorderLayout.PAGE_START );
		utleierPanel.add(utleiervelger, BorderLayout.LINE_START);

		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 7;
		add(utleierPanel, c);
		
		
		// legger til knapper for å lagre boligsøker eller gå tilbake til bruker info
		
		JPanel buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(fl);
		
		newEierButton = new JButton("Nye Eier");
		saveBoligButton = new JButton("Lagre info");
		
		buttonPanel.add(newEierButton);
		buttonPanel.add(saveBoligButton);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(10,50,0,10);
		add(buttonPanel, c);
		
		// label som fyller bunn
		JPanel bottomFillPanel = new JPanel( new BorderLayout());
		
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 9;
		add(bottomFillPanel, c);
	}
	
	public void newEierActionListener(ActionListener al) {  
	    newEierButton.addActionListener(al);  
	  } 
	public void saveBoligActionListener(ActionListener al) {  
	    saveBoligButton.addActionListener(al);  
	  }
	public void setUtleierListe(Personliste p){
		try{
			utleierListe = p.utleierliste();
		}
		catch ( NumberFormatException e ) {
		    errorOutput( "Ingen ny BoligSøker pga av feil tallformat" );
		  }	
	}
	
	public Bolig saveNyBolig(){
		try{
			Bolig bolig;
			String boadresse = adresse.getText();
			//utleierStringListe[(utleiervelger.getSelectedIndex())];
			
			int boboa = Integer.parseInt(boa.getText());
			String botype = typeListe[typevelger.getSelectedIndex()];
			String boutleier = utleiervelger.getItemAt(utleiervelger.getSelectedIndex());
			int bobygg = Integer.parseInt(byggeaar.getText());
			int bopris = Integer.parseInt(pris.getText());
			int brukerID = Integer.parseInt(utleiervelger.getItemAt(utleiervelger.getSelectedIndex()).substring(0,4));
			utl = utleierListe.finnUtleier(brukerID);
			if(botype == "Rekkehus"){
				bolig = new Rekkehus(boadresse, botype);
			}
			else if (botype == "Enebolig"){
				bolig = new Enebolig(boadresse, botype);
			}
			else {
				bolig = new Leilighet(boadresse, botype);
			}
			
			bolig.setBOA(boboa);
			bolig.setByggeAar(bobygg);
			bolig.setLeiePris(bopris);
			bolig.setEier(utl);
			
			return bolig;
			
			}
			catch ( NumberFormatException e ) {
			    errorOutput( "Ingen ny BoligSøker pga av feil tallformat" );
			    return null;
			  }	
	}
	
	
	
	private void errorOutput( String msg )
	{
	  JOptionPane.showMessageDialog( this, msg );
	}
}
