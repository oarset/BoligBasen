package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;

import Bolig.*;


public class BoligBaseFrame extends JFrame implements Serializable{
	

	private static final long serialVersionUID = 7705327600110562397L;
	private HeaderPanel header;
	private Personliste theList, utleie;
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
		utleie = new Personliste();
		boligList= new Boligliste();
		this.lesFraFil();
		
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
			
			// Oppretter et matching Panel for � finne boliger/boligs�kere som matcher
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
		
			// viser alle boligs�kere
			JMenuItem kundeliste = new JMenuItem("Alle Boligs�kere");
			kundeliste.setMnemonic('s');
			kundeliste.addActionListener( 
					new ActionListener(){
						// endrer infopanel til � vise liste over alle personer i personliste
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
						// endrer infopanel til � vise liste over alle personer i personliste
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
					// endrer infopanel til � vise liste over alle personer i personliste
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
					// endrer infopanel til � vise liste over alle personer i personliste
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

	// actionlistener som h�ndterer opprettelse av ny Boligs�ker (page1)
	 public void nySeekerP1AL(){
		 
	 brukerpan.newSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == brukerpan.newBoligSeekerButton){
					Boligs�ker seek = brukerpan.nyBoligSeeker();
					String infostring = seek.toString();
			    	info.addContent(infostring);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligs�ker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(3, seek, null, theList, null);
				}
			}
	 		
	 		
	 	});
	 } 
	
	 public void nySeekerP2AL(){
	 // actionlistener som h�ndterer lagring av Boligsk�er fra "SeekerPanel" (page2)
	 seeker.saveSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == seeker.saveSeekerButton){
					seeker.oppdaterBoligSeeker();
					Boligs�ker seek = seeker.getSeeker();
					String infostring = seek.toString();
					info.addContent(infostring);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligs�ker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(4, seek, null, theList, null);
				}
			}
	 		
	 		
	 	});
	 }
	 
	 public void nyUtlP1AL(){
	 
	// actionlistener som h�ndterer opprettelse av ny Utleier (page1)
 	brukerpan.newUtlActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == brukerpan.newUtleierButton){
				Utleiere utl = brukerpan.nyUtleier();
				String infostring = utl.toString();
		    	info.addContent(infostring);
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligs�ker");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(6, null, utl, theList, null);
			}
			}		

	 	});
	 }
	 
	 public void nyUtlP2AL(){
	// actionlistener som h�ndterer lagring av Utleier fra "UtleierPanel" (page2)
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
					utleie.settInnUtleier(utl);
					setLeftFrame(2, null, utl, theList, null);
				}
			}
	
	 	});
	 } 
	 
	 public void nySeekerBackP2AL(){
	 
	// actionlistener som h�ndterer "tilbake" knappen p� SeekerPanel (page2)
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
	// actionlistener som h�ndterer "tilbake" knappen p� SeekerInfoPanel (page3)
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
	// actionlistener som h�ndterer lagring av Boligs�ker fra "SeekerInfoPanel" (page3)
	 sip.saveSeekerInfoActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == sip.saveInfoButton){
					Boligs�ker bs = seeker.getSeeker();
					sip.setSeeker(bs);
					sip.setCompleetSeeker();
					Boligs�ker seek = sip.getSeeker();
					String infostring = seek.toString();
					info.addContent(infostring);
					theList.settInnPerson(seek);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligs�ker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(2, null, null, theList, null);
				}
			}
	 		
			
	 	});
	 
	 }
	 
	 public void nyBackUtlP2AL(){
	// actionlistener som h�ndterer "tilbake" knappen p� UtleierPanel (page2) og ny Eier p� BoligPanelet
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
	// actionlistener som h�ndterer Lagre Bolig knappen p� BoligPanelet (page1)
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
	 
	 public void setLeftFrame(int i, Boligs�ker seek, Utleiere utl, Personliste list, Boligliste blist){
		 
		leftframe = i; 
		
		// setter venstre panel  til NyBoligPanel
		if(leftframe == 1){
			
			Container c = getContentPane();
			c.removeAll();
			//NewBoligPanel boligpanel = new NewBoligPanel();	
			//boligpan = boligpanel;
			//boligpan.setUltListe(utleie);
			
			header.setText("Ny Bolig");
			try{
				Bruker cycle = utleie.getFirst();
			
				if (utleie.getFirst() != null){
					while (cycle != null ) {
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
			Boligs�ker s = seek;
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
			Boligs�ker s = seek;
			
			
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
		// setter venstre panel til ny brukerpanel etter lagring p� SeekerInfoPanel
		else if( leftframe == 5){
			Boligs�ker s = seek;
			
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
		// setter venstre panel til nyBolig og h�yre viser boligliste 
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
	 public void lagreTilFil() {
			try (ObjectOutputStream utfil = new ObjectOutputStream(
			        new FileOutputStream("liste.data") ))
			{
						ObjectOutputStream utfil2 = new ObjectOutputStream(
				        new FileOutputStream("liste2.data") );
						utfil.writeObject(theList);
						utfil2.writeObject(boligList);
						utfil.flush();
						utfil2.flush();
						utfil.close();
						utfil2.close();
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
			} catch (IOException e) {
				System.out.println("IO");
			}
	 }
	 
	 public void lesFraFil() {
		 try (ObjectInputStream innfil = new ObjectInputStream(
					new FileInputStream("liste.data")))
				{
			 		ObjectInputStream innfil2 = new ObjectInputStream(
			 		new FileInputStream("liste2.data") );
			 		theList = (Personliste) innfil.readObject();
			 		boligList = (Boligliste) innfil2.readObject();
				
				} catch (FileNotFoundException e) {
					System.out.println("file not found");
				} catch (IOException e) {
					System.out.println("IO");
				} catch (ClassNotFoundException e) {
					System.out.println("Class not found");
				}	
	 }
	 
	 // metode som repainter infoPanel avhengig av input
	 public void setInfoPanel(int i, Personliste list, Boligliste blist){
		 
		 int rightframe = i;
		 // infoPanel viser alle Utleiere
		 if(rightframe == 1){
			
			Personliste temp = new Personliste();
			temp = utleie;
			String s = temp.utleiertoString(); 
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
			this.lagreTilFil();
		}
		 
	 }
	  
	 private void errorOutput( String msg )
		{
		  JOptionPane.showMessageDialog( this, msg );
		}

	 
}
