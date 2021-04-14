package sec10.ch07;

import java.util.Scanner;

public class Bak1541Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] s = sc.next().split("\\-");
		//sc중간에 - + 라는 부호가들어있어서 빨간줄이뜰텐데
		//이걸 스플릿으로 빼준다고 구분을해주면 OK
		int[] arr = new int[50];
		//50개의 int형배열을 생성
		for (int i = 0; i < s.length; i++) {
			if (s[i].contains("+")) {
				//s인덱스안값이 +인경우
				String[] s2 = new String[s.length];
				//s인덱스길이만큼 split했으니 그뭉텅이길이를말함
				//예를들어 55-55+40 > 55, 55+40 총길이2
				s2 = s[i].split("\\+");
				//위예를보자면 s[1]값 + 와빈공간을짤라s2로
				for (int j = 0; j < s2.length; j++) {
					arr[i] += Integer.parseInt(s2[j]);
				}
			} else {
				arr[i] = Integer.parseInt(s[i]);
			}
		}
		
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum -= arr[i];
		}
		System.out.println(sum);
		
	}

}
