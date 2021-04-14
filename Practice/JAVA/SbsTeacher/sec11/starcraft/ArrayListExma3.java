package sec11.starcraft;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExma3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList();

		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d : %d\n" ,i, list.get(i));
		}
		
		System.out.println("----------------");

		for (int num : list) {
			System.out.println(num);
		}
	}

}
