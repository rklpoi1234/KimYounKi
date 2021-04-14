package sec06.ch04;

import java.util.Scanner;

public class IfMission3 {
	
	public static void main(String[] args) {
		String gender;
		int height = 0;
		
		final int MAN_AVG_HEIGHT = 175;
		final int WOMAN_AVG_HEIGHT = 163;
		int stand = MAN_AVG_HEIGHT;
		
		String printGender = "여자", printResult = "평균";
		
		Scanner san = new Scanner(System.in);
		System.out.println("성별 키를 입력바랍니다.");
		gender = san.next();
		height = san.nextInt();
		
		if (gender.equals("남")) {
			stand = WOMAN_AVG_HEIGHT;
			printGender = "남자";
		}
		
		//남자일시
		if (height > stand) {
			System.out.println("초과");
		} else if(height < stand) {
			System.out.println("평균");
		}
		
		System.out.printf("%s %s" ,printGender , printResult);
	}

}
