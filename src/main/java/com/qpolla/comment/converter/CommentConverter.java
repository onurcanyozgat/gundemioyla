package com.qpolla.comment.converter;

import com.qpolla.comment.data.dto.CommentDto;
import com.qpolla.comment.data.entity.CommentEntity;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {
    public CommentDto toDto(CommentEntity source) {
        CommentDto target = new CommentDto();
        target.setComment(source.getComment());
        target.setId(source.getId());
        target.setUrl(source.getUrl());
        target.setStatus(source.getStatus());
        target.setUpvoteCount(source.getUpvoteCount());
        target.setDownVoteCount(source.getDownVoteCount());
        if(source.getAuthor() != null) {
            target.setUserId(source.getAuthor().getId());
        }
        if(source.getPoll() != null) {
            target.setPollId(source.getPoll().getId());
        }
        if(source.getParent() != null) {
            target.setParentId(source.getParent().getId());
        }
        return target;
    }

    public CommentEntity toEntity(CommentDto source) {
        CommentEntity target = new CommentEntity();
        target.setStatus(source.getStatus());
        target.setId(source.getId());
        target.setComment(source.getComment());
        target.setDate(source.getDate());
        target.setUrl(source.getUrl());
        target.setUpvoteCount(source.getUpvoteCount());
        target.setDownVoteCount(source.getDownVoteCount());
        if (source.getUserId() != null) {
            // TODO find user
            //target.setAuthor();
        }
        if (source.getPollId() != null) {
            // TODO find poll
            //target.setPoll(,);
        }
        if (source.getParentId() != null) {
            // TODO find parent
            // target.setParent();
        }
        return target;
    }
}
