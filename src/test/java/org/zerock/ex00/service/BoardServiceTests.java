package org.zerock.ex00.service;

import lombok.Setter;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.ex00.domain.BoardVO;

@Log4j2
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@ExtendWith(SpringExtension.class)
public class BoardServiceTests {

    @Autowired
    BoardService boardService;

    @Test
    public void testList(){
        List<BoardVO> boardList = boardService.list();
        for (BoardVO board : boardList){
            log.info(board);
        }
    }

    @Test
    public void get(Long bno){
        BoardVO board = boardService.get(bno);
        log.info(board);
    }

}
