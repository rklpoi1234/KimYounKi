package sec08;

public class WhileKeyControlExam {

	public static void main(String[] args) throws Exception {
		boolean run = true;
		int speed = 0;
		int keyCode = 0;
		
		while (run)
		{
			if (keyCode != 13 && keyCode != 10 ) {
				System.out.println("---------------");
				System.out.println("1.증속 | 2.감속 | 3.중지");
				System.out.println("---------------");
				System.out.print("선택 : ");
			}
			
			keyCode = System.in.read();
			//System.out.println("keycode : " +keyCode);
			
			if (keyCode == 49) {//1
				speed++;
				System.out.println("speed : "+ speed);
			} else if (keyCode == 50) {//2
				speed--;//2 
				System.out.println("speed : "+ speed);
			} else if (keyCode == 51) {//3
				run = false;
		}

			System.out.println("End!");
		}

	}
}