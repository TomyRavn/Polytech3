public class Song {
	String title;
	String artist;
	String year;
	String country;
	
	public Song() {
		
	}
	
	public Song(String title, String artist, String year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}
	
	void show() {
		System.out.printf("%s�� %s ������ %s�� �θ� %s", year, country, artist, title);
	}
	
	
	public static void main(String[] args) {
		Song a = new Song("Dancing Queen", "ABBA", "1978", "������");
		a.show();
	}
}