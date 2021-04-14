package sec10.ch06;

import java.util.Arrays;
import java.util.Scanner;

public class AtmAlg2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int coin = sc.nextInt() ;
		int[] coinArr = {500,100,50,10,5,1};
		int result = 0;
		coin = 1000 - coin;
		
		for (int i = 0; i < coinArr.length; i++) {
			result += coin/coinArr[i];
			coin = coin%coinArr[i];
		}
		System.out.println(result);
	}

}

