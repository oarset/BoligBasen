/**
 * Eneboligklasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.io.Serializable;

public class Enebolig extends Bolig implements Serializable {
	
	private static final long serialVersionUID = -7239594569972937532L;
	private int antEtg, tomt;
	private boolean kjeller;
	

	public Enebolig(String add, String type) {
		super(add, type);
	}

	public void setAntEtg(int ant) {
		antEtg = ant;
	}
	
	public int getAntEtg() {
		return antEtg;
	}
	
	public void setTomt(int str) {
		tomt = str;
	}
	
	public int getTomt() {
		return tomt;
	}
	
	public void setKjeller(boolean kjlr){
		kjeller = kjlr;
	}
	public boolean getKjeller() {
		return kjeller;
	}
}