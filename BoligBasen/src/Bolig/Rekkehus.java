/**
 * Rekkehusklasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Rekkehus extends Bolig{
	
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
