package org.zerock.ex00.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.service.BoardService;

import java.util.List;

@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j2
@Controller
public class BoardController {

    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model){
        log.info("list");
        List<BoardVO> boards = boardService.list();
        model.addAttribute("boards", boards);
    }

    @GetMapping({"/{job}/{bno}", })
    public String read(@PathVariable("job") String job, @PathVariable("bno") Long bno, Model model){
        log.info("read method called");
        log.info("job:" + job);
        log.info("bno: " + bno);

        BoardVO board = boardService.get(bno);
        model.addAttribute("board", board);

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
