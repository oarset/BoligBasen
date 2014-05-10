/**
 * Boligs�ker --- Boligs�ker klasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Boligs�ker extends Person {
	
	private String sivilstatus, yrke, arbeidsforhold, r�yker, husdyr, balkong, hage;
	private int prisklasse, antRom, st�rrelse;

	
	public Boligs�ker(String nvn, String enavn, String adr,String epost, int tlf) {
		super(nvn, enavn, adr, epost, tlf);

	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
		return navn + " " + adresse + " " + email + " " + telefon;
	}
}
