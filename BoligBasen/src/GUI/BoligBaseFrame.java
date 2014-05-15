package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Bolig.*;


public class BoligBaseFrame extends JFrame{
	
	private HeaderPanel header;
	private Personliste theList;
	private InfoPanel info;
	private int leftframe;
	public NewBrukerPanel brukerpan;
	public NewBoligPanel boligpan;
	public SeekerPanel seeker;
	public SeekerInfoPanel sip;
	public UtleierPanel utlpan;
	
	
	 public BoligBaseFrame()
		{
		super("BoligBasen");

		leftframe = 1;
		theList = new Personliste();
		
		// lager default panelene
		brukerpan = new NewBrukerPanel();
		
		// lager hjelpe panel for boligsøkere og ny bolig
	 	seeker = new SeekerPanel();
	 	boligpan = new NewBoligPanel();
	 	sip = new SeekerInfoPanel();
	 	utlpan = new UtleierPanel();
		
		// lager default infor panel
		info = new InfoPanel();
		
		// lager default tittel
		header = new HeaderPanel();
		header.setText("Lag ny Bruker");

		
		 // Legger til Fil meny
		JMenu filemenu = new JMenu("Fil");
		filemenu.setMnemonic('F');
		
			// Oppretter Ny bruker valg i fil-menyen
			JMenuItem nyBruker = new JMenuItem("Ny bruker");
			nyBruker.setMnemonic('u');
			nyBruker.addActionListener( 
					new ActionListener(){
						// endrer venstre panel til "ny bolig panel"
						public void actionPerformed(ActionEvent e){
							
						setLeftFrame(2, null, null, theList);
						}


					});
			
			// Oppretter til Ny bolig valg i fil-menyen
			JMenuItem nyBolig = new JMenuItem("Ny bolig");
			nyBolig.setMnemonic('b');
			nyBolig.addActionListener( 
					new ActionListener(){
						// endrer venstre panel til "ny bolig panel"
						public void actionPerformed(ActionEvent e){
							
						setLeftFrame(1, null, null, theList);
						}


					});
		
		// Legger til Lister meny
		JMenu listemenu = new JMenu("Lister");
		listemenu.setMnemonic('L');
		
			// Oppretter til Ny bolig valg i fil-menyen
			JMenuItem kundeliste = new JMenuItem("Alle Boligsøkere");
			kundeliste.setMnemonic('B');
			kundeliste.addActionListener( 
					new ActionListener(){
						// endrer infopanel til å vise liste over alle personer i personliste
						public void actionPerformed(ActionEvent e){
							try{
								setRightFrame(1);
							}
							catch ( NullPointerException npe ) {
							    errorOutput( "Ingen brukere er registrert" );
							    
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
		
		
		//legger til inhold i fil menyen
		filemenu.add(nyBruker);
		filemenu.add(nyBolig);
		
		//legger til inhold i liste menyen
		listemenu.add(kundeliste);
				
		
		// legger til innhold i Info menyen
		infomenu.add(veiviser);
		infomenu.add(om);

		
		Container c = getContentPane();
	 	c.setLayout( new BorderLayout() );
	 	c.add(header,BorderLayout.PAGE_START);
	 	c.add(brukerpan, BorderLayout.LINE_START);
	 	c.add(info, BorderLayout.LINE_END);
		  
	 	addAllAL();
	 	
		setSize( 1080, 840 );
		setVisible( true );
		}

	// actionlistener som håndterer opprettelse av ny Boligsøker (page1)
	 public void addAllAL(){
	 brukerpan.newSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Boligsøker seek = brukerpan.nyBoligSeeker();
				String infostring = seek.toString();
		    	info.addContent(infostring);
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(3, seek, null, theList);
				
			}
	 		
	 		
	 	});
	 
	// actionlistener som håndterer opprettelse av ny Utleier (page1)
		 brukerpan.newUtlActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					Utleiere utl = brukerpan.nyUtleier();
					String infostring = utl.toString();
			    	info.addContent(infostring);
					JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
					header.removeAll();
					header.add(headerLabel);
					setLeftFrame(6, null, utl, theList);
					
				}
		 		
		 		
		 	});
	 // actionlistener som håndterer lagring av Boligsøer fra "SeekerPanel" (page2)
	 seeker.saveSeekerActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				seeker.oppdaterBoligSeeker();
				Boligsøker seek = seeker.getSeeker();
				String infostring = seek.toString();
				info.addContent(infostring);
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(4, seek, null, theList);
				
			}
	 		
	 		
	 	});
	// actionlistener som håndterer lagring av Utleier fra "UtleierPanel" (page2)
	 utlpan.saveUtlActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = getContentPane();
				c.removeAll();
			 	c.setLayout( new BorderLayout() );
			 	c.add(header,BorderLayout.PAGE_START);
			 	c.add(brukerpan, BorderLayout.LINE_START);
			 	c.add(info, BorderLayout.LINE_END);
			 	addAllAL();
				c.revalidate();
				c.repaint();
				
				Utleiere u = utlpan.getUtl();
				utlpan.setUtl(u);
				utlpan.setCompleetUtl();
				Utleiere utl = utlpan.getUtl();
				String infostring = utl.toString();
				info.addContent(infostring);
				theList.settInnPerson(utl);
				JLabel headerLabel = new JLabel("Legg inn data for Utleier");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(1, null, utl, theList);
				
			}
	 		
	 		
	 	});
	 
	 
	// actionlistener som håndterer "tilbake" knappen på SeekerPanel (page2)
	 seeker.seekerBackActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = getContentPane();
				c.removeAll();
			 	c.setLayout( new BorderLayout() );
			 	c.add(header,BorderLayout.PAGE_START);
			 	brukerpan.revalidate();
			 	brukerpan.repaint();
			 	c.add(brukerpan, BorderLayout.LINE_START);
			 	c.add(info, BorderLayout.LINE_END);
			 	addAllAL();
				c.revalidate();
				c.repaint();
				
			}
	 		
	 		
	 	});
	// actionlistener som håndterer "tilbake" knappen på SeekerInfoPanel (page3)
	 sip.seekerInfoBackActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = getContentPane();
				c.removeAll();
			 	c.setLayout( new BorderLayout() );
			 	c.add(header,BorderLayout.PAGE_START);
			 	c.add(seeker, BorderLayout.LINE_START);
			 	c.add(info, BorderLayout.LINE_END);
			 	addAllAL();
				c.revalidate();
				c.repaint();
				
			}
	 		
	 		
	 	});
	// actionlistener som håndterer lagring av Boligsøker fra "SeekerInfoPanel" (page3)
	 sip.saveSeekerInfoActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
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
				setLeftFrame(1, null, null, theList);
				
			}
	 		
			
	 	});
	// actionlistener som håndterer "tilbake" knappen på UtleierPanel (page2)
	 utlpan.utlBackActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Container c = getContentPane();
				c.removeAll();
			 	c.setLayout( new BorderLayout() );
			 	c.add(header,BorderLayout.PAGE_START);
			 	c.add(brukerpan, BorderLayout.LINE_START);
			 	c.add(info, BorderLayout.LINE_END);
			 	addAllAL();
				c.revalidate();
				c.repaint();
				
			}
	 		
	 		
	 	});
	 
	// actionlistener som håndterer "tilbake" knappen på UtleierPanel (page1)
		 boligpan.boligBackActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Container c = getContentPane();
					c.removeAll();
				 	c.setLayout( new BorderLayout() );
				 	c.add(header,BorderLayout.PAGE_START);
				 	c.add(brukerpan, BorderLayout.LINE_START);
				 	c.add(info, BorderLayout.LINE_END);
				 	addAllAL();
					c.revalidate();
					c.repaint();
					
				}
		 		
		 		
		 	});
	 
	 
}
	 
	 public void setLeftFrame(int i, Boligsøker seek, Utleiere utl, Personliste list){
		 
		leftframe = i; 
		
		// setter venstre frame til NyBoligPanel
		if(leftframe == 1){
				 
			header.setText("Ny Bolig");
			boligpan.setUtleierListe(list);
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(boligpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		}
		
		// setter venstre frame til NyBrukerPanel
		else if( leftframe == 2){
			
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(brukerpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		}
		
		// setter venstre frame til SeekerPanel
		else if( leftframe == 3){
			Boligsøker s = seek;
			
			seeker.setSeeker(s);
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(seeker, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		}
		// setter venstre frame til SeekerInfoPanel
		else if( leftframe == 4){
			Boligsøker s = seek;
			
			seeker.setSeeker(s);
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(sip, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		}
		
		else if( leftframe == 5){
			Boligsøker s = seek;
			
			seeker.setSeeker(s);
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(brukerpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		}
		
		// setter venstre frame til UtleierPanel
		else if( leftframe == 6){
			Utleiere u = utl;
			
			utlpan.setUtl(u);
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(utlpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		}
		 
	 }
	 
	 public void setRightFrame(int i){
		 
		 int rightframe = i;
		 
		 if(rightframe == 1){
			 
			String s = theList.toString(); 
			s += "lol";
			info.addContent(s); 
			Container c = getContentPane();
			c.removeAll();
		 	c.setLayout( new BorderLayout() );
		 	c.add(header,BorderLayout.PAGE_START);
		 	c.add(boligpan, BorderLayout.LINE_START);
		 	c.add(info, BorderLayout.LINE_END);
		 	addAllAL();
			c.revalidate();
			c.repaint();
		 }
		 
	 }
	 
	 public void nySeeker(){
		 
		 setLeftFrame(3, null, null, theList);

	 }
	 
	 private void errorOutput( String msg )
		{
		  JOptionPane.showMessageDialog( this, msg );
		}

	 
}
