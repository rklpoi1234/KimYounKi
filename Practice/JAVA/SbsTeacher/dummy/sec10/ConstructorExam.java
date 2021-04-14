package sec10.ch07;

public class ConstructorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tv tv1 = new Tv();
		tv1.brand = "samsung";
		tv1.inch = 100;
		tv1.maxChannel = 100;
		tv1.maxVolume = 100;
		tv1.displayState();
		

		 //현재볼륨 : 3
		
		Tv tv2 = new Tv("LG", 200, 150 ,200);
		tv2.displayState();
		
	}

}

class Tv {
	String brand;
	int inch;
	int maxChannel;
	int maxVolume;
	int currentChannel;
	int currentVolume;
	
	Tv(){
		
	}
	
	Tv(String brand,int inch, int maxChannel, int maxVolume){
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