/**
 * Boligsøker --- Boligsøker klasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Boligsøker extends Person {
	
	private String sivilstatus, yrke;
	private boolean røyker, husdyr, balkong, hage, arbeidsforhold;
	private int prisklasse, antRom, størrelse;

	
	public Boligsøker(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);
	}
	
	//Sette ny sivilstatus til en boligsøker.
	private void setSivilstatus(String ny) {
		sivilstatus = ny;
	}
	
	//Sette et yrke til en boligsøker.
	private void setYrke(String ny) {
		yrke = ny;
	}
	
	private void setRøyker(boolean ny) {
		røyker = ny;
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
	
	private void setStørrelse(int ny) {
		størrelse = ny;
	}
	
	//ToString for å hente informasjon om en utleier.
	public String toString() {
		return navn + " " + adresse + " " + email + " " + telefon;
	}
}
