package com.qpolla.poll.service;

import com.qpolla.poll.data.dto.PollDto;
import com.qpolla.poll.data.dto.PollStatusChangeRequestDto;
import com.qpolla.poll.data.dto.PollVoteDto;
import jakarta.persistence.EntityNotFoundException;

public interface PollService {

    PollDto create(PollDto pollDto);

    PollDto get(Long id) throws EntityNotFoundException;

    PollDto updateStatus(PollStatusChangeRequestDto dto);

    PollDto update(PollDto pollDto);

    PollDto vote(PollVoteDto dto);
}
