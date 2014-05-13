/**
 * Utleiere. Klasse for alle Personer av typen utleier.
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Utleiere extends Person {
	
	private String firma;
	
	public Utleiere(String nvn, String enavn, String adr, String pnr, String sted, String epost, int tlf) {
		super(nvn, enavn, adr, pnr, sted, epost, tlf);

	}
	
	//Metode for å sette firma til en utleier.
	public void setFirma(String selskap) {
		firma = selskap;
	}
	
	//ToString for å hente informasjon om en utleier.
	public String toString() {
		return firma + " " +  navn + " " + adresse + " " + email + " " + telefon;
	}
}
