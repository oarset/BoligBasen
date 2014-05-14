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
	
	private String getSivilstatus() {
		return sivilstatus;
	}
	
	//Sette et yrke til en boligs�ker.
	private void setYrke(String ny) {
		yrke = ny;
	}
	
	private String getYrke() {
		return yrke;
	}
	
	private void setR�yker(boolean ny) {
		r�yker = ny;
	}
	
	private boolean getR�yker() {
		return r�yker;
	}
	
	private void setHusdyr(boolean ny) {
		husdyr = ny;
	}
	
	private boolean getHusdyr() {
		return husdyr;
	}
	
	private void setBalkong(boolean ny) {
		balkong = ny;
	}
	
	private boolean getBalkong() {
		return balkong;
	}
	
	private void setHage(boolean ny) {
		hage = ny;
	}
	
	private boolean getHage() {
		return hage;
	}
	
	private void setArbeidsforhold(boolean ny) {
		arbeidsforhold = ny;
	}
	
	private boolean getArbeidsforhold() {
		return arbeidsforhold;
	}
	
	private void setPrisklasse(int ny) {
		prisklasse = ny;
	}
	
	private int getPrisklasse() {
		return prisklasse;
	}
	
	private void setAntRom(int ny) {
		antRom = ny;
	}
	
	private int getAntRom() {
		return antRom;
	}
	
	private void setSt�rrelse(int ny) {
		st�rrelse = ny;
	}
	
	private int getSt�rrelse() {
		return st�rrelse;
	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
		return navn + " " + etternavn + "\n" + 
			   adresse + "\n" + 
			   email + "\n" + 
			   telefon + "\n" +
			   sted  + "\n" +
			   postnr  + "\n" +
			   sivilstatus  + "\n" +
			   yrke  + "\n";
	}
}
