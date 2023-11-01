package com.example.bootStart01.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bootStart01.entity.Board;
import com.example.bootStart01.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequestMapping("/board")
@RequiredArgsConstructor // final이 붙은 속성을 포함하는 생성자를 자동으로 생성해줌 - 의존성 주입의 한 방법
@Controller
public class BoardController {

	private final BoardRepository boardRepository;
	
	@GetMapping("/main")
	public String goBoardMain() {
		List<Board> boardList = this.boardRepository.findAll();
		// findAll = select * from board 와 같은 의미
		return "board_main";
	}
}
