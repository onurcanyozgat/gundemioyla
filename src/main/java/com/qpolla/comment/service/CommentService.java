package com.qpolla.comment.service;

import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.dto.CommentStatusChangeDto;
import com.qpolla.comment.data.dto.CommentVoteDto;
import com.qpolla.exception.ResourceNotFoundException;

import java.util.List;

public interface CommentService {

    CommentDto create(CommentDto dto);

    CommentDto get(Long id) throws ResourceNotFoundException;

    List<CommentDto> findBy(Long pollId, int page, int size) throws ResourceNotFoundException;

    void vote(CommentVoteDto dto) throws ResourceNotFoundException;

    CommentDto updateStatus(CommentStatusChangeDto dto) throws ResourceNotFoundException;

    CommentDto update(CommentDto dto);

}
