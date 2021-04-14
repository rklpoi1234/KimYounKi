package sec08;

import java.util.Random;

public class WhileMission2 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		int val = (int)(Math.random() * 11) +0; //0~10 aside random
		System.out.println("val : " + val);
		
		for (int i = 0; i <= val; i++) {
			if (i % 2 == 0) {
				continue;
			}
			sum += i;
			System.out.println("sum : "+ sum);
		}
		
		//0이 아니면 계속 sum에 더해주셈 (0나올때까지 반복문돌려)
		
		//sum : 지금까지더한값을출력
	}

}
