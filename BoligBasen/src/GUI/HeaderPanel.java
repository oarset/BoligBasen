package GUI;

import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6851238053800983590L;
	private JLabel headerLabel;
	
	public HeaderPanel(){
		headerLabel = new JLabel();
		add(headerLabel);
	}
	
	public void setText(String s){
		headerLabel.setText(s);
	}
}
