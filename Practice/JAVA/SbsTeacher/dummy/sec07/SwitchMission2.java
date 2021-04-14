package sec07;

public class SwitchMission2 {

	public static void main(String[] args) {
		String pos = "과장";
		
		
		switch (pos) {
		case "부장": //pos value "부장" ->"700만원"
			System.out.println("700만원");
			break;
		case "과장": //pos  value "과장" ->"500만원"
			System.out.println("500만원");
			break;
		default: //other value ->"300만원"
			System.out.println("300만원");
			break;
		}
		
		
		

	}

}
