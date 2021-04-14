package sec09;

public class ArrayMission2 {

	public static void main(String[] args) {
		//정수형 배열 생성 (10칸짜리)
		//모든방에 정수값 20을 세팅해 주세요.
		
		int[] intArr = new int[10];
		for (int i = 0; i < 10; i++) {
			intArr[i] += 20;
			
			
		}
		for (int i = 0; i < 10; i++) {
			System.out.printf("intArr[%d] : %d\n" ,i,intArr[i]);
		}
	} 
	

}
