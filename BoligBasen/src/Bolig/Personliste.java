/**
 * Personliste --- Liste med personer.
 * @author    Alexander Maaby, Øyvind Årset
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
	
	public Bruker finnPerson(String epost) {
		return null;
	}
	
	public String toString() {
		return "lalala";
	}
}
