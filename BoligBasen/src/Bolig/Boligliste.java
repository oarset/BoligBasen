/**
 * Boligliste --- Liste med boliger.
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 9. mai - Lagt til metode for å hente ny boligliste basert på eier/epost.
 */

package Bolig;

import java.io.Serializable;

public class Boligliste implements Serializable {
	
	private Bolig first;
	
	public Boligliste() {
		
	}
	
	//Setter inn en ny bolig i listen.
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
			while (cycle.next != null) {
				cycle = cycle.next;
			}
			cycle.next = ny;
		}
	}
	
	//Setter inn en ny bolig i liste som tilhører en utleier.
	public void settInnUtleierBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Bolig cycle = first;
			while (cycle.utleierNext != null) 
				cycle = cycle.utleierNext;
			cycle.utleierNext = ny;
		}
	}
	
	//Setter inn en ny bolig sortert på pris.
	public void settInnSortertBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Bolig cycle = first;
			while (cycle.sortertNext != null) {
				if (cycle.getLeiePris() < ny.getLeiePris() && cycle.sortertNext.getLeiePris() > ny.getLeiePris()) {
					ny.sortertNext = cycle.sortertNext;
					cycle.sortertNext = ny;
					return;
				}
				cycle = cycle.sortertNext;
			}
		}
	}
	
	//Setter inn en ny bolig basert på matching score.
	public void settInnSortertMatchetBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Bolig cycle = first;
			if (cycle.getMatchingScore() > ny.getMatchingScore() ) {
				ny.matchedNext = cycle;
				return;
			}
			while (cycle.matchedNext != null) {
				if (cycle.matchedNext.getMatchingScore() > ny.getMatchingScore() && cycle.getMatchingScore() < ny.getMatchingScore() ) {
					ny.matchedNext = cycle.matchedNext;
					cycle.matchedNext = ny;
					return;
				}
				cycle = cycle.matchedNext;
				
			}
			if (cycle.matchedNext != null && cycle.getMatchingScore() < ny.getMatchingScore()) {
				cycle.matchedNext = ny;
				return;
			}
			return;
		}
	}
	
	//Sletter en bolig 
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
			while (cycle.next != ny) {
				cycle = cycle.next;
			}
			if (cycle.next == ny && cycle.next.next != null) {
				cycle.next = cycle.next.next;
				return;
			}
			else if(cycle.next == ny && cycle.next.next == null) {
				cycle.next = null;
				return;
			}
			else
				return;
		}
	}
	
	//Sorterer en boligliste på pris og så returnerer den nye sorterte listen.
	public Boligliste prisSort() {
		Boligliste ny = new Boligliste();
		Bolig cycle = first;
		while (cycle.next != null) {
			ny.settInnSortertBolig(cycle);
		}
		return ny;
	}
	
	//Returnerer en boligliste hvor alle boliger i listen er eid av bruker med epost i input.
	public Boligliste utleierBoligliste(String epost) {
		if (epost == null) 
			return null;
		Boligliste ny = new Boligliste();
		Bolig cycle = first;
		while (cycle != null) {
			if (cycle.getEier().email == epost) {
				ny.settInnUtleierBolig(cycle);
			}
			cycle = cycle.utleierNext;
		}
		return ny;
	}
	
	//Returnerer en liste med boliger som passer til Boligsøkeren i input. Sortert på hvor god match de er.
	public Boligliste matchingBolig(Boligsøker person) {
		if (person == null)
			return null;
		Bolig cycle = first;
		Boligliste ny = new Boligliste();
		while (cycle.next != null) {
			cycle.resetMatchingScore();
			if (cycle.getLeiePris() < person.getMaxPris() && cycle.getLeiePris() > person.getMinPris()) {
				cycle.addToMatchingscore(cycle.getLeiePris() - person.getMinPris());
			if (person.getBalkong() != cycle.getBalkong()) {
				cycle.addToMatchingscore(1000);
			}
			ny.settInnSortertMatchetBolig(cycle);
			}
			cycle = cycle.next;
		}
		return ny;
	}
	
	//Sjekker som en utleier eier bolig.
	public boolean utleierHarBolig(Utleiere person) {
		if (person == null)
			return false;
		Bolig cycle = first;
		while (cycle.next != null) {
			if (cycle.getEier().email == person.email) {
				return true;
			}
			cycle = cycle.next;
			}
		return false;
	}
	
	//Returnerer informasjon om boligene i listen.
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
