package sec07;

public class ForMission5_1 {

	public static void main(String[] args) {
		//2*1=2  3*1=3  4*1 =4 ... 9 1 = 9
		//2 2 4  3 2 6  ...
		//2  3 6
		//...
		//2 9 18 3 9 27 ...
		
		for (int i = 2; i < 10; i++) {
			
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\t" ,j,i,i*j);
				
			}
			System.out.println();
		}
	}
}
