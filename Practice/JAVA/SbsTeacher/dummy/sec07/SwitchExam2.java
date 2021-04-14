package sec07;

public class SwitchExam2 {

	public static void main(String[] args) {
		String habbit = "수영";
		
		switch (habbit) {
		case "수영": 
		case "등산":
			System.out.println("건강한 취미");
			break;
		case "sns":
		case"tabaco":
			System.out.println("no no");
		default:
			break;
		}

	}

}
