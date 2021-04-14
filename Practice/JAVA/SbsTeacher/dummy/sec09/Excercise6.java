package sec09;

import java.util.Scanner;

public class Excercise6 {

	public static void main(String[] args) {
		
		boolean run = true;
		int balance = 0;
		int deposit = 0;
		int Out = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		
		
		while (run) {
			
			System.out.println("------------");
			
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			
			System.out.println("--------------");
			
			int number = scanner.nextInt();
			
			if (number == 1) {
				System.out.println("예금액");
				deposit = scanner.nextInt();
				balance += deposit;
			} else if (number == 2) {
				System.out.println("출금액");
				Out = scanner.nextInt();
				balance -= Out;
			} else if (number == 3 ) {
				System.out.println(balance);
			} else if (number == 4) {
				run = false;
			} else {
				System.out.println("Plz number 1~4");
			}
			
			if (balance < 0) {
				System.out.println("음수는 안된다");
				balance += Out;
			}
		}
		
		System.out.println("프로그램 exit");
	}

}
