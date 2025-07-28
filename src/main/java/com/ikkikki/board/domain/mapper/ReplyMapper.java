package com.ikkikki.board.domain.mapper;

import com.ikkikki.board.domain.dto.ReplyDTO;
import com.ikkikki.board.domain.entity.Reply;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReplyMapper {
  @Mapping(source = "board.bno", target = "bno")
  ReplyDTO toDto(Reply reply);

//  @Mapping(source = "bno", target = "board.bno")
  @InheritInverseConfiguration
  Reply toEntity(ReplyDTO dto);
}
