package com.qpolla.user.data.dto;

import com.qpolla.poll.data.EnumPollStatus;
import com.qpolla.user.data.EnumUserStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserChangeRequestDto implements Serializable {
    private String username;

    private EnumUserStatus newStatus;
}
