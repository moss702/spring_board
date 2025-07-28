package com.ikkikki.board.domain.projection.dto;

import com.ikkikki.board.domain.entity.Board;
import com.ikkikki.board.domain.entity.Reply;

public interface BoardWithReplyDTO {
  Board getBoard();
  Reply getReply();
}
