package sec09;

import java.util.Scanner;

public class WhileKeyControlWithScannerExam {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int speed = 0;
		
		System.out.println("---------------");
		System.out.println("1.증속 | 2.감속 | 3.중지");
		System.out.println("---------------");
		System.out.print("선택 : ");
				
		while(true) {
			int inputVal = scan.nextInt();
			
			if (inputVal == 1) {
				speed++;
			} else if (inputVal == 2) {
				speed--;
			} else if (inputVal == 3) {
				break;
			} else {
				System.out.println("1,2,3 input plz");
				continue;
			}
			System.out.println("speed :" +speed);
		}
		
		System.out.println("End");
	}

}
