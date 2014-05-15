package GUI;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel{

	private JLabel headerLabel;
	
	public HeaderPanel(){
		headerLabel = new JLabel();
		add(headerLabel);
	}
	
	public void setText(String s){
		headerLabel.setText(s);
	}
}
