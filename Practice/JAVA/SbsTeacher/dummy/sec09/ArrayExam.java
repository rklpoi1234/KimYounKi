package sec09;

public class ArrayExam {

	public static void main(String[] args) {
		//배열
		
		int[] intArr = new int[10];
		intArr[0] = 11;
		intArr[1] = 12;
		intArr[9] = 13;
		intArr[3] = intArr[9] + 4;
		
		String[] strArr = new String[10];
		System.out.println("stra [1] : " + strArr[1]);
	
		
		System.out.println("stra [1] : " + intArr[1]);
		
		int[] intArr2 = {1,2,3};
		
		for (int i = 0; i < 3; i++) {
			System.out.printf("intArr[%d] : %d\n" ,i,intArr2[i]);
		}  
	}
	

}
