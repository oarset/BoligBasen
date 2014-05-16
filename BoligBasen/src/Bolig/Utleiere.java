/**
 * Utleiere. Klasse for alle Personer av typen utleier.
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.io.Serializable;

public class Utleiere extends Bruker implements Serializable {
	
	private String firma, firmaInfo;
	private boolean utleier;
	public Utleiere(String nvn, String enavn, String adr, String pnr, String sted, int d, int m, int aa, String epost, String tlf) {
		super(nvn, enavn, adr, pnr, sted, d, m, aa, epost, tlf);
		utleier = true;
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
	
	public Utleiere returnThis() {
		return this;
	}
	
	public boolean erUtleier(){
		return utleier;
	}
	
	//Returnerer String med informasjon om en utleier sitt firma, men bare om utleieren har et firma registrert.
	public String firmaToString() {
		String ut = "";
		if (firma != null) 
			ut += "Firmanavn: " + firma  + "\n";
		if (firmaInfo != null)
			ut += "Informasjon om firma: " + firmaInfo  + "\n";
		return ut;
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
		if (firma != null) 
			ut += "Firma: " + firma  + "\n";
		if (firmaInfo != null)
			ut += "Informasjon om firma: " + firmaInfo  + "\n";
		return ut;
		}
}
