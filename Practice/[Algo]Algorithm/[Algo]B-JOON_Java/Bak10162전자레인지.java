package BakAlg;

import java.util.Scanner;

public class Bak10162전자레인지 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int A = 0; //A 에다가 넣어줄 변수
		int B = 0; //B 에다가 넣어줄 변수
		int C = 0; //C 에다가 넣어줄 변수
		
		if (t >= 300) {
			A = t/300;  //나눠서 몫을 주고 나머지를빼버림
			t -= 300 * A;
		}
		
		if (t >= 60) {
			B = t/60;
			t -= 60 * B;
		}
		
		if (t >= 10) {
			C = t/10;
			t -= 10 * C;
		}
		if (t % 10 != 0) {
			System.out.println("-1");
			return;
		}
		
		System.out.printf("%d %d %d",A,B,C );
	}

}
