package com.qpolla.poll.converter;

import com.qpolla.poll.data.dto.OptionDto;
import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.entity.OptionEntity;
import com.qpolla.poll.data.entity.PollEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PollConverter {
    private final OptionConverter optionConverter;

    @Autowired
    public PollConverter(OptionConverter optionConverter) {
        this.optionConverter = optionConverter;
    }

    public PollDto toDto(PollEntity source) {
        PollDto target = new PollDto();
        target.setId(source.getId());
        target.setCategory(source.getCategory());
        target.setStatus(source.getStatus());
        target.setDescription(source.getDescription());
        target.setUrl(source.getUrl());
        target.setTitle(source.getTitle());
        target.setApprovedDate(source.getApprovedDate());
        List<OptionDto> optionList = source.getOptionList().stream().map(e -> optionConverter.toDto(e)).collect(Collectors.toList());
        target.setOptionList(optionList);
        target.setVotingEndDate(source.getVotingEndDate());
        target.setVotingStartDate(source.getVotingStartDate());
        if (source.getAuthor() != null) {
            target.setAuthorId(source.getAuthor().getId());
        }
        // TODO image need to be implemented
        return target;
    }

    public PollEntity toEntity(PollDto source) {
        PollEntity target = new PollEntity();
        List<OptionEntity> optionList = source.getOptionList().stream().map(e -> optionConverter.toEntity(e)).collect(Collectors.toList());
        target.setOptionList(optionList);
        target.setDescription(source.getDescription());
        target.setCategory(target.getCategory());
        target.setId(source.getId());
        target.setUrl(source.getUrl());
        target.setTitle(source.getTitle());
        target.setStatus(source.getStatus());
        target.setApprovedDate(source.getApprovedDate());
        // TODO find user and set to target
        //target.setAuthor();
        // TODO image need to be implemented
        target.setVotingEndDate(target.getVotingEndDate());
        target.setVotingStartDate(target.getVotingStartDate());
        //TODO entry need to be implemented if needed
        return target;
    }

}
