package sec06.ch04;

public class IfMission {

	public static void main(String[] args) {
		int score = 89;
		
		if (score < 70) {
			System.out.println("m D");
		} else if (score < 80) {
			System.out.println("m C");
		} else if (score < 90) {
			System.out.println("m B");
		} else {
			System.out.println("m A");
		}
		System.out.println("End");
	}

}
