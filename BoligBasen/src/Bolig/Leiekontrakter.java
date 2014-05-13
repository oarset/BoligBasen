package Bolig;

public class Leiekontrakter {
	
	Bolig utleieboligen;
	Person utleier;
	Person leietaker;
	int pris, varighet;
	
	public Leiekontrakter(Bolig bolig, Person utleieren, Person leietakeren, int leie, int lengde) {
		utleieboligen = bolig;
		utleier = utleieren;
		leietaker = leietakeren;
		pris = leie;
		varighet = lengde;
	}
}
