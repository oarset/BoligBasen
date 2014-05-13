/**
 * Boligs�ker --- Boligs�ker klasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Boligs�ker extends Person {
	
	private String sivilstatus, yrke;
	private boolean r�yker, husdyr, balkong, hage, arbeidsforhold;
	private int prisklasse, antRom, st�rrelse;

	
	public Boligs�ker(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);
	}
	
	//Sette ny sivilstatus til en boligs�ker.
	private void setSivilstatus(String ny) {
		sivilstatus = ny;
	}
	
	//Sette et yrke til en boligs�ker.
	private void setYrke(String ny) {
		yrke = ny;
	}
	
	private void setR�yker(boolean ny) {
		r�yker = ny;
	}
	
	private void setHusdyr(boolean ny) {
		husdyr = ny;
	}
	
	private void setBalkong(boolean ny) {
		balkong = ny;
	}
	
	private void setHage(boolean ny) {
		hage = ny;
	}
	
	private void setArbeidsforhold(boolean ny) {
		arbeidsforhold = ny;
	}
	
	private void setPrisklasse(int ny) {
		prisklasse = ny;
	}
	
	private void setAntRom(int ny) {
		antRom = ny;
	}
	
	private void setSt�rrelse(int ny) {
		st�rrelse = ny;
	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
		return navn + " " + adresse + " " + email + " " + telefon;
	}
}
