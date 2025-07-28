package com.ikkikki.board.domain.projection.dto;

import com.ikkikki.board.domain.entity.Board;
import com.ikkikki.board.domain.entity.Member;

public record BoardWithWriterDTORecord(Board board, Member member) {
}
