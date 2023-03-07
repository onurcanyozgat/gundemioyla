package com.qpolla.comment.converter;

import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public CommentDto toDto(CommentEntity source) {
        CommentDto target = new CommentDto();
        return target;
    }

    public CommentEntity toEntity(CommentDto source) {
        CommentEntity target = new CommentEntity();
        return target;
    }
}
