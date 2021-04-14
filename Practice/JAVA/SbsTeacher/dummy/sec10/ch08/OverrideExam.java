package sec10.ch08;

public class OverrideExam {

	
	public static void main(String[] args) {
		NumBox nb1 = new NumBox(10);
		NumBox nb2 = new NumBox(10);
		
		
		System.out.println("nb1 == nb2 : " + (nb1 == nb2));
		System.out.println("nb1.equals(nb2) : " + (nb1.equals(nb2)));
		
	}
	
}

class NumBox {
	private int num;
	public NumBox(int num) {
		// TODO Auto-generated constructor stub
		this.num = num;
		
	}

	public int getNum() {
		return num;
	}
	
	@Override
	public boolean equals(Object obj) {
		NumBox temp = (NumBox) obj;
		return this.getNum() == temp.getNum();
	}
	
	
}