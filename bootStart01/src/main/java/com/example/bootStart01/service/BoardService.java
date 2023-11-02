package com.example.bootStart01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bootStart01.DataNotFound;
import com.example.bootStart01.entity.Board;
import com.example.bootStart01.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

// Controller와 Repository의 중간단계 - 캡슐화를 위해 필요함
// 보안상의 이유로 필요
@RequiredArgsConstructor
@Service 
public class BoardService {
	private final BoardRepository boardRepository;
	
	// 게시판 리스트 조회
	public List<Board> selectList(){
		return this.boardRepository.findAll();
	}
	
	// 게시글 상세조회
	public Board boardDetail(Integer boardNum) {
		// Optional 타입으로 받아야함
		// Optional - null처리를 유연하게 하기 위해 사용하는 클래스 
		// 			- isPresent를 사용해서 null인지 아닌지 확인한 후 실제 객체값을 받음
		Optional<Board> b = this.boardRepository.findById(boardNum);
		if(b.isPresent()) {
			// null이 아님
			return b.get();
		}else {
			throw new DataNotFound("없는 게시글입니다");
		}
		
	}
	
}
