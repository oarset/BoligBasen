/**
 * Boligsøker --- Boligsøker klasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Boligsøker extends Person {
	
	private String sivilstatus, yrke, arbeidsforhold, røyker, husdyr, balkong, hage;
	private int prisklasse, antRom, størrelse;

	
	public Boligsøker(String nvn, String enavn, String adr,String epost, int tlf) {
		super(nvn, enavn, adr, epost, tlf);

	}
	
	//ToString for å hente informasjon om en utleier.
	public String toString() {
		return navn + " " + adresse + " " + email + " " + telefon;
	}
}
