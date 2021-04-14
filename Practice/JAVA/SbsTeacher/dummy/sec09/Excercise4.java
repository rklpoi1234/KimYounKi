package sec09;

public class Excercise4 {

	public static void main(String[] args) {
		
		int n1 = 0 , n2 =0;
		
		while (n1 + n2 != 5) {
			 n1 = (int)(Math.random() * 6) + 1;
			 n2 = (int)(Math.random() * 6) + 1;
			System.out.printf("(%d,%d)" ,n1,n2);
			
			
		}
		
		
	}

}
