/**
 * Personliste --- Liste med personer.
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 13. mai
 */

package Bolig;

public class Personliste {
	
	private Person first;

	public Personliste() {
		
	}
	
	public void settInnPerson(Person ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Person cycle = first;
			while (cycle.neste != null) 
				cycle = cycle.neste;
			cycle.neste = ny;
		}
	}
	
	public void slettPerson(Person ny) {
		if (ny == null) {
			return;
		}
		if (first == ny) {
			first = first.neste;
			return;
		}
		else {
			Person cycle = first;
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
	
	public Person finnPerson(String epost) {
		return null;
	}
	
	public String toString() {
		return "lalala";
	}
}
