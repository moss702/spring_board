package com.ikkikki.board.service;

import com.ikkikki.board.domain.dto.BoardDTO;
import com.ikkikki.board.domain.dto.ReplyDTO;
import com.ikkikki.board.domain.entity.Board;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Log4j2
@SpringBootTest
public class ReplyServiceTest {

  @Autowired
  private ReplyService replyService;

  @Test
  public void testExist() {
    log.info("{}", replyService);
  }

  @Test
  public void testResister() {
    replyService.register(ReplyDTO.builder().bno(55L).text("등록테스트").replyer("테스트입력자").build());
  }


  @Test
  public void testGetList() {
    replyService.getList(55L).forEach(log::info);
  }

  @Test
  public void testModify() {
    ReplyDTO replyDTO = replyService.get((60L));
    replyDTO.setText("내용변경");
    replyService.modify(replyDTO);
  }

  @Test
  public void testGet() {
    try {
      ReplyDTO dto = replyService.get(60L);
    } catch (IllegalAccessError e) {
      log.error(e.getMessage(), e.getClass().getSimpleName());
    }
  }

  @Test
  public void testRemove() {
    replyService.remove(600L);
  }
}