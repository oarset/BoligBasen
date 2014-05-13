package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Bolig.Boligsøker;
import Bolig.Person;


public class NewBrukerPanel extends JPanel{

	private JFormattedTextField fornavn, etternavn, adresse, pnr, sted, dag, mnd, aar, email, tlf;
	private JButton newBoligSeekerButton, newUtleierButton;
	private Person per;
	
	public NewBrukerPanel(){
		
		setPreferredSize(new Dimension(500,200));
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.NORTHWEST;
	

		
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
		c.insets = new Insets(30,50,0,10);
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
		c.insets = new Insets(10,50,0,10);
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
		
		
		// label og inputfelt for fødselsdato
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
		
		
		datoPanel.add( new JLabel( "Fødselsdato" ), BorderLayout.PAGE_START );
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
		
		// legger til knapper for å lagre boligsøker/utleier
		
		JPanel buttonPanel = new JPanel();
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(fl);
		
		newBoligSeekerButton = new JButton("Ny Bolig Søker");
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
		
		Knappelytter lytter = new Knappelytter();

		newBoligSeekerButton.addActionListener( lytter );
		newUtleierButton.addActionListener(lytter);
		
	}
	
	public Boligsøker nyBoligSeeker(){
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
		
		Boligsøker seeker = new Boligsøker(bsfnavn, bsenavn, bsadd, bspnr, bssted, bsdag, bsmnd, bsaar, bsemail, bstlf);
		
		return seeker;
		
		}
		catch ( NumberFormatException e ) {
		    errorOutput( "Ingen ny BoligSøker pga av feil tallformat" );
		    return null;
		  }
		
		
		
		
	}
	
	public void nyUtleier(){
		
	}
	
	
	private void errorOutput( String msg )
	{
	  JOptionPane.showMessageDialog( this, msg );
	}

	private class Knappelytter implements ActionListener
	{
	  public void actionPerformed( ActionEvent e )
	  {
	    if ( e.getSource() == newBoligSeekerButton )
	      nyBoligSeeker();
	    else if ( e.getSource() == newUtleierButton )
	      nyUtleier();

	  }
	}
}


