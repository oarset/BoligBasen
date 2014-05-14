/**
 * Utleiere. Klasse for alle Personer av typen utleier.
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public class Utleiere extends Bruker {
	
	private String firma, firmaInfo;
	
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
	
	//Metode for � sette informasjon om firma til en utleier.
	public void setFirmaInfo(String selskapInfo) {
		firmaInfo = selskapInfo;
	}
	
	//Metode for � returnere en String med informasjon om firmaet til en utleier.
	public String getFirmaInfo() {
		return firmaInfo;
	}
	
	//ToString for � hente informasjon om en utleier.
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
		if (firma != null) 
			ut += "Firma: " + firma  + "\n";
		if (firmaInfo != null)
			ut += "Informasjon om firma: " + firmaInfo  + "\n";
		return ut;
		}
}
