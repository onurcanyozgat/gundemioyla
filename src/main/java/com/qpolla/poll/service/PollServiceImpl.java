package com.qpolla.poll.service;

import com.qpolla.poll.converter.PollConverter;
import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.data.entity.PollEntity;
import com.qpolla.poll.repository.PollRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

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
    public PollDto get(Long id) throws EntityNotFoundException{
        Optional<PollEntity> entity = repository.findById(id);
        PollEntity e =  entity.orElseThrow(() -> new EntityNotFoundException("Poll not found with the given id:" + id));
        return converter.toDto(e);
    }

    @Override
    public PollDto updateStatus(PollStatusChangeRequestDto dto) {
        Optional<PollEntity> entity = repository.findById(dto.getPollId());
        PollEntity e =  entity.orElseThrow(() -> new EntityNotFoundException("Poll not found with the given id:" + dto.getPollId()));
        e.setStatus(dto.getNewStatus());
        repository.save(e);
        return converter.toDto(e);
    }

    @Override
    public PollDto update(PollDto pollDto) {
        return create(pollDto);
    }
}
