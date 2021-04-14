package sec09;

public class ArrayMission {

	public static void main(String[] args) {
		
		//정수형 배열 생성 (10칸짜리)
		//1~10 값 순차적대입 for
		//각방의 값을 출력 for
		//i/o은 분리
		
		int[] value = new int[10];
		
		for (int i = 0; i < value.length; i++) {
			value[i] = 1;
			
		}
		for (int i = 0; i < value.length; i++) {
			System.out.printf("output %d : %d\n " ,i,value[i]);
		}
	} 
	

}
