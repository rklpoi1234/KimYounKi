package sec10.ch06;

import java.util.Arrays;
import java.util.Scanner;


public class InstanceExam5 {

	public static void main(String[] args) {
		//Car 객체화 2개
		//첫번째 차는 name은 "소나타", cc는 2000
		//2 "911" , cc  5000
		//1 드라이브
		//2 스톱
		Car sonata = new Car();
		Car nine = new Car();
		
		sonata.name = "소나타";
		sonata.cc = 2000;
		sonata.drive();
		
		nine.name = "911";
		nine.cc = 5000;
		nine.stop();
		
		
		}
		
	}
	
	
class Car {
	String name;
	int cc;
	
	void drive() {
		System.out.printf("%s는 달린다" ,name);
	}
	void stop() {
		System.out.printf("%s는 멈춘다" ,name);
	}
}
	