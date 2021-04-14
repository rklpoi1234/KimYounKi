package sec10.ch07;

public class ConstructorExam2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv2 tv = new Tv2();
		tv.displayState();
		//일렉트로 50inch 100channel 50Vol
		
	}

}

class Tv2 {
	String brand;
	int inch;
	int maxChannel;
	int maxVolume;
	int currentChannel;
	int currentVolume;
	
	Tv2(){
		
	}
	
	Tv2(String brand,int inch, int maxChannel, int maxVolume){
		this.brand = brand;
		this.inch = inch;
		this.maxChannel = maxChannel;
		this.maxVolume = maxVolume;
	}
	
	void volumeUp(){
		currentVolume += 1;
	}
	
	void displayVolume() {
		System.out.println("현재볼륨:"+currentVolume);
	}
	
	void displayState() {
		System.out.printf("%s %dinch %dChaBungun %dVol\n" ,brand,inch,maxChannel,maxVolume);
	}
}