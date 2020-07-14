package july_0713;

public class RetEx {

	public static void main(String[] args) {
		RemoteControl s = new Radio();
		s.turnOn();
		s.setMute(true);
		Radio ok = (Radio) s;
		ok.setVolume(90);

	}

}
