package June15;

public class Song {
	String title;
	String artist;
	String year;
	String country;

	void show() {
		System.out.println(year + country + "의" + artist + "(이)가 부른" + title);
	}

	public Song(String title, String artist, String year, String country) {
		this.title = title;
		this.artist = artist;
		this.year = year;
		this.country = country;
	}

	public static void main(String[] args) {
		Song ABBA = new Song("Dancing Queen", "ABBA", "1978년", "스웨덴");
		ABBA.show();

	}

}
