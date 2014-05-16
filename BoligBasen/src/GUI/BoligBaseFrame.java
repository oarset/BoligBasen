package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.*;

import Bolig.*;


public class BoligBaseFrame extends JFrame implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7705327600110562397L;
	private HeaderPanel header;
	private Personliste theList;
	private Boligliste boligList;
	private InfoPanel info;
	private int leftframe;
	private NewBrukerPanel brukerpan;
	private NewBoligPanel boligpan;
	private SeekerPanel seeker;
	private SeekerInfoPanel sip;
	private UtleierPanel utlpan;
	private MatchPanel match;
	
	
	 public BoligBaseFrame()
		{
		super("BoligBasen");
		
		leftframe = 1;
		theList = new Personliste();
		boligList= new Boligliste();
		
		// lager default panelene
		brukerpan = new NewBrukerPanel();
		
		// lager panelsene som ligger i framen
	 	seeker = new SeekerPanel();
	 	boligpan = new NewBoligPanel();
	 	sip = new SeekerInfoPanel();
	 	utlpan = new UtleierPanel();
	 	match = new MatchPanel();
		
		// lager default info panel
		info = new InfoPanel();
		
		// lager default tittel
		header = new HeaderPanel();
		header.setText("Lag ny Bruker");

		
		 // Legger til Filmeny
		JMenu filemenu = new JMenu("Fil");
		filemenu.setMnemonic('F');
		
			// Oppretter Ny bruker valg i fil-menyen
			JMenuItem nyBruker = new JMenuItem("Ny bruker");
			nyBruker.setMnemonic('u');
			nyBruker.addActionListener( 
					new ActionListener(){
						// endrer venstre panel til "ny bolig panel"
						public void actionPerformed(ActionEvent e){
							
						setLeftFrame(2, null, null, theList, null);
						}


					});
			
			// Oppretter til Ny bolig valg i fil-menyen
			JMenuItem nyBolig = new JMenuItem("Ny bolig");
			nyBolig.setMnemonic('b');
			nyBolig.addActionListener( 
					new ActionListener(){
						// endrer venstre panel til "ny bolig panel"
						public void actionPerformed(ActionEvent e){
							
						setLeftFrame(1, null, null, theList, null);
						}


					});
			
			// Oppretter et matching Panel for å finne boliger/boligsøkere som matcher
					JMenuItem matcher = new JMenuItem("Match bolig");
					matcher.setMnemonic('b');
					matcher.addActionListener( 
							new ActionListener(){
								// endrer venstre panel til Matching Panel
								public void actionPerformed(ActionEvent e){
									
								setLeftFrame(7, null, null, theList, null);
								}
							});
		
		// Legger til Lister meny
		JMenu listemenu = new JMenu("Lister");
		listemenu.setMnemonic('L');
		
			// viser alle boligsøkere
			JMenuItem kundeliste = new JMenuItem("Alle Boligsøkere");
			kundeliste.setMnemonic('s');
			kundeliste.addActionListener( 
					new ActionListener(){
						// endrer infopanel til å vise liste over alle personer i personliste
						public void actionPerformed(ActionEvent e){
							try{
								setInfoPanel(2, theList, boligList);
							}
							catch ( NullPointerException npe ) {
							    errorOutput( "Ingen brukere er registrert" );
							    
							}	
						
						}


					});
			
			// Viser alle utleiere
			JMenuItem utlliste = new JMenuItem("Alle Utleiere");
			utlliste.setMnemonic('U');
			utlliste.addActionListener( 
					new ActionListener(){
						// endrer infopanel til å vise liste over alle personer i personliste
						public void actionPerformed(ActionEvent e){
							try{
								setInfoPanel(1, theList, boligList);
							}
							catch ( NullPointerException npe ) {
							    errorOutput( "Ingen Utleiere er registrert" );
							    
							}	
						
						}


					});
			
			// Viser alle utleiere
			JMenuItem boligliste = new JMenuItem("Alle Boliger");
			boligliste.setMnemonic('B');
			boligliste.addActionListener( 
				new ActionListener(){
					// endrer infopanel til å vise liste over alle personer i personliste
					public void actionPerformed(ActionEvent e){
						try{
							setInfoPanel(3, theList, boligList);
						}
						catch ( NullPointerException npe ) {
						    errorOutput( "Ingen Boliger er registrert" );    
						}
					}
				});
			
		// Legger til en meny for lagring
		JMenu savemenu = new JMenu("Lagre");
		savemenu.setMnemonic('L');
		
			// Lagre meny
			JMenuItem saveFile = new JMenuItem("Lagre til Fil");
			saveFile.setMnemonic('F');
			saveFile.addActionListener( 
				new ActionListener(){
					// endrer infopanel til å vise liste over alle personer i personliste
					public void actionPerformed(ActionEvent e){
						try{
							setInfoPanel(4, theList, boligList);
						}
						catch ( NullPointerException npe ) {
						    errorOutput( "Kunne ikke lagre" );    
						}
					}
				});
		
		// Legger til info meny
		JMenu infomenu = new JMenu("Info");
		infomenu.setMnemonic('I');
		
		
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
		menu.add(listemenu);
		menu.add(infomenu);
		menu.add(savemenu);
		
		//legger til inhold i fil menyen
		filemenu.add(nyBruker);
		filemenu.add(nyBolig);
		filemenu.add(matcher);
		
		
		//legger til inhold i liste menyen
		listemenu.add(kundeliste);
		listemenu.add(utlliste);
		listemenu.add(boligliste);
		
		//legger til inhold i lagrings menyen
		savemenu.add(saveFile);
				
		
		// legger til innhold i Info menyen
		infomenu.add(veiviser);
		infomenu.add(om);

		
		Container c = getContentPane();
	 	c.setLayout( new BorderLayout() );
	 	c.add(header,BorderLayout.PAGE_START);
	 	c.add(brukerpan, BorderLayout.LINE_START);
	 	c.add(info, BorderLayout.LINE_END);
		  
	 	nySeekerP1AL();
	 	nyUtlP1AL();
	 	
		setSize( 1080, 840 );
		setVisible( true );
		}

	// actionlistener som håndterer opprettelse av ny Boligsøker (page1)
	 public void nySeekerP1AL(){
		 
	 brukerpan.newSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == brukerpan.newBoligSeekerButton){
					Boligsøker seek = brukerpan.nyBoligSeeker();
					String infostring = seek.toString();
			    	info.addContent(infostring);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(3, seek, null, theList, null);
				}
			}
	 		
	 		
	 	});
	 } 
	
	 public void nySeekerP2AL(){
	 // actionlistener som håndterer lagring av Boligskøer fra "SeekerPanel" (page2)
	 seeker.saveSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == seeker.saveSeekerButton){
					seeker.oppdaterBoligSeeker();
					Boligsøker seek = seeker.getSeeker();
					String infostring = seek.toString();
					info.addContent(infostring);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(4, seek, null, theList, null);
				}
			}
	 		
	 		
	 	});
	 }
	 
	 public void nyUtlP1AL(){
	 
	// actionlistener som håndterer opprettelse av ny Utleier (page1)
 	brukerpan.newUtlActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == brukerpan.newUtleierButton){
				Utleiere utl = brukerpan.nyUtleier();
				String infostring = utl.toString();
		    	info.addContent(infostring);
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(6, null, utl, theList, null);
			}
			}		

	 	});
	 }
	 
	 public void nyUtlP2AL(){
	// actionlistener som håndterer lagring av Utleier fra "UtleierPanel" (page2)
	 utlpan.saveUtlActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == utlpan.saveUtlButton){
					Utleiere u = utlpan.getUtl();
					utlpan.setUtl(u);
					utlpan.setCompleetUtl();
					Utleiere utl = utlpan.getUtl();
					String infostring = utl.toString();
					info.addContent(infostring);
					theList.settInnPerson(utl);
					//Container c = getContentPane();
					//c.removeAll();
				 	//c.setLayout( new BorderLayout() );
				 	//c.add(header,BorderLayout.PAGE_START);
				 	//c.add(brukerpan, BorderLayout.LINE_START);
				 	//c.add(info, BorderLayout.LINE_END);
					//c.revalidate();
					//c.repaint();
					setLeftFrame(2, null, utl, theList, null);
				}
			}
	
	 	});
	 } 
	 
	 public void nySeekerBackP2AL(){
	 
	// actionlistener som håndterer "tilbake" knappen på SeekerPanel (page2)
	 seeker.seekerBackActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == seeker.backButton){
					setLeftFrame(2, null, null, theList, null);
				}
				}
	 		
	 		
	 	});
	 
	 }
	 
	 public void nySeekerBackP3AL(){
	// actionlistener som håndterer "tilbake" knappen på SeekerInfoPanel (page3)
	 sip.seekerInfoBackActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == sip.saveInfoButton){
					
					setLeftFrame(2, null, null, theList, null);
				}
			}
	 		
	 		
	 	});
	 
	 }
	 
	 public void nySeekerP3AL(){
	// actionlistener som håndterer lagring av Boligsøker fra "SeekerInfoPanel" (page3)
	 sip.saveSeekerInfoActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == sip.saveInfoButton){
					Boligsøker bs = seeker.getSeeker();
					sip.setSeeker(bs);
					sip.setCompleetSeeker();
					Boligsøker seek = sip.getSeeker();
					String infostring = seek.toString();
					info.addContent(infostring);
					theList.settInnPerson(seek);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(2, null, null, theList, null);
				}
			}
	 		
			
	 	});
	 
	 }
	 
	 public void nyBackUtlP2AL(){
	// actionlistener som håndterer "tilbake" knappen på UtleierPanel (page2) og ny Eier på BoligPanelet
	 utlpan.utlBackActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == utlpan.backButton){
					setLeftFrame(2, null, null, theList, null);
				}
			}
	 		
	 		
	 	});
	 }
	 public void nySaveBOP1AL(){
	// actionlistener som håndterer Lagre Bolig knappen på BoligPanelet (page1)
		 boligpan.saveBoligActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getSource() == boligpan.saveBoligButton){	
					
					Bolig b = boligpan.saveNyBolig();
					boligList.settInnBolig(b);
					String infostring = b.toString();
					info.addContent(infostring);
					setLeftFrame(1, null, null, theList, boligList);
					}
				}
		 		
		 		
		 	});
	 
	 }
	 
	 public void setLeftFrame(int i, Boligsøker seek, Utleiere utl, Personliste list, Boligliste blist){
		 
		leftframe = i; 
		
		// setter venstre panel  til NyBoligPanel
		if(leftframe == 1){
			
			Personliste p = theList.utleierliste();
			Container c = getContentPane();
			c.removeAll();
			NewBoligPanel boligpanel = new NewBoligPanel();	
			boligpan = boligpanel;
			boligpan.setUltListe(p);
			
			header.setText("Ny Bolig");
			try{
				Bruker cycle = boligpan.getUtlListe().getFirst();
			
			if (boligpan.getUtlListe().getFirst() != null){
				while (cycle.utleierNeste != null) {
					boligpan.utleiervelger.addItem(cycle.nametoString());
					cycle = cycle.utleierNeste;
					
				}	
			}
			}
			catch ( NullPointerException npe ) {
			    errorOutput( "Ingen Utleiere er registrert" );
			    
			}	
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(boligpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
		 	nySaveBOP1AL();
		 	nyBackUtlP2AL();
		 	//repainting
			c.revalidate();
			c.repaint();
		}
		
		// setter venstre panel  til NyBrukerPanel
		else if( leftframe == 2){
			
			Container c = getContentPane();
			c.removeAll();
			
			NewBrukerPanel brukerpanel = new NewBrukerPanel(); 
			brukerpan = brukerpanel;
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(brukerpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
		 	nySeekerP1AL();
		 	nyUtlP1AL();
		 	//repainting
			c.revalidate();
			c.repaint();
		}
		
		// setter venstre panel til SeekerPanel
		else if( leftframe == 3){
			Boligsøker s = seek;
			Container c = getContentPane();
			SeekerPanel seekpanel = new SeekerPanel();
			seeker = seekpanel;
			seeker.setSeeker(s);
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(seeker, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
		 	nySeekerP2AL();
		 	nySeekerBackP2AL();
		 	//repainting
			c.revalidate();
			c.repaint();

		}
		// setter venstre panel  til SeekerInfoPanel
		else if( leftframe == 4){
			Boligsøker s = seek;
			
			
			Container c = getContentPane();
			SeekerInfoPanel sipanel = new SeekerInfoPanel();
			sip = sipanel;
			sip.setSeeker(s);
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(sip, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
		 	nySeekerP3AL();
		 	nySeekerBackP3AL();
		 	//repainting
			c.revalidate();
			c.repaint();
		}
		// setter venstre panel til ny brukerpanel etter lagring på SeekerInfoPanel
		else if( leftframe == 5){
			Boligsøker s = seek;
			
			seeker.setSeeker(s);
			Container c = getContentPane();
			NewBrukerPanel brukerpanel = new NewBrukerPanel();
			brukerpan = brukerpanel;
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(brukerpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
		 	nySeekerP1AL();
		 	nyUtlP1AL();
		 	//repainting
			c.revalidate();
			c.repaint();
		}
		
		// setter venstre panel  til UtleierPanel
		else if( leftframe == 6){
			Utleiere u = utl;
			
			
			Container c = getContentPane();
			UtleierPanel utlpanel = new UtleierPanel();
			utlpan = utlpanel;
			utlpan.setUtl(u);
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(utlpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
			nyUtlP2AL();
			nyBackUtlP2AL();
			//repainting
			c.revalidate();
			c.repaint();
		}
		// setter venstre panel  til NyBoligPanel
		else if(leftframe == 7){
				 
			Container c = getContentPane();
			MatchPanel matchpan = new MatchPanel();
			match = matchpan;
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(match, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
			nyUtlP2AL();
			nyBackUtlP2AL();
			//repainting
			c.revalidate();
			c.repaint();
		}
		// setter venstre panel til nyBolig og høyre viser boligliste 
		else if( leftframe == 8){
			Utleiere u = utl;
			
			
			Container c = getContentPane();
			UtleierPanel utlpanel = new UtleierPanel();
			utlpan = utlpanel;
			utlpan.setUtl(u);
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(utlpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	//laster ActionListeners
			nyUtlP2AL();
			nyBackUtlP2AL();
			//repainting
			c.revalidate();
			c.repaint();
		}
		 
	 }
	 
	 // metode som repainter infoPanel avhengig av input
	 public void setInfoPanel(int i, Personliste list, Boligliste blist){
		 
		 int rightframe = i;
		 // infoPanel viser alle Utleiere
		 if(rightframe == 1){
			
			Personliste utleiere = new Personliste(); 
			utleiere = theList.utleierliste();
			String s = utleiere.toString(); 
			s += "lol";
			info.removeAll();
			info.addContent(s);
			info.revalidate();
			info.repaint();
		 }
		 
		 //infoPanel viser alle leiere
		 if(rightframe == 2){
			 
			Personliste seekers = new Personliste(); 
			seekers = theList;
			String s = seekers.toString(); 
			s += "lol";
			info.removeAll();
			info.addContent(s);
			info.revalidate();
			info.repaint();
			 }
		 
		//infoPanel viser alle boliger
		 if(rightframe == 3){
			 
			String s = blist.toString(); 
			s += "lol";
			info.removeAll();
			info.addContent(s);
			info.revalidate();
			info.repaint();
			 }
		 
		 
		//Lagrer alt
		 if(rightframe == 4){
			 
			
			info.removeAll();
			info.addContent("Lagret data til fil");
			info.revalidate();
			info.repaint();
			 }
		 
	 }
	  
	 private void errorOutput( String msg )
		{
		  JOptionPane.showMessageDialog( this, msg );
		}

	 
}
