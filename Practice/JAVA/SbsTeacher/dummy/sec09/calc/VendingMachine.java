package sec09.calc;

import java.util.Scanner;

public class VendingMachine {

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
		
		//메뉴판 배열로출력
		System.out.println("<메뉴>");
		for (int i = 0; i < menuNmArr.length; i++) {
			System.out.printf("%d %s \n" ,i + 1,menuNmArr[i]);
		}
		//선택구간
		System.out.print("선택>");
		int val = sc.nextInt();
		
		if (deposit > 0) {
			switch (val) {
			case 1 :
				System.out.println("콜라를 선택하셨습니다.");
				withdraw += menuPriceArr[0];
				break;
			case 2:
				System.out.println("사이다를 선택하셨습니다.");
				withdraw += menuPriceArr[1];
				break;
			case 3:
				System.out.println("환타를 선택하셨습니다.");
				withdraw += menuPriceArr[2];
				break;
			default:
				System.out.println("3번까지만 허용하겠습니다.");
				break;
			}
		} else {
			System.out.println("deposit 음수");
		}
		
		System.out.println("충지출 -> withdraw : " + withdraw);
		sc.close();
	}

}
