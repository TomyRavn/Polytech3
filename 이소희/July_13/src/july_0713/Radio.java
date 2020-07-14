package july_0713;

public class Radio implements RemoteControl {
	
	private int volume;
	void test() {
		System.out.println("나는 라디오입니다.");
	}

	@Override
	public void turnOn() {
		System.out.println("라디오를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("라디오를 끕니다.");

	}
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
		}else if (volume<RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else {
			this.volume= volume;
		}
		System.out.println("현재 Audio 볼륨 : " + volume);
	}

}
