package sec10.ch07;

public class AccessExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Access acc = new Access();
		acc.printNum();
	}

}

class Access {
	private int num;
	
	void printNum() {
		System.out.println("num : " + num);
	}
}
