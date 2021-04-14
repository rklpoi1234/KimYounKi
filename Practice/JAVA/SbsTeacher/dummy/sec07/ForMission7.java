package sec07;

public class ForMission7 {

	public static void main(String[] args) {
		int star = (int)(Math.random() * 5 + 3) ; //3~7random)
		System.out.println(star);
		//star = 3
		
		//*
		//**
		//***
		for (int i = 0; i < star; i--) {
			for (int j = star; j < i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//star =  5
	}

}
