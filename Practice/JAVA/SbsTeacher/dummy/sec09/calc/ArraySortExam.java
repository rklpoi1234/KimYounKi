package sec09.calc;

import java.util.Arrays;

public class ArraySortExam {

	public static void main(String[] args) {
		int[] arr = {88, 65, 23, 1, 900, 42, 95};
		
		int temp = arr[1];
		
		arr[1] = arr[0];
		arr[0] = temp;		
		
		System.out.println(Arrays.toString(arr));
	}

}
