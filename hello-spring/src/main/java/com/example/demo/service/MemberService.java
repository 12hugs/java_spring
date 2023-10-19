package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepositoty;
import com.example.demo.repository.MemoryMemberRepository;

public class MemberService {  
	
	private final MemberRepositoty memberRepositoty;

	public MemberService(MemberRepositoty memberRepositoty) {
		this.memberRepositoty = memberRepositoty;
	}

	// 회원가입
	public long join(Member member) {
		// 같은 이름이 있는 중복 회원은 안되게 로직 구성하기
		Optional<Member> result = memberRepositoty.findByName(member.getName());
		result.ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다");
		});
		memberRepositoty.save(member);
		return member.getId();
	}
	
	// 전체회원조회
	public List<Member> findMembers(){
		return memberRepositoty.findAll();
	}
	
	public Optional<Member> findOne(long memberId){
		return memberRepositoty.findById(memberId);
	}
	
	
}
