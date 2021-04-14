package sec10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Bak11047Coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int CountCoin = sc.nextInt();
		int totalValue = sc.nextInt();
		int result = 0;
		ArrayList<Integer> moneyList = new ArrayList<>();
		
		
		for (int i = 0; i < CountCoin; i++) {
			moneyList.add(sc.nextInt());  
		}
		
		Collections.sort(moneyList, Comparator.reverseOrder());
		//50000만부터 정렬이됨 그니까 큰수부터 money.get[i]에먼저들옴
		for (int i = 0; i < CountCoin; i++) {
			int money = moneyList.get(i);
			result += totalValue/money; //INT값때문에 소수점어짜피잘려나감
			//4200을 주었다면 5000은안되고 1000일때 4번나눠서 리줠트4고 밑에 계산식에서
			//나머지 200이나오기때문에 200을또 리줠트값에넣을수있는것이다
			//500은안되고 100일때 전부나눠지면서 나뭐지도 0으로되어서
			//최소값이 6이나오고 퀘스트완료입니다.
			totalValue %= money;
		}
		System.out.println(result);
	}
}
