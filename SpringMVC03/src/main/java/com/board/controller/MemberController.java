package com.board.controller;

import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	// 회원가입 폼으로 이동
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		
		return "member/joinForm";
	}
	
	
	
}
