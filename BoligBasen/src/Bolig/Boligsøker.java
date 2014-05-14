/**
 * Boligsøker --- Boligsøker klasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Boligsøker extends Bruker {
	
	private String sivilstatus, yrke;
	private boolean røyker, husdyr, balkong, hage;
	private int maxpris, minpris, antrom, størrelse, husholdningSize;

	
	public Boligsøker(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);
	}
	
	//Sette ny sivilstatus til en boligsøker.
	public void setSivilstatus(String ny) {
		sivilstatus = ny;
	}
	
	public String getSivilstatus() {
		return sivilstatus;
	}
	
	//Sette et yrke til en boligsøker.
	public void setYrke(String ny) {
		yrke = ny;
	}
	
	public String getYrke() {
		return yrke;
	}
	
	public void setRøyker(boolean ny) {
		røyker = ny;
	}
	
	public boolean getRøyker() {
		return røyker;
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
	
	public void setStørrelse(int ny) {
		størrelse = ny;
	}
	
	public int getStørrelse() {
		return størrelse;
	}
	
	public void setHusholdningSize(int ny) {
		husholdningSize = ny;
	}
	
	public int getHusholdningSize() {
		return husholdningSize;
	}
	
	//ToString for å hente informasjon om en utleier.
	public String toString() {
		String ut = "";
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
		if (røyker == true) {
			ut += "Røyker: " + "Ja" + "\n";
		}
		else {
			ut += "Røyker: " + "Nei" + "\n";
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
