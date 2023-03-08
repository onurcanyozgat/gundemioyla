package com.qpolla.poll.data.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PollVoteDto {
    private Long pollId;

    private Long optionId;

    private Long userId;

}
