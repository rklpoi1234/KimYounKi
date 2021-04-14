package sec10;

import java.util.Arrays;

public class MethodMission5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 8, 10, 11, 45};
		
		String result = toString(arr);
		System.out.println(result);
		
		//4, 8, 10, 11, 45
	}
	
	public static String toString(int[] array) {
		String arr = "";
		for (int i = 0; i < array.length; i++) {
			arr += array[i];
			if (i < array.length-1) {
				arr += ",";
			}
		}
		
		return String.format("[%s]" ,arr); 
		
		
	}

}
