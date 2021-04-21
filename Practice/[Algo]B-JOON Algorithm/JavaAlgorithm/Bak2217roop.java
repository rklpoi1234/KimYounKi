package BakAlg;


import java.util.Arrays;
import java.util.Scanner;

public class Bak2217roop {

	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();//로프갯수
		 int p2 = 0; //하다가 필요해서넣음
		 int[] kg = new int[n]; //로프각각무게
		 
		 for (int i = 0; i < n; i++) {
			kg[i] = sc.nextInt();//돌면서 무게설정
		}
		 
		 Arrays.sort(kg); //내림차순도되고 오름차순도되고
		 
		 
		 for (int i = 0; i < n; i++) {
			int p1 = kg[i] * (n-i); //들어올릴수있는 최대중량
			if (p1 > p2) { //최대중량을구하기위해 p2이상되어야지
				//값이 다시 p2로넘어감 (최대구하기)
				p2 = p1;
			}
			
		}
		 System.out.println(p2);
    }
	 
}