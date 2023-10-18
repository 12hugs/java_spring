package com.example.demo.service;

import domain.Member;
import repository.MemberRepositoty;
import repository.MemoryMemberRepository;

public class MemberService {
	
	private final MemberRepositoty memberRepositoty = new MemoryMemberRepository();

	// 회원가입
	public long join(Member member) {
		// 같은 이름이 있는 중복 회원은 안되게 로직 구성하기
		
		memberRepositoty.save(member);
		return member.getId();
	}
	
}
