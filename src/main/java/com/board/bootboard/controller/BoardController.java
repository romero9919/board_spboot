package com.board.bootboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.board.bootboard.dto.BoardDto;
import com.board.bootboard.dto.CommentDto;
import com.board.bootboard.service.BoardService;
import com.board.bootboard.service.CommentService;

import java.util.*;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum){
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);
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
        List<CommentDto> commentDtoList = commentService.getCommentList(no);
        model.addAttribute("commentList", commentDtoList);

        return "view";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Integer no, Model model){
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "update";
    }

    // post ud
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

    // comment save and delete
    @PostMapping("/post/writecomment")
    public String writeComment(CommentDto commentDto){
        System.out.println(commentDto.getUsername());
        commentService.saveComment(commentDto);
        
        return "redirect:/";
    }

    @DeleteMapping("/post/comment/{no}")
    public String deleteComment(@PathVariable("no") Integer no){
        commentService.deleteComment(no);

        return "redirect:/";
    }


}
