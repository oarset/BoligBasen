/**
 * Utleiere. Klasse for alle Personer av typen utleier.
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Utleiere extends Person {
	
	private String firma;
	
	public Utleiere(String nvn, String enavn, String adr,String epost, int tlf) {
		super(nvn, enavn, adr, epost, tlf);

	}
	
	//Metode for � sette firma til en utleier.
	public void setFirma(String selskap) {
		firma = selskap;
	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
		return firma + " " +  navn + " " + adresse + " " + email + " " + telefon;
	}
}
