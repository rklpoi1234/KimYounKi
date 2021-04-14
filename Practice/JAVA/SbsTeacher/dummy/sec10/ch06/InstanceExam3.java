package sec10.ch06;

public class InstanceExam3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mainNum = 10;
		Box box = new Box();
		box.num = 10;
	
		int a=changeNum(mainNum);
		
		System.out.println("mainNum : " + a);
		
		changeBoxNum(box);
		
		System.out.println("box.num : " + box.num);
	}
	
	public static int changeNum(int num) {
		num = 20;
		return num;
	}
	
	public static void changeBoxNum(Box box) {
		box.num = 20;
	}

}

class Box {
	int num;
}