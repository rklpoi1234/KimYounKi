package sec06.ch04;

public class IfMission4 {

	public static void main(String[] args) {
		final int SCORE = (int)(Math.random() * 20) + 81;
		System.out.println("SCORE : " + SCORE);
		//score 값은 81~100 점 사이의 값이 된다.. 랜덤
	
		int pReuslt = SCORE % 10;
		char cr ='A';
		char crd = '-';
		
		
		if (SCORE > 90) {
			cr = 'A';
		} else if (SCORE > 80) {
			cr = 'B';
		}
		
		if (pReuslt >= 7 || pReuslt == 0) 
		{
			crd = '+'; 
		} else if (pReuslt < 4) 
		{
			crd = '-';
		}
		
		System.out.printf("%d %c%c" , SCORE , cr , crd);
		//90~100 A (97점 이상은 "A+" "도출력이되야함)
		// 96~94 "A", 93~91 "A-"
		//80~90 B (87점 이상은 "B+")
		// 86~84 "B", 83~81 "B-"
	}

}
