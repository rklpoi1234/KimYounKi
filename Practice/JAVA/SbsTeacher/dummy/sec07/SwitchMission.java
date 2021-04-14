package sec07;

public class SwitchMission {

	public static void main(String[] args) {
		int time = (int)(Math.random()*4) + 8;
		
		System.out.println("time : " +time);
		//스위치문으로 해결
		//t8 출근
		switch (time) {
		case 8:
			System.out.println("출근합니다");
			break;
		case 9:
			System.out.println("회의를 합니다");
			break;
		case 10:
			System.out.println("업무를 봅니다");
			break;
		default:
			System.out.println("외근을 나갑니다.");
			break;
		}
		//t9 회의
		
		//t10 업무
	
		//other time 외근
	}

}
