package com.qpolla.comment.data.dto;

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

}
