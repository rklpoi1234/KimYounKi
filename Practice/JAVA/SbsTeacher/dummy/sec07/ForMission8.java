package sec07;

public class ForMission8 {

	public static void main(String[] args) {
		int star = (int)(Math.random() * 5 + 3) ; //3~7random)
		System.out.println(star);
		//star = 3
		
		//*
		//**
		//***
		for (int i = star; i > 0; i--) {
			for (int j = i; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//이번엔 역으로
	}
}