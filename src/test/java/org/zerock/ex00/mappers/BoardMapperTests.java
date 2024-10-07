package org.zerock.ex00.mappers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardMapperTests {

    @Autowired(required = false)
    BoardMapper boardMapper;

    // Test if boardMapper object exists
    @Test
    public void test1() {
        log.info(boardMapper);
    }

    // Testing BoardMapper's getList()
    @Test
    public void testList(){
        boardMapper.getList().forEach(boardVO -> log.info(boardVO));
    }

    @Test
    public void testInsert(){
        BoardVO boardVO = new BoardVO();
        boardVO.setTitle("Test Title");
        boardVO.setContent("Test123 Content");
        boardVO.setWriter("Test Author");

        log.info("COUNT: " + boardMapper.insert(boardVO));
        log.info("BNO: " + boardVO.getBno());
    }
}
