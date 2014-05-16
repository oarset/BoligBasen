/**
 * Leiekontraktliste 
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 16. mai.
 */

package Bolig;

import java.io.Serializable;

public class Leiekontrakterliste implements Serializable{
	
	private static final long serialVersionUID = -5564329984600662602L;
	public Leiekontrakter first;
	private int leiekontraktID = 10000;
	
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
			first.setLeieID(leiekontraktID);
			leiekontraktID += 1;
			return;
		}
		else {
			Leiekontrakter cycle = first;
			while (cycle.neste != null) { 
				cycle = cycle.neste;	
			}
			cycle.neste = ny;	
			cycle.neste.setLeieID(leiekontraktID);
			leiekontraktID +=1;
		}
	}
	
	//Finner en leiekontrakt basert på id og returnerer den. Returnerer null om den ikke finnes.
	public Leiekontrakter finnLeiekontrakt(int id) {
		Leiekontrakter cycle = first;
		while (cycle != null) {
			if (cycle.getLeieID() == id) {
				return cycle;
			}
			if (cycle.neste == null) {
				return null;
			}
		}
		return null;
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
