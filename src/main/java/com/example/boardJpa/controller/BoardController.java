package com.example.boardJpa.controller;

import com.example.boardJpa.entity.Board;
import com.example.boardJpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/write")
    public String boardWriteForm() {
        return "boardWrite";
    }

    @PostMapping("/write-pro")
    public String boardWritePro(Board board) {

        boardService.boardWrite(board);

        return "";
    }

    @GetMapping("/list")
    public String list(Model model) {

        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }

    @GetMapping("/view")
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));

        return "boardView";
    }

    @GetMapping("/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/modify/{id}")
    public String boardModify(@PathVariable("id") Integer id ,Model model) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardModify";
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        boardService.boardWrite(boardTemp);

        return "redirect:/board/list";
    }
}
