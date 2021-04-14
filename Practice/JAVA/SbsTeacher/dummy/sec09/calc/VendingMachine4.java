package sec09.calc;

import java.util.Scanner;

public class VendingMachine4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] drink = {"콜라","사이다","박하사탕"};
		int[] drinkPrice = {1000,1200,1300};
		int withdraw = 0;
		//deposit input
		System.out.println("돈을 입금바람ㄱ");
		int deposit = sc.nextInt();
		
		
		
		//menu for
		System.out.println("메뉴");
		for (int i = 0; i < drink.length; i++) {
			System.out.printf("%s %d \n" ,drink[i],drinkPrice[i]);
		}
		
		while (true) {
			System.out.println("\n선택('-^)b");
			int choice = sc.nextInt();
			int val = choice -1;
			if (choice == 0) {
				break;
			} else if (choice < 0 || choice > drink.length) {
				System.out.println("(ㅠㅠ)");
				continue;
			} else {
				if (deposit < drinkPrice[val]) {
					System.out.printf("죄송합니다. 금액이 %d원 부족합니다.%n", drinkPrice[val] - deposit);
					continue;
				}
				withdraw += drinkPrice[val];
				deposit -= drinkPrice[val];
				}
				System.out.printf("%s 를 삼 (남금%d)\n" ,drink[val],deposit);
				
				
			}
		System.out.println("총나간금액일뜻withdrow : " + withdraw);
		System.out.println("currentMoney : " + deposit);
		sc.close();
		}
		
	}
		
