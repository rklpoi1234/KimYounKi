package sec07;

public class ForMission5 {

	public static void main(String[] args) {
		//2~9
		//2*1 =2  ... 4 ... 18
		//(blank)
		//3*1 =3 ... 6 ... 9 9 = 81
		
		for (int i = 2; i < 10; i++) {
			System.out.println();
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\n" , i , j , (i*j));
			}
		}
	}

}
