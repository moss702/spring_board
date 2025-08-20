package com.ikkikki.board.controller;

import com.ikkikki.board.domain.dto.BoardDTO;
import com.ikkikki.board.domain.dto.PageRequestDTO;
import com.ikkikki.board.service.BoardService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// react에서 데이터를 가져오거나 등록하기 위해 만든 컨트롤러입니다.
@RestController
@RequestMapping("boardrest")
@CrossOrigin(origins = "http://localhost:3000") //react에서 데이터 가져오려고 씀!
@Log4j2
@Data
public class BoardRestController {
  private  final BoardService service;

  // 목록 조회
  @GetMapping("list")
  public ResponseEntity<?> list(PageRequestDTO dto){
    return ResponseEntity.ok(service.getList(dto));
  }

  // 글 단일조회 * 사실 아래랑 동일 기능
  @GetMapping("/{bno}")
  public ResponseEntity<?> get(@PathVariable("bno") Long bno){
    return ResponseEntity.ok(service.get(bno));
  }
  // 단일조회
  @GetMapping("read")
  public ResponseEntity<?> read(@ModelAttribute("requestDto") PageRequestDTO dto, Long bno){
    return ResponseEntity.ok(service.get(bno));
  }

  // 등록 프로세스
  @PostMapping("register")
  public ResponseEntity<?> register(@RequestBody BoardDTO dto){
    return ResponseEntity.ok(service.register(dto));
  }

  // 글 수정 프로세스
  @PostMapping("modify")
  public ResponseEntity<?> modify(BoardDTO boardDTO){
    service.modify(boardDTO);
    return ResponseEntity.ok(boardDTO.getBno());
  }

  // 글 삭제 프로세스
  @PostMapping("remove")
  public ResponseEntity<?> remove(Long bno){
    service.remove(bno);
    return ResponseEntity.ok(bno + "글이 삭제되었습니다.");
  }
}

