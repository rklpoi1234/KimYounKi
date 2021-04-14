package sec09.calc;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSoryMission {

	public static void main(String[] args) {
		int[] arr = {8, 7, 3, 1, 6};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					System.out.printf(Arrays.toString(arr));
				}
			}
		}
		

	}

}
