package org.zerock.ex00.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.mappers.BoardMapper;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Log4j2
@Service
public class BoardService {

    private final BoardMapper boardMapper;

    public Long register(BoardVO board){
        log.info("-----------------------");
        log.info("Registered: " + board);

        int count = boardMapper.insert(board);

        return board.getBno();
    }

    public List<BoardVO> list(){
        return boardMapper.getList();
    }

    public BoardVO get(Long bno){
        return boardMapper.select(bno);
    }

    public boolean modify(BoardVO board){
        return boardMapper.update(board) == 1;
    }

    public boolean delete(BoardVO board){
        return false;
    }
}
