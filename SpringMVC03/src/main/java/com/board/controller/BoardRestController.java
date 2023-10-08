package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.entity.Board;
import com.board.mapper.BoardMapper;


// 비동기 통신만 가능
// 데이터, 객체를 리턴
// 페이지 이동 불가

@RestController // => 원래 ResponseBody가 있어야 하지만 RestController 덕분에 없어도 됨
@RequestMapping("/board")
public class BoardRestController {
	
	@Autowired
	private BoardMapper boardMapper;
		
	
		// 게시글 전체조회하기 /boardSelectList.do
		// @ResponseBody : 비동기 방식으로 요청되어서 사용되는 것. 무조건 명시해줘야 함. JSON형태로 데이터를 뿌려줌
		@GetMapping("/all")
		public @ResponseBody List<Board> boardSelectList(){
			System.out.println("[게시글 전체조회]");
			List<Board> list = boardMapper.boardSelectList();
			return list;
		}
		
		// 게시글 등록하기
		@PostMapping("/new")
		public @ResponseBody void boardInsert(Board board) {
			boardMapper.boardInsert(board);
		}
		
		// 게시글 삭제하기
		@DeleteMapping("/{idx}")
		public @ResponseBody void boardDelete(@PathVariable("idx") int idx) {
			boardMapper.boardDelete(idx);
		}
		
		// 게시글 조회수
		@PutMapping("/count/{idx}")
		public @ResponseBody void boardCount(@PathVariable("idx") int idx) {
			boardMapper.boardCount(idx);
		}
		
		// 게시글 수정하기
		@PutMapping("/update")
		public @ResponseBody void boardUpdate(@RequestBody Board board) {
			boardMapper.boardUpdate(board);
		}
		
		// 게시글 상세보기
		@GetMapping("/{idx}")
		public @ResponseBody Board boardContent(@PathVariable("idx") int idx){
			Board board = boardMapper.boardContent(idx);
			return board;
		}
}
