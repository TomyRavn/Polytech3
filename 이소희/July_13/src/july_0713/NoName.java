package july_0713;

public class NoName {
	public static void main(String[] args) {
		RemoteControl ok = new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("익명의 제품을 켠다~");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("익명의 제품을 끈다~");
				
			}
		
	};
	
	
	RemoteControl ok1 = new RemoteControl() {
		
		@Override
		public void turnOn() {
			System.out.println("익명1의 제품을 켠다~");
			
		}
		
		@Override
		public void turnOff() {
			System.out.println("익명1의 제품을 끈다~");
			
		}
		
	};
	
	ok1.turnOn();
	ok = new Radio();
	ok.turnOn();
	}
}
