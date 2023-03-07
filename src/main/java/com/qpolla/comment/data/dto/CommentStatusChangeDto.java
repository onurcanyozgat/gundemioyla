package com.qpolla.comment.data.dto;

import com.qpolla.comment.data.EnumCommentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentStatusChangeDto {
    private Long commentId;

    private EnumCommentStatus status;
}
