package chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bak2839br {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
				

		if (n == 4 || n == 7) {
			System.out.println(-1);
		} else if (n % 5 == 0) {
			System.out.println(n/5);
		} else if (n % 5 == 1 || n % 5 == 3) {
			System.out.println(n/5 + 1);
		} else if (n % 5 == 2 || n % 5 == 4) {
			System.out.println(n/5 + 2);
		}
	}

}
