package com.ikkikki.board.domain.projection.dto;

import com.ikkikki.board.domain.entity.Board;
import com.ikkikki.board.domain.entity.Member;

public record BoardWithReplyCount(Board board, Member member, Long replyCount){ }

