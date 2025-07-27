package com.ikkikki.board.projection.dto;

import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Member;
import lombok.Getter;

@Getter
public class BoardWithWriterDTOClass {
  private final Board board;
  private final Member member;

  public BoardWithWriterDTOClass(Board board, Member member) {
    this.board = board;
    this.member = member;
  }
}
