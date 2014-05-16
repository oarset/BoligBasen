/**
 * Personliste --- Liste med personer.
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 13. mai
 */

package Bolig;

import java.io.Serializable;

public class Personliste implements Serializable {
	
	private Bruker first;
	private int brukerTeller = 1000;

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
			ny.setBrukerid(brukerTeller);
			brukerTeller += 1;
			return;
		}
		else {
			Bruker cycle = first;
			while (cycle.neste != null) { 
				cycle = cycle.neste;	
			}
			cycle.neste = ny;	
			ny.setBrukerid(brukerTeller);
			brukerTeller += 1;
		}
	}
	
	//Setter inn en utleier i lista.
	public void settInnUtleier(Bruker ny) {
		if (ny == null) {
			return;
		}
		if(ny.erUtleier() == true){
			//tom liste
			if (first == null) {
				first = ny;		
				return;
			}
			else {
				Bruker cycle = first;
				while (cycle != null) { 
					cycle = cycle.neste;	
				}
				
				cycle = ny;	
			}
		}
		else{
			return;
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
			while (cycle.neste != ny)
				cycle = cycle.neste;
			if (cycle.neste == ny && cycle.neste.neste != null) {
				cycle.neste = cycle.neste.neste;
				return;
			}
			else if (cycle.neste == ny && cycle.neste.neste == null) {
				cycle.neste = null;
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
		while (cycle.neste != null) {
			ny.settInnUtleier(cycle);
			cycle = cycle.neste;
			}	

		return ny;
	}
	
	//Teller hvor mange personer som er registrert i lista.
	public int antPersoner() {
		Bruker cycle = first;
		int teller = 0;
		while (cycle != null) {
			teller += 1;
			if (cycle.neste != null) {
			cycle = cycle.neste;
			}
		}
		return teller;
	}
	
	//Finner en bruker i lista basert på brukerid
	public Utleiere finnUtleier(int brukerid) {
		Bruker cycle = first;
		while (cycle != null) {
		if (cycle.getBrukerid() == brukerid && cycle.erUtleier() == true) {
			return cycle.returnThis();
			}
		if (cycle.neste != null) {
			cycle = cycle.neste;
		}
		}
		return null;
	}
	
	public Boligsøker finnBoligsøker(int brukerid) {
		Bruker cycle = first;
		while (cycle != null) {
			if (cycle.getBrukerid() == brukerid && cycle.erUtleier() == false) {
				return cycle.returnDenne();
			}
		if (cycle.neste != null) {
			cycle = cycle.neste;
		}
		}
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
