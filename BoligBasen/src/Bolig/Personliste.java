/**
 * Personliste --- Liste med personer.
 * @author    Alexander Maaby, �yvind �rset
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
			return;
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
	
	public int antPersoner() {
		Bruker cycle = first;
		int teller = 0;
		while (cycle.neste != null) {
			teller += 1;
			cycle = cycle.neste;
		}
		return teller;
	}
	
	public Bruker finnPerson(String epost) {
		return null;
	}
	public Bruker getFirst(){
		return first;
	}
	
	public String toString() {
		
		if(first ==null){
			return "Ingen Utleiere opprettet";
		}
		else{
		
		Bruker cycle = first;
		String toString = "Utleiere: \n ---- \n\n" + first.toString() + "\n\n ---- \n\n";
		while (cycle.neste != null){
			toString += cycle.toString() + "\n\n ---- \n\n";
			cycle = cycle.neste;
		 }
		 
		return toString;
		}
	}
}
