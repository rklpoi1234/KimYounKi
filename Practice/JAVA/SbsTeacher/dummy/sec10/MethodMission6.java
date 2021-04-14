package sec10;

import java.util.Arrays;
import java.util.Scanner;

public class MethodMission6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] menuNmArr = {"콜라", "사이다","환타","스프라이트","망고주스","포도주스"};
		int[] menuPriceArr = {1000,1200,1300,1500,2000,3000};
		
		printMenu(menuNmArr,menuPriceArr);
		
	}

	public static void printMenu(String[] menu, int[] Price) {
		System.out.println("<메뉴>");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d. %s (%d)\n" , i, menu[i], Price[i]);
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("선택('-^)b");
		int select = scan.nextInt();
	}
	
	public static void printMenu2(String[] menu, int[] Price) {
		String str = "";
		System.out.println("<메뉴>");
		for (int i = 0; i < menu.length; i++) {
			str += String.format("%d. %s (%d)\n" , i, menu[i], Price[i]);
			System.out.println(str);
		}
		System.out.println(str);
	}
}
