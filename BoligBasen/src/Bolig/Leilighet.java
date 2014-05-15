/**
 * Leilighetklasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.io.Serializable;

public class Leilighet extends Bolig implements Serializable {

	private int etasje;
	private boolean heis, balkong;
	
	public Leilighet(String add, String type) {
		super(add, type);
	}
	
	public void setEtg(int etsj) {
		etasje = etsj;
	}
	
	public int getEtg() {
		return etasje;
	}

	public void setHeis(boolean lift) {
		heis = lift;
	}
	
	public boolean getHeis() {
		return heis;
	}
	
	public void setBalkong(boolean balcony) {
		balkong = balcony;
	}
	
	public boolean getBalkong() {
		return balkong;
	}
}
