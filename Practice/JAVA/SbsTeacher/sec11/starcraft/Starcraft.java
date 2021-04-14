package sec11.starcraft;

public class Starcraft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Medic medic = new Medic();
		Medic medic1 = new Medic();
		Marine marine = new Marine();
		Tank tank = new Tank();
		

		System.out.println("medic1 : hp :" +medic1.getCurrentHP());
		System.out.println("marine : hp :" +marine.getCurrentHP());
		
		medic.heal(medic1); //치료메딕
		medic.heal(marine); //치료메딕
		medic.heal(tank); //치료메딕

		System.out.println("medic1 : hp :" +medic1.getCurrentHP());
		System.out.println("marine : hp :" +marine.getCurrentHP());
	}

}
