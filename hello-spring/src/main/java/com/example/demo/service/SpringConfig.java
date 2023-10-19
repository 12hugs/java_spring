package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemberRepositoty;
import com.example.demo.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepositoty());
	}
	
	@Bean
	public MemberRepositoty memberRepositoty() {
		return new MemoryMemberRepository();
	}
	
}
