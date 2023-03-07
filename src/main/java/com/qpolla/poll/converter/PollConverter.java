package com.qpolla.poll.converter;

import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.entity.PollEntity;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class PollConverter {

    public PollDto toDto(PollEntity entity) {
        PollDto dto = new PollDto();
        dto.setId(entity.getId());
        dto.setCategory(entity.getCategory());
        dto.setStatus(entity.getStatus());
        dto.setDescription(entity.getDescription());
        dto.setUrl(entity.getUrl());
        dto.setTitle(entity.getTitle());
        dto.setApprovedDate(entity.getApprovedDate());
        // TODO option converter need to be implemented
        //dto.setOptionList();
        dto.setVotingEndDate(entity.getVotingEndDate());
        dto.setVotingStartDate(entity.getVotingStartDate());
        // TODO user need to be implemented
        // TODO image need to be implemented
        return dto;
    }

    public PollEntity toEntity(PollDto dto) {
        PollEntity entity = new PollEntity();
        // TODO option converter need to be implemented
        //entity.setOptionList();
        entity.setDescription(dto.getDescription());
        entity.setCategory(entity.getCategory());
        entity.setId(dto.getId());
        entity.setUrl(dto.getUrl());
        entity.setTitle(dto.getTitle());
        entity.setStatus(dto.getStatus());
        entity.setApprovedDate(dto.getApprovedDate());
        // TODO user need to be implemented
        //entity.setAuthor();
        // TODO image need to be implemented
        entity.setVotingEndDate(entity.getVotingEndDate());
        entity.setVotingStartDate(entity.getVotingStartDate());
        //TODO entry need to be implemented if needed
        return entity;
    }

}
