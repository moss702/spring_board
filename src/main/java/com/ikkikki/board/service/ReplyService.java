package com.ikkikki.board.service;

import com.ikkikki.board.domain.dto.BoardDTO;
import com.ikkikki.board.domain.dto.PageRequestDTO;
import com.ikkikki.board.domain.dto.PageResponseDTO;
import com.ikkikki.board.domain.dto.ReplyDTO;
import com.ikkikki.board.domain.entity.Board;
import com.ikkikki.board.domain.entity.Member;
import com.ikkikki.board.domain.entity.Reply;
import com.ikkikki.board.domain.projection.dto.BoardWithReplyCount;

import java.util.List;

public interface ReplyService {

  // 댓글 등록
  Long register(ReplyDTO replyDTO);

  // 특정 게시물의 댓글 목록

  ReplyDTO get(Long rno);

  // 댓글 수정
  void remove(Long rno);

  List<ReplyDTO> getList(Long bno);

  // 댓글 삭제
  void modify(ReplyDTO replyDTO);

  // DML (insert, update)
//  default Reply toEntity(ReplyDTO dto) {
//    Board board = Board.builder().bno(dto.getBno()).build();
//    return Reply.builder()
//            .rno(dto.getRno())
//            .text(dto.getText())
//            .replyer(dto.getReplyer())
//            .board(board)
//            .build();
//  }
//
//  default ReplyDTO toDTO(Reply reply) {
//    return ReplyDTO.builder()
//            .rno(reply.getRno())
//            .text(reply.getText())
//            .replyer(reply.getReplyer())
//            .regDate(reply.getRegDate())
//            .modDate(reply.getModDate())
//            .build();
//  }

}
