package chap05;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList list = new MyArrayList();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d : %d\n" ,i,list.get(i));
		}

		System.out.println("----------------");
//
//		for (int num : list) {
//		System.out.println(num);
//		}
//		Box bx = new Box();
//		bx.val = 10;
//		
//		Box bx2 = new Box();
//		bx2.val = 20;
//
//		bx.nextbox = bx2; 
//		
//		System.out.println(bx.nextBox);
	}

}
class Box {
	int val;
	Box nextBox;
}