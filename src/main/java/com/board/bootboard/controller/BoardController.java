package com.board.bootboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import com.board.bootboard.dto.BoardDto;
import com.board.bootboard.service.BoardService;

import java.util.*;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        List<BoardDto> boardList = boardService.getBoardlist();
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/write")
    public String write(){
        return "write.html";
    }


    @PostMapping("/write")
    public String write(BoardDto boardDto){
        System.out.println(boardDto.getTitle());
        boardService.savePost(boardDto);

        return "redirect:/";
    }
}
