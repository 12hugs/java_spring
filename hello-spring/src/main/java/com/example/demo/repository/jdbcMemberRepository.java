package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.example.demo.domain.Member;

public class jdbcMemberRepository implements MemberRepositoty{

	private final DataSource dataSource;
	
	public jdbcMemberRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public Member save(Member member) {
		String sql = "insert into member(name) values(?)";
		
		
		
		return null;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Member> findByName(String name) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
