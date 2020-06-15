public class ThisOk {
	String model;
	String color;
	int maxSpeed;
	
	public ThisOk() {
		
	}
	
	public ThisOk(String model) {
		this(model, "Àº»ö", 150);
	}
	
	public ThisOk(String model, String color) {
		this(model, color, 150);
	}
	
	public ThisOk(String model, String color, int maxSpeed) {
		//this(model, color, maxSpeed);
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
}