package Bolig;

public class Leiekontrakter {
	
	Bolig utleieboligen;
	Bruker utleier;
	Bruker leietaker;
	int pris, varighet;
	
	public Leiekontrakter(Bolig bolig, Bruker utleieren, Bruker leietakeren, int leie, int lengde) {
		utleieboligen = bolig;
		utleier = utleieren;
		leietaker = leietakeren;
		pris = leie;
		varighet = lengde;
	}
}
