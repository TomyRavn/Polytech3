package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")	//이름을 통해 검색하기 위해서는 ()안에 이름 적음
public class GridExamConsole implements ExamConsole {
	
	//1. 필드 위에 위치 시, 기본생성자에서 처리, 기본생성자가 없을 시에 문제 발생
	@Autowired	//
//	@Qualifier("exam1")
	private Exam exam;
	
	public GridExamConsole() {
		System.out.println("constructor");
	}
	
	//2. 오버로드 생성자 위치에 둘 시에는 매개 변수가 사용자 지정이라 갯수를 알 수 없으므로
	//	 생성자 위가 아닌 필드 앞에 위치(여러 개 따로 따로 가능)
	public GridExamConsole(/*@Qualifier("exam1")*/Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}
	
	@Override
	public void print() {
		if(exam == null) {
			System.out.println("┌─────────┬─────────┐");
			System.out.println("│  total  │   avg   │");
			System.out.println("├─────────┼─────────┤");
			 System.out.printf("│  %3d    │  %3.2f  │\n", 0, 0.0f);
			System.out.println("└─────────┴─────────┘");
		}
		else {
		System.out.println("┌─────────┬─────────┐");
		System.out.println("│  total  │   avg   │");
		System.out.println("├─────────┼─────────┤");
		 System.out.printf("│  %3d    │  %3.2f  │\n", exam.total(), exam.avg());
		System.out.println("└─────────┴─────────┘");
		}
	}

	
	//3. setter 위에 위치했을 시에는 set을 하면서 처리
//	@Autowired
//	@Qualifier("exam1")
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
