package org.zerock.ex00.tinker;

import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.mappers.BoardMapper;
import org.zerock.ex00.service.BoardService;

import java.util.List;

public class DBTest {

    private final BoardMapper boardMapper = new BoardMapper() {
        @Override
        public List<BoardVO> getList() {
            return null;
        }

        @Override
        public BoardVO select(Long bno) {
            return null;
        }

        @Override
        public int insert(BoardVO board) {

            return 0;
        }

        @Override
        public int update(BoardVO BoardVO) {
            return 0;
        }

        @Override
        public int delete(BoardVO BoardVO) {
            return 0;
        }
    };


    // 입력 단계
    // 1) 1만건
    // 2) 10만건
    // 3) 10만건
    // 4) 50만건
    // 5) 50만건
    // 6) 100만건
    // 7) 1000만건
    // 8) 5000만건
    // 총 6221만건
    public static void main(String[] args) {
        // timer start

        // Parse data from Excel files?

        
        // timer end
    }
}
