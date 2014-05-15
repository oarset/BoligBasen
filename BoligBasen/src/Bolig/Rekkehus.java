/**
 * Rekkehusklasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.io.Serializable;

public class Rekkehus extends Bolig implements Serializable{
	
	private int antEtg, tomt;
	private boolean kjeller;
	
	public Rekkehus(String add, String type) {
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
