package chap01;

public class MethodExam {

	public static void main(String[] args) {
		
		int aaa = 10;
		
		int result = sum(aaa,2034153);
		System.out.println(result);
		result = minus(19,20);
		System.out.println(result);

		
		
	}
	
	public static int sum(int n1,int n2) {
		return n1 + n2;
	}
	public static int minus(int n1,int n2) {
		return n1 - n2;
	}
	
	

}
