package sec11;

public class SamsungTv implements RemoteControl {
	private int sound;
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		sound += 2;
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		sound -= 2;
		
	}

	@Override
	public void chkVolume() {
		// TODO Auto-generated method stub
		System.out.println("sound : " +sound);
		
	}

}
