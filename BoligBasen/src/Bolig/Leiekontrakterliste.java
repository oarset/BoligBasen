/**
 * Leiekontraktliste 
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 16. mai.
 */

package Bolig;

import java.io.Serializable;

public class Leiekontrakterliste implements Serializable{
	
	Leiekontrakter first;
	
	public Leiekontrakterliste() {
		
	}
	
	//Setter inn en ny leiekontrakt i listen.
	public void settInnLeiekontrakt(Leiekontrakter ny) {
		if (ny == null) {
			return;
		}
		
		//tom liste
		if (first == null) {
			first = ny;		
			return;
		}
		else {
			Leiekontrakter cycle = first;
			while (cycle.neste != null) { 
				cycle = cycle.neste;	
			}
			cycle.neste = ny;	
		}
	}
	
	public String toString() {
		Leiekontrakter cycle = first;
		String ut = "";
		while (cycle != null) {
			ut += cycle.toString();
			if (cycle.neste == null) {
				return ut;
			}
		}
		return ut;
	}
}
