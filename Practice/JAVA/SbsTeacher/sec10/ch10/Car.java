package sec10.ch10;

public class Car {

	public void hoot() {
		// TODO Auto-generated method stub
		System.out.println("빵빵");
	}

}

class Bus extends Car{
	public void openDoor() {
		System.out.println("opendoor");
		
	}
	public void hoot() {
		// TODO Auto-generated method stub
		System.out.println("bus빵빵");
	}
}

class LocalBus extends Bus{
	public void hoot() {
		// TODO Auto-generated method stub
		System.out.println("localbus빵빵");
	}	
}

class Truck extends Car{
	public void hoot() {
		// TODO Auto-generated method stub
		System.out.println("Truck빵빵");
	}	
}
