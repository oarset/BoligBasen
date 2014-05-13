package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoligBaseFrame extends JFrame{
	
	private JTextField header;
	private int leftframe;
	
	
	 public BoligBaseFrame()
		{
		super("BoligBasen");

		leftframe = 1;
		
		// lager default panelene
		newBrukerPanel brukerpan = new newBrukerPanel();
		
		// lager default infor panel
		final infoPanel info = new infoPanel();
		
		// lager default tittel
		final JPanel header = new JPanel();
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
						
					setLeftFrame(2, info, header);
					}


				});
		
		// Oppretter til Ny bolig valg i fil-menyen
		JMenuItem nyBolig = new JMenuItem("Ny bolig");
		nyBolig.setMnemonic('b');
		nyBolig.addActionListener( 
				new ActionListener(){
					// endrer venstre panel til "ny bolig panel"
					public void actionPerformed(ActionEvent e){
						
					setLeftFrame(1, info, header);
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
		  
		  
		setSize( 1080, 840 );
		setVisible( true );
		}
	 
	 public void setLeftFrame(int i, infoPanel info, JPanel head){
		 
		leftframe = i; 
		if(leftframe == 1){
		newBoligPanel boligpan = new newBoligPanel();
			 
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
		newBrukerPanel brukerpan = new newBrukerPanel();
		
		Container c = getContentPane();
		c.removeAll();
	 	c.setLayout( new BorderLayout() );
	 	c.add(head,BorderLayout.PAGE_START);
	 	c.add(brukerpan, BorderLayout.LINE_START);
	 	c.add(info, BorderLayout.LINE_END);
		c.revalidate();
		c.repaint();
		}
		 
	 }
}
