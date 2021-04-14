package sec09.calc;

import java.util.*;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class Method2Exam3 {

		public static void main(String[] args) {
			int mon = 10;
			printSeason(3);
			
			
		}
		
		public static void printSeason(int mon) {
			switch (mon) {
			case 3: case 4: case 5:
				System.out.println("봄");
				return;
			case 6: case 7: case 8:
				System.out.println("여름");
				return;
			case 9: case 10: case 11:
				System.out.println("가을");
				return;
			case 12: case 13: case 14:
				System.out.println("겨울");
				return;
			}
			System.out.println("잘 못 입력하셨습니다.");
			}
		
	}
