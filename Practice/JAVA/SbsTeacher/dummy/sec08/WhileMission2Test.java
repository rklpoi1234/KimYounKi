package sec08;

import java.util.Random;

public class WhileMission2Test {

	public static void main(String[] args) {
		
		int sum = 0;
		
		
		
		while (true) {
			int val = (int)(Math.random() * 11) +0; //0~10 aside random
			System.out.println("val : " + val);
			if(val == 0) {
				break;
			}
			sum += val;
		}
		
		System.out.println("sum : " +sum);
	
	}

}
