package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Bolig.Boligsøker;
import Bolig.Bruker;
import Bolig.Utleiere;


public class BoligBaseFrame extends JFrame implements ActionListener{
	
	private JPanel header;
	private InfoPanel info;
	private int leftframe;
	public NewBrukerPanel brukerpan;
	public SeekerPanel seeker;
	
	
	 public BoligBaseFrame()
		{
		super("BoligBasen");

		leftframe = 1;
		
		// lager default panelene
		brukerpan = new NewBrukerPanel();
		
		// lager hjelpe panel for boligsøkere
	 	seeker = new SeekerPanel();
		
		// lager default infor panel
		info = new InfoPanel("");
		
		// lager default tittel
		header = new JPanel();
		JLabel headerLabel = new JLabel("Lag ny Bruker");
		header.add(headerLabel);
		
		 // Legger til Fil meny
		JMenu filemenu = new JMenu("Fil");
		filemenu.setMnemonic('F');
		
		JMenu infomenu = new JMenu("Info");
		infomenu.setMnemonic('I');
		
		// Oppretter Ny bruker valg i fil-menyen
		JMenuItem nyBruker = new JMenuItem("Ny bruker");
		nyBruker.setMnemonic('u');
		nyBruker.addActionListener( 
				new ActionListener(){
					// endrer venstre panel til "ny bolig panel"
					public void actionPerformed(ActionEvent e){
						
					setLeftFrame(2, info, header, null, null);
					}


				});
		
		// Oppretter til Ny bolig valg i fil-menyen
		JMenuItem nyBolig = new JMenuItem("Ny bolig");
		nyBolig.setMnemonic('b');
		nyBolig.addActionListener( 
				new ActionListener(){
					// endrer venstre panel til "ny bolig panel"
					public void actionPerformed(ActionEvent e){
						
					setLeftFrame(1, info, header, null, null);
					}


				});
		
		// Oppretter til Ny bolig valg i fil-menyen
		JMenuItem veiviser = new JMenuItem("Veiviser");
		veiviser.setMnemonic('b');
				
		// Oppretter til Ny bolig// Oppretter til Ny bolig valg i fil-menyen
		JMenuItem om = new JMenuItem("Om...");
		om.setMnemonic('b');

		
		// plaserer menylinjen i framen
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		//legger til menyer
		menu.add(filemenu);
		menu.add(infomenu);
		
		
		//legger til inhold i fil menyen
		filemenu.add(nyBruker);
		filemenu.add(nyBolig);
		
		// legger til innhold i Info menyen
		infomenu.add(veiviser);
		infomenu.add(om);

		
		Container c = getContentPane();
	 	c.setLayout( new BorderLayout() );
	 	c.add(header,BorderLayout.PAGE_START);
	 	c.add(brukerpan, BorderLayout.LINE_START);
	 	c.add(info, BorderLayout.LINE_END);
		  
	 	// actionlistener som håndterer opprettelse av ny Boligsøker (page1)
	 	brukerpan.newSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Boligsøker seek = brukerpan.nyBoligSeeker();
				String infostring = seek.toString();
		    	InfoPanel info = new InfoPanel(infostring);
		    	JPanel header = new JPanel();
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
				header.add(headerLabel);
				setLeftFrame(3, info, header, seek, null);
				
			}
	 		
	 		
	 	});
	 	
	 	seeker.saveSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Boligsøker seek = seeker.getSeeker();
				String infostring = seek.toString();
		    	InfoPanel info = new InfoPanel(infostring);
		    	JPanel header = new JPanel();
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
				header.add(headerLabel);
				setLeftFrame(3, info, header, seek, null);
				
			}
	 		
	 		
	 	});
	 	

	 	

	 	
		setSize( 1080, 840 );
		setVisible( true );
		}
	 
	 public void setLeftFrame(int i, InfoPanel info, JPanel head, Boligsøker seek, Utleiere utl){
		 
		leftframe = i; 
		if(leftframe == 1){
		NewBoligPanel boligpan = new NewBoligPanel();
			 
		Container c = getContentPane();
		c.removeAll();
	 	c.setLayout( new BorderLayout() );
	 	c.add(head,BorderLayout.PAGE_START);
	 	c.add(boligpan, BorderLayout.LINE_START);
	 	c.add(info, BorderLayout.LINE_END);
		c.revalidate();
		c.repaint();
		}
		
		else if( leftframe == 2){
		NewBrukerPanel brukerpan = new NewBrukerPanel();
		
		Container c = getContentPane();
		c.removeAll();
	 	c.setLayout( new BorderLayout() );
	 	c.add(head,BorderLayout.PAGE_START);
	 	c.add(brukerpan, BorderLayout.LINE_START);
	 	c.add(info, BorderLayout.LINE_END);
		c.revalidate();
		c.repaint();
		}
		
		else if( leftframe == 3){
			Boligsøker s = seek;
			
			seeker.setSeeker(s);
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(head,BorderLayout.PAGE_START);
		 	c.add(seeker, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
			c.revalidate();
			c.repaint();
			}
		 
	 }
	 
	 public void nySeeker(){
		 
		 setLeftFrame(3, info, header, null, null);

	 }
	 

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if ( e.getSource() == brukerpan.newBoligSeekerButton ){
	
	
		  }
		    else if ( e.getSource() == brukerpan.newUtleierButton ){
		      brukerpan.nyUtleier();
	
		  }
			
		}

		  
	 
	 
}
