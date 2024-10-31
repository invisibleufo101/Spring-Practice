package org.zerock.ex00.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.domain.Criteria;
import org.zerock.ex00.domain.PageDTO;
import org.zerock.ex00.service.BoardService;

import java.util.List;

@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j2
@Controller
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public void list(@ModelAttribute("criteria") Criteria pageCriteria, Model model){
        log.info("list");
        List<BoardVO> boards = boardService.getList(pageCriteria);

        log.info(boards);

        model.addAttribute("boards", boards);

        PageDTO pageDTO = new PageDTO(pageCriteria, boardService.getTotal(pageCriteria));
        model.addAttribute("pageMaker", pageDTO);
    }

    @GetMapping({"/{job}/{bno}", })
    public String read(@PathVariable("job") String job, @PathVariable("bno") Long bno, Model model){
        log.info("read method called");
        log.info("job:" + job);
        log.info("bno: " + bno);

        BoardVO board = boardService.get(bno);
        model.addAttribute("board", board);

        if (!job.equals("read") && !job.equals("modify")){
            throw new RuntimeException("Bad Request");
        }

        return "board/" + job;
    }

    @GetMapping("/register")
    public void register(){
//        boardService
    }

    @PostMapping("/register")
    public String registerPost(BoardVO board, RedirectAttributes rttr){
        log.info("board:" + board);

        long bno = boardService.register(board);
        rttr.addFlashAttribute("result", bno);

        // PRG Pattern (Post-Redirect-Get) : To prevent duplicate form submissions
        return "redirect:/board/list";
    }


    @PostMapping("/modify/{bno}")
    public String modify(@PathVariable("bno") Long bno, BoardVO board){
        log.info("modify\n---------------");
        // Making sure the Board post that we're modifying is really the post that we're trying to modify
        board.setBno(bno);

        log.info("BoardVO: " + board);
        boardService.modify(board);

        // PRG (Post-Redirect-Get)
        return "redirect:/board/read/" + bno;
    }

    @PostMapping("/delete/{bno}")
    public String delete(@PathVariable("bno") Long bno, RedirectAttributes rttr){
        log.info("delete\n-------------");
        BoardVO board = new BoardVO();
        board.setBno(bno);
        board.setTitle("해당 글은 삭제 되었습니다.");
        board.setContent("해당 글은 삭제 되었습니다.");
        board.setWriter("삭제");

        log.info("BoardVO: " + board);
        boardService.modify(board);

//        log.info("BoardVO: " + board);
//        boardService.delete(board);

        // PRG (Post-Redirect-Get)
        return "redirect:/board/list";
    }

    // View-Model binding (search by PK)
//    @GetMapping("/read/{bno}")
//    public String read(@PathVariable("bno") Long bno, Model model){
//        log.info("read\n..........");
//        log.info("bno: " + bno);
//
//        BoardVO board = boardService.get(bno);
//        model.addAttribute("board", board); // <- In JSP&Servlet, we did request.setAttribute("model", model)
//
//        return "board/read";
//    }
//
//    @GetMapping("/modify/{bno}")
//    public String modify(@PathVariable(name="bno") Long bno, Model model){
//        log.info("modify\n...........");
//        log.info("bno: " + bno);
//
//        BoardVO board = boardService.get(bno);
//        log.info("board: " + board);
//
//        model.addAttribute("board", board); // <- In JSP&Servlet, we did request.setAttribute("model", model)
//
//        return "board/modify";
//    }
}
