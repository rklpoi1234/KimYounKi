package sec11;

public class LGTv implements RemoteControl{
	private int volume;
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		volume++;
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		
		volume--;
	}

	@Override
	public void chkVolume() {
		// TODO Auto-generated method stub
		System.out.println("volume : " + volume);
		
	}

}
