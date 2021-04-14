package sec10;

public class MethodMission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int star = 3;
		//printStarLine(star);
		System.out.println();

		
		//printStarSqure(star);
		
		printStarTri(star);
	}
	
	public static void printStarLine(int star) {
		for (int i = 0; i < star; i++) {
			System.out.print("*");
		}
	}	

	
	public static void printStarSqure(int star) {
		for (int i = star - 1; i > 0; i--) {
			printStarLine(star);
			System.out.println();
		}
		
	}
	
	public static void printStarTri (int star) {
		
		for (int i = 0; i <= star; i++) {
			printStarLine(i);
			System.out.println();
		}
		
	}

}
