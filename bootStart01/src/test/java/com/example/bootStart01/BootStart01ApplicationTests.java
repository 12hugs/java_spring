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
		
		for(int i = 0; i<=100; i++) {
			Board b = new Board();
			b.setBoardTitle(String.format("테스트제목(%d)", i));
			b.setBoardCon("테스트내용");
			b.setBoardDate(LocalDateTime.now());
			this.boardRepository.save(b);
		}
		
	}

}
