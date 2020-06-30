package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {
	
	public static void main(String[] args) {
		
		//Top-Down 방식 사용
		
		//1.
//		Exam exam = new NewlecExam();
//		ExamConsole console = new InlineExamConsole(exam);	//DI
//		ExamConsole console = new GridExamConsole(exam);
		
		//2. -> 이 부분을 스프링에게 지시하는 방법으로 코드를 변경
//		Exam exam = new NewlecExam();
//		ExamConsole console = new GridExamConsole();
//		console.setExam(exam);
		
		//(1) java config
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(NewlecDIConfig.class);
				
				//(2) xml config
				//new ClassPathXmlApplicationContext("spring/di/setting.xml");
		
		//Spring -> ExamConsole console = ?;
//		ExamConsole console = (ExamConsole)context.getBean("console");
		
//		Exam exam = context.getBean(Exam.class);
//		System.out.println(exam.toString());
		
		
		ExamConsole console = (ExamConsole)context.getBean("console");	//이름으로
//		ExamConsole console = context.getBean(ExamConsole.class);		//형식으로
		console.print();
		
		
//		List<Exam> exams = (List<Exam>) context.getBean("exams"); //new ArrayList<>();
//		exams.add(new NewlecExam(1, 1, 1, 1));
		
//		for(Exam e : exams)
//			System.out.println(e);
	}
	
}