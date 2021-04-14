package sec06.ch04;

import java.util.Scanner;

public class IfMission2 {
	
	public static void main(String[] args) {
		String gender;
		int height;
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("키를 입력바랍니다.");
		height = scanner.nextInt();
		System.out.println("성별을 입력바랍니다.");
		gender = scanner.next();
		
		final int MAN_STAND = 175;
		final int WOMAN_STAND = 163;
		int stand = MAN_STAND;
		
		//man, 170 >미만
		//남 175 >평균
		//남, 176 >초과
		//여 162 >미만
		//여,163 >평균
		//여,164>초과
		

		if(gender.equals("여")){
			stand = WOMAN_STAND;
			
		}
		//남자일시 실행이됩니다.
		if (height > stand) {
			System.out.println("초과");
		} else if (height == stand){
			System.out.println("평균");
		} else {
			System.out.println("미만");
		}
		//end
		
	}

}
