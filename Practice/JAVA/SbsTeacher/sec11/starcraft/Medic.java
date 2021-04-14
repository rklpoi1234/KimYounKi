package sec11.starcraft;

public class Medic implements Bionic {
	private int currentHP = 3;
	private final int MAXHP = 15;

	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public void heal(Object unit) {
		if (this == unit || !(unit instanceof Bionic)){
			System.out.println("치료할수없습니다");
			return;
		}
		if (unit instanceof Bionic) {
			if (unit instanceof Marine) {
				Marine marine = (Marine)unit;
				marine.setCurrentHP(marine.MAXHP);
				
			}
			if (unit instanceof Medic) {
				Medic medic = (Medic)unit;
				medic.setCurrentHP(medic.MAXHP);
			}
			return;
		}
		System.out.println("치료할수없습니다.");
	}
}
