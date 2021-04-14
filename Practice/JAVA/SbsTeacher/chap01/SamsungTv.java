package chap05;

public class SamsungTv implements RemoteControl {
	int vom = 0;
	@Override
	public void voluemUp() {
		// TODO Auto-generated method stub
		vom += 2;
	}

	@Override
	public void voluemDown() {
		// TODO Auto-generated method stub
		vom -= 2;

	}

	@Override
	public void chkVoluem() {
		// TODO Auto-generated method stub

	System.out.println(vom);	
	}

}
