/**
 * Leiekontraktliste 
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 16. mai.
 */

package Bolig;

import java.io.Serializable;

public class Leiekontrakterliste implements Serializable{
	
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
	
	//Finner en leiekontrakt basert p� id og returnerer den. Returnerer null om den ikke finnes.
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
