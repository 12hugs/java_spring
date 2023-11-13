package com.example.bootStart01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bootStart01.DataNotFound;
import com.example.bootStart01.entity.Board;
import com.example.bootStart01.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

// Controller와 Repository의 중간단계 - 캡슐화를 위해 필요함
// 보안상의 이유로 필요
@RequiredArgsConstructor // this가 붙어있는 속성의 생성자를 자동으로 붙여줌
@Service 
public class BoardService {
	private final BoardRepository boardRepository;
	
	// 게시판 리스트 조회
	public Page<Board> selectList(int page){
		// Sort - 데이터 정렬을 지원하는 클래스
		List<Sort.Order> sort = new ArrayList<>();
		sort.add(Sort.Order.desc("boardDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sort));
		// PageRequest.of(page, size, sort) - Pageable이 가진 클래스
		return this.boardRepository.findAll(pageable);
	}
	
	// 게시글 상세조회
	public Board boardDetail(Integer boardNum) {
		
		// Optional 타입으로 받아야함
		// Optional - null처리를 유연하게 하기 위해 사용하는 클래스 
		// 			- isPresent를 사용해서 null인지 아닌지 확인한 후 실제 객체값을 받음
		Optional<Board> b = this.boardRepository.findById(boardNum);
		
		if(b.isPresent()) { //null인지 아닌지 판단. 해당 사항은 True일 경우
			// null이 아니라는 뜻
			return b.get();
		}else {
			throw new DataNotFound("없는 게시글입니다");
		}
		
	}
	
}
