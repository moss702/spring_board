package com.ikkikki.board.projection.dto;

import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Member;

public record BoardWithWriterDTORecord(Board board, Member member) {
}
