/**
 * Personklasse
 * @author    Alexander Maaby, �yvind �rset
 * Siste forandring: 10. mai.
 */

package Bolig;

public abstract class Person {
	
	protected String navn, etternavn, adresse, postnr, sted, email, telefon;
	protected int dag, mnd, aar;
	public Person neste;
	
	//Constructor som oppretter person
	public Person(String nvn, String enavn, String adr,String pnr, String s, int d, int m, int aa, String epost, String tlf) {
		navn = nvn;
		adresse = adr;
		postnr = pnr;
		sted = s;
		email = epost;
		telefon = tlf;
		etternavn = enavn;
		dag = d;
		mnd = m;
		aar = aa;
	}
	
	//ToString for � hente informasjon om en utleier.
		public String toString() {
			return navn + " " + adresse + " " + email + " " + telefon;
		}
}
