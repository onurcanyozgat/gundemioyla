package com.qpolla.comment.data.dto;

import com.qpolla.comment.data.EnumVoteType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentVoteDto {
    private Long commentId;

    private EnumVoteType voteType;
}
