/**
 * Utleiere. Klasse for alle Personer av typen utleier.
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Utleiere extends Person {
	
	private String firma;
	
	public Utleiere(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);

	}
	
	//Metode for � sette firma til en utleier.
	public void setFirma(String selskap) {
		firma = selskap;
	}
	
	//Metode for � returnere en String med firmaet til en utleier.
	public String getFirma() {
		return firma;
	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
			return navn + " " + etternavn + "\n" + 
				   adresse + "\n" + 
				   email + "\n" + 
				   telefon + "\n" +
				   sted  + "\n" +
				   postnr  + "\n" +
				   firma  + "\n";
		}
}
