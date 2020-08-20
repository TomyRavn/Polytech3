package kr.ac.kopo.bookshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//controller 2개이상 만드는 편

@Controller
public class RootController {
	
	@RequestMapping("/")
	String index() {
		return "index";
	}
	
}