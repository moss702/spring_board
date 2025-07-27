package com.ikkikki.board.projection.dto;

import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Reply;

public interface BoardWithReplyDTO {
  Board getBoard();
  Reply getReply();
}
