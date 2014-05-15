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
	
	//Setter inn en person i lista.
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
			while (cycle.neste != null) { 
				cycle = cycle.neste;	
			}
			cycle.neste = ny;	
		}
	}
	
	//Setter inn en utleier i lista.
	public void settInnUtleier(Bruker ny) {
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
			while (cycle.utleierNeste != null) { 
				cycle = cycle.utleierNeste;	
			}
			cycle.utleierNeste = ny;	
		}
	}
	
	//Sletter en person fra lista.
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
	
	//Lager en ny liste med bare utleiere, ut av hovedlisten med både boligsøkere og utleiere.
	public Personliste utleierliste() {
		if (first == null) {
			return null;
		}
		Personliste ny = new Personliste();
		Bruker cycle = first;
		while (cycle != null) {
			if (cycle.erUtleier() == true) {
				ny.settInnUtleier(cycle);
			}
			cycle = cycle.neste;
		}
		return ny;
	}
	
	//Teller hvor mange personer som er registrert i lista.
	public int antPersoner() {
		Bruker cycle = first;
		int teller = 0;
		while (cycle.neste != null) {
			teller += 1;
			cycle = cycle.neste;
		}
		return teller;
	}
	
	//Finner en bruker i lista basert på epost, ubrukt.
	public Bruker finnPerson(String epost) {
		return null;
	}
	
	//Henter ut første person i lista.
	public Bruker getFirst(){
		return first;
	}
	
	//Lever en String med informasjon fra lista.
	public String toString() {
		
		if(first ==null){
			return "Ingen brukere opprettet";
		}
		else{
		
		Bruker cycle = first;
		String toString = "Brukere: \n ---- \n\n";
		while (cycle.neste != null){
			toString += cycle.toString() + "\n\n ---- \n\n";
			cycle = cycle.neste;
		 }
		toString += cycle.toString() + "\n\n ---- \n\n";
		return toString;
		}
	}
}
