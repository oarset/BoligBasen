package Bolig;

public class Boligsøker extends Person {
	
	private String sivilstatus, yrke, arbeidsforhold, røyker, husdyr, balkong, hage;
	private int prisklasse, antRom, størrelse;

	
	public Boligsøker(String nvn, String adr,String epost, int tlf) {
		super(nvn, adr, epost, tlf);

	}
	
	//ToString for å hente informasjon om en utleier.
	public String toString() {
		return navn + " " + adresse + " " + email + " " + telefon;
	}
}
