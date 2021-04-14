package sec07;

public class ForMission6 {

	public static void main(String[] args) {
		int star = (int)(Math.random() * 5) + 3;
		System.out.println(star);	//3~7 random()
		
		for (int i = 0; i < star; i++) {
			
			for (int j = 0; j < star; j++) {
				System.out.print("*");
			} 
			System.out.print("\n");
		}	
		//star = 3; (3칸짜리 ㅂㄹ이 3줄) (5칸ㄴ짜리 별이5줄)

	}

}
