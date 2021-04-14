package sec10.ch06;

public class InstanceExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog kim = new Dog();
		Dog kim2 = kim;
		kim.name = "work";
		kim2.name = "dool";
		
		kim.짓다();
		kim2.짓다();
	}

}

