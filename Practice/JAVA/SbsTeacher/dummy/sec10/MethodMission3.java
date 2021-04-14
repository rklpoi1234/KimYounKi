package sec10;

public class MethodMission3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = getRandomScore(50, 100); //50~100 사이 숫자
		
		char grade = getGrade(score);
		//90점 이상 'a'
		//80 'b'
		//70 'c'
		//60 'd'
		//other 'e'
		char grade2 = getGrade2(score);
		//8이상이거나 100 '+'
		//3 이하이면 '-'
		//나머지 ''빈킨이 리턴 되도록!
		System.out.printf("%d : %c%c\n", score, grade, grade2);
	}
	
	public static int getRandomScore (int from, int to) {
		int score = (int)(Math.random() * (from - to - 1)) + to;
		return score;
	}
	
	public static char getGrade(int num) {
		
		if (num >= 90) {
			return 'A';
		} else if (num >= 80) {
			return 'B';
		} else if (num >= 70) {
			return 'C';
		} else if (num >= 60) {
			return 'D';
		} else {
			return 'E';
		}
		
	}
	public static char getGrade2 (int num) {
		
		if (num % 10 >= 8 || num == 100) {
			return '+';
		} else if (num % 10 <= 3) {
			return '-';
		}
		return ' '; 
		
		
	}

}
