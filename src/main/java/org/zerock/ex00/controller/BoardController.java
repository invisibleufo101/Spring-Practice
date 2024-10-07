package org.zerock.ex00.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
        List<BoardVO> list = boardService.list();
        model.addAttribute("list", list);
    }

    // View-Model binding (search by PK)
    @GetMapping("/read/{bno}")
    public String read(@PathVariable("bno") Long bno, Model model){
        log.info("read\n..........");
        log.info("bno: " + bno);

        BoardVO board = boardService.get(bno);
        model.addAttribute("board", board); // <- In JSP&Servlet, we did request.setAttribute("model", model)

        return "board/read";
    }
}
