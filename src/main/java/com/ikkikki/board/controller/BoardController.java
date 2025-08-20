package com.ikkikki.board.controller;

import com.ikkikki.board.domain.dto.BoardDTO;
import com.ikkikki.board.domain.dto.PageRequestDTO;
import com.ikkikki.board.service.BoardService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("board")
@Log4j2
@Data
public class BoardController {
  private  final BoardService service;
  // 목록 조회
  @GetMapping("list")
  public void list(@ModelAttribute("requestDto")  PageRequestDTO dto, Model model){
    model.addAttribute("dto", service.getList(dto));
    log.info(model.toString());
  }
  // 등록폼
  @GetMapping("register")
  public  void register(BoardDTO dto, Model model){
  }
  // 등록 프로세스
  @PostMapping("register")
  public String register(BoardDTO dto, RedirectAttributes rttr){
    rttr.addAttribute("msg", service.register(dto));
    return "redirect:/list";
  }
  // 단일조회
  @GetMapping("read")
  public void read(@ModelAttribute("requestDto") PageRequestDTO dto, Model model, Long bno){
    log.info(bno);
    model.addAttribute("dto", service.get(bno));
  }
  // 글 수정 폼
  @GetMapping("modify")
  public void modify(@ModelAttribute("requestDto") PageRequestDTO dto, Model model, Long bno ){
    model.addAttribute("dto", service.get(bno));
  }
  // 글 수정 프로세스
  @PostMapping("modify")
  public String modify( PageRequestDTO dto,BoardDTO boardDTO, Long bno, RedirectAttributes rttr){
    service.modify(boardDTO);
    rttr.addAttribute("bno", boardDTO.getBno());
    rttr.addAttribute("page", dto.getPage());
    rttr.addAttribute("size", dto.getSize());
    rttr.addAttribute("type", dto.getType());
    rttr.addAttribute("keyword", dto.getKeyword());
    return "redirect:read";
  }
  
  // 글 삭제 프로세스
  @PostMapping("remove")
  public String remove( PageRequestDTO dto,BoardDTO boardDTO, Model model, Long bno, RedirectAttributes rttr){
    service.remove(bno);
    rttr.addAttribute("msg", bno);
    rttr.addAttribute("page", dto.getPage());
    rttr.addAttribute("size", dto.getSize());
    return "redirect:list";
  }
}

