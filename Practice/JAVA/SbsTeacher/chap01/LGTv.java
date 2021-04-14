package chap05;

public class LGTv implements RemoteControl {

	int vom = 0;
	@Override
	public void voluemUp() {
		// TODO Auto-generated method stub
		vom++;
	}

	@Override
	public void voluemDown() {
		// TODO Auto-generated method stub
		vom--;
	}

	@Override
	public void chkVoluem() {
		// TODO Auto-generated method stub
		System.out.println(vom);
	}
	
}
