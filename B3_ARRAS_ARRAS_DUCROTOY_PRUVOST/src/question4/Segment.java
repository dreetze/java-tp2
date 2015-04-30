package question4;

public class Segment {
	
	private int extr1;
	private int extr2;
	private int point;
	

	public Segment(int extr1, int extr2, int point) {
		this.extr1 = extr1;
		this.extr2 = extr2;
		this.point = point;
	}
	
	public int valeurSegment(){
		int resultat;
		
		resultat = extr1-extr2;
		return Math.abs(resultat);
		
	}
	
	public boolean appartientAuSegment(int point){
		if(this.extr1<point && point<this.extr2 || this.extr1>point && point>this.extr2){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		if(extr1 > extr2){
			int tmp = 0;
			tmp = extr1;
			extr1 = extr2;
			extr2 = tmp;
		}
		
		if(appartientAuSegment(point)){
			return "Longueur du Segment[" + extr1 + "," + extr2+"]"
					+ ": " + valeurSegment() + "\n" + point + " appartient au segment [" + extr1 + "," + extr2+"]";
		} else {
			return "Longueur du Segment[" + extr1 + "," + extr2+"]"
					+ ": " + valeurSegment() + "\n" + point + " n'appartient pas au segment[" + extr1 + "," + extr2+"]";
		}
	
	}
	
}
