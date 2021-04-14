package sec10.ch10;

public class PolyExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//instanceof는 상속관계일떄 사용하는 기능
		Car car1 = new LocalBus();
	
		Bus bus1 = (Bus)car1;
		
		System.out.println(bus1 instanceof Bus);
		
		System.out.println("----------------------");
		
		
		Bus car2 = new Bus(); 
		
		System.out.println(car2 instanceof Car);
		
		Truck truck = new Truck();
		
		System.out.println(truck instanceof Object);
	}

}
