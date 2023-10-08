package com.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.board.entity.Board;

@Mapper // mapper라고 명시해줘야 함
public interface BoardMapper {

	// 메소드 이름과 동일하게 ID를 설정해야 알아서 인식해줌
	public List<Board> boardSelectList();

	public void boardInsert(Board board);

	public Board boardContent(int idx);

	public void boardDelete(int idx);

	public Board boardUpdateForm(int idx);

	public void boardUpdate(Board board);

	@Update("update board set count = count + 1 where idx = #{num}")
	public void boardCount(int num);
	
}
