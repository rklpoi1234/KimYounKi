package sec10;

import java.util.Scanner;

public class MethodMission2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String answer = null;
		do {
			
			System.out.println("성별 : ");
			String gender = scan.next(); //남, 여
			
			System.out.println("키 : ");
			int height = scan.nextInt();
			
			String result = chk(gender, height);
			System.out.println(result);
			//성별 : 남, 키:170cm , 평균미만
			
			System.out.println("계속 하시겠습니까?(y,n)");
			answer = scan.next();
			
			
		} while (answer.equals("y"));
		System.out.println("끝");
		scan.close();
		
		
	}
	
	public static String chk(String gender,int height) {
		String avg = " ";
		if (gender.equals("여")) {
			gender = "여";
			if (height  > 163) {
				avg = "초과";
			} else if (height < 163) {
				avg = "미만";
			}
		} else {
			gender = "남"; //무조건 남자
			if (height  > 170) {
				avg = "초과";
			} else if (height < 170) {
				avg = "미만";
			}
		}
		
		return "성별: "+gender+ "키: " +height+ " 평균" + avg;
		
		
	}

}
