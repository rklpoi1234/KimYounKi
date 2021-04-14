package sec10.ch10;

public class Animal {
	
	public static void main(String[] args) {
		Car car1 = new Bus();
		Car car2 = new Car();
		Car car3 = new LocalBus();
		
		Bus bus1 = (Bus)car1;
//		bus1.openDoor();
//		bus1.hoot();
		Bus bus2 = (LocalBus)car3;
		
		System.out.println(car1 instanceof LocalBus);
		
		System.out.println("뚱!");
	}
	


}
