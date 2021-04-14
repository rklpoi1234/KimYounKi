package sec10.ch06;

import java.util.Arrays;
import java.util.Scanner;

public class AtmAlg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() ;
		
		int[] p = new int[n];//사람의 수만큼 인출시간배열을만듬
		//스택안에있는 p에다가 힙영역에 있는 int타입[n]의 배열길이를 참조
		for (int i = 0; i < n; i++) {
			p[i] = sc.nextInt();
		}
		Arrays.sort(p); //p 를 오름차순으로 작은숫자를 앞으로
		
		int t_time = 0; //총시간
		int w_time = 0; //걸린시간
		
		for (int i = 0; i < n; i++) {
			w_time += p[i]; //각사람의 인출시간은 걸린시간에 추가를해주면서
			//계속 쌓이면서 늘려줍니다.
			t_time += w_time;//걸린시간들을 계속 총시간에넣어줘서 필요시간의 합의최솟값을구할수있다;
		}
		System.out.println(t_time);
	}

}

