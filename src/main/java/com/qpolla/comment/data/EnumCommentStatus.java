package com.qpolla.comment.data;

import lombok.Getter;

@Getter
public enum EnumCommentStatus {
    APPROVED,
    REJECTED,
    BANNED,
    SENSITIVE
}