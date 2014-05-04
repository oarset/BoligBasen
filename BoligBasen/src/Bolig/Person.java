package Bolig;

public abstract class Person {
	
	protected String navn, adresse, email;
	protected int telefon;
	public Person neste;
	
	//Constructor som oppretter person
	public Person(String nvn, String adr,String epost, int tlf) {
		navn = nvn;
		adresse = adr;
		email = epost;
		telefon = tlf;
	}
}
