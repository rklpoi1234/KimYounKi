package chap05;

public class MyArrayList implements MyList {

	private int[] arr;

	public MyArrayList() {
		arr = new int[0];
	}
	@Override
	public void add(int n1) {
		int[] temp = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		temp[arr.length] = n1;
		arr = temp;
	}

	@Override
	public int get(int n1) {
		// TODO Auto-generated method stub
		return arr[n1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return arr.length;
	}

}
