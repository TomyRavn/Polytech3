import java.util.Calendar;

public class Ex04 {
	public static void main(String[] args) {

		Week today = null;

		//Calendar 클래스는 이미 만들어져있는 클래스
		Calendar cal = Calendar.getInstance();	//getInstance 메소드를 통해 가져옴

		int week = cal.get(Calendar.DAY_OF_WEEK);

		switch(week) {
		case 1: today = Week.SUNDAY; break;
		case 2: today = Week.MONDAY; break;
		case 3: today = Week.TUESDAY; break;
		case 4: today = Week.WEDNESDAY; break;
		case 5: today = Week.THURSDAY; break;
		case 6: today = Week.FRIDAY; break;
		case 7: today = Week.SATURDAY; break;
		}
		
		System.out.println("오늘 요일은 " + today);
		
		if(today.equals(Week.SUNDAY)) System.out.println("일요일~");
		else System.out.println("자바 공부중~~~");
	}
}