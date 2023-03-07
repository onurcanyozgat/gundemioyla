package com.qpolla.poll.data.dto;

import com.qpolla.poll.data.EnumPollCategory;
import com.qpolla.poll.data.EnumPollStatus;
import com.qpolla.user.data.dto.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PollDto {
    private Long id;

    private String title;

    private String description;

    private List<OptionDto> optionList;

    private EnumPollCategory category;

    private long votingStartDate;

    private long votingEndDate;

    private long approvedDate;

    private EnumPollStatus status;

    private UserDto author;

    private String url;
    // TODO json error
    //private byte[] image;
}
