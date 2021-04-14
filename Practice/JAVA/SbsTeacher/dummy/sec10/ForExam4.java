package sec10.ch07;

import java.util.ArrayList;

public class ForExam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strArr = {"A","B","C","D","E"};
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = strArr.length-1; i >= 0; i--) {
			
			System.out.println(strArr[i]);
			
		}
		
		for (int i = 0; i < strArr.length; i++) {
			array.add(i);
			
			
		}
		
//		for (String string : strArr) {
//			System.out.println(string);
//		}
	}

}
