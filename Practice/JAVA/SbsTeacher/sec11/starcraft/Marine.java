package sec11.starcraft;

public class Marine implements Bionic {
	private int currentHP = 10;
	final int MAXHP = 20;

	public int getCurrentHP() {
		return currentHP;
	}
	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}
	
	
}