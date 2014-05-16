package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InfoPanel extends JPanel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6850235223016977454L;
	private JTextArea output;

	public InfoPanel(){
		
		setPreferredSize(new Dimension(540,300));
		BorderLayout bl = new BorderLayout();
		bl.setVgap(5);
		setLayout(bl);

		add( new JLabel( "" ),BorderLayout.PAGE_START );
	
	}
	
	public void addContent(String s){
		
		removeAll();
		output = new JTextArea( 0, 40 );
		output.setEditable( false );
		add( output, BorderLayout.LINE_START );
		output.setText(s);
	}
}
