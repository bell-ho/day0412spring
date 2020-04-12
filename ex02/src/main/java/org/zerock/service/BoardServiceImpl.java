package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVo;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor 
//@AllArgsContstructor는 모든 파라미터를 이용하는 생성자를 만든다
public class BoardServiceImpl implements BoardService {
	@Setter(onMethod_ =@Autowired )
	private BoardMapper mapper;

	@Override
	public void register(BoardVo board) {
		// TODO Auto-generated method stub
		log.info("등록....등록....등록....등록....등록....등록...."+board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVo get(Long bno) {
		// TODO Auto-generated method stub
		
		log.info("get........."+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVo board) {
		// TODO Auto-generated method stub
		
		log.info("modify......"+board);
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove......"+bno);
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVo> getList() {
		// TODO Auto-generated method stub
		
		log.info("getList...........");
		return mapper.getList();

		
	}
}
