/**
 * Boligs�ker --- Boligs�ker klasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Boligs�ker extends Bruker {
	
	private String sivilstatus, yrke;
	private boolean r�yker, husdyr, balkong, hage;
	private int maxpris, minpris, antRom, st�rrelse, husholdningSize;

	
	public Boligs�ker(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);
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
		antRom = ny;
	}
	
	public int getAntRom() {
		return antRom;
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
