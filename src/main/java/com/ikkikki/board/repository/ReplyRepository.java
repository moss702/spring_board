package com.ikkikki.board.repository;

import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
  void deleteByBoard_Bno(Long bno);
}
