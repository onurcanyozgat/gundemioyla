package com.qpolla.comment;

import com.qpolla.comment.converter.CommentConverter;
import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.dto.CommentStatusChangeDto;
import com.qpolla.comment.data.dto.CommentVoteDto;
import com.qpolla.comment.data.entity.CommentEntity;
import com.qpolla.comment.repository.CommentRepository;
import com.qpolla.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        CommentEntity entity = converter.toEntity(dto);
        CommentEntity savedEntity = repository.save(entity);
        return converter.toDto(savedEntity);
    }

    @Override
    public CommentDto get(Long id) throws ResourceNotFoundException {
        Optional<CommentEntity> optionEntity = repository.findById(id);
        CommentEntity commentEntity =
                optionEntity.orElseThrow(() -> new ResourceNotFoundException("Comment not found with the given id:", String.valueOf(id)));
        return converter.toDto(commentEntity);
    }

    @Override
    public List<CommentDto> findBy(Long pollId, int page, int size) throws ResourceNotFoundException {
        Pageable pageable = PageRequest.of(page, size);
        List<CommentEntity> commentList = repository.findByPoll_id(pollId, pageable);
        return commentList.stream().map(converter::toDto).collect(Collectors.toList());
    }

    @Override
    public void vote(CommentVoteDto dto) throws ResourceNotFoundException {
        Optional<CommentEntity> optionEntity = repository.findById(dto.getCommentId());
        CommentEntity commentEntity = optionEntity.orElseThrow(
                () -> new ResourceNotFoundException("Comment not found with the given id:", String.valueOf(dto.getCommentId())));
        commentEntity.vote(dto.getVoteType());
        repository.save(commentEntity);
    }

    @Override
    public CommentDto updateStatus(CommentStatusChangeDto dto) throws ResourceNotFoundException{
        Optional<CommentEntity> optionEntity = repository.findById(dto.getCommentId());
        CommentEntity commentEntity = optionEntity.orElseThrow(
                () -> new ResourceNotFoundException("Comment not found with the given id:", String.valueOf(dto.getCommentId())));
        commentEntity.setStatus(dto.getStatus());
        CommentEntity savedEntity = repository.save(commentEntity);
        return converter.toDto(savedEntity);
    }

    @Override
    public CommentDto update(CommentDto dto) {
        return create(dto);
    }
}
