package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

public class TestRun implements Serializable{

	
	private static final long serialVersionUID = 5051413251274124535L;

	public static void main( String[] args )
	{
		final BoligBaseFrame bbf = new BoligBaseFrame();
		
		
		bbf.addWindowListener(
			    new WindowAdapter() {
			      public void windowClosing( WindowEvent e )
			      {
			    	  bbf.lagreTilFil();
			    	  System.exit( 0 );
			      }
			    } );
	}
}
