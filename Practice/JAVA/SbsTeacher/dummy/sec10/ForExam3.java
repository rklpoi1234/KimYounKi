package sec10.ch07;

public class ForExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,9,10,56};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("--------------");
		
		for (int val : arr) {
			System.out.print(val);
		}
	}

}
