/**
 * Personklasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.io.Serializable;

public abstract class Bruker implements Serializable {
	
	private static final long serialVersionUID = -4822555228248176346L;
	protected String navn, etternavn, adresse, postnr, sted, email, telefon;
	protected int dag, mnd, aar, brukerid;
	public Bruker neste;
	public Bruker utleierNeste;
	
	//Constructor som oppretter bruker
	public Bruker(String nvn, String enavn, String adr,String pnr, String s, int d, int m, int aa, String epost, String tlf) {
		navn = nvn;
		adresse = adr;
		postnr = pnr;
		sted = s;
		email = epost;
		telefon = tlf;
		etternavn = enavn;
		dag = d;
		mnd = m;
		aar = aa;
		neste = null;
	}

	//Hjelpemetode for � lage utleierlister.
	public abstract boolean erUtleier();
	
	//Metode for � sjekke om en bruker �nsker balkong.
	public boolean getBalkong() {
		return false;
	}

	//Setter telefonnummer
	public void setTelefon(String tlf) {
		telefon = tlf;
	}
	
	//Setter en brukerid til en bruker
	public void setBrukerid(int id) {
		brukerid = id;
	}
	
	//Henter ut en bruker sin brukerid
	public int getBrukerid() {
		return brukerid;
	}
	
	//Henter ut telefonnummer
	public String getTelefon() {
		return telefon;
	}
	
	public String toString() {
		return navn + " " + etternavn ;
	} 
	
	//Metode som returnerer navn og etternavn som String.
		public String nametoString() {
			String ut = "";
			if (navn != null && etternavn != null) 
				ut += brukerid +" - " + navn + " " + etternavn + "\n";
			return ut;
		}

		public Utleiere returnThis() {
			return null;
		}
		public Boligs�ker returnDenne() {
			return null;
		}
}
