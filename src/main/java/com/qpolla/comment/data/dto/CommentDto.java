package com.qpolla.comment.data.dto;

import com.qpolla.comment.data.EnumCommentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentDto {

    private Long id;

    private Long parentId;

    private Long pollId;

    private Long userId;

    private String url;

    private String comment;

    private EnumCommentStatus status;

    private long date;

    private int downVoteCount;

    private int upvoteCount;

}
