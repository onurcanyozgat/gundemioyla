package com.qpolla.comment;

import com.qpolla.comment.converter.CommentConverter;
import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.dto.CommentStatusChangeDto;
import com.qpolla.comment.data.dto.CommentVoteDto;
import com.qpolla.comment.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;

    private final CommentConverter converter;

    @Autowired
    public CommentServiceImpl(CommentRepository repository, CommentConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public CommentDto create(CommentDto dto) {
        return null;
    }

    @Override
    public CommentDto get(Long id) throws EntityNotFoundException {
        return null;
    }

    @Override
    public void vote(CommentVoteDto dto) {
    }

    @Override
    public CommentDto updateStatus(CommentStatusChangeDto dto) {
        return null;
    }

    @Override
    public CommentDto update(CommentDto dto) {
        return null;
    }
}
