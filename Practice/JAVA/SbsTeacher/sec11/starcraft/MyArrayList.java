package sec11.starcraft;

public class MyArrayList implements MyList {
	private int[] arr;

	public MyArrayList() {
		arr = new int[0];
	}
	@Override
	public void add(int add) {
		int[] temp = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
			
		} 
		temp[arr.length] = add;
		arr = temp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return arr.length;
	}

	@Override
	public int get(int i) {
		// TODO Auto-generated method stub
		return arr[i];
	}
		
	
}
