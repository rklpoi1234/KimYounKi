package sec06.ch03;

public class OperatorExam2 {
	public static void main(String[] args) {
		int n1 = 10;
		System.out.println("n1 : " + n1);
		n1++;
		System.out.println("n1 : " + n1);
		++n1;
		System.out.println("n1 : " + n1);
		--n1;
		System.out.println("n1 : " + n1);
		n1--;
		System.out.println("n1 : " + n1);
		
		int n2 = 10;
		int result = 10 + (++n2);
		System.out.println("n2 result : " +result);
		System.out.println("n2 : " +n2);
		
		int n3 = 10;
		int result2 = 10 + (n3++);
		System.out.println("n3 result : " +result2);
		System.out.println("n3 : " +n3);
		
		
		
	}
}
