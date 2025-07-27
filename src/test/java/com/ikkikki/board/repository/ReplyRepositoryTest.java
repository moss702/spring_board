package com.ikkikki.board.repository;

import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTest {
  @Autowired
  private ReplyRepository repository;
  @Autowired
  private BoardRepository boardRepository;


  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);
  }

  @Test
  public void insertReplies() {
    List<Long> bons = boardRepository.findAll().stream().map(Board::getBno).toList();

    IntStream.rangeClosed(1, 300).forEach(i -> {
      long bno = bons.get(new Random().nextInt(bons.size()));
      Board board = Board.builder().bno(bno).build();
      Reply reply = Reply.builder()
              .board(board)
              .text("reply" + i)
              .replyer("guest")
              .build();
      repository.save(reply);
    });
  }

  @Test
  public void testRead() {
    Reply reply = repository.findById(100L).orElse(null);
    log.info(reply);
    log.info(reply.getBoard());
    log.info(reply.getBoard().getWriter());
  }
}
