package com.qpolla.poll.data.dto;

import com.qpolla.poll.data.EnumPollStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class PollStatusChangeRequestDto implements Serializable {

    private Long pollId;

    private EnumPollStatus newStatus;
}
