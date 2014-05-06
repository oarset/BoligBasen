package Bolig;

public abstract class Person {
	
	protected String navn, etternavn, adresse, email;
	protected int telefon;
	public Person neste;
	
	//Constructor som oppretter person
	public Person(String nvn, String enavn, String adr,String epost, int tlf) {
		navn = nvn;
		adresse = adr;
		email = epost;
		telefon = tlf;
		etternavn = enavn;
	}
}
