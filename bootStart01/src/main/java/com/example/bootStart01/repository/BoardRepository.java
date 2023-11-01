package com.example.bootStart01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bootStart01.entity.Board;

// JpaRepository<대상이 되는 엔터티, 해당 엔터티의 식별자 데이터타입>

// JpaRepository가 가지고 있는 메서드를 사용해서 DB를 제어할 수 있음
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	
}
