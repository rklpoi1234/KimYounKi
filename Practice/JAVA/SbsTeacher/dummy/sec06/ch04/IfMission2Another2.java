package sec06.ch04;

import java.util.Scanner;

public class IfMission2Another2 {

	public static void main(String[] args) {
		
		//초기화
		String gender;
		int height = 0;
		//키값을받기위해
		Scanner scanner = new Scanner(System.in);
		
		final int MAN_HEIGHT_AVG= 175;
		final int WOMAN_HEIGHT_AVG= 163;
		int genderAvg = MAN_HEIGHT_AVG;
		String displayGender = "여자" , displayResult = "평균";
		
		
		//키입력받기
		System.out.println("성별을 말하시요");
		gender = scanner.next();
		System.out.println("키를 말하시요");
		height = scanner.nextInt();
		
		
		if (gender.equals("남자")) {
			genderAvg = MAN_HEIGHT_AVG;
			displayGender = "남자";
			
		}
		
		//남자일시 설정
		if (height < genderAvg) {
			displayResult = "평균 미만";
		} else if (height > genderAvg){
			displayResult = "평균 초과";
		}
		System.out.printf("%s %s\n" , displayGender , displayResult);
		
		
		
		
		
		
		
		
		
	}

}
