package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

import Bolig.Boligs�ker;
import Bolig.Bruker;
import Bolig.Utleiere;


public class NewBrukerPanel extends JPanel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -221958276479046410L;
	private JFormattedTextField fornavn, etternavn, adresse, pnr, sted, dag, mnd, aar, email, tlf;
	public JButton newBoligSeekerButton, newUtleierButton;
	private JPanel buttonPanel;
	private Bruker per;
	
	
	public NewBrukerPanel(){
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
		
		// label og input felt for fornavn
		JPanel fornavnPanel = new JPanel();
		BorderLayout bl = new BorderLayout();
		bl.setVgap(5);
		fornavnPanel.setLayout(bl);
		fornavn = new JFormattedTextField();
		fornavn.setColumns(20);
		
		fornavnPanel.add( new JLabel( "Fornavn" ), BorderLayout.PAGE_START );
		fornavnPanel.add(fornavn, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.ipady = 10;
		c.weightx = 1;
		c.weighty = 0;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(10,50,0,10);
		add(fornavnPanel, c);
		
		// label og input felt for etternavn
		JPanel etternavnPanel = new JPanel();
		BorderLayout bl2 = new BorderLayout();
		bl2.setVgap(5);
		etternavnPanel.setLayout(bl2);
		etternavn = new JFormattedTextField();
		etternavn.setColumns(20);
		
		etternavnPanel.add( new JLabel( "Etternavn" ), BorderLayout.PAGE_START );
		etternavnPanel.add(etternavn, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 2;
		add(etternavnPanel, c);
		
		// label og inputfelt for addresse
		JPanel adressePanel = new JPanel();
		BorderLayout bl3 = new BorderLayout();
		bl3.setVgap(5);
		adressePanel.setLayout(bl3);
		adresse = new JFormattedTextField();
		adresse.setColumns(20);
		
		adressePanel.add( new JLabel( "Adresse" ), BorderLayout.PAGE_START );
		adressePanel.add(adresse, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 3;
		add(adressePanel, c);
		
		// label og inputfelt for postnummer/sted
		
		JPanel postPanel = new JPanel();
		BorderLayout bl4 = new BorderLayout();
		bl4.setHgap(10);
		bl4.setVgap(5);
		postPanel.setLayout(bl4);
		pnr = new JFormattedTextField(  );
		pnr.setColumns(4);
		sted = new JFormattedTextField(  );
		sted.setColumns(15);
				
		postPanel.add( new JLabel( "Postnummer/Sted" ), BorderLayout.PAGE_START );
		postPanel.add(pnr, BorderLayout.LINE_START);
		postPanel.add(sted, BorderLayout.CENTER);

		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 4;
		add(postPanel, c);
		
		
		// label og inputfelt for f�dselsdato
		JPanel datoPanel = new JPanel();
		BorderLayout bl5 = new BorderLayout();
		bl5.setHgap(10);
		bl5.setVgap(5);
		datoPanel.setLayout(bl5);
		dag = new JFormattedTextField(  );
		dag.setColumns(2);
		mnd = new JFormattedTextField(  );
		mnd.setColumns(2);
		aar = new JFormattedTextField(  );
		aar.setColumns(4);
		
		
		datoPanel.add( new JLabel( "F�dselsdato" ), BorderLayout.PAGE_START );
		datoPanel.add(dag, BorderLayout.LINE_START);
		datoPanel.add(mnd, BorderLayout.CENTER);
		datoPanel.add(aar, BorderLayout.LINE_END);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 5;
		add(datoPanel, c);
		
		// label og inputfelt for mail
		JPanel emailPanel = new JPanel();
		BorderLayout bl6 = new BorderLayout();
		bl6.setVgap(5);
		emailPanel.setLayout(bl6);
		email = new JFormattedTextField();
		email.setColumns(20);
		
		emailPanel.add( new JLabel( "Email" ), BorderLayout.PAGE_START );
		emailPanel.add(email, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(10,50,0,10);
		add(emailPanel, c);
		
		// label og inputfelt for mail
		JPanel tlfPanel = new JPanel();
		BorderLayout bl7 = new BorderLayout();
		bl7.setVgap(5);
		tlfPanel.setLayout(bl7);
		tlf = new JFormattedTextField();
		tlf.setColumns(20);
		
		tlfPanel.add( new JLabel( "Tlf" ), BorderLayout.PAGE_START );
		tlfPanel.add(tlf, BorderLayout.LINE_START);
		
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(10,50,0,10);
		add(tlfPanel, c);
		
		// legger til knapper for � lagre boligs�ker/utleier
		
		buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(fl);
		
		newBoligSeekerButton = new JButton("Ny Bolig S�ker");
		newUtleierButton = new JButton("Ny Utleier");
		
		buttonPanel.add(newBoligSeekerButton);
		buttonPanel.add(newUtleierButton);
		
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

		//newBoligSeekerButton.addActionListener(new BoligBaseFrame());
		//newUtleierButton.addActionListener(new BoligBaseFrame());

		
		
	}
	
	public void newSeekerActionListener(ActionListener al) {  
	    newBoligSeekerButton.addActionListener(al);  
	  }  
	
	public void newUtlActionListener(ActionListener al) {  
	    newUtleierButton.addActionListener(al);  
	  } 

	
	public Boligs�ker nyBoligSeeker(){
		try{
		String bsfnavn = fornavn.getText();
		String bsenavn = etternavn.getText();
		String bsadd = adresse.getText();
		String bspnr = pnr.getText();
		String bssted = sted.getText();
		int bsdag = Integer.parseInt(dag.getText());
		int bsmnd = Integer.parseInt(mnd.getText());
		int bsaar = Integer.parseInt(aar.getText());
		String bsemail = email.getText();
		String bstlf = tlf.getText();
		
		Boligs�ker seeker = new Boligs�ker(bsfnavn, bsenavn, bsadd, bspnr, bssted, bsdag, bsmnd, bsaar, bsemail, bstlf);

		
		return seeker;
		
		}
		catch ( NumberFormatException e ) {
		    errorOutput( "Ingen ny BoligS�ker pga av feil tallformat" );
		    return null;
		  }		
		
	}
	
	public Utleiere nyUtleier(){
		try{
			String bsfnavn = fornavn.getText();
			String bsenavn = etternavn.getText();
			String bsadd = adresse.getText();
			String bspnr = pnr.getText();
			String bssted = sted.getText();
			int bsdag = Integer.parseInt(dag.getText());
			int bsmnd = Integer.parseInt(mnd.getText());
			int bsaar = Integer.parseInt(aar.getText());
			String bsemail = email.getText();
			String bstlf = tlf.getText();
			
			Utleiere utleier = new Utleiere(bsfnavn, bsenavn, bsadd, bspnr, bssted, bsdag, bsmnd, bsaar, bsemail, bstlf);
			
			
			
			return utleier;
			
			}
			catch ( NumberFormatException e ) {
			    errorOutput( "Ingen ny BoligS�ker pga av feil tallformat" );
			    return null;
			  }	
	}
	
	
	private void errorOutput( String msg )
	{
	  JOptionPane.showMessageDialog( this, msg );
	}
	
	
	
	

	
}


