package chap02;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[100]; //배열 100개선언
		int[] counting = new int[31]; //범위 0~30
		int[] result = new int[100]; //정렬된배열출력되게
	
		for (int i = 0; i < array.length; i++) {
			array[i] = (int)(Math.random()*31); // 0 ~ 30
		}
		
		//정렬
		for (int i = 0; i < array.length; i++) {
			//array 의 목 값을 인덱스로 하는 카운트 배열 값 1증가
			counting[array[i]]++;
		}
		
		for (int i = 1; i < counting.length; i++) {
			//누적합해주기
			counting[i] += counting[i - 1];
		}
		
		for (int i = array.length - 1; i >= 0; i--) {
			//i 번째 원소를 인덱스로 하는 카운팅 배열을 1 감소시킨뒤
			//카운팅 배열의 값을 인덱스로 하여 result에 value 값을 저장한다.
			
			int value = array[i];
			counting[value]--;
			result[counting[value]] = value;
		}
		// 초기 배열 
				System.out.println("array[]");
				for(int i = 0; i < array.length; i++) {
					if(i % 10 == 0) System.out.println();
					System.out.print(array[i] + "\t");
				}
				System.out.println("\n\n");

				// Counting 배열 
				System.out.println("counting[]");
				for(int i = 0; i < counting.length; i++) {
					if(i % 10 == 0) System.out.println();
					System.out.print(counting[i] + "\t");
				}
				System.out.println("\n\n");
				// 정렬된 배열
				System.out.println("result[]");
				for(int i = 0; i < result.length; i++) {
					if(i % 10 == 0) System.out.println();
					System.out.print(result[i] + "\t");
				}
				System.out.println();
	}
	

}
