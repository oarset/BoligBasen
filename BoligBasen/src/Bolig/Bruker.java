/**
 * Personklasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

public abstract class Bruker {
	
	protected String navn, etternavn, adresse, postnr, sted, email, telefon;
	protected int dag, mnd, aar;
	public Bruker neste;
	
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

	public boolean erUtleier() {
		if(getClass() == Utleiere.class){
			return true;
		}
		else 
		return false;
	}
	
	public void setTelefon(String tlf) {
		telefon = tlf;
	}
	
	public String getTelefon() {
		return telefon;
	}
	
	public String toString() {
		return "masse tekst" + navn + " " + etternavn ;
	} 
	
	//Metode som returnerer navn og etternavn som String.
		public String nametoString() {
			String ut = "";
			if (navn != null && etternavn != null) 
				ut += "Navn: " + navn + " " + etternavn + "\n";
			return ut;
		}
}