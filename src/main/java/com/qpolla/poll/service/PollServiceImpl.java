package com.qpolla.poll.service;

import com.qpolla.exception.ResourceNotFoundException;
import com.qpolla.poll.converter.PollConverter;
import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.data.dto.PollVoteDto;
import com.qpolla.poll.data.entity.PollEntity;
import com.qpolla.poll.repository.PollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PollServiceImpl implements PollService {
    private final PollRepository repository;

    private final PollConverter converter;

    @Autowired
    public PollServiceImpl(PollRepository repository, PollConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public PollDto create(PollDto pollDto) {
        PollEntity entity = converter.toEntity(pollDto);
        PollEntity savedEntity = repository.save(entity);
        return converter.toDto(savedEntity);
    }

    @Override
    public PollDto get(Long id) throws ResourceNotFoundException {
        Optional<PollEntity> entity = repository.findById(id);
        PollEntity e = entity.orElseThrow(() -> new ResourceNotFoundException("Poll not found with the given id:", String.valueOf(id)));
        return converter.toDto(e);
    }

    @Override
    public PollDto updateStatus(PollStatusChangeRequestDto dto) throws ResourceNotFoundException {
        Optional<PollEntity> entity = repository.findById(dto.getPollId());
        PollEntity e = entity.orElseThrow(() -> new ResourceNotFoundException("Poll not found with the given id:", String.valueOf(dto.getPollId())));
        e.setStatus(dto.getNewStatus());
        repository.save(e);
        return converter.toDto(e);
    }

    @Override
    public PollDto update(PollDto pollDto) {
        return create(pollDto);
    }

    @Override
    public PollDto vote(PollVoteDto dto) throws ResourceNotFoundException {
        Optional<PollEntity> entity = repository.findById(dto.getPollId());
        PollEntity pollEntity =
                entity.orElseThrow(() -> new ResourceNotFoundException("Poll not found with the given id:", String.valueOf(dto.getPollId())));
        pollEntity.vote(dto.getOptionId());
        PollEntity savedEntity = repository.save(pollEntity);
        return converter.toDto(savedEntity);
    }

    @Override
    public Page<PollDto> filterByCategory(EnumPollCategory category, int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<PollEntity> pollList = repository.findByCategory(category, paging);
        List<PollDto> pollDtoList = pollList.stream().map(e -> converter.toDto(e)).collect(Collectors.toList());
        return new PageImpl<>(pollDtoList, paging, pollList.getTotalElements());
    }
}
