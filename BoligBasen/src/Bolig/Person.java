/**
 * Personklasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

public abstract class Person {
	
	protected String navn, etternavn, adresse, postnr, sted, email;
	protected int telefon;
	public Person neste;
	
	//Constructor som oppretter person
	public Person(String nvn, String enavn, String adr,String pnr, String s, String epost, int tlf) {
		navn = nvn;
		adresse = adr;
		postnr = pnr;
		sted = s;
		email = epost;
		telefon = tlf;
		etternavn = enavn;
	}
}
