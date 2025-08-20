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
@CrossOrigin(origins = "http://localhost:3000") //react에서 데이터 가져오려고 씀!
@RequestMapping("replies")
public class ReplyController {
  private final ReplyService replyService;

  //  @RequestMapping(value = "board/{bno}", method = {RequestMethod.GET, RequestMethod.POST})
  @GetMapping("board/{bno}")
  public ResponseEntity<?> getList(@PathVariable("bno") Long bno){
    return ResponseEntity.ok(replyService.getList(bno));
  }

  @PostMapping
  public ResponseEntity<?> create(@RequestBody ReplyDTO dto){
    log.info(dto);
    return ResponseEntity.ok(replyService.register(dto)); // Long타입 제네릭으로 리턴
  }

  // =================================
  @GetMapping("{rno}")
  public ResponseEntity<?> get(@PathVariable("rno") Long rno){
    return ResponseEntity.ok(replyService.get(rno));
  } // 댓글 하나 찾기

  @DeleteMapping("{rno}")
  public ResponseEntity<?> delete(@PathVariable("rno") Long rno){
    replyService.remove(rno);
//    // rno번 댓글이 삭제되었다는 알람을 위해 rno는 리턴해줌
//    return ResponseEntity.ok(rno);
    return ResponseEntity.ok("success");
  }

  @PutMapping("{rno}")
  public ResponseEntity<?> update(@RequestBody ReplyDTO dto){
    replyService.modify(dto);
    return ResponseEntity.ok(dto.getRno());
  }

}

