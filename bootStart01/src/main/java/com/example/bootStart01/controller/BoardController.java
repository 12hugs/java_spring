package com.example.bootStart01.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bootStart01.entity.Board;
import com.example.bootStart01.repository.BoardRepository;
import com.example.bootStart01.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor // final이 붙은 속성을 포함하는 생성자를 자동으로 생성해줌 - 의존성 주입의 한 방법
@Controller
public class BoardController {

	//private final BoardRepository boardRepository;
	private final BoardService boardService;
	
	// 게시글 리스트 조회
	@GetMapping("/main")
	public String goBoardMain(Model model, @RequestParam(value="page", defaultValue = "0")int page) {
		Page<Board> boardList = this.boardService.selectList(page);
		// findAll = select * from board 와 같은 의미
		model.addAttribute("boardList" ,boardList);
		return "board_main";
	}
	
	// 게시글 상세조회
	@GetMapping("/detail/{boardNum}")
	public String boardDetail(Model model, @PathVariable("boardNum") Integer boardNum) {
		Board board = this.boardService.boardDetail(boardNum);
		LocalDateTime date = board.getBoardDate();
		model.addAttribute(board);
		return "board_detail";
	}
}
