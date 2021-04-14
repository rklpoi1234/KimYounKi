package sec09.calc;

import java.util.Scanner;

public class VendingMachine3 {

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
		String[] menuNmArr = {"콜라", "사이다", "환타"};
		int[] menuPriceArr = {1000, 1200, 1300};
		
		//메뉴판 배열로출력 (while문 사용)
	
			System.out.println("\n<메뉴>");
			System.out.println("0은종료가딱이야");
			for (int i = 0; i < menuNmArr.length; i++) {
				System.out.printf("%d %s (%,d원)\n", (i+1), menuNmArr[i],menuPriceArr[i]);
				
			}
			
		//출력부
			int userPrice = 0;
			
			while(true) {
				System.out.println("선택 ('-^)b");
				int choice = sc.nextInt();
				
			if (choice == 0) {
				break;
			} else if (choice < 0 || choice > menuNmArr.length) {
				System.out.printf("잘못 선택");
				continue;
			} else {
				int selectedIdx = choice -1 ;
				
				System.out.printf("%s 를 초이스하셨습니다.\n" ,menuNmArr[selectedIdx]);
				userPrice += menuPriceArr[selectedIdx];
			}
		}
			System.out.println("충지출 -> withdraw : " + userPrice);
			sc.close();
	
		
	}
		

}
