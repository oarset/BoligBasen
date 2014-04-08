package Bolig;

import java.util.Date;


public class Bolig {

	private String addresse, boligtype, beskrivelse;
	private int boa, byggeaar;
	private int pris; // pris regnes i øre (pris = 300000 beetyr 3000 kroner)
	private Date opprettet;
	
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
}
