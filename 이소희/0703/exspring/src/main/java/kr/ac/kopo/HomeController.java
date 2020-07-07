package kr.ac.kopo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@Controller의 @RequestMapping메서드는 실행결과로서 스프링에게 모델과 뷰 정보를 알려줘..
//모델: 응답에 포함되어야하는 데이터 (JSP에서 꺼내서 사용할 데이터)
//뷰 : 응답 화면 출력을 담당하는 객체 (어떤 JSP로 이동할 것인지에 대한 정보)

@Controller //웹 요청을 받아서 실행되는 클래스임을 표시 (서블릿과 유사한 역할)
public class HomeController {
	//로그 출력을 위한 로거 객체 가져오기
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

//	@RequestMapping으로 어떤 주소와 요청방식으로 요청이 왔을 때 실행될 메서드인지를 설정
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)//"/home.do" 주소로 GET방식 요청이 오면 이 메서드를 실행
	public String home(Locale locale, Model model) {
		//로그 출력
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date(); //현재 시간을 담은 객체 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);		
		String formattedDate = dateFormat.format(date); //날짜/시간을 현재 로케일에 맞는 형태의 문자열로 변환
		
		//모델에 "serverTime"라는 이름으로 formattedDate 변수값을 저장 
		//JSP에서는 ${serverTime}라는 표현으로 formattedDate 변수값을 사용 가능
		model.addAttribute("serverTime", formattedDate );
		
		//화면출력을 위해 이동해야 할 뷰(JSP)와 이름을 반환
		return "home"; //"/WEB-INF/views/home.jsp"
	}
	
//	http://localhost:8000/kopo/home.do 주소로 요청을 보내면,
//	test.jsp 화면이 나오도록 구현
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
//	@RequestMapping(value = "/test.do") //method를 생략하면 요청 방식에 상관 없이 실행
//	@RequestMapping("/test.do")
	public String test(
			@RequestParam("myNo") String no, //"myNo"라는 이름의 파라미터 값을 이 변수에 저장
			int myNo, //변수명이 파라미터명과 같은 경우에는 @RequestParam 생략 가능 (자동 형변환 가능)
			@ModelAttribute("mvo") MyVo mv, //사용자가 정의한 객체의 변수에는 동일한 이름의 파라미터 값이 자동 저장
			//@ModelAttribute를 사용하여 모델에 지정한 이름으로 추가 가능			
			MyVo vo, //파라미터를 받기 위한 객체는 자동으로 모델에 추가
			Model model, ModelMap modelMap, Map map) {
		System.out.println("myNo : "+no);
		System.out.println("myNo : "+ myNo);
		System.out.println("mv의 myNo : "+mv.getMyNo());
		System.out.println("mv의 myId : "+mv.getMyId());
		
		String s = "Hello Spring!";
		
		//모델에 데이터를 추가(저장)하는 방법 :
		//인자로 받은 Model, ModelMap, Map 객체에 데이터를 저장 
		model.addAttribute("modelVal", s);
		modelMap.addAttribute("modelMapVal" , s);
		map.put("mapVal", s);
//		map.put("mvo", mv);
				
		return "test";
		
	}
	
}
