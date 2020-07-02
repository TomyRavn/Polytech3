package kr.ac.kopo.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//싱글톤 패턴 :
//애플리케이션 전체에서 객체(인스턴스)를 '1개만' 만들어서(new) 여러 곳에서 함께 사용

//Framework / library : 남이 만든것을 가져다 쓰는 공통점
//차이점 : 코드의 주도권을 누가 가지고 있느냐(전체적인 흐름)
//Library : 흐름은 내가 가지되, 남이 만든 걸 중간에 가져다 넣는 것
//Framework : 주된 흐름을 이미 남이 만들어놓아서 내가 그 흐름에 따라 중간중간에 코드를 끼워넣는 것

//JQuery -> 브라우저가 익스플로러 위주의 표준을 안지켜주는 까다로운 상태일 때, JQuery가 이것을 미리 만들어놓아 많이쓰였음
//현재는 브라우저가 많이 발달하면서 JS로 돌아가는 흐름
// Vue(쉬움), React(인기), Angular(대규모에 장점) -> JS의 3대장 프레임워크 (브라우저에서 프로그램을 처리하자, Program Framework)
// SASS/SCSS(인기) , LESS -> CSS를 프로그래밍 언어처럼 기능을 추가 해주는 언어
// CSS Framework : BootStrap ; 라이브러리와 비슷, 클래스만 딱딱 쓰면 사용됨. cf) Foundation

//Servlet : Controller , JSP : View, (Service : Service + Vo : VO (+ Dao : DAO))-> (Business)Model
//요청받았을 때 사용되는 것들(Servlet) 을 Controller
//보여줄 때 사용되는 것들(jsp) 을 View
//dao, vo 등의 클래스는 Model (핵심 비즈니스 모델) dao는 사실 model이라고 잘 칭하지 않고, vo와 service가 모델의 핵심(데이터를 담은 클래스와 중간에 껴서 요청과 db와 분리된 클래스)
// + service라는 클래스까지 포함하여 Model이라고 지칭
//service 는 db와 관계없이 순수한 java 데이터만 다룸 (핵심 비즈니스 로직)
//==> MVC 패턴 이라고하며, Model2 방식이라고 함
//
//ps. Model1방식은 jsp 안에서 모든 것을 다 처리하는 방식 -> 유지보수가 어려우므로 Model2 방식과 같이 나눠서 처리

@WebServlet("/member/list.do")
public class MemberListServlet extends HttpServlet{
	
	private MemberService memberService = MemberServiceImpl.getInstance(); //객체 생성을 반복할 필요없음

	//링크, 리다이렉트 등의 경우 전부 get방식 / post는 form에서 submit한 경우에만 썼음
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//리스트를 전달할 필요성 -> 요청객체에 담아서 준다
		List<MemberVo> memberList = memberService.selectMemberList();
		req.setAttribute("memList", memberList);	//요청객체에 "memList"라는 사용자정의이름으로 memberlist 데이터를 저장

		//"*/ex_web/WebContent
		// /WEB-INF/jsp/member/memList.jsp" 파일로 이동
		//현재 파일을 위임하여 처리할 수 있도록 하는 디스패쳐 가져오기
		//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp");

		req.getRequestDispatcher("/WEB-INF/jsp/member/memList.jsp").forward(req, resp);	//현재 요청객체와 응답객체를 전달해주면서 이동

		//				rd에는 forward -> 맡기고 jsp로 다시 가져올 필요없다.
		//				include -> 맡기고 다시 작업해야할때 다시 이리로 오게끔함
	}

}