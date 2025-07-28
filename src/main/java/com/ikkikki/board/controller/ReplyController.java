package com.ikkikki.board.controller;

import com.ikkikki.board.domain.dto.ReplyDTO;
import com.ikkikki.board.service.ReplyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//@Data
@RequiredArgsConstructor // 필요 생성자
@Log4j2
@RestController
@RequestMapping("replies")
public class ReplyController {
  private final ReplyService replyService;

  //  @RequestMapping(value = "board/{bno}", method = {RequestMethod.GET, RequestMethod.POST})
  @GetMapping("board/{bno}")
  public ResponseEntity<?> getList(@PathVariable("bno") Long bno){
    return ResponseEntity.ok(replyService.getList(bno));
  }
}

