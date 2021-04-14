package sec07;

public class ForMission3 {

	public static void main(String[] args) {
		int star = (int)(Math.random() * (11-5) ) + 5;
		System.out.println("star : " + star);
		
		for (int i = 0; i <= star; i++  )
		{
			System.out.print("*");
		}
		//star 5 =*5개
		
		//star 8 =*8개
		
		//5~10사이 랜덤값

	}

}
