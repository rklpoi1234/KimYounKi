package sec10.ch07;

public class InstanceExam7 {

	public static void main(String[] args) {
	
		//칼 객체화
		Calc calc = new Calc();
		//섭 메소드 호출 아규먼츠 5 ,10
		calc.sum(5, 10);
	}
	
}

class Calc {
	void sum (int n1, int n2) {
		System.out.println(n1 + n2);
	}
}