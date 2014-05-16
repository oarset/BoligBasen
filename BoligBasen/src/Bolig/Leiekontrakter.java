/**
 * Klasse for leiekontrakter
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 16. mai.
 */

package Bolig;

import java.io.Serializable;

public class Leiekontrakter implements Serializable {
	
	private static final long serialVersionUID = -2432248480300189465L;
	Bolig utleieboligen;
	Bruker utleier;
	Bruker leietaker;
	int pris, varighet, leiekontraktID;
	Leiekontrakter neste;
	
	public Leiekontrakter(Bolig bolig, Bruker utleieren, Bruker leietakeren, int leie, int lengde) {
		utleieboligen = bolig;
		utleier = utleieren;
		leietaker = leietakeren;
		pris = leie;
		varighet = lengde;
	}
	
	//Gir en leiekontrakt en id.
	public void setLeieID(int id) {
		leiekontraktID = id;
	}
	
	//Returnerer id-en til leiekontrakten.
	public int getLeieID() {
		return leiekontraktID;
	}
	
	public String toString() {
		String ut = "";
		if (utleieboligen.getAdresse() != null) 
			ut += "Adresse: " + utleieboligen.getAdresse() + "\n";
		if (utleier != null) {
			ut += "Utleier brukerid: " + utleier.getBrukerid() + "\n";
			ut += "Utleier navn: " + utleier.nametoString()  + "\n";
			}
		if (leietaker != null) {
			ut += "Leietaker brukerid: " + leietaker.getBrukerid()  + "\n";
			ut += "Leietaker navn: " + leietaker.nametoString()  + "\n";
		}
		ut += "Leiepris: " + pris + "\n";
		ut += "Varighet på låneavtale: " + varighet  + "\n";
		return ut;
	}
}
