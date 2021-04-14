package sec10;

public class MethodMission4 {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
	//	gugudan(8);
//		// 8 * 1 = 8
//		// 8 * 2 = 16
		gugudan(2,8);
		
	}
	public static void gugudan(int number) {
		
			for (int j = 1  ; j <= number ; j++) {
				System.out.printf("%d * %d = %d \n" , number, j, (number*j));
			}
			System.out.println();
		
	}
	
	public static void gugudan(int num1, int num2) {
		for (int i = num1; i <= num2; i++) {
			gugudan(i);
			System.out.println("-----------");
		}
	}

}
