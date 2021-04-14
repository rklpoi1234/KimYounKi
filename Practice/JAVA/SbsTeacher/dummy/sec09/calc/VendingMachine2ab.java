package sec09.calc;

import java.util.Scanner;

public class VendingMachine2ab {

	public static void main(String[] args) {
		/* 
		 * <메뉴>
		 * 1.콜라 (1000
		 * 1.사이다 (1200
		 * 1.환타 (1300
		 print  withdraw
		 */
		
		
		//선언부
		Scanner sc = new Scanner(System.in);
		int deposit = 0;
		int withdraw = 0;
		
		String[] menuNmArr = {"콜라", "사이다", "환타"};
		int[] menuPriceArr = {1000, 1200, 1300};
		
		//메뉴판 배열로출력 (while문 사용)
		while(true) {
			System.out.println("\n<메뉴>");
			for (int i = 0; i < menuNmArr.length; i++) {
				System.out.printf("%d %s (%,d원)\n", (i+1), menuNmArr[i],menuPriceArr[i]);
			}
			System.out.println("선택 >");
			int choice = sc.nextInt();
			
			if (choice == 0) {
				break;
			} else if (choice >= 1 && choice <= menuNmArr.length) {
				System.out.printf("%s를 선택하셨습니다" ,menuNmArr[choice-1]);
			} else {
				System.out.printf("%d번 까지만허용됩니다" ,menuNmArr.length);
			}
		}
		
		System.out.println("충지출 -> withdraw : " + withdraw);
		sc.close();
	}

}
