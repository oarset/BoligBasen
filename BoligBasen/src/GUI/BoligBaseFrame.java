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
	
	private JPanel header;
	private InfoPanel info;
	private int leftframe;
	private Personliste personliste;
	public NewBrukerPanel brukerpan;
	public NewBoligPanel boligpan;
	public SeekerPanel seeker;
	public SeekerInfoPanel sip;
	public UtleierPanel utlpan;
	
	
	 public BoligBaseFrame()
		{
		super("BoligBasen");

		leftframe = 1;
		personliste = new Personliste();
		
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
						
					setLeftFrame(2, null, null);
					}


				});
		
		// Oppretter til Ny bolig valg i fil-menyen
		JMenuItem nyBolig = new JMenuItem("Ny bolig");
		nyBolig.setMnemonic('b');
		nyBolig.addActionListener( 
				new ActionListener(){
					// endrer venstre panel til "ny bolig panel"
					public void actionPerformed(ActionEvent e){
						
					setLeftFrame(1, null, null);
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
				setLeftFrame(3, seek, null);
				
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
					setLeftFrame(6, null, utl);
					
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
				setLeftFrame(4, seek, null);
				
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
				personliste.settInnPerson(utl);
				JLabel headerLabel = new JLabel("Legg inn data for Utleier");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(1, null, utl);
				
			}
	 		
	 		
	 	});
	 
	 
	 
	 seeker.seekerBackActionListener(new ActionListener(){
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
	 
	 sip.seekerBackActionListener(new ActionListener(){
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
	 
	 sip.saveSeekerInfoActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Boligsøker bs = seeker.getSeeker();
				sip.setSeeker(bs);
				sip.setCompleetSeeker();
				Boligsøker seek = sip.getSeeker();
				String infostring = seek.toString();
				info.addContent(infostring);
				personliste.settInnPerson(seek);
				JLabel headerLabel = new JLabel("Legg inn data for ny Boligsøker");
				header.removeAll();
				header.add(headerLabel);
				setLeftFrame(1, null, null);
				
			}
	 		
			
	 	});
	 
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
	 
	 
}
	 
	 public void setLeftFrame(int i, Boligsøker seek, Utleiere utl){
		 
		leftframe = i; 
		
		// setter venstre frame til NyBoligPanel
		if(leftframe == 1){
				 
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
	 
	 public void nySeeker(){
		 
		 setLeftFrame(3, null, null);

	 }

	 
}
