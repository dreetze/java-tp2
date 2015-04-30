package question3;

public class Multiplication {

	public Multiplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int i=0;
		int j=0;
		System.out.print("- \t");
		for(i=0; i<6; i++){
			System.out.print(i+"\t");
		}
		
		for(i=0; i<6; i++){
			System.out.print("\n"+i+"\t");
			for(j=0; j<6; j++){
				System.out.print(j*i+"\t");
			}
		}
		

	}

}
