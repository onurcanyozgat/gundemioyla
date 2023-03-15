package com.qpolla.poll.service;

import com.qpolla.exception.ResourceNotFoundException;
import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.data.dto.PollVoteDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PollService {

    PollDto create(PollDto pollDto);

    PollDto get(Long id) throws ResourceNotFoundException;

    PollDto updateStatus(PollStatusChangeRequestDto dto) throws ResourceNotFoundException;

    PollDto update(PollDto pollDto);

    PollDto vote(PollVoteDto dto) throws ResourceNotFoundException;

    Page<PollDto> filterByCategory(EnumPollCategory category, int page, int size);
}
