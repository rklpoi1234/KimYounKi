package sec09;

public class DoubleForMission {

	public static void main(String[] args) {
		
		OUTER:
		for (int n1 = 1; n1 <= 9; n1++) {
			
			for (int n2 = 0; n2 <= 9; n2++) {
				if (n2 == n1) {
					break;
				}
				System.out.printf("%d%d\n" ,n1,n2);
			}
			System.out.println();
			if (n1 == 8) {
				break;
			}
		}
		System.out.println("End!");
	}

}
