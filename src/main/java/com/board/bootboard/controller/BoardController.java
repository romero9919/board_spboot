package com.board.bootboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        return "write";
    }


    @PostMapping("/write")
    public String write(BoardDto boardDto){
        System.out.println(boardDto.getTitle());
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Integer no, Model model){
        BoardDto boardDTO = boardService.getPost(no);
        model.addAttribute("boardDto", boardDTO);
        return "view";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Integer no, Model model){
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "update";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO){
        boardService.savePost(boardDTO);
        
        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Integer no){
        boardService.deletePost(no);

        return "redirect:/";
    }
}
