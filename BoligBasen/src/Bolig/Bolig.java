/**
 * Bolig --- Boligklasse
 * @author    Alexander Maaby, Øyvind Årset
 * Siste forandring: 10. mai.
 */

package Bolig;

import java.util.Date;


public abstract class Bolig {

	private String addresse, boligtype, beskrivelse;
	private int boa, byggeaar;
	private int leiepris; 
	private Date opprettet;
	private Utleiere eier;
	public Bolig next;
	
	// constructor oppretter bolig med adresse og type
	public Bolig(String add, String type){
		
		addresse = add;
		boligtype = type;
		
	}
	// setter inn areal
	public void setBOA(int b){
		boa = b;
	}
	// henter ut boarealet
	public int getBOA(){
		return boa;
	}
	// setter inn byggeåret for boligen
	public void setByggeAar(int aar){
		byggeaar = aar;
	}
	// henter ut byggeåret for boligen
	public int getByggeAar(){
		return byggeaar;
	}
	// setter leie prisen pr. mnd.
	public void setLeiePris(int leie){
		leiepris = leie;
	}
	public Utleiere getEier() {
		return eier;
	}
	// finner leieprisen for boligen (pr. mnd)
	public int getLeiePris(){
		return leiepris;
	}
	public String toString() {
		String printString = "test";
		return printString;
	}
}
