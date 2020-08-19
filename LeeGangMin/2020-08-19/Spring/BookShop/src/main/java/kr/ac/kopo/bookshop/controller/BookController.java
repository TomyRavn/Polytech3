package kr.ac.kopo.bookshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.kopo.bookshop.model.Book;
import kr.ac.kopo.bookshop.service.BookService;
import kr.ac.kopo.bookshop.util.Pager;

@Controller
@RequestMapping("/book")
public class BookController {
	
	//앞에서 뒤로 가는 방식 (TDD와 유사) Controller -> Service //eclipse에서 자동생성으로 만들어지기 때문에 오타를 막을 수 있다.
	
//	JSR로 표준화하면서 Resource로 대체
	
	//Spring annotation //type기준
	//@Resource 자바	//name 기준
	@Autowired
	BookService service;
	
	
	@RequestMapping("/dummy")
	String dummy() {
		service.dummy();
		
		return "redirect:list";
	}
	
	@RequestMapping("/init")
	String init() {
		service.init();
		
		return "redirect:list";
	}
	
	
	@RequestMapping("/list")
	String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);
		
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String add() {
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	String add(Book item) {
		service.add(item);
		
		return "redirect:list";
	}
	
	@RequestMapping("/{bookid}/delete")
	String delete(@PathVariable int bookid) {
		service.delete(bookid);
		
		return "redirect:../list";
	}
	
	@RequestMapping(value = "/{bookid}/update", method = RequestMethod.GET)
	String update(@PathVariable int bookid, Model model) {
		Book item = service.item(bookid);
		
		model.addAttribute("item", item);
		
		return "update";
	}
	
	@RequestMapping(value = "/{bookid}/update", method = RequestMethod.POST)
	String update(@PathVariable int bookid, Book item) {
		item.setBookid(bookid);
		
		service.update(item);
		
		return "redirect:../list";
	}
	
}