package chap02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Bak11399AtmCountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		//입력 범위 1~1000이므로 1001개의 index를 둔다.
		int[] arr = new int [1001];
		
		//counting Sort
		while (n-- > 0){
			arr[in.nextInt()]++;
			
		}
		
		int prev = 0; //이전 누적합
		int sum = 0; //사람별 대기시간 총합
		
		for (int i = 0; i < 1001; i++) {
			
			//해당  i 인덱스가 0이 될 때 까지 반복
			while (arr[i]-- > 0) {
				//이전까지의 대기시간과 현재 사람이 걸리는 시간을 더해준다.
				sum += (i + prev);
				//이전까지의 누적합에 현재 걸리는 시간을 더해준다.
				prev += i;
				
			}
		}
		System.out.println(sum);
	}

}
