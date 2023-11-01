package com.example.bootStart01;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.bootStart01.entity.Board;
import com.example.bootStart01.repository.BoardRepository;

@SpringBootTest
class BootStart01ApplicationTests {

	@Autowired // 의존성 주입
	private BoardRepository boardRepository;
	
	// 실행할 코드가 정말 잘 되는 지 테스트 해보는 코드
	@Test
	void contextLoads() {
		Board b1 = new Board();
		b1.setBoardTitle("스프링 부트 가보자");
		b1.setBoardCon("이거 진짜 되나?");
		b1.setBoardDate(LocalDateTime.now());
		this.boardRepository.save(b1);
		
		Board b2 = new Board();
		b2.setBoardTitle("스프링 부트 실패...");
		b2.setBoardCon("이거 진짜 안될 거 같음...");
		b2.setBoardDate(LocalDateTime.now());
		this.boardRepository.save(b2);
	}

}
