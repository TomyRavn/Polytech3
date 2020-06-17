
public class ThisOk {

	String model;
	String color;
	int maxSpeed;

	public ThisOk(String model) {
		this.model = model;
		color = "은색";
		maxSpeed = 150;
	}
	public ThisOk(String model,String color) {
		this.model = model;
		this.color = color;
		maxSpeed = 150;
	}
	public ThisOk(String model,String color,int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = 150;
	
	}


//	public ThisOk(String model) {
//	 this(model,"은색",150);
		
	}

