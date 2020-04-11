package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVo;

public interface BoardMapper {
//	@Select("select * from tbl_board02 where bno > 0")
	public List<BoardVo>getList();
	
	public void insert(BoardVo board);
	
	public void insertSelectKey(BoardVo board);
	
	public BoardVo read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVo board);
}
