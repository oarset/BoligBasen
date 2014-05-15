package GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.Serializable;

public class TestRun implements Serializable{

	
	public static void main( String[] args )
	{
		final BoligBaseFrame bbf = new BoligBaseFrame();
		
		
		bbf.addWindowListener(
			    new WindowAdapter() {
			      public void windowClosing( WindowEvent e )
			      {

			    	  System.exit( 0 );
			      }
			    } );
	}
}
