/**
 * Boligliste --- Liste med boliger.
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 9. mai - Lagt til metode for � hente ny boligliste basert p� eier/epost.
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
			while (cycle.next != null) {
				if (cycle.getLeiePris() < ny.getLeiePris() && cycle.next.getLeiePris() > ny.getLeiePris()) {
					ny.next = cycle.next;
					cycle.next = ny;
					return;
				}
				cycle = cycle.next;
			}
		}
	}
	
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
				ny.next = cycle;
				return;
			}
			while (cycle.next != null) {
				if (cycle.next.getMatchingScore() > ny.getMatchingScore() && cycle.getMatchingScore() < ny.getMatchingScore() ) {
					ny.next = cycle.next;
					cycle.next = ny;
					return;
				}
				cycle = cycle.next;
				
			}
			if (cycle.next != null && cycle.getMatchingScore() < ny.getMatchingScore()) {
				cycle.next = ny;
				return;
			}
			return;
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
			if (cycle.next == ny) {
				cycle.next = cycle.next.next;
				return;
			}
			else
				return;
		}
	}
	
	//Sorterer en boligliste p� pris og s� returnerer den nye sorterte listen.
	public Boligliste prisSort() {
		Boligliste ny = new Boligliste();
		Bolig cycle = first;
		while (cycle.next != null) {
			ny.settInnSortertBolig(cycle);
		}
		return ny;
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
	
	public Boligliste matchingBolig(Boligs�ker person) {
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
