/**
 * Boligliste --- Liste med boliger.
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 9. mai - Lagt til metode for å hente ny boligliste basert på eier/epost.
 */

package Bolig;

public class Boligliste {
	
	private Bolig first;
	
	public Boligliste() {
		
	}
	
	public void settInnBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Bolig cycle = first;
			while (cycle.next != null) 
				cycle = cycle.next;
			cycle.next = ny;
		}
	}
	
	public void slettBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == ny) {
			first = first.next;
			return;
		}
		else {
			Bolig cycle = first;
			while (cycle.next != ny && cycle.next != null)
				cycle = cycle.next;
			cycle.next = cycle.next.next;
			return;
		}
	}
	
	public Boligliste utleierBoligliste(String epost) {
		if (epost == null) 
			return null;
		Boligliste ny = new Boligliste();
		if (first.getEier().email == epost) {
			ny.first = first;
		}
		else {
		Bolig cycle = first;
		while (cycle.next != null) {
			if (cycle.getEier().email == epost) {
				ny.settInnBolig(cycle);
			}
			cycle = cycle.next;
		}
		return ny;
		}
		return null;
	}
	
	public String toString() {
		String outPrint = "";
		Bolig cycle = first;
		while (cycle.next != null) {
			outPrint += cycle.toString();
			cycle = cycle.next;
		}
		return outPrint;
	}
}
