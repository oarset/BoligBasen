package GUI;

import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class newBrukerPanel extends JPanel{

	private JFormattedTextField fornavn, etternavn, adresse, dag, mnd, aar, email, tlf;
	
	public newBrukerPanel(){
		
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
		
		// label og inputfelt for f�dselsdato
		JPanel datoPanel = new JPanel();
		BorderLayout bl4 = new BorderLayout();
		bl4.setHgap(10);
		bl4.setVgap(5);
		datoPanel.setLayout(bl4);
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
		c.gridy = 4;
		add(datoPanel, c);
		
		
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
