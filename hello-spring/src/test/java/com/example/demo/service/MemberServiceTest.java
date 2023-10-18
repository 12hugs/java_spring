package com.example.demo.service;

import org.junit.jupiter.api.Test;

import domain.Member;

public class MemberServiceTest {

	MemberService memberService = new MemberService();
	
	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("hello");
		
		// when
		long saveId = memberService.join(member);
		
		// then
		Member findMember = memberService.findOne(saveId).get();
		
	}
	
	@Test
	void findMembers() {
		
	}
	
	@Test
	void findOne() {
		
	}
	
}
