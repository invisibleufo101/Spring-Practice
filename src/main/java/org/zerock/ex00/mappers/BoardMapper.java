package org.zerock.ex00.mappers;

import org.zerock.ex00.domain.BoardVO;

import java.util.List;

public interface BoardMapper {
    List<BoardVO> getList();
    BoardVO select(Long bno);
    int insert(BoardVO board);
    int update(BoardVO BoardVO);
    int delete(BoardVO BoardVO);
}
