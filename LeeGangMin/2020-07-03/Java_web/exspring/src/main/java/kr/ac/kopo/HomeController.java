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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//Spring의 Dispatcher에 등록돼서 활용되는 클래스

/**
 * Handles requests for the application home page.
 */
@Controller	//웹 요청을 받아서 실행되는 클래스임을 표시(서블릿과 유사한 역할)
public class HomeController {
	//로그 출력을 위한 로거 객체 가져오기(로거 라이브러리 사용해 sysout 대신 로그 출력 대체)
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping으로 어떤 주소와 요청방식으로 요청이 왔을 때 실행될 메소드인지를 설정
//	value = "주소"
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)		//"home.do"주소로 GET방식 요청이 오면 이 메소드를 실행
	public String home(Locale locale, Model model) {
		//로그 출력
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();	//현재 시간을 담은 객체 생성
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);	// 날짜/시간을 현재 로케일에 맞는 형태의 문자열로 변환
		
		//모델에 "serverTime"라는 이름으로 formattedDate 변수값을 저장
		//모델 : 화면 출력을 위해 공유해야 할 데이터(요청객체 대신 역할) => req.setAttribute("memList", list); 와 비슷한 역할
		//응답에 포함되어야하는 데이터(예 : JSP에서 꺼내서 사용할 데이터)
		//cf) 뷰 : 응답 화면 출력을 담당하는 객체(예 : 어떤 JSP로 이동할 것인지에 대한 정보) 
		model.addAttribute("serverTime", formattedDate );
		
		//화면출력을 위해 이동해야 할 뷰(JSP)의 이름을 반환
		return "home";
	}
	
//	http://localhost:8000/kopo/test.do 주소로 요청을 보내면,
//	test.jsp 화면이 나오도록 구현
	
	@RequestMapping(value = "/test.do", method = RequestMethod.GET)	//method를 생략하면 요청방식에 상관없이 실행
//	@RequestMapping("/test.do")	//value 옵션에 옵션값을 하나로만 지정하면 앞의 지정자도 생략가능
	public String test(
			@RequestParam(name = "myNo") String no,		//1.myNo 라는 이름의 파라미터 값을 이 변수에 저장 
//			String myNo,								//2.변수명이 파라미터명과 같은 경우에는 @RequestParam 생략 가능
			int myNo,									//3.자동형변환기능
			MyVo myVo,									//4.사용자가 정의한 객체의 변수에는 동일한 이름의 파라미터값이 자동저장
			Model model/*스프링 제공*/, ModelMap modelMap/*스프링 제공*/, Map map/*자바 제공*/) {
		System.out.println("myNo : " + no);
		System.out.println("myNo : " + myNo);
		System.out.println("myVo의 myNo : " + myVo.getMyNo());
		System.out.println("myVo의 myId : " + myVo.getMyId());
		
		String s = "Hello, Spring!";
		//모델에 데이터를 추가(저장)하는 방법 : 
		//인자로 받은 Model, ModelMap, Map 객체에 데이터를 저장
		model.addAttribute("modelVal", s);
		modelMap.addAttribute("modelMapVal", s);
		map.put("mapVal", s);
		
		return "test";
	}
	
}