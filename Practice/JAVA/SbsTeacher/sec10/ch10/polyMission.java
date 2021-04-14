package sec10.ch10;

public class polyMission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car1 = new Car();
		Car car2 = new Bus();
		Car car3 = new LocalBus();
		Car car4 = new Truck();
		
		blowKlaxon(car1);
		blowKlaxon(car2);
		blowKlaxon(car3);
		blowKlaxon(car4);
	}

	public static void blowKlaxon(Car car) {
		if (car instanceof Bus) {
			((Bus) car).openDoor();
		}
		car.hoot();
	}
}


