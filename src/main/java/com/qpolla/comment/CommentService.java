package com.qpolla.comment;

import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.dto.CommentStatusChangeDto;
import com.qpolla.comment.data.dto.CommentVoteDto;
import jakarta.persistence.EntityNotFoundException;

public interface CommentService {

    CommentDto create(CommentDto dto);

    CommentDto get(Long id) throws EntityNotFoundException;

    void vote(CommentVoteDto dto);

    CommentDto updateStatus(CommentStatusChangeDto dto);

    CommentDto update(CommentDto dto);

}
