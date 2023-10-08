package com.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.entity.Board;
import com.board.mapper.BoardMapper;

@Controller
public class BoardController {

	@Autowired
	private BoardMapper boardMapper;

	// main.jsp로 이동하는 동기방식 메소드
	@RequestMapping("/boardMain.do")
	public String main() {
		return "board/main";
	}
	
	// 게시글 전체조회하기 /boardSelectList.do
	// @ResponseBody : 비동기 방식으로 요청되어서 사용되는 것. 무조건 명시해줘야 함. JSON형태로 데이터를 뿌려줌
	@RequestMapping("/boardSelectList.do")
	public @ResponseBody List<Board> boardSelectList(){
		System.out.println("[게시글 전체조회]");
		List<Board> list = boardMapper.boardSelectList();
		return list;
	}
	
	// 게시글 등록하기
	@PostMapping("/boardInsert.do")
	public @ResponseBody void boardInsert(Board board) {
		boardMapper.boardInsert(board);
	}
	
	// 게시글 삭제하기
	@GetMapping("/boardDelete.do")
	public @ResponseBody void boardDelete(@RequestParam("idx") int idx) {
		boardMapper.boardDelete(idx);
	}
	
	// 게시글 조회수
	@GetMapping("/boardCount.do")
	public @ResponseBody void boardCount(@RequestParam("idx") int idx) {
		boardMapper.boardCount(idx);
	}
	
	@PostMapping("/boardUpdate.do")
	public @ResponseBody void boardUpdate(Board board) {
		boardMapper.boardUpdate(board);
	}
	
	@GetMapping("/boardContent.do")
	public @ResponseBody Board boardContent(int idx){
		Board board = boardMapper.boardContent(idx);
		return board;
	}
	
	
	
	
}
