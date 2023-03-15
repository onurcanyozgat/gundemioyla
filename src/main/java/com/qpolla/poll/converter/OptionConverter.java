package com.qpolla.poll.converter;

import com.qpolla.poll.data.dto.OptionDto;
import com.qpolla.poll.data.entity.OptionEntity;
import org.springframework.stereotype.Component;

@Component
public class OptionConverter {
  public   OptionDto toDto(OptionEntity source){
      OptionDto target = new OptionDto();
      target.setId(source.getId());
      target.setImage(source.getImage());
      target.setContent(source.getContent());
      target.setVoteCount(source.getVoteCount());
      return target;
  }

  public OptionEntity toEntity(OptionDto source){
      OptionEntity target = new OptionEntity();
      target.setId(source.getId());
      target.setImage(source.getImage());
      target.setContent(source.getContent());
      target.setVoteCount(source.getVoteCount());
      // TODO: target.setPoll();
      return target;
  }
}
