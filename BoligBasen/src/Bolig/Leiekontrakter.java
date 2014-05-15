package Bolig;

import java.io.Serializable;

public class Leiekontrakter implements Serializable {
	
	Bolig utleieboligen;
	Bruker utleier;
	Bruker leietaker;
	int pris, varighet;
	
	public Leiekontrakter(Bolig bolig, Bruker utleieren, Bruker leietakeren, int leie, int lengde) {
		utleieboligen = bolig;
		utleier = utleieren;
		leietaker = leietakeren;
		pris = leie;
		varighet = lengde;
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
