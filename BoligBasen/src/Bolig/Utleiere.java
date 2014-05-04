package Bolig;

public class Utleiere extends Person {
	
	private String firma;
	private Boligliste eierskapListe;
	
	public Utleiere(String nvn, String adr,String epost, int tlf) {
		super(nvn, adr, epost, tlf);

	}
	
	//Metode for å sette firma til en utleier.
	public void setFirma(String selskap) {
		firma = selskap;
	}
	
	//Metode for å sette en liste med boliger til en utleier.
	public void setBoligliste(Boligliste liste) {
		eierskapListe = liste;
	}
	
	//ToString for å hente informasjon om en utleier.
	public String toString() {
		return firma + " " +  navn + " " + adresse + " " + email + " " + telefon;
	}
}
