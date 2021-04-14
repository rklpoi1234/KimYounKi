package sec09.calc;

public class MethodMission5 {

	public static void main(String[] args) {
//		int rNum = getRandomNum(); //0~9
//		System.out.println("rNum : " + rNum);
//		
//		int iKido = getRandomNum(20);
//		
//		System.out.println("roamroamroamroamroamroamroamroamroam :" + iKido);
//		
//		iKido = getRandomNum(5);
//		
//		System.out.println("roamroamroamroamroamroamroamroamroam :" + iKido);

		int rNum = getRandomNum(10,11);
		System.out.println(rNum);
	}

	
	
//	private static int getRandomNum() {
//		int random = (int)(Math.random() * 10);
//		if (random < 0 || random > 9 ) {
//			System.out.println("그럴일없음");
//		} else {
//			System.out.println("ㅇ");
//		}
//		return random;
//		//뻘짓
//	}
//	//여기서부터 미숀
//	private static int getRandomNum(int sass) {
//		return (int)(Math.random() * sass);
//	}
//	
	public static int getRandomNum(int st1, int en2) {
		
		if (st1 > en2) {
			return (int)(Math.random() * (st1 - en2 + 1)) + en2;
		} else {
			return (int)(Math.random() * (st1 - en2 - 1 )) + en2;
		}
	}
	
}//0+5<=x <1*11  ,5,10
	