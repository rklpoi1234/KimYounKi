package sec11.starcraft;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list = new ArrayList();
		LinkedList list1 = new LinkedList();
		
		list.add(10);
		list.add(10.1);
		list.add("ddd");
		//list.add(new Card("",""));
		
		int val2 = (int) list.get(0);
		System.out.println("val2 : " + val2);
		
		Object obj = list.get(1);
		double val = (double)obj;
		System.out.println("val : " + val);

	}

}
