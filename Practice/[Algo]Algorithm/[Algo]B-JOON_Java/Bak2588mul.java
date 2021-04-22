package BakAlg;

import java.util.Scanner;

public class Bak2588mul {

	public static void main(String[] args) {
		// TODO Auto-generated method stubi
		Scanner n = new Scanner(System.in);
		int A1 = n.nextInt();
		int B2 = n.nextInt();
		System.out.println(A1*(B2%10));
		System.out.println(A1*(B2%100/10));
		System.out.println(A1*(B2/100));
		System.out.println(A1*B2);
		n.close();
	}

}
