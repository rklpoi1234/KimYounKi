package sec10.ch08;

public class StaticExam4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalcInstance2 ci2 = new CalcInstance2();
		//선언
		ci2.num1=10; ci2.num2 = 20;
		int result = ci2.sum();
		//
		System.out.println(result);
		System.out.println(ci2.sum());
	}

}

class CalcStatic2 {
	static int sum(int num1, int num2) {
		return num1 + num2;
	}
}

class CalcInstance2 {
	int num1;
	int num2;
	int sum() {
		return num1 + num2;
	}
}