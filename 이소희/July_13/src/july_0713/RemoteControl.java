package july_0713;

public interface RemoteControl {
	int MAX_VOLUME = 100;
	int MIN_VOLUME = 0;
	
	void turnOn();
	void turnOff();
	default void testjj() {};
	
	static void changeBattery() {
		System.out.println("건전지를 교환합니다.");
	}
	
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
		}else
			System.out.println("무음 해제 합니다");
	}
}
