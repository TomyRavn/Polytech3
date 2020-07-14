package july_0713;

public interface Ret {
	int MAX_VOLUME = 100;
	int MIN_VOLUME = 100;
	
	void turnOn();
	void turnOff();
	
	default void setMute(boolean mute) {
		System.out.println("무음 처리");
	}
	
	static void setValue() {}

}
