/**
 * Boligs�ker --- Boligs�ker klasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.io.Serializable;

public class Boligs�ker extends Bruker implements Serializable {
	
	private String sivilstatus, yrke;
	private boolean r�yker, husdyr, balkong, hage;
	private int maxpris, minpris, antrom, st�rrelse, husholdningSize;
	private boolean utleier;

	
	public Boligs�ker(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);
		utleier = false;
	}
	
	//Sette ny sivilstatus til en boligs�ker.
	public void setSivilstatus(String ny) {
		sivilstatus = ny;
	}
	
	public String getSivilstatus() {
		return sivilstatus;
	}
	
	//Sette et yrke til en boligs�ker.
	public void setYrke(String ny) {
		yrke = ny;
	}
	
	public String getYrke() {
		return yrke;
	}
	
	public void setR�yker(boolean ny) {
		r�yker = ny;
	}
	
	public boolean getR�yker() {
		return r�yker;
	}
	
	public void setHusdyr(boolean ny) {
		husdyr = ny;
	}
	
	public boolean getHusdyr() {
		return husdyr;
	}
	
	public void setBalkong(boolean ny) {
		balkong = ny;
	}
	
	public boolean getBalkong() {
		return balkong;
	}
	
	public void setHage(boolean ny) {
		hage = ny;
	}
	
	public boolean getHage() {
		return hage;
	}
	
	public void setMaxPris(int ny) {
		maxpris = ny;
	}
	
	public int getMaxPris() {
		return maxpris;
	}
	
	public void setMinPris(int ny) {
		minpris = ny;
	}
	
	public int getMinPris() {
		return minpris;
	}
	
	public void setAntRom(int ny) {
		antrom = ny;
	}
	
	public int getAntRom() {
		return antrom;
	}
	
	public void setSt�rrelse(int ny) {
		st�rrelse = ny;
	}
	
	public int getSt�rrelse() {
		return st�rrelse;
	}
	
	public void setHusholdningSize(int ny) {
		husholdningSize = ny;
	}
	
	public int getHusholdningSize() {
		return husholdningSize;
	}
	
	public Boligs�ker returnDenne() {
		return this;
	}
	
	//Hjelpemetode for � lage utleierliste.
	public boolean erUtleier() {
		return utleier;
	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
		String ut = "";
		ut += "Brukerid: " + brukerid + "\n";
		if (navn != null && etternavn != null) 
			ut += "Navn: " + navn + " " + etternavn + "\n";
		if (adresse != null)
			ut += "Adresse: " + adresse + "\n";
		if (email != null)
			ut += "Email: " + email  + "\n";
		if (telefon != null)
			ut += "Telefon: " + telefon  + "\n";
		if (sted != null && postnr != null)
			ut += "Postnummer og sted: " + postnr + " " + sted + "\n";
		if (sivilstatus != null)
			ut += "Sivilstatus: " + sivilstatus  + "\n";
		if (yrke != null)
			ut += "Yrke: " + yrke  + "\n";
		if (r�yker == true) {
			ut += "R�yker: " + "Ja" + "\n";
		}
		else {
			ut += "R�yker: " + "Nei" + "\n";
		}
		if (minpris != 0 || maxpris != 0){
			ut += "Pris: " + minpris + " til " + maxpris +"\n";
		}
		if (antrom != 0){
			ut += "Minimum antall rom: " + antrom + "\n";
		}
		return ut;
	}
}
