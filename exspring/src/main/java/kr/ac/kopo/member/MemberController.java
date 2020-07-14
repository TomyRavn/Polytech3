package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//@Autowired,@Inject,@Resource 중 하나를 사용하여 스프링에 등록된 객체를 주입
	@Resource(name="memberService")
	private MemberService memberService;

//	@RequestMapping(value="/member/list.do",method = RequestMethod.GET)
	@RequestMapping("/member/list.do")
	public String list(Map modelMap) {
		List<MemberVo> list = memberService.selectMemberList();
		modelMap.put("memList", list);// 모델에 "memList"라는 이름으로 list를 저장
		return "member/memList";
	}
	
	@RequestMapping(value = "/member/index.do", method = RequestMethod.GET)
	public String test() {
		return "/member/index";
	}

	@RequestMapping(value = "/member/add.do", method = RequestMethod.GET)
	public String addform() {
		return "/member/memAddForm";
	}

	@RequestMapping(value = "/member/add.do", method = RequestMethod.POST)
	public String add(MemberVo vo) {

		int num = memberService.insertMember(vo);
		System.out.println(num + "개의 레코드 추가");
		return "redirect:/member/list.do";
	}

	@RequestMapping(value = "/member/edit.do", method = RequestMethod.GET)
	public String editform(String memId, Map modelMap) {
		MemberVo vo = memberService.selectMember(memId);
		modelMap.put("memVo", vo);
		return "/member/memEditForm";
	}

	@RequestMapping(value = "/member/edit.do", method = RequestMethod.POST)
	public String edit(MemberVo vo) {
		
		int num = memberService.updateMember(vo);
		System.out.println(num + "개의 레코드 변경");
		return "redirect:/member/list.do";

	}

	@RequestMapping("/member/del.do")
	public String del(String memId) {
		int num = memberService.delMember(memId);
		System.out.println(num + "명의 회원삭제");
		return "redirect:/member/list.do";
	}
	
	
	@RequestMapping(value="/member/login.do", method =RequestMethod.GET )
	public String loginform(){ 	
	return "member/login";		
}	
	
	@RequestMapping(value="/member/login.do", method =RequestMethod.POST )
	public String login(MemberVo vo, HttpSession session) {		
//	HttpServletRequest,HttpServletResponse,HttpSession 객체가 필요한 경우, 
//  컨트롤러 메서드의 파라미터로 지정하면 스프링이 전달해준다
	
	MemberVo loginVo = memberService.selectLoginMember(vo);
	
	if(loginVo==null) { 
		return "redirect:/member/login.do";
	} else { 
		session.setAttribute("loginUser", loginVo); 		
		return "redirect:/member/list.do";
	}		
	}
	
	@RequestMapping(value ="/member/logout.do", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
//		session.setAttribute("loginUser", null); //세션에 "loginUser"라는 이름으로 null을 저장
//		session.removeAttribute("loginUser");//세션에 "loginUser"라는 이름으로 저장한 내용을 제거
		session.invalidate();//세션객체자체를 초기화(새로생성)=세션에 저장했던 모든 데이터 삭제
		return "redirect:/member/login.do";
		
	}
}
