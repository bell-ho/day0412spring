package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVo;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

//	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}

//	@Test
	public void testInsert() {
		BoardVo board = new BoardVo();
		board.setTitle("새로 작성하는 귤");
		board.setContent("새로 작성하는 내용");
		board.setWriter("뉴비");

		mapper.insert(board);

		log.info(board);
	}
//	@Test
	public void testRead() {
		BoardVo board = mapper.read(26L);
		log.info(board);
		System.out.println("읽어오기===========================================");
	}
//	@Test
	public void testDelete() {
		log.info("delete count: "+mapper.delete(3L));
	}
//	@Test
	public void testUpdate() {
		BoardVo board = new BoardVo();
		
		board.setBno(1L);
		board.setTitle("수정제목");
		board.setContent("수장내용");
		board.setWriter("수정작가");
		
		int count = mapper.update(board);
		log.info("update count:"+count);
	}
}
