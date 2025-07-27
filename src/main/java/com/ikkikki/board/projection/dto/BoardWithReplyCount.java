package com.ikkikki.board.projection.dto;

import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Member;
import com.ikkikki.board.entity.Reply;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BoardWithReplyCount {
  private Board board;
  private Member member;
  private Long replyCount;

  public BoardWithReplyCount(Board board, Member member, Long replyCount) {
    this.board = board;
    this.member = member;
    this.replyCount = replyCount;
  }


}
