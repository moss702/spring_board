package com.ikkikki.board.service;

import com.ikkikki.board.dto.BoardDTO;
import com.ikkikki.board.dto.PageRequestDTO;
import com.ikkikki.board.dto.PageResponseDTO;
import com.ikkikki.board.entity.Board;
import com.ikkikki.board.entity.Member;
import com.ikkikki.board.projection.dto.BoardWithReplyCount;

public interface BoardService {
  Long register(BoardDTO boardDTO);

  PageResponseDTO<BoardDTO, BoardWithReplyCount> getList(PageRequestDTO pageRequestDTO);

  BoardDTO get(Long bno);

  void remove(Long bno);

  void modify(BoardDTO boardDTO);

  // DML (insert, update)
  default Board toEntity(BoardDTO dto) {
    return Board.builder()
            .bno(dto.getBno())
            .title(dto.getTitle())
            .content(dto.getContent())
            .writer(Member.builder().email(dto.getWriterEmail()).build())
            .build();
  }
  default BoardDTO toDTO(Board entity, Member member, Long replyCnt) {
    return BoardDTO.builder()
            .bno(entity.getBno())
            .title(entity.getTitle())
            .content(entity.getContent())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .writerEmail(member.getEmail())
            .writerName(member.getName())
            .replyCount(replyCnt)
            .build();

  }
  default BoardDTO projectionToDTO(BoardWithReplyCount entity) {
    return BoardDTO.builder()
            .bno(entity.getBoard().getBno())
            .title(entity.getBoard().getTitle())
            .content(entity.getBoard().getContent())
            .regDate(entity.getBoard().getRegDate())
            .modDate(entity.getBoard().getModDate())
            .writerEmail(entity.getBoard().getWriter().getName())
            .replyCount(entity.getReplyCount())
            .build();
  }
}
