package Bolig;

public class Boligs�ker extends Person {
	
	private String sivilstatus, yrke, arbeidsforhold, r�yker, husdyr, balkong, hage;
	private int prisklasse. antRom, st�rrelse;

	
	public Boligs�ker(String nvn, String adr,String epost, int tlf) {
		super(nvn, adr, epost, tlf);

	}
	
	//ToString for � hente informasjon om en utleier.
	public String toString() {
		return firma + " " +  navn + " " + adresse + " " + email + " " + telefon;
	}
}
