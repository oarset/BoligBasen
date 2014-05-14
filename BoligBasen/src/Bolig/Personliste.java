/**
 * Personliste --- Liste med personer.
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 13. mai
 */

package Bolig;

public class Personliste {
	
	private Bruker first;

	public Personliste() {
		
	}
	
	public void settInnPerson(Bruker ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Bruker cycle = first;
			while (cycle.neste != null){ 
				cycle = cycle.neste;
			cycle.neste = ny;
			}
		}
	}
	
	public void slettPerson(Bruker ny) {
		if (ny == null) {
			return;
		}
		if (first == ny) {
			first = first.neste;
			return;
		}
		else {
			Bruker cycle = first;
			while (cycle.neste != ny && cycle.neste != null)
				cycle = cycle.neste;
			if (cycle.neste == ny) {
				cycle.neste = cycle.neste.neste;
				return;
			}
			else
				return;
		}
	}
	
	public Personliste utleierliste() {
		if (first == null) {
			return null;
		}
		Personliste ny = new Personliste();
		Bruker cycle = first;
		while (cycle.neste != null) {
			if (cycle.erUtleier() == true) {
				ny.settInnPerson(cycle);
			}
			cycle = cycle.neste;
		}
		return ny;
	}
	
	public Bruker finnPerson(String epost) {
		return null;
	}
	public Bruker getFirst(){
		return first;
	}
	
	public String toString() {
		return "lalala";
	}
}
