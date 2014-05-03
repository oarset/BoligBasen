package Bolig;

public class Boligliste {
	
	private Bolig first;
	
	public Boligliste() {
		
	}
	
	public void settInnBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == null) {
			first = ny;
			return;
		}
		else {
			Bolig cycle = first;
			while (cycle.next != null) 
				cycle = cycle.next;
			cycle.next = ny;
		}
	}
	
	public void slettBolig(Bolig ny) {
		if (ny == null) {
			return;
		}
		if (first == ny) {
			first = first.next;
			return;
		}
		else {
			Bolig cycle = first;
			while (cycle.next != ny && cycle.next != null)
				cycle = cycle.next;
			cycle.next = cycle.next.next;
			return;
		}
	}
	
	public String toString() {
		String outPrint = "";
		Bolig cycle = first;
		while (cycle.next != null) {
			outPrint += cycle.toString();
			cycle = cycle.next;
		}
		return outPrint;
	}
}
