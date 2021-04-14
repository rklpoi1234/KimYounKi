package sec07;

public class ForMission4 {

	public static void main(String[] args) {
		int dan = (int)(Math.random() * 8) + 2 ; 
				
		//2~9 random
		for (int i = 6; i < 15; i++) {
			System.out.printf("dan : %d * %d = %d \n" ,dan, i - 5,(dan*(i-5)));
		}
		//console -> 2*1 = 2 ... 9dan kara
				
				

	}

}
