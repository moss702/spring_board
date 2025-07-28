package com.ikkikki.board.repository;

import com.ikkikki.board.domain.entity.Board;
import com.ikkikki.board.domain.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
  void deleteByBoard_Bno(Long bno);

  List<Reply> findByBoard_BnoOrderByRno(Long bno);
  List<Reply> findByBoard(Board board);
}
