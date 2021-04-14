package sec10.ch08;

public class InheriExam {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat("고양이" , 4);
		cat.howling();
//		cat.name = "고양이";
//		cat.age = 4;
//		cat.howling();
//		cat.lick();

		
		
		System.out.printf("%s,%d" ,cat.name,cat.age);
		
		
		
	}
	
}

class Animal {
	String name;
	int age;
	
	
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}


	void howling() {
		System.out.println("운다");
	}
}

class Cat extends Animal {
	
	Cat(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	void lick() {
		System.out.printf("%s가 핥다\n" ,name);
	}
	
	@Override
	void howling() {
		System.out.println("야옹");
	}
}

class Koshort extends Cat {
	Koshort(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}

	void pee() {
		System.out.printf("%s가 소변을 본다" ,name);
	}
}