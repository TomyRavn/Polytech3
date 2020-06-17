
public class Song {
		
		String title;
		String artist;
		String year;
		String county;
		
	void show() {
		System.out.println(year+"년"+county+"국적"+artist+"가 부른"+title);		
}
	public Song (String year, String county,String artist,String title) {
		  this.year = year;
		  this.county = county;
		  this.artist = artist;
	      this.title = title;
	
}
	
	public static void main(String[] args) {
		Song n = new Song("1978","스웨덴","ABBA","QUEEN");
		n.show();
		
	}
	
}

