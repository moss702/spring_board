package com.ikkikki.board.service;

import com.ikkikki.board.domain.dto.PageRequestDTO;
import com.ikkikki.board.domain.dto.PageResponseDTO;
import com.ikkikki.board.domain.dto.ReplyDTO;
import com.ikkikki.board.domain.entity.Reply;
import com.ikkikki.board.domain.mapper.ReplyMapper;
import com.ikkikki.board.domain.projection.dto.BoardWithReplyCount;
import com.ikkikki.board.repository.ReplyRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Data
public class ReplyServiceImpl implements ReplyService {
  private  final ReplyMapper replyMapper;
  private  final ReplyRepository replyRepository;

  @Override
  public Long register(ReplyDTO dto) {
    return replyRepository.save(replyMapper.toEntity(dto)).getRno();
  }

  @Override
  public void remove(Long rno) {
    replyRepository.deleteById(rno);

  }

  @Override
  public void modify(ReplyDTO dto) {
    replyRepository.save(replyMapper.toEntity(dto));

  }

  @Override
  public ReplyDTO get(Long rno) {
    return replyMapper.toDto(replyRepository.findById(rno).orElseThrow(() -> new IllegalArgumentException("댓글 없음")));
  }

  public List<ReplyDTO> getList(Long bno) {
    return replyRepository.findByBoard_BnoOrderByRno(bno).stream().map(replyMapper::toDto).toList();
  }
}
