/**
 * Personliste --- Liste med personer.
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 13. mai
 */

package Bolig;

public class Personliste {
	
	private Bruker first;

	public Personliste() {
		first = null;
	}
	
	
	public void settInnPerson(Bruker ny) {
		if (ny == null) {
			return;
		}
		
		//tom liste
		if (first == null) {
			first = ny;			
		}
		else {
			Bruker cycle = first;
			while (cycle.neste != null) 
				cycle = cycle.neste;	
			cycle.neste = ny;
			
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
		String toString = "";
		Bruker cycle = first;
		while (cycle.neste != null) {
			toString += cycle.toString() + "\n\n ---- \n\n";
			cycle = cycle.neste;
		}
		return toString;
	}
}
