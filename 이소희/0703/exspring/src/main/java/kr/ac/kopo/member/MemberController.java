package kr.ac.kopo.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberController {
//	@Autowired, @Inject, @Resource 중 하나를 사용하여 스프링에 등록된 객체를 주입
	@Resource(name = "memberService")
	private MemberService memberService;
	
//	@RequestMapping(value = "/member/list.do", method = RequestMethod.GET)
	@RequestMapping("/member/list.do")
	public String list(Map modelMap) {	
		List<MemberVo> list = memberService.selectMemberList();
		modelMap.put("memList", list); //모델에 "memList" 라는 이름으로 list 저장
		return"/member/memList";
	}
	
		@RequestMapping(value="/member/add.do", method = RequestMethod.GET)
		public String addform() {
			return "/member/memAddForm";
		}
		
		@RequestMapping(value="/member/add.do", method = RequestMethod.POST)
		public String add(MemberVo vo) {		
			int num = memberService.insertMember(vo);
			System.out.println(num + "개의 레코드 추가");		
			return "redirect:/member/list.do";
		}
					
		
		@RequestMapping(value = "/member/edit.do" ,method = RequestMethod.GET)
		public String editform(String memId, Map modelMap) {
			MemberVo vo = memberService.selectMember(memId);	
			modelMap.put("memVo", vo);
			return "member/memEditForm";
		}
		
		@RequestMapping(value = "/member/edit.do" ,method = RequestMethod.POST)
		public String edit(MemberVo vo){
			int num = memberService.updateMember(vo);
			System.out.println(num + "개의 레코드 추가");
			return "redirect:/member/list.do";		
		}
		
		
		@RequestMapping("/member/del.do")	
		public String del(String memId) {	
			int num = memberService.deleteMember(memId); 
			System.out.println(num + "명의 회원 삭제");
			return "redirect:/member/list.do";
		}
		}
	
	

