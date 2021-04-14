package sec10.ch06;

public class InstanceExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog kim = new Dog();
		Dog kim2 = new Dog();
		kim.name = "뽀삐";
		kim.짓다();
		kim2.name = "응딩";
		kim2.짓다();
	}

}

class Dog {
	String name;
	int age;
	
	void 짓다(){
		System.out.printf("%s가 멍멍\n" ,name);
	}
}
